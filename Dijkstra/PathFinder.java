import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PathFinder {

    //Kieu cai tien dung PriorityQueue
    public void ShortestP(Vert startVert) { 
        startVert.setDist(0);
        PriorityQueue<Vert> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(startVert);
        startVert.setVisited(true);

        while (!priorityQueue.isEmpty()) {
            Vert actualVertex = priorityQueue.poll();
            for (Edge edge : actualVertex.getList()) {
                Vert v = edge.getTargetVert();
                if (!v.Visited()) {
                    double newDistance = actualVertex.getDist()
                        + edge.getWeight();
                    if (newDistance < v.getDist()) {
                        priorityQueue.remove(v);
                        v.setDist(newDistance);
                        v.setPr(actualVertex);
                        priorityQueue.add(v);
                    }
                }
            }
            actualVertex.setVisited(true);
        }
    }


    //Kieu truyen thong
    // public void shortestP(List<Vert> list, Vert initialVert){
    //     for(int i=0; i<list.size(); i++){
    //         Vert bestVert = initialVert;
    //         double maxWeight = Double.MAX_VALUE;
    //         for(Vert V : list){
    //            if(V.getDist()<maxWeight&&!V.Visited()){
    //                bestVert=V;
    //                maxWeight=V.getDist();
    //            }
    //         }
    //         bestVert.setVisited(true);
    //         for(Edge edge:bestVert.getList()){
    //             Vert v = edge.getTargetVert();
    //             if(v.getDist()>bestVert.getDist()+edge.getWeight()){
    //                 v.setDist(bestVert.getDist()+edge.getWeight());
    //                 v.setPr(bestVert);
    //             }
    //         }
    //     }
    // }

    public List<Vert> getShortestP(Vert targetVertex) {
        List<Vert> path = new ArrayList<>();
        for (Vert vertex = targetVertex; vertex != null; vertex = vertex.getPr()) {
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }

}
 
