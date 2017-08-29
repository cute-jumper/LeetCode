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
        return cloneGraph(node, new HashMap<>());
    }
    UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(copy.label, copy);
        for (UndirectedGraphNode n : node.neighbors) {
            copy.neighbors.add(cloneGraph(n, map));
        }
        return copy;
    }
}
