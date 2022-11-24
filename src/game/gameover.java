/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Guy
 */
public class gameover extends JPanel{
    
    private ImageIcon wallpaper = new ImageIcon("Tree_Root_Canopy_by_ANTIFAN_REAL.jpg");
    private ImageIcon exitover = new ImageIcon("exit.jpg");
    private ImageIcon restart = new ImageIcon("start.jpg");
    public JButton BStartover = new JButton(restart);
    public JButton BExitover  = new JButton(exitover);

    public gameover() {
        
        this.setLayout(null);
	BExitover.setBounds(500, 650, 150,90);
	add(BExitover);
	BStartover.setBounds(750,650,150,90);
        add(BStartover);
        
    }
    
    public void paintComponent(Graphics g){
        
        super.repaint();
        g.drawImage(wallpaper.getImage(),0,0,1280,783,this);
        
    }
    
}
