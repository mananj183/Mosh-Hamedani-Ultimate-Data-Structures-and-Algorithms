import java.util.*;

public class WeightedGraph {
    private class Node{
        String label;
        private List<Edge> edges = new ArrayList<>();
        public Node(String label){
            this.label = label;
        }
        public void addEdge(Node to, int weight){
            edges.add(new Edge(this, to, weight));
        }
        public List<Edge> getEdges(){
            return edges;
        }
        @Override
        public String toString() {
            return "Node: " + label;
        }
    }
    private class Edge{
        Node from;
        Node to;
        int weight;
        public Edge(Node from, Node to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }
    Map<String,Node> nodes = new HashMap<>();
    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }
    public void addEdge(String from, String to, int weight){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null){
            throw new IllegalStateException();
        }
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }
    public void print(){
        for(Node node : nodes.values()){
            List<Edge> edges = node.getEdges();
            if (!edges.isEmpty())
                System.out.println(node + " is connected to " + edges);
        }
    }

    private class NodeEntry{
        Node node;
        int priority;
        public NodeEntry(Node node, int priority){
            this.node = node;
            this.priority = priority;
        }
    }
    public int getShortestDistance(String from, String to){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null){
            throw new IllegalStateException();
        }
        PriorityQueue<NodeEntry> pq = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        Map<Node, Integer>  distances = new HashMap<>();
        Map<Node, Node> previousNode = new HashMap<>();
        for(Node n : nodes.values()){
            distances.put(n, Integer.MAX_VALUE);
        }
        distances.put(nodes.get(fromNode), 0);
        List<Node> traversed = new ArrayList<>();
        pq.add(new NodeEntry(fromNode, 0));
        while(!pq.isEmpty()){
            Node current = pq.remove().node;
            if (traversed.contains(current)){
                continue;
            }
            traversed.add(current);
            for (Edge e : current.edges){
                long newDistance = distances.get(current) + e.weight;
                if (newDistance < distances.get(e.to)){
                    distances.replace(e.to, (int) newDistance);
                    pq.add(new NodeEntry(e.to, (int) newDistance));
                }
            }
        }
        return distances.get(nodes.get(to));
    }
}
