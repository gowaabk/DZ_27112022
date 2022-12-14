import java.util.Arrays;
import java.util.Random;

public class MapBuild {

    public static int[][] map;

    public MapBuild() {
        this(2, 2);
    }

    public MapBuild(int size) {
        this(size, size);
    }

    public MapBuild(int rows, int columns) {
        map = new int[rows][columns];
    }

    public int getValue(MapPoint point) {
        return map[point.getX()][point.getY()];
    }

    public int getRowNumber() {
        return map.length;
    }

    public int getColNumber() {
        return map[0].length;
    }

    public void setValue(MapPoint point, int value) {
        map[point.getX()][point.getY()] = value;
    }

    public static void addRandomWalls(int numOfWalls) {
        if (numOfWalls < (map.length * map[0].length)) {
            int rowIndex;
            int colIndex;
            Random rnd = new Random();
            while (numOfWalls > 0) {
                rowIndex = rnd.nextInt(map.length);
                colIndex = rnd.nextInt(map[0].length);
                if (map[rowIndex][colIndex] == 0) {
                    map[rowIndex][colIndex] = -1;
                    numOfWalls -= 1;
                } else {
                    continue;
                }
            }
        } else {
            System.out.println("Слишком много стен!");
        }
    }

    public void addManualWall(int row, int col) {
        if (row < map.length && col < map[0].length) {
            map[row][col] = -1;
        } else {
            System.out.println("Координата [" + row + "][" + col + "] за пределами карты");
        }
    }

    public void print() {
        for (int[] row : map) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}