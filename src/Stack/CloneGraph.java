package Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    //使用HashMap来对应原图中的结点和新生成的克隆图中的结点
    //map用来存放新生成的克隆图中的结点
    public HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return clone(node);
    }
    //在递归函数中，首先判空，然后再看当前的结点是否已经被克隆过了，
    // 若在HashMap中存在，则直接返回其映射结点。
    // 否则就克隆当前结点，并在HashMap中建立映射，
    // 然后遍历当前结点的所有neighbor结点，调用递归函数并且加到克隆结点的neighbors数组中
    public Node clone(Node node) {
        if (node == null) return null;

        if (map.containsKey(node.val))
            return map.get(node.val);

        Node newNode = new Node(node.val, new ArrayList<Node>());

        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors)
            newNode.neighbors.add(clone(neighbor));
        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
