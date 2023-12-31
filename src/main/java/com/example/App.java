package com.example;

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
        
    }
}
