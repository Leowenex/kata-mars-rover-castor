package com.castor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Rover {

    private Vec2Int coordinates;

    private Planet planet;

    private Direction direction = Direction.NORTH;

    public void land(Planet planet, Vec2Int coordinates) {
        this.planet = planet;
        this.coordinates = coordinates;
    }

    public void sendCommands(List<Character> commands) {
        boolean commandSuccess = true;
        for (Character command : commands) {
            switch (command) {
                case 'F':
                    commandSuccess = moveForward();
                    break;
                case 'B':
                    commandSuccess = moveBackward();
                    break;
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
            }
            if (!commandSuccess) {
                break;
            }
        }
    }

    private boolean moveForward() {
        Vec2Int movement = this.direction.getForwardVector();
        Vec2Int targetCoord = Vec2Int.add(coordinates, movement);
        if (planet.hasObstacle(targetCoord)) {
            return false;
        }
        this.coordinates = targetCoord;
        checkBoundaries();
        return true;
    }

    private boolean moveBackward() {
        Vec2Int movement = this.direction.getForwardVector().getOpposite();
        Vec2Int targetCoord = Vec2Int.add(coordinates, movement);
        if (planet.hasObstacle(targetCoord)) {
            return false;
        }
        this.coordinates = targetCoord;
        checkBoundaries();
        return true;
    }

    private void checkBoundaries() {
        if (coordinates.getX() < 0) {
            coordinates.setX(planet.getBoundaries().getX() - 1);
        }
        if (coordinates.getX() >= planet.getBoundaries().getX()) {
            coordinates.setX(0);
        }
        if (coordinates.getY() < 0) {
            coordinates.setY(planet.getBoundaries().getY() - 1);
        }
        if (coordinates.getY() >= planet.getBoundaries().getY()) {
            coordinates.setY(0);
        }
    }

    private void turnLeft() {
        direction = direction.getLeft(direction);
    }

    private void turnRight() {
        direction = direction.getRight(direction);
    }
}
