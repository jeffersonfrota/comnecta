package com.example;

import static org.junit.Assert.assertNotNull;

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
    
}
