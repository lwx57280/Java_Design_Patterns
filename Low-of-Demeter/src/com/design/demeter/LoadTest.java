package com.design.demeter;

public class LoadTest {

    public static void main(String[] args) {
        TeamLeader teamLeader =new TeamLeader();
        Employee employee = new Employee();
        teamLeader.commandCheckNumber(employee);

    }
}
