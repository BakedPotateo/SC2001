package SC2001.Project2.PriorityQueue;

import java.util.*;

public class GraphNode implements Comparator<GraphNode>{
    public int node;
    public int cost;
    
    public GraphNode(){} // empty constructor

    // constructor overload
    public GraphNode(int node, int cost){
        this.node = node; // node ID
        this.cost = cost; // cost from previous node
    }

    @Override // override parent "compare" function
    public int compare(GraphNode node1, GraphNode node2){ 
        if (node1.cost < node2.cost) 
            return -1; 
        if (node1.cost > node2.cost) 
            return 1; 
        return 0; 
    }
}
