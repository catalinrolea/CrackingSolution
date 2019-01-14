package graphs;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class RoutesBetweenNodes {

     class GraphNode    {
         private int nrNodes;
         private List<Integer> connections[];
         public GraphNode(int nrNodes)  {
             this.nrNodes = nrNodes;
             connections = new LinkedList[nrNodes];
             for (int i=0; i<nrNodes; i++)  {
                 connections[i] = new LinkedList<>();
             }
         }
     }

     class Edge {
         private int src, dest;
         public Edge(int src, int dest)    {
             this.src = src;
             this.dest = dest;
         }
     }

     static void addGraph(GraphNode graphNode, Edge edge)   {
         graphNode.connections[edge.src].add(edge.dest);
     }

     void breadthFirstSearch(int startingNode, GraphNode graphNode)  {
         if (graphNode == null)
             return;
         boolean[] visited = new boolean[graphNode.nrNodes];
         visited[startingNode] = true;
         List<Integer> queue = new LinkedList<>();
        queue.add(startingNode);
        while (queue.size() != 0)   {
            startingNode = ((LinkedList<Integer>) queue).poll();
            System.out.print(startingNode + " ");
            Iterator<Integer> it = graphNode.connections[startingNode].listIterator();
            while (it.hasNext())    {
              int n = it.next();
              if (!visited[n])  {
                  visited[n] = true;
                  queue.add(n);
              }
            }
        }


     }

     boolean checkRouteBetweenNodes(GraphNode graphNode, int startingNode, int destination) {
            if (graphNode == null)
                return false;

            boolean visited[] = new boolean[graphNode.nrNodes];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[startingNode] = true;
            queue.add(startingNode);

            while (queue.size() != 0)    {
                startingNode = queue.poll();
                int nextElement;
                //iterate through each node
                Iterator<Integer> it = graphNode.connections[startingNode].listIterator();
                while (it.hasNext())    {
                    nextElement = it.next();
                    if (nextElement == destination)
                        return true;

                    if (!visited[nextElement])  {
                        visited[nextElement] = true;
                        queue.add(nextElement);
                    }

                }
            }
        return false;
    }

     @Test
    public void testRoutesBetweenNodes()    {
         int nrNodes = 4;
         GraphNode graphNode = new GraphNode(nrNodes);
         addGraph(graphNode,new Edge(0,1));
         addGraph(graphNode,new Edge(0,2));
         addGraph(graphNode,new Edge(1,2));
         addGraph(graphNode,new Edge(2,0));
         addGraph(graphNode,new Edge(2,3));
         addGraph(graphNode,new Edge(3,3));
         breadthFirstSearch(2,graphNode );
         System.out.println("");
         int source = 1;
         int destination = 3;
         if (checkRouteBetweenNodes(graphNode,source, destination))
                System.out.println("Route between " + source + " and " + destination + " EXIST");
         else
                System.out.println("Route between " + source + " and " + destination + " DOESN'T exist");
     }

}