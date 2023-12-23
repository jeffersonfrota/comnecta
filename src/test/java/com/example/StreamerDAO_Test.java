package com.example;

import static org.junit.Assert.assertNotNull;
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
    }
}
