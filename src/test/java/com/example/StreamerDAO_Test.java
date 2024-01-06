package com.example;


import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;

import com.example.util.models.Streamer;
import com.example.util.modelsDAO.StreamerDAO;


public class StreamerDAO_Test {
    
    @Test
    public void getStreamersTest()
    {
        ArrayList<Streamer> streamers = StreamerDAO.getStreamers();
        assertNotNull(streamers);
        assertNotEquals(0, streamers.size());
    }
    @Test
    public void insertStreamerTest(){
        Streamer streamer = new Streamer("00000000090", "Jess", "Jess@gmail.com", 6, "Brasileira", "n", "adora estudar", 5);
        boolean result = StreamerDAO.insertStreamer(streamer);
        System.out.println(result);
        assertTrue(result);
    }
    
    @Test
    public void updateStreamerTest(){
        Streamer streamer = new Streamer("00000000090", "Júlie", "Júlie@gmail.com", 7, "Argentina", "s", "Estudante", 9);
        boolean result = StreamerDAO.updateStreamer(streamer);
        System.out.println(result);
        assertTrue(result);
    }

    @Test
    public void removeStreamerTest(){
        Streamer streamer = new Streamer("00000000090", "Jeff", "Jeff@gmail.com", 7, "Brasileira", "s", "Estudante", 0);
        boolean result = StreamerDAO.removeStreamer(streamer);
        System.out.println(result);
        assertTrue(result);
    }
}
