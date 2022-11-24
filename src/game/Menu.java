

package game;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Guy
 */
public class Menu extends JPanel{
    
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("BG.gif"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("QU.png"));
    private ImageIcon start = new ImageIcon(this.getClass().getResource("st.png"));
    public JButton bexit = new JButton(exit);
    public JButton bstart = new JButton(start);

    public Menu() {
    
         setLayout(null);
         add(bexit);
         add(bstart);
         bstart.setBounds(400, 400, 470, 120);
         bexit.setBounds(400, 540, 470, 120);
    
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
            g.drawImage(wallpaper.getImage(),-7,0,1280,750,this);
          
        
    }
    
}
