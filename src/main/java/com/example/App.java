package com.example;

import com.example.recuperaDadosBD.*;
import com.example.util.Streamer;
import com.example.util.Viewer;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Viewer> viewers = recuperaDadosBD.recuperaViewers();
        
        for(Viewer v : viewers){
            System.out.print(v.toString());
        }

       
        ArrayList<Streamer> streamers = recuperaDadosBD.recuperaStreamers();

          for(Streamer s : streamers){
            System.out.print(s.toString());
        }
    

       

    }
}
