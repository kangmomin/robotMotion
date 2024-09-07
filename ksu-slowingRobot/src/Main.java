import java.util.Scanner;

// 2024664001 강모민
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Robot robot = new Robot();

        String commands = scanner.nextLine();

        for (int i = 0; i < commands.length(); i++) {
            char c = commands.charAt(i);
            Robot.DirectionEnum direction = convertToEnum(c);

            // 움직임 관련이면 move 실행
            if (direction == Robot.DirectionEnum.FORWARD ||
                    direction == Robot.DirectionEnum.BACKWARD) {
                robot.move(direction);
            } else {
                // 방향 설정이라면 updateDirection
                robot.updateDirection(direction);
            }
        }

        System.out.println("x:" + robot.getLocation().getX());
        System.out.println("y:" + robot.getLocation().getY());
    }

    private static Robot.DirectionEnum convertToEnum(char c) {
        switch (c) {
            case 'L' -> {
                return Robot.DirectionEnum.LEFT;
            }
            case 'R' -> {
                return Robot.DirectionEnum.RIGHT;
            }
            case 'G' -> {
                return Robot.DirectionEnum.FORWARD;
            }
            case 'B' -> {
                return Robot.DirectionEnum.BACKWARD;
            }
        }
        throw new IllegalArgumentException();
    }
}