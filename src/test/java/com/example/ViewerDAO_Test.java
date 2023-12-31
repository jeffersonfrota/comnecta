package com.example;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;
import com.example.util.models.Viewer;
import com.example.util.modelsDAO.ViewerDAO;

public class ViewerDAO_Test {
    @Test
    public void getViewersTest() {
        ArrayList<Viewer> viewers = ViewerDAO.getViewers();
        assertNotNull(viewers);
        assertNotEquals(0, viewers.size());
    }

    @Test
    public void insertViewerTest(){
        Viewer viewer = new Viewer("00000000090", "Jess", "Jess@gmail.com", 6, "Brasileira", "n", "adora estudar");
        boolean result = ViewerDAO.insertViewer(viewer);
        System.out.println(result);
        assertTrue(result);
    }

    @Test
    public void updateViewerTest(){
        Viewer viewer = new Viewer("00000000090", "Júlie", "Júlie@gmail.com", 7, "Argentina", "s", "Estudante");
        boolean result = ViewerDAO.updateViewer(viewer);
        System.out.println(result);
        assertTrue(result);
    }

    @Test
    public void removeViewerTest(){
        Viewer viewer = new Viewer("00000000090", "Jeff", "Jeff@gmail.com", 7, "Brasileira", "s", "Estudante");
        boolean result = ViewerDAO.removeViewer(viewer);
        System.out.println(result);
        assertTrue(result);
    }
    
}
