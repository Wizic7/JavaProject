import java.awt.Graphics;
import java.awt.Color;

public class Circle extends Shape{



    public Circle(int x, int y, int w, int h)
    {
        super(x-w/2, y-h/2, w, h);
    }
    public Circle(int x, int y, int w, int h, Color stroke, Color fill)
    {
        super(x-w/2, y-h/2, w, h);
        this.setFill(fill);
        this.setStroke(stroke);
    }

    @Override
    public void updatePos(int x, int y)
    {
        super.updatePos(x-this.width/2, y-this.height/2);
    }


    @Override
    public void drawShape(Graphics g) {
        //Do 
        g.setColor(_Fill_Color);
        g.fillOval(x_pos,y_pos,width,height);

        if(_has_Stroke) {
            g.setColor(_Stroke_Color);
            g.drawOval(x_pos,y_pos,width,height);
        }
    }
}
