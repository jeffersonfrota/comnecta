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
        
      /*
        Viewer viewer = new Viewer("00000000059", "Júck", "Júck@gmail.com", 7, "Brasileira", "s", "Estudante");
        boolean result = ViewerDAO.insertViewer(viewer);
        System.out.println(result);
       */
 
        
    }
}
