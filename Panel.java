import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

//Mouse stuff
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;



public class Panel extends JPanel {

    private int panelHeight = 600;
    private int panelWidth = 800;

    private Shape currentShape = new Circle(-25,-25,25,25, Color.BLACK, Color.RED);
    private ArrayList<Shape> drawingList = new ArrayList<Shape>();

    public Panel() {

        setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                String output = "You clicked on x: " + x + " and y: " + y;
                System.out.println(output);

                //If we clicked on the menu, find where
                if(y<150)
                {
                    if(x < 200 && y < 30)
                    {
                    //Set to circle
                    System.out.println("Setting to circles");
                    currentShape = new Circle(-25,-25,currentShape.getWidth(),currentShape.getHeight(), Color.BLACK, Color.RED);
                    }
                                    //Set to square
                    else if(x < 200 && y > 30 && y < 50)
                    {
                        System.out.println("Setting to squares");
                        currentShape = new Square(-25,-25,currentShape.getWidth(),currentShape.getHeight(), Color.BLACK, Color.RED);
                    }
                    else if(x > 200 && x < 300 && y < 30)
                    {
                        //Increase Width
                        currentShape.updateWidth(currentShape.getWidth() + 5);
                    }
                    else if(x > 300 && x < 400 && y < 30)
                    {
                        //Decrease Width
                        currentShape.updateWidth(currentShape.getWidth() - 5);
                    }
                    else if(x > 200 && x < 300 && y > 30 && y < 50)
                    {
                        //Increase Height
                        currentShape.updateHeight(currentShape.getHeight() + 5);
                    }
                    else if(x > 300 && x < 400 && y > 30 && y < 50)
                    {
                        //Decrease Height
                        currentShape.updateHeight(currentShape.getHeight() - 5);
                    }
                }
                else{

                    moveCurrentShape(e.getX(),e.getY(), currentShape);
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
            if(y>80)
                moveCurrentShape(e.getX(),e.getY(), currentShape);
            }
        });
        
    }
    
    private void moveCurrentShape(int x, int y, Shape s){

        // Current shape state, stored as final variables 
        // to avoid repeat invocations of the same methods.
        final int CURR_X = s.getX();
        final int CURR_Y = s.getY();
        final int CURR_W = s.getWidth();
        final int CURR_H = s.getHeight();
        final int OFFSET = 1;

        if ((CURR_X!=x) || (CURR_Y!=y)) {

            // The Shape is moving, repaint background 
            // over the old square location. 
            //repaint(CURR_X,CURR_Y,CURR_W+OFFSET,CURR_H+OFFSET);

            // Update coordinates.
            s.updatePos(x,y);

            // Repaint the shape at the new location.
            repaint(s.getX(), s.getY(), CURR_W+OFFSET, CURR_H+OFFSET);
        }
    }

    

    public Dimension getPreferredSize() {
        return new Dimension(panelWidth, panelHeight);
    }

    public void makeMenu(Graphics g)
    {
        // Makes the text in a box from the first 150 pixels down
        g.setColor(Color.BLACK);
        g.drawString("Click Here to Draw with Circles",10,20);
        g.drawRect(5,5,200,20);
        g.drawString("Click Here to Draw with Squares",10,45);
        g.drawRect(5,30,200,20);

        g.drawString("Increase Width",210,20);
        g.drawRect(205,5,100,20);
        g.drawString("Increase Height",210,45);
        g.drawRect(205,30,100,20);

        g.drawString("Decrease Width",310,20);
        g.drawRect(305,5,100,20);
        g.drawString("Decrease Height",310,45);
        g.drawRect(305,30,100,20);

    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        makeMenu(g);

        drawingList.add(currentShape);
        for(Shape s : drawingList)
        {
            s.drawShape(g);
        }

        if(drawingList.size() > 300)
        {
            drawingList.remove(0);
        }
    }  
}
