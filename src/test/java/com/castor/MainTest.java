package com.castor;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    void rover_shouldFaceNorth_whenLanded() {
        // GIVEN
        var planet = new Planet(new Vec2Int(10, 10));
        var rover = new Rover();

        // WHEN
        rover.land(planet, new Vec2Int(5, 5));

        // THEN
        assertEquals(rover.getDirection(), Direction.NORTH);
        assertEquals(rover.getCoordinates(), new Vec2Int(5, 5));
    }

    @Test
    void rover_shouldGoForward_whenReceivingForwardCommand() {
        // GIVEN
        var planet = new Planet(new Vec2Int(10, 10));
        var rover = new Rover();
        rover.land(planet, new Vec2Int(5, 5));

        // WHEN
        List<Character> commands = List.of('F');
        rover.sendCommands(commands);

        // THEN
        assertEquals(rover.getDirection(), Direction.NORTH);
        assertEquals(rover.getCoordinates(), new Vec2Int(5, 6));
    }

    @Test
    void rover_shouldFaceWest_whenReceivingLeftCommand() {
        // GIVEN
        var planet = new Planet(new Vec2Int(10, 10));
        var rover = new Rover();
        rover.land(planet, new Vec2Int(5, 5));

        // WHEN
        List<Character> commands = List.of('L');
        rover.sendCommands(commands);

        // THEN
        assertEquals(rover.getDirection(), Direction.WEST);
        assertEquals(rover.getCoordinates(), new Vec2Int(5, 5));
    }

    @Test
    void rover_shouldFaceEast_whenReceivingRightCommand() {
        // GIVEN
        var planet = new Planet(new Vec2Int(10, 10));
        var rover = new Rover();
        rover.land(planet, new Vec2Int(5, 5));

        // WHEN
        List<Character> commands = List.of('R');
        rover.sendCommands(commands);

        // THEN
        assertEquals(rover.getDirection(), Direction.EAST);
        assertEquals(rover.getCoordinates(), new Vec2Int(5, 5));
    }
    
    @Test
    void rover_shouldMoveTwoStepsUp_whenReceivingTwoForwardCommand() {
        // GIVEN
        var planet = new Planet(new Vec2Int(10, 10));
        var rover = new Rover();
        rover.land(planet, new Vec2Int(5, 5));

        // WHEN
        List<Character> commands = List.of('F', 'F');
        rover.sendCommands(commands);

        // THEN
        assertEquals(rover.getDirection(), Direction.NORTH);
        assertEquals(rover.getCoordinates(), new Vec2Int(5, 7));
    }
}
