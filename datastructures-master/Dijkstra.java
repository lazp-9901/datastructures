
import java.util.List;
import java.util.ArrayList;

public class Dijkstra {
    public static void main(String[] args) {


        //Kieu cai tien dung priorityQueue
        Vert vA = new Vert("A");
        Vert vB = new Vert("B");
        Vert vC = new Vert("C");
        Vert vD = new Vert("D");
        Vert vE = new Vert("E");


        vA.addNeighbour(new Edge(3, vA, vC));
        vA.addNeighbour(new Edge(5, vA, vB));
        vC.addNeighbour(new Edge(2, vC, vB));
        vC.addNeighbour(new Edge(6, vC, vE));
        vC.addNeighbour(new Edge(5, vC, vD));
        vB.addNeighbour(new Edge(4, vB, vC));
        vB.addNeighbour(new Edge(3, vB, vD));
        vB.addNeighbour(new Edge(4, vB, vE));
        vE.addNeighbour(new Edge(2, vE, vD));

        PathFinder shortestPath = new PathFinder();
        shortestPath.ShortestP(vA);
        System.out.println("Khoang cach toi thieu tu:");
        System.out.println("A to B: " + vB.getDist());
        System.out.println("A to C: " + vC.getDist());
        System.out.println("A to D: " + vD.getDist());
        System.out.println("A to E: " + vE.getDist());
        System.out.println("Duong di ngan nhat tu:");
        System.out.println("A to B: " + shortestPath.getShortestP(vB));
        System.out.println("A to C: " + shortestPath.getShortestP(vC));
        System.out.println("A to D: " + shortestPath.getShortestP(vD));
        System.out.println("A to E: " + shortestPath.getShortestP(vE));


        // Kieu truyen thong
        // Vert vA = new Vert("A");
        // Vert vB = new Vert("B");
        // Vert vC = new Vert("C");
        // Vert vD = new Vert("D");
        // Vert vE = new Vert("E");

        // vA.setDist(0);

        // List<Vert> list = new ArrayList<Vert>();
        // list.add(vA);
        // list.add(vB);
        // list.add(vC);
        // list.add(vD);
        // list.add(vE);


        // vA.addNeighbour(new Edge(3, vA, vC));
        // vA.addNeighbour(new Edge(5, vA, vB));
        // vC.addNeighbour(new Edge(2, vC, vB));
        // vC.addNeighbour(new Edge(6, vC, vE));
        // vC.addNeighbour(new Edge(5, vC, vD));
        // vB.addNeighbour(new Edge(4, vB, vC));
        // vB.addNeighbour(new Edge(3, vB, vD));
        // vB.addNeighbour(new Edge(4, vB, vE));
        // vE.addNeighbour(new Edge(2, vE, vD));

        // PathFinder shortestPath = new PathFinder();
        // shortestPath.shortestP(list, vE);
        // System.out.println("Khoang cach toi thieu tu:");
        // System.out.println("A to B: " + vB.getDist());
        // System.out.println("A to C: " + vC.getDist());
        // System.out.println("A to D: " + vD.getDist());
        // System.out.println("A to E: " + vE.getDist());
        // System.out.println("Duong di ngan nhat tu:");
        // System.out.println("A to B: " + shortestPath.getShortestP(vB));
        // System.out.println("A to C: " + shortestPath.getShortestP(vC));
        // System.out.println("A to D: " + shortestPath.getShortestP(vD));
        // System.out.println("A to E: " + shortestPath.getShortestP(vE));

    }
}
