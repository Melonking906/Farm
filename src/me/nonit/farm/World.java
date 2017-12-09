package me.nonit.farm;

import me.nonit.farm.things.Thing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class World
{
    private ArrayList<Thing> things;

    public World()
    {
        things = new ArrayList<>();
    }

    public void addThing( Thing thing )
    {
        things.add( thing );
    }

    public ArrayList<RenderObject> getObjectsForRender()
    {
        ArrayList<RenderObject> renderObjects = new ArrayList<>();

        for( Thing thing : things )
        {
            for( RenderObject thingsRenderObject : thing.getRenderObjects() )
            {
                renderObjects.add( thingsRenderObject );
            }
        }

        Collections.sort( renderObjects, new LayerComparator() );

        return renderObjects;
    }

    //Comparator sorts RenderObjects by their layer so background is loaded first and so on.
    public class LayerComparator implements Comparator<RenderObject>
    {
        @Override
        public int compare(RenderObject r1, RenderObject r2)
        {
            return r1.getLayer() - r2.getLayer();
        }
    }
}