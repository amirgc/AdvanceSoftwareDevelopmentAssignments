package lab_11_01;

import java.util.Map;
import java.util.TreeMap;

public class DisplayNodeVisitor implements NodeVisitor {

	Map<String, Integer> rightNodeCount = new TreeMap<>();
	Map<String, Integer> leftNodeCount = new TreeMap<>();

	@Override
	public void visit(Root root) {
		System.out.println(root.getName());
		System.out.println("Right Nodes:");
		for (Composite node : root.getChildren()) {
			if (node.getSide().equals(Side.RIGHT)) {
				visit((Node) node);
			}
		}
		for (String key : rightNodeCount.keySet()) {
			System.out.println(String.format("%d nodes %s", rightNodeCount.get(key), key));
		}

		System.out.println("Left Nodes:");
		for (Composite node : root.getChildren()) {
			if (node.getSide().equals(Side.LEFT)) {
				visit((Node) node);
			}
		}
		for (String key : leftNodeCount.keySet()) {
			System.out.println(String.format("%d nodes %s", leftNodeCount.get(key), key));
		}

	}

	@Override
	public void visit(Node node) {
		if (node.getSide().equals(Side.RIGHT)) {
			rightNodeCount.put(node.getName(), 1);
		} else {
			leftNodeCount.put(node.getName(), 1);
		}
		for (Composite child : node.getChildren()) {
			if (child.getSide().equals(Side.RIGHT)) {
				visitAndCount(rightNodeCount, node.getName(), child);
			} else {
				visitAndCount(leftNodeCount, node.getName(), child);
			}

		}
	}

	private void visitAndCount(Map<String, Integer> nodeCount, String name, Composite node) {
		int count = nodeCount.get(name);
		nodeCount.put(name, count + 1);
		for (Composite child : node.getChildren()) {
			visitAndCount(nodeCount, name, child);
		}
	}

}
