

package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Guy
 */
public class Play extends JFrame implements ActionListener{

    Menu m = new Menu();
    state s = new state();
    
    public Play() {
        
        this.setSize(1280, 783);
        this.add(m);
        m.bstart.addActionListener(this);
        m.bexit.addActionListener(this);
        s.BExithome.addActionListener(this);
        s.BPause.addActionListener(this);
        s.Bresume.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == m.bstart){
            
            this.setLocationRelativeTo(null);
            this.remove(m);
            this.setSize(1280, 783);
            this.add(s);
            s.requestFocusInWindow();
            s.timestart = false;
            s.scor = 0;
            s.HP = 3;
            s.times = 100;
            s.startball = false;
            s.timestart = false;
            
        }
        
        else if (e.getSource() == s.BExithome) {
            
            System.exit(0);
            
        } else if (e.getSource() == m.bexit) {
            
            System.exit(0);
            
        } else if (e.getSource() == s.BPause) {
            this.setLocationRelativeTo(null);
            this.setSize(1280, 783);
            this.add(s);
            s.requestFocusInWindow();
            s.t.suspend();
            s.time.suspend();
            s.actor.suspend();
            s.tballs1.suspend();
            s.tballs5.suspend();
            
        }
        
        else if (e.getSource() == s.Bresume) {
            this.setLocationRelativeTo(null);
            this.setSize(1280, 783);
            this.add(s);
            s.requestFocusInWindow();
            s.t.resume();
            s.time.resume();
            s.actor.resume();
            s.tballs1.resume();
            s.tballs5.resume();
        }
        
        this.validate();
        this.repaint();
        
    }
    
    public static void main(String[] args) {
        JFrame jf = new Play();
        jf.setSize(1280, 783);
        jf.setTitle("Magician");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
        
}
