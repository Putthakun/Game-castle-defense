/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Guy
 */
public class state extends JPanel implements ActionListener{
    
    private final ImageIcon state1 = new ImageIcon(this.getClass().getResource("state1.gif"));
    private final ImageIcon state2 = new ImageIcon(this.getClass().getResource("state2.gif"));
    private final ImageIcon enemy = new ImageIcon(this.getClass().getResource("Alien.png"));
    private final ImageIcon pause = new ImageIcon(this.getClass().getResource("p.png"));
    private final ImageIcon resume = new ImageIcon(this.getClass().getResource("play.png"));
    private final ImageIcon back = new ImageIcon(this.getClass().getResource("back.png"));
    player p = new player();
    
    Menu m2 = new Menu();
    
    ImageIcon over = new ImageIcon(this.getClass().getResource("Game Over.gif"));
    ImageIcon img_p = new ImageIcon(this.getClass().getResource("1.png"));
    ImageIcon exitover = new ImageIcon(this.getClass().getResource("QU.png"));
    ImageIcon restart = new ImageIcon(this.getClass().getResource("st.png"));
    JButton BStartover = new JButton(restart);
    JButton BExitover = new JButton(exitover);
    
    private JLabel score = new JLabel();
    public JButton BPause = new JButton(pause);
    public JButton BExithome = new JButton(back);
    public JButton Bresume = new JButton(resume);
    
    public ArrayList<Fireball> s = new ArrayList<Fireball>();
    public ArrayList<Alien> al = new ArrayList<Alien>();
    public ArrayList<star3> st = new ArrayList<star3>();
    public int times;
    public int HP = 3;
    public int rs1 = 1;
    public int rs2 = 2;
    boolean timestart = true;
    boolean startball = false;
    
    private gameover go = new gameover();
    public int scor = 0;
    boolean paralyze1 = false;
    int time_paralyze = 5;
    
