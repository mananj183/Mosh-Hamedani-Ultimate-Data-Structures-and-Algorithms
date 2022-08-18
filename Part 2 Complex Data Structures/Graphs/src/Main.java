import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Graph graph = new Graph();
//        graph.addNode("X");
//        graph.addNode("A");
//        graph.addNode("B");
//        graph.addNode("P");
//        graph.addEdge("X", "A");
//        graph.addEdge("X", "B");
//        graph.addEdge("A", "P");
//        graph.addEdge("B", "P");
//        graph.topologicalSort();
        graph.addNode("0");
        graph.addNode("1");
        graph.addNode("2");
        graph.addNode("3");
//        graph.addNode("4");
//        graph.addNode("5");
//        graph.addNode("6");
//        graph.addNode("7");
        graph.addEdge("0","1");
        graph.addEdge("1", "2");
        graph.addEdge("1", "3");
        graph.addEdge("2","3");
        System.out.println(graph.hasCycle());
//        graph.addEdge("0", "4");
//        graph.addEdge("0", "3");
//        graph.addEdge("1", "3");
//        graph.addEdge("2", "4");
//        graph.addEdge("2", "7");
//        graph.addEdge("3", "5");
//        graph.addEdge("3", "6");
//        graph.addEdge("3", "7");
//        graph.addEdge("4", "6");
//        graph.topologicalSort();
//        graph.depthFirstSearch("C");
//        graph.traverseDepthFirst("C");
//        graph.traverseBreadthFirst("1");
//        graph.breadthFirstSearch("1");
        graph.print();
    }
}
