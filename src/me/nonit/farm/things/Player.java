package me.nonit.farm.things;

import me.nonit.farm.InputMaster;
import me.nonit.farm.RenderObject;

import java.awt.*;

public class Player extends Thing
{
    private int x;
    private int y;

    public Player()
    {
        super( "player" );

        x = 200;
        y = 200;
    }

    private void move()
    {
        if( isKeyDown(InputMaster.Inputs.FORWARD ) )
        {
            y = y - 5;
        }
        if( isKeyDown(InputMaster.Inputs.BACK ) )
        {
            y = y + 5;
        }
        if( isKeyDown(InputMaster.Inputs.RIGHT ) )
        {
            x = x + 5;
        }
        if( isKeyDown(InputMaster.Inputs.LEFT ) )
        {
            x = x - 5;
        }

        wait( 20 );
    }

    @Override
    protected void main()
    {
        move();

        renderObjects.clear();
        renderObjects.add( new RenderObject( new Rectangle( x, y, 40, 40 ), Color.black, 1 ) );

        wait( 10 );
    }
}
