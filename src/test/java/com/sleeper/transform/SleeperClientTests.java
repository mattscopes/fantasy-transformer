package com.sleeper.transform;

import com.sleeper.transform.models.nfl.sleeper.SleeperLeague;
import com.sleeper.transform.models.nfl.sleeper.SleeperRoster;
import com.sleeper.transform.models.nfl.sleeper.SleeperPlayer;
import com.sleeper.transform.models.nfl.sleeper.SleeperState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SleeperClientTests {
    
    @Test
    void testSuccessfulQueryFromSleeper() throws Exception {
        assertDoesNotThrow(() -> {
            SleeperClient sleeperClient = new SleeperClient(HttpClient.newHttpClient());
            sleeperClient.getState("nfl");
        });
    }
    
    @Test
    void testGetLeague() throws Exception {
        // Arrange
        String json = "{\n" +
            "  \"league_id\": \"123\",\n" +
            "  \"name\": \"Test League\",\n" +
            "  \"total_rosters\": 12,\n" +
            "  \"last_message_time\": 1726274930594,\n" +
            "  \"metadata\": {\n" +
            "    \"auto_continue\": \"on\",\n" +
            "    \"continued\": \"yes\",\n" +
            "    \"keeper_deadline\": \"0\",\n" +
            "    \"latest_league_winner_roster_id\": \"7\",\n" +
            "    \"trophy_loser\": \"loser3\",\n" +
            "    \"trophy_loser_background\": \"apple\",\n" +
            "    \"trophy_loser_banner_text\": \"LOWER BRACKET\"\n" +
            "  }\n" +
            "}";
        HttpClient mockClient = Mockito.mock(HttpClient.class);
        HttpResponse<String> mockResponse = Mockito.mock(HttpResponse.class);
        Mockito.when(mockResponse.body()).thenReturn(json);
        Mockito.when(mockClient.send(Mockito.any(HttpRequest.class), Mockito.any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);
        
        SleeperClient client = new SleeperClient(mockClient);
        
        // Act
        SleeperLeague sleeperLeague = client.getLeague("123");
        
        // Assert
        assertEquals("123", sleeperLeague.getLeagueId());
        assertEquals("Test League", sleeperLeague.getName());
        assertEquals(Instant.parse("2024-09-14T00:48:50.594Z"), sleeperLeague.getLastMessageTime());
        assertEquals(12, sleeperLeague.getTotalRosters());
    }
    
    @Test
    void testGetRosters() throws Exception {
        // Arrange
        String json = "[{ \"roster_id\": 1, \"league_id\": \"123\", \"owner_id\": \"owner1\" }]";
        HttpClient mockClient = Mockito.mock(HttpClient.class);
        HttpResponse<String> mockResponse = Mockito.mock(HttpResponse.class);
        Mockito.when(mockResponse.body()).thenReturn(json);
        Mockito.when(mockClient.send(Mockito.any(HttpRequest.class), Mockito.any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);
        
        SleeperClient client = new SleeperClient(mockClient);
        
        // Act
        List<SleeperRoster> sleeperRosters = client.getRosters("123");
        
        // Assert
        assertEquals(1, sleeperRosters.get(0).getRosterId());
        assertEquals("123", sleeperRosters.get(0).getLeagueId());
        assertEquals("owner1", sleeperRosters.get(0).getOwnerId());
    }
    
    @Test
    void testGetPlayers() throws Exception {
        // Arrange
        String json = "{ \"1352\": { \"player_id\": \"1352\", \"first_name\": \"Robert\", \"last_name\": \"Woods\" }, \"6462\": { \"player_id\": \"6462\", \"first_name\": \"Ellis\", \"last_name\": \"Richardson\" } }";
        HttpClient mockClient = Mockito.mock(HttpClient.class);
        HttpResponse<String> mockResponse = Mockito.mock(HttpResponse.class);
        Mockito.when(mockResponse.body()).thenReturn(json);
        Mockito.when(mockClient.send(Mockito.any(HttpRequest.class), Mockito.any(HttpResponse.BodyHandler.class)))
            .thenReturn(mockResponse);
        
        SleeperClient client = new SleeperClient(mockClient);
        
        // Act
        Map<String, SleeperPlayer> sleeperPlayersById = client.getPlayers("nfl");
        
        // Assert
        assertEquals(2, sleeperPlayersById.size());
        assertEquals("Robert", sleeperPlayersById.get("1352").getFirstName());
        assertEquals("Woods", sleeperPlayersById.get("1352").getLastName());
        assertEquals("Ellis", sleeperPlayersById.get("6462").getFirstName());
        assertEquals("Richardson", sleeperPlayersById.get("6462").getLastName());
    }
    
}
