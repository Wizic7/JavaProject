import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class Paint {


    public static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Fun Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Panel());
        f.pack();
        f.setVisible(true);
    }

}



