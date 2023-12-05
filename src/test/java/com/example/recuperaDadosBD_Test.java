package com.example;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import com.example.recuperaDadosBD.recuperaDadosBD;
import com.example.util.Streamer;
import com.example.util.Viewer;

public class recuperaDadosBD_Test 
{
    @Test
    public void recuperaViewersTest()
    {
        ArrayList<Viewer> viewers = recuperaDadosBD.recuperaViewers();
        assertNotNull(viewers);
    }

    @Test
    public void recuperaStreamersTest(){
        ArrayList<Streamer> streamers = recuperaDadosBD.recuperaStreamers();
        assertNotNull(streamers);
    }
}
