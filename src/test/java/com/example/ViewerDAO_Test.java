package com.example;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;
import com.example.util.models.Viewer;
import com.example.util.modelsDAO.ViewerDAO;

public class ViewerDAO_Test {
    @Test
    public void getViewersTest(){
        ArrayList<Viewer> viewers = ViewerDAO.getViewers();
        assertNotNull(viewers);
    }

    @Test
    public void insertViewerTest(){
        Viewer viewer = new Viewer("000000000720", "Jeff", "Jeff@gmail.com", 7, "Brasileira", "s", "Estudante");
        boolean result = ViewerDAO.insertViewer(viewer);
        System.out.println(result);
        assertTrue(result);
    }
    
}
