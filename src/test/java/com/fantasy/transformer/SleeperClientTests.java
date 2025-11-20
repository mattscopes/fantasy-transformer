package com.fantasy.transformer;

import com.fantasy.transformer.models.sleeper.SleeperLeague;
import com.fantasy.transformer.models.sleeper.SleeperRoster;
import com.fantasy.transformer.models.sleeper.SleeperPlayer;
import com.fantasy.transformer.models.sleeper.SleeperUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

public class SleeperClientTests {

    private SleeperClient client;

    @BeforeEach
    void setUp() {
        client = new SleeperClient(HttpClient.newHttpClient());
    }

    @Test
    void testSuccessfulQueryFromSleeper() throws Exception {
        assertDoesNotThrow(() -> {
            client.getState("nfl");
        });
    }
    
    @Test
    void testGetLeague() throws Exception {
        SleeperClient client = createMockedClientFromJson("src/test/resources/sleeper-client-tests/test-league.json");
        SleeperLeague sleeperLeague = client.getLeague("123");
        assertEquals("1274146033739247616", sleeperLeague.getLeagueId());
        assertEquals("test", sleeperLeague.getName());
        assertEquals("2025", sleeperLeague.getSeason());
        assertEquals(8, sleeperLeague.getTotalRosters());
    }

    @Test
    void testGetUsers() throws Exception {
        SleeperClient client = createMockedClientFromJson("src/test/resources/sleeper-client-tests/test-users.json");
        List<SleeperUser> sleeperUsers = client.getUsers("123");
        assertEquals(3, sleeperUsers.size());
        assertEquals("34576657345345657", sleeperUsers.get(0).getUserId());
        assertEquals("ham123", sleeperUsers.get(0).getDisplayName());
        assertEquals("5324532464574566", sleeperUsers.get(1).getUserId());
        assertEquals("fake123", sleeperUsers.get(1).getDisplayName());
        assertEquals("C.S. Disguise & Vacuum", sleeperUsers.get(1).getMetadata().getTeamName());
        assertNull(sleeperUsers.get(0).getMetadata().getTeamName());
    }
    
    @Test
    void testGetRosters() throws Exception {
        SleeperClient client = createMockedClientFromJson("src/test/resources/sleeper-client-tests/test-rosters.json");
        List<SleeperRoster> sleeperRosters = client.getRosters("123");
        assertEquals(1, sleeperRosters.get(0).getRosterId());
        assertEquals("1234567890", sleeperRosters.get(0).getLeagueId());
        assertEquals("12345", sleeperRosters.get(0).getOwnerId());
    }

    @Test
    void testGetPlayers() throws Exception {
        SleeperClient client = createMockedClientFromJson("src/test/resources/sleeper-client-tests/test-players.json");
        Map<String, SleeperPlayer> sleeperPlayersById = client.getPlayers("nfl");
        assertEquals(3, sleeperPlayersById.size());
        assertEquals("Ellis", sleeperPlayersById.get("6462").getFirstName());
        assertEquals("Richardson", sleeperPlayersById.get("6462").getLastName());
        assertEquals("Malkelm", sleeperPlayersById.get("8842").getFirstName());
        assertEquals("Morrison", sleeperPlayersById.get("8842").getLastName());
    }

    @Test
    void testSuccessfulGetPlayersromSleeper() throws Exception {
        assertDoesNotThrow(() -> {
            client.getPlayers("nfl");
        });
    }

    private SleeperClient createMockedClientFromJson(String jsonFilePath) throws Exception {
        String json = Files.readString(Paths.get(jsonFilePath));
        HttpClient mockClient = Mockito.mock(HttpClient.class);
        HttpResponse<String> mockResponse = Mockito.mock(HttpResponse.class);
        Mockito.when(mockResponse.body()).thenReturn(json);
        Mockito.when(mockClient.send(Mockito.any(HttpRequest.class), Mockito.any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);
        return new SleeperClient(mockClient);
    }

}
