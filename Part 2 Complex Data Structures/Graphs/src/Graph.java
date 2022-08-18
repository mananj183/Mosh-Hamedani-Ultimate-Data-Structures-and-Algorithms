import java.util.*;

public class Graph {
    private class Node{
        private String label;
        public Node(String label){
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label){
        Node newNode = new Node(label);
        nodes.putIfAbsent(label, newNode);
        adjacencyList.putIfAbsent(newNode, new ArrayList<>());
    }
    public void removeNode(String label){
        Node nodeToBeRemoved = nodes.get(label);
        if (nodeToBeRemoved == null)
            return;
        for (Node source:adjacencyList.keySet()){
            adjacencyList.get(source).remove(nodeToBeRemoved);
        }
        nodes.remove(label);
        adjacencyList.remove(nodeToBeRemoved);
    }
    public void addEdge(String from, String to){
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalStateException();

        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalStateException();
        List<Node> adjacentNodes = adjacencyList.get(fromNode);
        int size = adjacentNodes.size()-1;
        if (adjacentNodes.isEmpty() || adjacentNodes.get(size).label.charAt(0) < to.charAt(0)){
            adjacencyList.get(fromNode).add(toNode);
        }else if (adjacentNodes.get(size).label.charAt(0) > to.charAt(0)) {
            Node n = adjacentNodes.remove(size);
            adjacencyList.get(fromNode).add(size, toNode);
            adjacencyList.get(fromNode).add(n);
        }
    }
    public void removeEdge(String from, String to){

        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }
    public void depthFirstSearch(String root){
        List<Node> traversed = new ArrayList<>();
        Node rootNode = nodes.get(root);
        depthFirstSearch(rootNode, traversed);
        System.out.println(traversed);
    }
    private void depthFirstSearch(Node root, List<Node> traversed){
        List<Node> adjacentNodes = adjacencyList.get(root);
        traversed.add(root);
        for (Node n : adjacentNodes){
            if (!traversed.contains(n)) {
                depthFirstSearch(n, traversed);
            }
        }
    }

//    public void breadthFirstSearch(String root){
//        List<Node> traversed = new ArrayList<>();
//        Node rootNode = nodes.get(root);
//        Queue<Node> q = new ArrayDeque<>();
//        breadthFirstSearch(rootNode, traversed, q);
//        System.out.println(traversed);
//    }
//    private void breadthFirstSearch(Node root, List<Node> traversed, Queue<Node> q){
//        List<Node> adjacentNode = adjacencyList.get(root);
//        if (!traversed.contains(root))
//            return;
//        traversed.add(root);
//        for (Node n : adjacentNode){
//            if (!traversed.contains(n)){
//                traversed.add(n);
//            }
//        }
//        breadthFirstSearch();
//    }
    public void traverseDepthFirst(String root){
        Node nodeTraversed = nodes.get(root);
        if (nodeTraversed == null)
            return;
        List<String> traversed = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(nodeTraversed);
        while (!st.isEmpty()){
            Node current = st.pop();
            if (traversed.contains(current.label))
                continue;
            traversed.add(current.label);
            List<Node> pairs = adjacencyList.get(current);
            for(Node n : pairs){
                if (!traversed.contains(n.label)){
                    st.push(n);
                }
            }
        }
        System.out.println(traversed);
    }

    public void traverseBreadthFirst(String root){
        Node nodeTraversed = nodes.get(root);
        if (nodeTraversed == null)
            return;
        List<String> traversed = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(nodeTraversed);
        while (!q.isEmpty()){
            Node current = q.remove();
            if (traversed.contains(current.label))
                continue;
            traversed.add(current.label);
            List<Node> pairs = adjacencyList.get(current);
            for(Node n : pairs){
                if (!traversed.contains(n.label)){
                    q.add(n);
                }
            }
        }
        System.out.println(traversed);
    }

    public void topologicalSort(){
        Set<Node> visited = new HashSet<>();
        Stack<Node> st = new Stack<>();
        List<String> sorted = new ArrayList<>();
        for(Node n : nodes.values()){
            if (!visited.contains(n)){
                topologicalSort(n, visited, st);
            }
        }
        while (!st.isEmpty()){
            sorted.add(st.pop().label);
        }
        System.out.println(sorted);
    }
    private void topologicalSort(Node root, Set<Node> visited, Stack<Node> st){
        visited.add(root);
        List<Node> adjacentNodes = adjacencyList.get(root);
        for (Node n : adjacentNodes){
            if (!visited.contains(n)){
                topologicalSort(n, visited, st);
            }
        }
        st.add(root);
    }

    public void breadthFirstSearch(String root){
        Node rootNode = nodes.get(root);
        if (rootNode == null)
            return;
        List<Node> traversed = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        traversed.add(rootNode);
        breadthFirstSearch(rootNode, traversed, q);
        System.out.println(traversed);
    }
    private void breadthFirstSearch(Node root, List<Node> traversed, Queue<Node> q){
        for (Node n: adjacencyList.get(root)){
            if (!traversed.contains(n)){
                traversed.add(n);
                q.add(n);
            }
        }
        while (!q.isEmpty()){
            breadthFirstSearch(q.remove(), traversed, q);
        }
    }
    public boolean hasCycle(){
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        while (!all.isEmpty()){
            Node n = all.iterator().next();
            System.out.println(n.label);
            if(hasCycle(n, all, visiting, visited))
                return true;
        }
        return false;
    }
    private boolean hasCycle(Node root, Set<Node> all, Set<Node> visiting, Set<Node> visited){
        all.remove(root);
        visiting.add(root);
        List<Node> l = adjacencyList.get(root);
        for(Node n : l){
            if (visited.contains(n)){
                continue;
            }
            if (visiting.contains(n)){
                return true;
            }
            if(hasCycle(n,all,visiting, visited)){
                return true;
            }
        }
        visiting.remove(root);
        visited.add(root);
        return false;
    }
    public void print(){
        for (Node source: adjacencyList.keySet()){
            List<Node> targetNodes = adjacencyList.get(source);
            System.out.println(source.label + " is connected to " + targetNodes);
        }
    }
}
