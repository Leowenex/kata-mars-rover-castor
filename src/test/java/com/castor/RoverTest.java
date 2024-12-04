package com.castor;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void rover_shouldFaceNorth_whenLanded() {
        // GIVEN
        var planet = new Planet(new Vec2Int(10, 10));
        var rover = new Rover();

        // WHEN
        rover.land(planet, new Vec2Int(5, 5));

        // THEN
        assertEquals(Direction.NORTH, rover.getDirection());
        assertEquals(new Vec2Int(5, 5), rover.getCoordinates());
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
        assertEquals(Direction.NORTH, rover.getDirection());
        assertEquals(new Vec2Int(5, 6), rover.getCoordinates());
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
        assertEquals(Direction.WEST, rover.getDirection());
        assertEquals(new Vec2Int(5, 5), rover.getCoordinates());
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
        assertEquals(Direction.EAST, rover.getDirection());
        assertEquals(new Vec2Int(5, 5), rover.getCoordinates());
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
        assertEquals(Direction.NORTH, rover.getDirection());
        assertEquals(new Vec2Int(5, 7), rover.getCoordinates());
    }

    @Test
    void rover_shouldFaceWest_whenMovingInCircleClockwise() {
        // GIVEN
        var planet = new Planet(new Vec2Int(10, 10));
        var rover = new Rover();
        rover.land(planet, new Vec2Int(5, 5));

        // WHEN
        List<Character> commands = List.of('F', 'R', 'F', 'R', 'F', 'R', 'F');
        rover.sendCommands(commands);

        // THEN
        assertEquals(Direction.WEST, rover.getDirection());
        assertEquals(new Vec2Int(5, 5), rover.getCoordinates());
    }

    @Test
    void rover_shouldFaceEast_whenReceivingForwardCommandEastwards() {
        // GIVEN
        var planet = new Planet(new Vec2Int(10, 10));
        var rover = new Rover();
        rover.land(planet, new Vec2Int(5, 5));
        rover.setDirection(Direction.EAST);

        // WHEN
        List<Character> commands = List.of('F');
        rover.sendCommands(commands);

        // THEN
        assertEquals(Direction.EAST, rover.getDirection());
        assertEquals(new Vec2Int(6, 5), rover.getCoordinates());
    }

    @Test
    void rover_shouldGoOnOppositeHorizontalBorder_whenMovingOutOfHorizontalBounds() {
        // GIVEN
        var planet = new Planet(new Vec2Int(10, 10));
        var rover = new Rover();
        rover.land(planet, new Vec2Int(0, 0));
        rover.setDirection(Direction.WEST);

        // WHEN
        List<Character> commands = List.of('F');
        rover.sendCommands(commands);

        // THEN
        assertEquals(Direction.WEST, rover.getDirection());
        assertEquals(new Vec2Int(9, 0), rover.getCoordinates());
    }

    @Test
    void rover_shouldGoOnOppositeVerticalBorder_whenMovingOutOfVerticalBounds() {
        // GIVEN
        var planet = new Planet(new Vec2Int(10, 10));
        var rover = new Rover();
        rover.land(planet, new Vec2Int(0, 0));
        rover.setDirection(Direction.SOUTH);

        // WHEN
        List<Character> commands = List.of('F');
        rover.sendCommands(commands);

        // THEN
        assertEquals(Direction.SOUTH, rover.getDirection());
        assertEquals(new Vec2Int(0, 9), rover.getCoordinates());
    }

    @Test
    void rover_shouldStaySamePosition_whenObstacleIsOnTheWay() {
        // GIVEN
        var planet = new Planet(new Vec2Int(10, 10));
        planet.putObstacle(new Obstacle(new Vec2Int(6, 5)));
        var rover = new Rover();
        rover.land(planet, new Vec2Int(5, 5));
        rover.setDirection(Direction.EAST);

        // WHEN
        List<Character> commands = List.of('F');
        rover.sendCommands(commands);

        // THEN
        assertEquals(Direction.EAST, rover.getDirection());
        assertEquals(new Vec2Int(5, 5), rover.getCoordinates());
    }

    @Test
    void rover_cuttingCommandSequence_whenObstacleIsOnTheWay() {
        // GIVEN
        var planet = new Planet(new Vec2Int(10, 10));
        planet.putObstacle(new Obstacle(new Vec2Int(6, 5)));
        var rover = new Rover();
        rover.land(planet, new Vec2Int(5, 5));
        rover.setDirection(Direction.EAST);

        // WHEN
        List<Character> commands = List.of('F', 'F', 'L', 'F', 'R');
        rover.sendCommands(commands);

        // THEN
        assertEquals(Direction.EAST, rover.getDirection());
        assertEquals(new Vec2Int(5, 5), rover.getCoordinates());
    }
}
