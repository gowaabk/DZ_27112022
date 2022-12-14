
public class Main {
    public static void main(String[] args) {
        MapBuild myMap = new MapBuild(6);

        MapBuild.addRandomWalls(5);
        myMap.print();

        MapPoint startPoint = new MapPoint(5, 2, 1);
        System.out.println("Точка старта: " + startPoint);
        MapPoint finishPoint = new MapPoint(1, 3);
        System.out.println("Точка финиш: " + finishPoint);
        new WaveAlgorithm(myMap, startPoint);
        myMap.print();

        finishPoint.setPointValue(myMap.getValue(finishPoint));

        PathFinder path1 = new PathFinder(myMap, finishPoint);
        path1.findShortPath();
        for (MapPoint point : path1.getPath()) {
            System.out.println(point.toString());
        }
    }
}