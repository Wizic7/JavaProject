import java.awt.Graphics;
import java.awt.Color;


public class Square extends Shape{
    
    public Square(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }
    public Square(int x, int y, int w, int h, Color stroke, Color fill)
    {
        super(x, y, w, h);
        this.setFill(fill);
        this.setStroke(stroke);
    }


    @Override
    public void drawShape(Graphics g) {
        //Do 
        g.setColor(_Fill_Color);
        g.fillRect(x_pos,y_pos,width,height);

        if(_has_Stroke) {
            g.setColor(_Stroke_Color);
            g.drawRect(x_pos,y_pos,width,height);
        }
    }
}
