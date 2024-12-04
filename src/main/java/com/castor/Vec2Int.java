package com.castor;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Vec2Int{
    int x;
    int y;

    public static Vec2Int add(Vec2Int vec1, Vec2Int vec2) {
        return new Vec2Int(vec1.x + vec2.x, vec1.y + vec2.y);
    }

    public Vec2Int getOpposite() {
        return new Vec2Int(-this.x, -this.y);
    }
}
