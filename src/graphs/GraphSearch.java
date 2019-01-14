package graphs;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphSearch {
    static void addGraph(GraphNode graphNode, Edge edge) {
        graphNode.connections[edge.src].add(edge.dest);
    }


    static class GraphNode {
        private int nrNodes;
        private List<Integer> connections[];

        public GraphNode(int nrNodes) {
            this.nrNodes = nrNodes;
            connections = new LinkedList[nrNodes];
            for (int i = 0; i < nrNodes; i++) {
                connections[i] = new LinkedList<>();
            }
        }
    }

    static class Edge {
        private int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    void depthFirstSearch(int startingNode, GraphNode graphNode) {
        if (graphNode == null)
            return;
        boolean[] visited = new boolean[graphNode.nrNodes];
        //call recursive dfs
        depthFirstSearchRecursive(graphNode, visited, startingNode);
    }

    void depthFirstSearchRecursive(GraphNode node, boolean[] visited, int currentNode) {
        System.out.print(" ");
        System.out.print(currentNode);
        visited[currentNode] = true;
        Iterator<Integer> it = node.connections[currentNode].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (visited[n] == false) {
                visited[n] = true;
                depthFirstSearchRecursive(node, visited, n);
            }
        }
    }

    static void  breadthFirstSearch(int startingNode, GraphNode graphNode)   {
        boolean[] visited = new boolean[graphNode.nrNodes];
        List<Integer> queue = new LinkedList<>();
        visited[startingNode] = true;
        queue.add(startingNode);
        while (queue.size() != 0)   {

            startingNode = ((LinkedList<Integer>) queue).poll();
            System.out.print(startingNode + " ");
            Iterator<Integer> it = graphNode.connections[startingNode].listIterator();
            while (it.hasNext())    {
                int n = it.next();
                if (!visited[n])    {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

    }

    @Test
    public void testDFS() {
        int numberOfNodes = 6;
        GraphNode graphNode = new GraphNode(numberOfNodes);
        addGraph(graphNode, new Edge(0, 1));
        addGraph(graphNode, new Edge(0, 4));
        addGraph(graphNode, new Edge(0, 5));
        addGraph(graphNode, new Edge(1, 3));
        addGraph(graphNode, new Edge(1, 4));
        addGraph(graphNode, new Edge(2, 1));
        addGraph(graphNode, new Edge(3, 2));
        addGraph(graphNode, new Edge(3, 4));

        System.out.print("Depth first search(adancime): ");
        depthFirstSearch(0, graphNode);
        System.out.println(" ");
        System.out.print("Breadth first search(latime): ");
        breadthFirstSearch(0,graphNode);
    }

}
