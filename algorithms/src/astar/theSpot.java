package astar;


import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saadm
 */
public interface theSpot<S> {
     double getH(S goal, int mode);

    double getG(S neighbour);

    Set<S> getNeighbours();
}
