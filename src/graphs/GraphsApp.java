package graphs;

import graphs.baeldung.Graph;

public class GraphsApp {

    public static void main(String args[]) {

        test2();
    }

    public static void test2() {
        Graph graph = new Graph();
        graph.addVertex("7");
        graph.addVertex("1");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("2");
        graph.addVertex("6");
        graph.addVertex("9");
        graph.addVertex("5");
        graph.addEdge("7", "3");
        graph.addEdge("1", "3");
        graph.addEdge("3", "4");
        graph.addEdge("4", "6");
        graph.addEdge("2", "6");
        graph.addEdge("6", "9");
        graph.addEdge("9", "5");

        graph.getAdjVertices("7").forEach(e -> {
            System.out.println(e);
        });

        System.out.println(graph.depthFirstTraversal(graph, "7").toString());
    }

    public static void test1() {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        graph.getAdjVertices("Bob").forEach(e -> {
            System.out.println(e);
        });

        System.out.println(graph.depthFirstTraversal(graph, "Bob").toString());
    }
}
