package com.sleeper.transform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sleeper.transform.models.League;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SleeperClientTests {
    
    @Test
    void testGetLeagueData() throws Exception {
        // Arrange
        String json = "{\n" +
            "  \"league_id\": \"123\",\n" +
            "  \"name\": \"Test League\",\n" +
            "  \"total_rosters\": 12,\n" +
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
        
        ObjectMapper mapper = new ObjectMapper();
        
        // Replace with your actual client class and constructor
        SleeperClient client = new SleeperClient(mockClient, "12345");
        
        // Act
        League league = client.getLeagueData();
        
        // Assert
        assertEquals("123", league.getLeagueId());
        assertEquals("Test League", league.getName());
        assertEquals(12, league.getTotalRosters());
    }
    
}
