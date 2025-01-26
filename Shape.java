import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
    //Draw shape calls g.fill/draw
    public abstract void drawShape(Graphics g);


    protected Color _Stroke_Color;
    protected Color _Fill_Color;
    protected boolean _has_Stroke;
    
    protected int width;
    protected int height;
    protected int x_pos;
    protected int y_pos;

    public int getX()
    {
        return x_pos;
    }
    public int getY()
    {
        return y_pos;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }


    public Shape(int x, int y, int w, int h)
    {
        x_pos = x;
        y_pos = y;
        width = w;
        height = h;
        _Stroke_Color = Color.BLACK;
        _Fill_Color = Color.WHITE;
        _has_Stroke = false;
    }



    public void updatePos(int x, int y)
    {
        x_pos = x;
        y_pos = y;
    }

    public void updateWidth(int w)
    {
        width = w;
    }
    public void updateHeight(int h)
    {
        height = h;
    }

    public void setStroke(Color color)
    {
        _has_Stroke = true;
        _Stroke_Color = color;
    }

    public void removeStroke(){
        _has_Stroke = false;
    }
    
    public void setFill(Color color)
    {
        _Fill_Color = color;
    }
    
    
}
