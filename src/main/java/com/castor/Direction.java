package com.castor;

import lombok.Getter;

@Getter
public enum Direction {
    NORTH,
    SOUTH,
    WEST,
    EAST;
    
    public Direction getLeft(Direction direction) {
        return switch (direction) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
        };
    }
    
    public Direction getRight(Direction direction) {
        return switch (direction) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
        };
    }

    public Vec2Int getForwardVector() {
        return switch (this) {
            case NORTH -> new Vec2Int(0, 1);
            case SOUTH -> new Vec2Int(0, -1);
            case WEST -> new Vec2Int(-1, 0);
            case EAST -> new Vec2Int(1, 0);
        };
    }
}
