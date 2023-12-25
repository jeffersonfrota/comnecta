package com.example;

import com.example.util.models.Streamer;
import com.example.util.models.Viewer;
import com.example.util.modelsDAO.*;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Viewer> viewers = ViewerDAO.getViewers();
        
        for(Viewer v : viewers){
            System.out.print(v.toString());
        }

        ArrayList<Streamer> streamers = StreamerDAO.getStreamers();

          for(Streamer s : streamers){
            System.out.print(s.toString());
        }


        Viewer viewer = new Viewer("00000000072", "Jeff", "Jeff@gmail.com", 7, "Brasileira", "s", "Estudante");
        boolean result = ViewerDAO.insertViewer(viewer);
        System.out.println(result);

    }
}
