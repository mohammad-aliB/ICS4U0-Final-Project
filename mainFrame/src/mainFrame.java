import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


public class mainFrame extends JFrame implements KeyListener{
    private mainDraw draw;
      /**
   * This method detects key down events
   */
    public void keyPressed(KeyEvent e) {
      if(e.getKeyCode()== KeyEvent.VK_ESCAPE){
        draw.escapePressed();
      }
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
            draw.setHorizontalMotion(1,1);
        else if(e.getKeyCode()== KeyEvent.VK_LEFT)
            draw.setHorizontalMotion(1,-1);
        else if(e.getKeyCode()== KeyEvent.VK_DOWN)
            draw.setVerticalMotion(0, -1);
        else if(e.getKeyCode()== KeyEvent.VK_UP)
              draw.setVerticalMotion(1,1);
        else if(e.getKeyCode()== KeyEvent.VK_ENTER)
              draw.enterPressed();
    }
      /**
   * This method detects key up events
   */
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
            draw.setHorizontalMotion(0,1);
        else if(e.getKeyCode()== KeyEvent.VK_LEFT)
            draw.setHorizontalMotion(0,-1);
    }
    public void keyTyped(KeyEvent e) {
    }
      /**
   * This is a constructor builds a mainDraw Jcomponent
   */
    public mainFrame(){
        this.draw=new mainDraw();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        draw.importAssets();
    }
      /**
   * Main class
   */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainFrame frame = new mainFrame();
                frame.setTitle("Race to Literacy");
                frame.setResizable(false);
                frame.setSize(720, 720);
                frame.setMinimumSize(new Dimension(720,720));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(frame.draw);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}