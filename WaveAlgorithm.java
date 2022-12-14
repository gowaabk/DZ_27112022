
import java.util.ArrayDeque;
import java.util.Queue;

public class WaveAlgorithm {
    private MapBuild myMap;
    private Queue<MapPoint> queue;
    private MapPoint startPoint;
    private int[][] routeRule = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public WaveAlgorithm(MapBuild myMap, MapPoint startPoint) {
        this.myMap = myMap;
        this.startPoint = startPoint;
        this.start();
    }

    public void start() {
        this.queue = new ArrayDeque<>();
        MapPoint currentPoint;
        MapPoint newPoint;
        int rowNumber = this.myMap.getRowNumber();
        int colNumber = this.myMap.getColNumber();

        this.queue.add(startPoint);
        this.myMap.setValue(startPoint, startPoint.getPointValue());

        while (!this.queue.isEmpty()) {
            currentPoint = this.queue.poll();
            for (int[] step : this.routeRule) {
                newPoint = new MapPoint(currentPoint.getX() + step[0], currentPoint.getY() + step[1],
                        currentPoint.getPointValue() + 1);

                if (newPoint.getX() >= 0 && newPoint.getY() >= 0 && newPoint.getX() < rowNumber
                        && newPoint.getY() < colNumber && this.myMap.getValue(newPoint) == 0) {
                    this.myMap.setValue(newPoint, newPoint.getPointValue());
                    this.queue.add(new MapPoint(newPoint.getX(), newPoint.getY(), newPoint.getPointValue()));
                }
            }
        }
    }
}