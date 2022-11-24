/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import javax.swing.ImageIcon;

/**
 *
 * @author Guy
 */
public class player {
        
        public ImageIcon[] p = new ImageIcon[7];
        public int x;
        public int y;
        public int count = 0;
        
        player(){
            
            for(int i = 0; i < p.length; i++){
                
                p[i] = new ImageIcon(this.getClass().getResource((i+1)+".png"));
                
            }
            
        }
        
}
