package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphImpl {
    public static class GraphNode  {
        int nrNodes;
        List<Integer> connections[];
        public GraphNode(int nrNodes)   {
            this.nrNodes = nrNodes;
            connections = new LinkedList[nrNodes];
            for (int i=0; i<nrNodes; i++)   {
              connections[i] = new LinkedList<>();
            }
        }
    }
    static class Edge {
        int src, dest;
        public Edge(int src, int dest)  {
            this.src = src;
            this.dest = dest;
        }
    }

    static void addGraph(GraphNode graphNode, Edge muchie)  {
        //undirected graph
        graphNode.connections[muchie.src].add(muchie.dest);

    }
    public static void main(String[] args)  {
        int numberOfNodes = 4;
        GraphNode graphNode = new GraphNode(numberOfNodes);
        addGraph(graphNode,new Edge(0,1));
        addGraph(graphNode,new Edge(1,2));
        addGraph(graphNode,new Edge(2,0));
        addGraph(graphNode,new Edge(2,3));
        addGraph(graphNode,new Edge(3,2));

        for (int i=0; i<numberOfNodes; i++) {
            for (Integer index: graphNode.connections[i])   {
                System.out.print("->" + "[" + i + ", " + index + "]");
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("");
        for (Integer index : list)  {
            System.out.print(index + " ");
        }
    }
}
