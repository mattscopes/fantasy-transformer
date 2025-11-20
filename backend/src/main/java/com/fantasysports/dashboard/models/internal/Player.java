package com.fantasysports.dashboard.models.internal;

import java.util.List;

public class Player {

    private String firstName;
    private String lastName;
    private List<String> positions;
    private String team;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


    @Override
    public String toString() {
        return "Player{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", positions=" + positions +
            ", team='" + team + '\'' +
            '}';
    }
}
