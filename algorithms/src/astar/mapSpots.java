package astar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import astar.theSpot;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Sergey Kim
 */
public class mapSpots {
    private final double[][] map;
    private final boolean Diagonal;

    /**
     * A node in a 2d map. This is simply the coordinates of the point.
     * 
     * @author Ben Ruijl
     * 
     */
    public class MapSpot implements theSpot<MapSpot> {
        private final int x, y;

        public MapSpot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double getH(MapSpot goal, int mode) {
            if (mode == 0) {
                return Math.abs(x - goal.x) + Math.abs(y - goal.y);
            }
            if (mode == 1) {
                return Math.sqrt(Math.pow(x - goal.x, 2) + Math.pow(y - goal.y, 2));
            }
            return Math.max(Math.abs(x - goal.x), Math.abs(y - goal.y));
          
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }

        public double getG(MapSpot neighbour) {
            return 1 + map[neighbour.y][neighbour.x];
        }

        public Set<MapSpot> getNeighbours() {
            Set<MapSpot> neighbours = new HashSet<MapSpot>();

            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if ((i == x && j == y) || i < 0 || j < 0 || j >= map.length || i >= map[j].length) {
                        continue;
                    }

                    if (!Diagonal && ((i < x && j < y) || (i > x && j > y))) {
                        continue;
                    }

                    if (map[j][i] < 0) {
                        continue;
                    }

                    neighbours.add(new MapSpot(i, j));
                }
            }

            return neighbours;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        @Override
        public int hashCode() {
            int Final = 1;
            final int x = 31;
            
            Final = x * Final + getType().hashCode();
            Final = x * Final + x;
            Final = x * Final + y;
            return Final;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object)
                    return true;
            if (object == null)
                    return false;
            if (getClass() != object.getClass())
                    return false;
            MapSpot eltra = (MapSpot) object;
            if (!getType().equals(eltra.getType()))
                    return false;
            if (x != eltra.x)
                    return false;
            if (y != eltra.y)
                    return false;
            return true;
        }

        private mapSpots getType() {
            return mapSpots.this;
        }

    }

    public mapSpots(double[][] map, boolean Diagonal) {
        this.map = map;
        this.Diagonal = Diagonal;
    }

    public List<MapSpot> findPath(int xStart, int yStart, int xEnd, int yEnd, int mode) {
        return theAlgorithm.AStar(new MapSpot(xStart, yStart), new MapSpot(xEnd, yEnd), mode);
    }
}
