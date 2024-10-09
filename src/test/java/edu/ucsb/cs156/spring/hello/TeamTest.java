package edu.ucsb.cs156.spring.hello;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
        team.addMember("Viraj");
        team.addMember("Vincent");
        team.addMember("Jun");
        team.addMember("Scott");
        team.addMember("Raymond");
        team.addMember("Cameron");
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Team(name=test-team, members=[Viraj, Vincent, Jun, Scott, Raymond, Cameron])", team.toString());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void test_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void test_different_classes() {
        String s = "team 1";
        assertFalse(team.equals(s));
    }

    @Test
    public void test_same_team_different_members() {
        Team t = new Team("test-team");
        team.addMember("Foo");
        team.addMember("Bar");
        assertFalse(team.equals(t));
    }

    @Test
    public void test_same_team_same_members() {
        Team t2 = new Team("test-team");
        t2.addMember("Viraj");
        t2.addMember("Vincent");
        t2.addMember("Jun");
        t2.addMember("Scott");
        t2.addMember("Raymond");
        t2.addMember("Cameron");
        assertTrue(team.equals(t2));
    }

    @Test
    public void test_different_team_different_members() {
        Team t3 = new Team("team-3");
        t3.addMember("Bob");
        assertFalse(team.equals(t3));
    }

    @Test
    public void test_hash_code_values() {
        ArrayList<String> first = new ArrayList<>();
        first.add("Bob");
        first.add("John");
        first.add("Carol");

        ArrayList<String> second = new ArrayList<>();
        second.add("Ben");
        second.add("Chris");
        second.add("Frank");

        Team t1 = new Team("team1");
        Team t2 = new Team("team1");
        Team t3 = new Team("team3");
        Team t4 = new Team("team1");

        t1.setMembers(first);
        t2.setMembers(first);
        t3.setMembers(second);
        t4.setMembers(second);

        assertEquals(t1.hashCode(), t2.hashCode());
        assertNotEquals(t2.hashCode(), t3.hashCode());
        assertNotEquals(t3.hashCode(), t4.hashCode());
        assertNotEquals(t1.hashCode(), t3.hashCode());
    }
}
