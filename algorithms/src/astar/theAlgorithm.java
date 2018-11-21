/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author Sergey Kim
 */
public class theAlgorithm {
    
    public static <S extends theSpot<S>> List<S> AStar(S start, S goal, int mode) {
               Map<S, Double> gScore = new HashMap<S, Double>();                //creating gScore map and fScore map
         Map<S, Double> fScore = new HashMap<S, Double>();
       
         PriorityQueue<S> openList = new PriorityQueue<S>(11, new Comparator<S>() {     //openList is the lowest fScore//

            public int compare(S nodeA, S nodeB) {
                return Double.compare(fScore.get(nodeA), fScore.get(nodeB));
            }
        });
        Set<S> closedList = new HashSet<S>();
        Map<S, S> cameFrom = new HashMap<S, S>();
        List<S> route = new LinkedList<S>();            //created the closedSet and cameFrom map, and the complete route as a list
 

        gScore.put(start, 0.0);
        fScore.put(start, start.getH(goal, mode));
        openList.offer(start);

        while (!openList.isEmpty()) {               // while openlist is not empty
            S current = openList.poll();
            if (current.equals(goal)) {         //if current is the end then finish
                while (current != null) {
                    route.add(0, current);
                    current = cameFrom.get(current);
                }

                return route;
            }

            closedList.add(current);

            for (S neighbour : current.getNeighbours()) {           //for each of current neighbours
                if (closedList.contains(neighbour)) {
                    continue;
                }

                double tentG = gScore.get(current) + current.getG(neighbour);       

                boolean contains = openList.contains(neighbour);
                if (!contains || tentG < gScore.get(neighbour)) {       //if tg < the gScore of the neighbour then its a better route!
                    gScore.put(neighbour, tentG);
                    fScore.put(neighbour, tentG + neighbour.getH(goal, mode));

                    if (contains) {
                        openList.remove(neighbour);
                    }

                    openList.offer(neighbour);   
                    cameFrom.put(neighbour, current);
                }
            }
        }

        return null;
    }
}
