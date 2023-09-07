package week03$recursion;

public class TravelDirectionTest {

    private static void goNorthEast(int endX, int endY, int x, int y, String route) {

        if (x == endX && y == endY) {
            System.out.println(route);

        } else if (x <= endX && y <= endY) {
            goNorthEast(endX, endY, x, y + 1, route + " N");
            goNorthEast(endX, endY, x + 1, y, route + " E");
            goNorthEast(endX, endY, x + 1, y + 1, route + " NE");
        }

        //OTHERWISE : DO NOTHING
    }

    public static void goNorthEast(int endX, int endY, int startX, int startY) {
        goNorthEast(endX, endY, startX, startY, "moves:");
    }

    private static void goSouthWest(int endX, int endY, int x, int y, String route) {
        if (x == endX && y == endY) {
            System.out.println(route);
        } else if (x >= endX && y >= endY) {
            goSouthWest(endX, endY, x, y - 1, route + " S");
            goSouthWest(endX, endY, x - 1, y, route + " W");
            goSouthWest(endX, endY, x - 1, y - 1, route + " SW");
        }
        //OTHERWISE: DO NOTHING
    }

    public static void goSouthWest(int endX, int endY, int startX, int startY) {
        goSouthWest(endX, endY, startX, startY, "moves:");
    }

    public static void intro() {
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println("\t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println("\t T R A V E L    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        intro();
        System.out.println("Solutions for (1, 2):");
        goNorthEast(1, 2, 0, 0);
        System.out.println();

        System.out.println("Solutions for (1, 2) returning to (0, 0):");
        goSouthWest(0, 0, 1, 2);
        System.out.println();
    }
}
