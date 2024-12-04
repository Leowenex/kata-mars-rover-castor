package com.castor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Planet {

    private Vec2Int boundaries;
    private List<Obstacle> obstacles;

    public Planet(Vec2Int boundaries) {
        this.boundaries = boundaries;
        this.obstacles = new ArrayList<>();
    }

    public void putObstacle(Obstacle obstacle) {
        this.obstacles.add(obstacle);
    }

    public boolean hasObstacle(Vec2Int targetPos) {
        for (Obstacle obstacle : this.obstacles) {
            if (obstacle.coordinates().equals(targetPos)) {
                return true;
            }
        }
        return false;
    }
}
