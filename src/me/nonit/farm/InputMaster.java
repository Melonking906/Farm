package me.nonit.farm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class InputMaster implements KeyListener
{
    public enum Inputs
    {
        FIRE    ( ' ' ),
        FORWARD ( 'w' ),
        BACK    ( 's' ),
        LEFT    ( 'a' ),
        RIGHT   ( 'd' );

        private final char input;
        Inputs( char input )
        {
            this.input = input;
        }

        public final char getValue()
        {
            return input;
        }
    }

    private ArrayList<Inputs> activeInputs;

    public InputMaster()
    {
        activeInputs = new ArrayList<>();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        for( Inputs input : Inputs.values() )
        {
            if( input.getValue() == e.getKeyChar() )
            {
                activeInputs.add( input );
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        for( Inputs input : Inputs.values() )
        {
            if( input.getValue() == e.getKeyChar() )
            {
                activeInputs.remove( input );
                break;
            }
        }
    }

    public ArrayList<Inputs> getActiveInputs()
    {
        return activeInputs;
    }
}
