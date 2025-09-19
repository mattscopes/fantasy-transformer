package com.fantasy.transformer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpClient;

public class TransformerServiceTests {
    private SleeperClient sleeperClient;
    private TransformerService transformerService;

    @BeforeEach
    void setUp() {
        sleeperClient = new SleeperClient(HttpClient.newHttpClient());
        transformerService = new TransformerService();
        // Inject SleeperClient into TransformerService using reflection
        try {
            var field = TransformerService.class.getDeclaredField("sleeperClient");
            field.setAccessible(true);
            field.set(transformerService, sleeperClient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
//    void testGetLeague_returnsOrException() {
//        try {
//            Object result = transformerService.getLeague("");
//            System.out.println("getLeague return: " + result.toString());
//        } catch (Exception e) {
//            System.out.println("getLeague threw exception: " + e);
//        }
//    }
//
//    @Test
//    void testGetRosters_returnsOrException() {
//        try {
//            Object result = transformerService.getRosters("");
//            System.out.println("getRosters return: " + result.toString());
//        } catch (Exception e) {
//            System.out.println("getRosters threw exception: " + e);
//        }
//    }
//
//    @Test
//    void testGetUsers_returnsOrException() {
//        try {
//            Object result = transformerService.getUsers("");
//            System.out.println("getUsers return: " + result.toString());
//        } catch (Exception e) {
//            System.out.println("getUsers threw exception: " + e);
//        }
//    }
//
//    @Test
//    void testGetPlayers_returnsOrException() throws IOException, InterruptedException {
//        try {
//            Object result = transformerService.getPlayers();
//            System.out.println("getPlayers return: " + result.toString());
//        } catch (Exception e) {
//            throw e;
//        }
//    }
}
