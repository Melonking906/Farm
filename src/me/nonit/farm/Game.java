package me.nonit.farm;

import me.nonit.farm.things.Grass;
import me.nonit.farm.things.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JPanel
{
    public static final int WINDOW_HEIGHT = 600;
    public static final int WINDOW_WIDTH = 800;

    private static World _world;
    private static InputMaster _inputMaster;

    public Game()
    {
        _world = new World();

        //Create and register the key listener
        _inputMaster = new InputMaster();
        addKeyListener( _inputMaster );
        setFocusable(true);
    }

    public static World getWorld()
    {
        return _world;
    }

    public static InputMaster getInputMaster()
    {
        return _inputMaster;
    }

    private void makeGrass()
    {
        int rows = WINDOW_WIDTH / Grass.getGrassSize();
        int colums = WINDOW_HEIGHT / Grass.getGrassSize();

        boolean colorFlip = false;

        for( int r = 0 ; r < rows ; r++ )
        {
            for( int c = 0 ; c < colums ; c++ )
            {
                Color colorPick;

                if( colorFlip )
                {
                    colorPick = Color.decode( "#4acb58" );
                    colorFlip = false;
                }
                else
                {
                    colorPick = Color.decode( "#3ca949" );
                    colorFlip = true;
                }

                Grass grass = new Grass( r*Grass.getGrassSize(), c*Grass.getGrassSize(), colorPick );

                _world.addThing( grass );
            }

            if( colorFlip )
            {
                colorFlip = false;
            }
            else
            {
                colorFlip = true;
            }
        }
    }

    @Override
    public void paint( Graphics g )
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        ArrayList<RenderObject> renderObjects = _world.getObjectsForRender();

        for( RenderObject renderObject : renderObjects )
        {
            g2d.setColor( renderObject.getColor() );
            g2d.fill( renderObject.getShape() );
        }
    }

    public static void main( String[] args ) throws InterruptedException
    {
        JFrame frame = new JFrame("Farm");
        Game game = new Game();
        frame.add( game );
        frame.setSize( WINDOW_WIDTH, WINDOW_HEIGHT );
        frame.setVisible(true);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //Generate grass objects at game startup
        game.makeGrass();
        _world.addThing( new Player() );

        while( true )
        {
            game.repaint();
            Thread.sleep(10);
        }
    }
}
