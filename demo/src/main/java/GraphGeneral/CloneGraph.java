package GraphGeneral;

import java.util.HashMap;


public class CloneGraph {
    HashMap<Integer, Node> nodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (nodes.containsKey(node.val)) return nodes.get(node.val);

        Node copy = new Node(node.val);
        nodes.put(node.val, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }

        return copy;
    }
}