    Thread time = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }

                if (timestart == false) {
                    repaint();
                }
            }
        }
    });

    Thread actor = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });
    
    Thread tballs1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 10000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    al.add(new Alien());
                }
            }
        }
    });
    
    Thread tballs5 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 10000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    st.add(new star3());
                }
            }
        }
    });
    
    Thread paralyze = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (time_paralyze < 1) {
                    paralyze1 = false;
                    time_paralyze = 5;
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    
    Thread t = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (timestart == false) {
                    times = (times - 1);
                    if (paralyze1) {
                        time_paralyze--;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    
    
    state(){
        
        this.setFocusable(true);
        this.setLayout(null);
        BPause.setBounds(1100, 50, 40, 40);
        Bresume.setBounds(1150, 50, 40, 40);
        BPause.addActionListener(this);
        BExithome.addActionListener(this);
        Bresume.addActionListener(this);
        BExithome.addActionListener(this);
        this.add(BPause);
        this.add(BExithome);
        this.add(score);
        this.add(Bresume);
        
        this.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e) {
                
                int a = e.getKeyCode();
                
                if (!paralyze1) {
                    
                    if (a == KeyEvent.VK_A) {
                        
                        p.x -= 10;
                        p.count++;
                        
                    } else if (a == KeyEvent.VK_D) {
                        
                        p.x += 10;
                        p.count++;
                        
                    }
                    
                    if (p.count > 3) {
                        p.count = 0;
                        
                    } else if (a == KeyEvent.VK_UP) {
                        
                        p.count = 5;
                        s.add(new Fireball(p.x, 550));
                        
                    }
                    
                }
                
            }
            
            public void keyReleased(KeyEvent e) {
                
                p.count = 0;
                
            }
            
        });
        
        p.x = 400;
        time.start();
        actor.start();
        t.start();
        tballs1.start();
        tballs5.start();
        paralyze.start();
        
    }
            
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        if (times <= 0 || HP <= 0) {
            
            this.remove(BPause);
            this.remove(Bresume);
            this.remove(BExithome);
            this.setLayout(null);
            g.drawImage(over.getImage(), 0, 0, 1280, 800, this);
        
        } else if (times <= 50) {
            
            g.drawImage(state2.getImage(), 0, 0, 1280, 800, this);
            
            if (paralyze1) {
                
                g.drawImage(img_p.getImage(), p.x, 550, 100, 150, this);
                
            } else {
                
                g.drawImage(p.p[p.count].getImage(), p.x, 550, 110, 160, this);
                
            }
            
            
            if (p.x < 0) {
                
                p.x = this.getWidth() - 10;
                
            }
            
            if (p.x > this.getWidth()) {
                
                p.x = 20;
                
            }
            
            for (int i = 0; i < s.size(); i++) {
                
                Fireball ba= s.get(i);
                g.drawImage(ba.imgStar[ba.count % 5].getImage(), ba.x, ba.y, 50, 50, null);
                ba.move();
                ba.count++;
                if (ba.y < 0) {
                    s.remove(i);
                }
            }
            
            for (int i = 0; i < al.size(); i++) {
                
                g.drawImage(al.get(i).getImage(), al.get(i).getX(), al.get(i).getY(), 100, 100, this);
                
            }
            
            for (int i = 0; i < s.size(); i++) {
                
                for (int j = 0; j < al.size(); j++) {
                    
                    if (Intersect(s.get(i).getbound(), al.get(j).getbound())) {
                        al.remove(j);
                        s.remove(i);
                        scor += 10;
                        g.drawString("+10", p.x + 100, 650);
                        
                    }
                    
                }
                
            }
            
            for (int i = 0; i < s.size(); i++) {
                
                for (int j = 0; j < st.size(); j++) {
                    
                    if (Intersect(s.get(i).getbound(), st.get(j).getbound())) {
                        
                        st.remove(j);
                        s.remove(i);
                        scor -= 20;
                        HP = HP - 1;
                        g.drawString("-1HP", p.x + 100, 650);
                        g.drawString("-20", p.x + 100, 580);
                        
                    }
                    
                }
                
            }
            
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 30));
            g.setColor(Color.WHITE);
            g.drawString("SCORE =  " + scor, 50, this.getHeight() - 10);
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 50));
            g.drawString("Time " + times, this.getWidth() - 200, this.getHeight() - 50);
            g.setColor(Color.WHITE);
            g.drawString("HP  " + HP, 50, this.getHeight() - 50);
            
        } else if (times <= 0 || HP <= 0) {
            
            this.remove(BPause);
            this.remove(Bresume);
            this.remove(BExithome);
            this.setLayout(null);
            g.drawImage(over.getImage(), 0, 0, 1280, 800, this);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 40));
            g.drawString("SCORE   " + scor, 380, 200);
            
        } else {
            
            g.drawImage(state1.getImage(), 0, 0, 1280, 800, this);
            
            if (paralyze1) {
                
                g.setColor(Color.RED);
                g.setFont(new Font("Hobo Std", Font.BOLD, 50));
                g.drawImage(img_p.getImage(), p.x, 550, 100, 150, this);
                g.drawString("-10", p.x + 100, 650);
                
            } else {
                
                g.drawImage(p.p[p.count].getImage(), p.x, 550, 110, 160, this);
            }
            
            if (p.x < 0) {
                
                p.x = this.getWidth() - 10;
                
            }
            
            if (p.x > this.getWidth()) {
                
                p.x = 20;
                
            }
            
            for (int i = 0; i < s.size(); i++) {
                
                Fireball ba = s.get(i);
                g.drawImage(ba.imgStar[ba.count % 5].getImage(), ba.x, ba.y, 50, 50, null);
                ba.move();
                ba.count++;
                if (ba.y < 0) {
                    
                    s.remove(i);
                    
                }
                
            }
            
            for (int i = 0; i < al.size(); i++) {
                
                g.drawImage(al.get(i).getImage(), al.get(i).getX(), al.get(i).getY(), 100, 100, this);
                
            }
            for (int i = 0; i < s.size(); i++) {
                
                for (int j = 0; j < al.size(); j++) {
                    
                    if (Intersect(s.get(i).getbound(), al.get(j).getbound())) {
                        al.remove(j);
                        s.remove(i);
                        scor += 10;
                        g.drawString("+10", p.x + 100, 650);
                    }
                    
                }
                
            }
            
            for (int i = 0; i < st.size(); i++) {
                g.drawImage(st.get(i).getImage(), st.get(i).getX(),
                        st.get(i).getY(), 100, 100, this);

            }
            for (int i = 0; i < s.size(); i++) {
                for (int j = 0; j < st.size(); j++) {
                    if (Intersect(s.get(i).getbound(), st.get(j).getbound())) {
                        st.remove(j);
                        s.remove(i);
                        scor -= 20;
                        HP = HP - 1;
                        g.drawString("-1HP", p.x + 100, 650);
                        g.drawString("-20", p.x + 100, 580);
                    }
                    
                }
                
            }
            
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 30));
            g.setColor(Color.WHITE);
            g.drawString("SCORE =  " + scor, 50, this.getHeight() - 10);
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 50));
            g.drawString("Time " + times, this.getWidth() - 200, this.getHeight() - 50);
            g.setColor(Color.WHITE);
            g.drawString("HP  " + HP, 50, this.getHeight() - 50);
        
        }
        
    }
    
    private boolean Intersect(Rectangle2D a, Rectangle2D b) {
        
        return (a.intersects(b));
       
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == BStartover) {
            this.setSize(1280, 800);
            this.add(m2);
            this.setLocation(null);
            timestart = true;
            startball = true;
        } else if (e.getSource() == BExitover) {
            
            System.exit(0);
            
        }
        
    }

}
