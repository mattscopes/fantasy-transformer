package com.fantasy.transformer.models.internal;

import java.util.List;

public class Player {

    private String firstName;
    private String lastName;
    private List<String> positions;
    private String team;
    private Integer number;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Player{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", positions=" + positions +
            ", team='" + team + '\'' +
            ", number=" + number +
            '}';
    }
}
