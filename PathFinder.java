import java.util.ArrayList;

public class PathFinder {
    private MapBuild map;
    private MapPoint finishPoint;
    private ArrayList<MapPoint> resultPath;
    private int[][] routeRule = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

    public PathFinder(MapBuild map, MapPoint finishPoint) {
        this.map = map;
        this.finishPoint = finishPoint;
    }

    public void findShortPath() {
        this.resultPath = new ArrayList<>();
        resultPath.add(finishPoint);
        int rowNumber = map.getRowNumber();
        int colNumber = map.getColNumber();

        MapPoint currentPoint = new MapPoint(finishPoint.getX(), finishPoint.getY(), finishPoint.getPointValue());
        MapPoint prevPoint = new MapPoint();

        while (currentPoint.getPointValue() != 1) {

            for (int[] step : routeRule) {
                prevPoint.setX(currentPoint.getX() + step[0]);
                prevPoint.setY(currentPoint.getY() + step[1]);
                if (prevPoint.getX() >= 0 && prevPoint.getY() >= 0 && prevPoint.getX() < rowNumber
                        && prevPoint.getY() < colNumber) {
                    prevPoint.setPointValue(map.getValue(prevPoint));

                    if (prevPoint.getPointValue() == currentPoint.getPointValue() - 1) {
                        resultPath.add(new MapPoint(prevPoint.getX(), prevPoint.getY(), prevPoint.getPointValue()));
                        break;
                    }
                }

            }
            currentPoint.setX(prevPoint.getX());
            currentPoint.setY(prevPoint.getY());
            currentPoint.setPointValue(prevPoint.getPointValue());
        }

    }

    public ArrayList<MapPoint> getPath() {
        return resultPath;
    }
}