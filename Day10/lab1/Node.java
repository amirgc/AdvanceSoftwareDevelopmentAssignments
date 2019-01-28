package lab_11_01;

public class Node extends Composite {

	public Node(String name) {
		setName(name);
	}

	public Node(String name, Side side) {
		this(name);
		setSide(side);
	}

	@Override
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}

	@Override
	public void addChild(Composite child) {
		child.setSide(getSide());
		getChildren().add(child);
	}
}
