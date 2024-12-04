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
        for (Character command : commands) {
            switch (command) {
                case 'F':
                    moveForward();
                    break;
                case 'B':
                    moveBackward();
                    break;
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
            }
        }
    }

    private void moveForward() {
        Vec2Int movement = this.direction.getForwardVector();
        coordinates.add(movement);
    }

    private void moveBackward() {
        Vec2Int movement = this.direction.getForwardVector().getOpposite();
        coordinates.add(movement);
    }

    private void turnLeft() {
        direction = direction.getLeft(direction);
    }

    private void turnRight() {
        direction = direction.getRight(direction);
    }
}
