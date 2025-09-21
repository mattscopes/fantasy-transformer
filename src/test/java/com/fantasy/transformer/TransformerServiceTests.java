package com.fantasy.transformer;

import com.fantasy.transformer.models.sleeper.SleeperUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransformerServiceTests {
    private SleeperClient sleeperClient;
    private TransformerService transformerService;

//    @BeforeEach
//    void setUp() {
//        sleeperClient = new SleeperClient(HttpClient.newHttpClient());
//        transformerService = new TransformerService();
//        // Inject SleeperClient into TransformerService using reflection
//        try {
//            var field = TransformerService.class.getDeclaredField("sleeperClient");
//            field.setAccessible(true);
//            field.set(transformerService, sleeperClient);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Test
//    void test() throws IOException, InterruptedException {
//
//        getUsers(null);
//
//    }
//
//    public List<User> getUsers(List<SleeperUser> sleeperUsers) throws IOException, InterruptedException {
//        List<User> users =  Optional.ofNullable(sleeperUsers)
//            .orElse(Collections.emptyList())
//            .stream()
//            .filter(Objects::nonNull)
//            .map(su -> {
//                User user = new User();
//                Optional.ofNullable(su.getUserId())
//                    .ifPresent(user::setId);
//                Optional.ofNullable(su.getDisplayName())
//                    .ifPresent(user::setName);
//                Optional.ofNullable(su.getMetadata())
//                    .map(meta -> meta.getTeamName())
//                    .ifPresent(user::setTeamName);
//                return user;
//            })
//            .collect(Collectors.toList());
//
//        System.out.println(users);
//        return users;
//    }

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
