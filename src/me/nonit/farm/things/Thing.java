package me.nonit.farm.things;

import me.nonit.farm.Game;
import me.nonit.farm.InputMaster;
import me.nonit.farm.RenderObject;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Thing extends Thread
{
    private final String name;
    private final UUID id;

    private boolean isDead;

    protected ArrayList<RenderObject> renderObjects;

    public Thing( String name )
    {
        this.name = name;

        id = UUID.randomUUID();
        isDead = false;

        renderObjects = new ArrayList<>();

        //Start the things thread
        this.start();
    }

    public void kill()
    {
        isDead = true;
    }

    public boolean isDead()
    {
        return isDead;
    }

    public ArrayList<RenderObject> getRenderObjects()
    {
        return renderObjects;
    }

    public String getTName()
    {
        return name;
    }

    public UUID getTId()
    {
        return id;
    }

    public boolean isKeyDown( InputMaster.Inputs input )
    {
        return Game.getInputMaster().getActiveInputs().contains( input );
    }

    //Handy shorthand for sleep without needing the try catch
    protected void wait( int milliseconds )
    {
        try
        {
            sleep( milliseconds );
        }
        catch( InterruptedException e ) {}
    }

    protected abstract void main();

    @Override
    public void run()
    {
        while( !isDead )
        {
            main();
        }
    }
}