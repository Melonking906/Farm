package me.nonit.farm;

import java.awt.*;

public class RenderObject
{
    private Shape shape;
    private Color color;
    private int layer;

    public RenderObject()
    {
        this.shape = new Rectangle( 0, 0, 10, 10 );
        this.color = Color.black;
        this.layer = 0;
    }

    public RenderObject( Shape shape )
    {
        this.shape = shape;
        this.color = Color.black;
        this.layer = 0;
    }

    public RenderObject( Shape shape, int layer )
    {
        this.shape = shape;
        this.color = Color.black;
        this.layer = layer;
    }

    public RenderObject( Shape shape, Color color )
    {
        this.shape = shape;
        this.color = color;
        this.layer = 0;
    }

    public RenderObject( Shape shape, Color color, int layer )
    {
        this.shape = shape;
        this.color = color;
        this.layer = layer;
    }

    public Shape getShape()
    {
        return shape;
    }

    public void setShape(Shape shape)
    {
        this.shape = shape;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public int getLayer()
    {
        return layer;
    }

    public void setLayer(int layer)
    {
        this.layer = layer;
    }
}
