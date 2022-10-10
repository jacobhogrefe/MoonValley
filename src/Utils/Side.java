package Utils;

import GameObject.Rectangle;

public enum Side {
    LEFT,
    RIGHT,
    TOP,
    BOTTOM;

    public Side inverse() {
        switch (this) {
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            case TOP: return BOTTOM;
            case BOTTOM: return TOP;
            default: return null;
        }
    }

    public boolean parallelToXAxis() {
        return this == TOP || this == BOTTOM;
    }

    public boolean parallelToYAxis() {
        return this == LEFT || this == RIGHT;
    }

    public Rectangle getBorderWithWidth(Rectangle rectangle, int thickness) {
        switch (this) {
            case LEFT:
                return new Rectangle(
                    -thickness,
                    rectangle.getY(),
                    thickness,
                    rectangle.getHeight()
                );
            case RIGHT:
                return new Rectangle(
                    rectangle.getX2(),
                    rectangle.getY(),
                    thickness,
                    rectangle.getHeight()
                );
            case TOP:
                return new Rectangle(
                    rectangle.getX(),
                    -thickness,
                    rectangle.getWidth(),
                    thickness
                );
            case BOTTOM:
                return new Rectangle(
                    rectangle.getX(),
                    rectangle.getY2(),
                    rectangle.getWidth(),
                    thickness
                );
            default:
                return null;
        }
    }
}
