package com.castor;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Vec2Int{
    int x;
    int y;

    public void addX(int x) {
        this.x += x;
    }
    
    public void addY(int y) {
        this.y += y;
    }

    public void add(Vec2Int vec) {
        this.x += vec.x;
        this.y += vec.y;
    }

    public Vec2Int getOpposite() {
        return new Vec2Int(-this.x, -this.y);
    }
}
