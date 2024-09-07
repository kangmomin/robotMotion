public class Robot {
    private final Location location = new Location();
    // 0 - left 1 - forward 2 - right 3 - backward
    private Integer directionValue = 1;

    public Location getLocation() {
        return location;
    }

    public void updateDirection(DirectionEnum direction) {
        switch (direction) {
            case RIGHT -> this.directionValue += 1;
            case LEFT -> this.directionValue -= 1;
        }

        if (this.directionValue == -1) {
            this.directionValue = 3;
        }
        if (this.directionValue == 4) {
            this.directionValue = 0;
        }
    }

    public void move(DirectionEnum directionEnum) {
        if (directionEnum == DirectionEnum.FORWARD) {
            switch (this.directionValue) {
                case 0 -> this.location.setX(location.getX() - 1);
                case 1 -> this.location.setY(location.getY() + 1);
                case 2 -> this.location.setX(location.getX() + 1);
                case 3 -> this.location.setY(location.getY() - 1);
            }
        } else if (directionEnum == DirectionEnum.BACKWARD) {
            switch (this.directionValue) {
                case 0 -> this.location.setX(location.getX() + 1);
                case 1 -> this.location.setY(location.getY() - 1);
                case 2 -> this.location.setX(location.getX() - 1);
                case 3 -> this.location.setY(location.getY() + 1);
            }
        } else {
            throw new IllegalArgumentException("Invalid direction");
        }
    }

    public enum DirectionEnum {
        FORWARD, BACKWARD, LEFT, RIGHT
    }
}

