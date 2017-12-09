package me.nonit.farm.things;

import me.nonit.farm.RenderObject;

import java.awt.*;

public class Grass extends Thing
{
    private static final int GRASS_SIZE = 20;

    protected Color color;
    private int x;
    private int y;

    public Grass( int x, int y, Color color )
    {
        super( "grass" );

        this.color = color;
        this.x = x;
        this.y = y;

        regenerateRenderObject();
    }

    private void regenerateRenderObject()
    {
        Rectangle rectangle = new Rectangle( x, y, GRASS_SIZE, GRASS_SIZE );

        RenderObject grassObject = new RenderObject( rectangle, color );

        renderObjects.clear();
        renderObjects.add( grassObject );
    }

    public static int getGrassSize()
    {
        return GRASS_SIZE;
    }

    @Override
    protected void main()
    {
        wait( 1000 );
    }
}