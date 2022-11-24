/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Guy
 */
public class Fireball extends JPanel{
    
    public ImageIcon[] imgStar = new ImageIcon[5];
    public int x;
    public int y;
    public int count = 0;

    public Fireball(int x, int y) {
        
        for(int i=0;i<imgStar.length;i++){
            String imageLocation = "s"+(i+1)+".png";
            imgStar[i] = new ImageIcon(this.getClass().getResource(imageLocation));
	}
        
        this.x = x;
        this.y = y;
        
    }
    
    public void move(){
        
        this.y -= 1;
        
    }
    
    public Rectangle2D getbound(){
        
        return (new Rectangle2D.Double(x,y,25,25));
        
    }
    
    
}
