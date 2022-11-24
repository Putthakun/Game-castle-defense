/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author Guy
 */
public class star2 extends star1{
    
    Image img;
    star2(){
        
        String imageLocation = "Alien.png";
        URL imageURL1 = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL1);
        runner.start();
        
    }
    
    Thread runner = new Thread(new Runnable() {
	public void run() {
            while(true){
		x += 2;
		if(x >= 1100){
                    img = null;
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try{
                    runner.sleep(30);
                }catch(InterruptedException e){}
            }
	}
    });

    public Image getImage(){
	return img;
    }
    
}
