/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> visited= new HashMap<>();
        return doCloneGraph(node, visited);
    }
    public UndirectedGraphNode doCloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> visited) {
        if (!visited.containsKey(node.label)) {
            UndirectedGraphNode n = new UndirectedGraphNode(node.label);
            n.neighbors = new ArrayList<UndirectedGraphNode>();
            visited.put(n.label, n);
            for (UndirectedGraphNode gn : node.neighbors) {
                n.neighbors.add(doCloneGraph(gn, visited));
            }
            return n;
        } else {
            return visited.get(node.label);
        }
    }
}
