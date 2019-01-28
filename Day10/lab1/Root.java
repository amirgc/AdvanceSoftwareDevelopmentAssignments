package lab_11_01;

public class Root extends Composite {
	public Root(String name) {
		setName(name);
	}

	@Override
	public Side getSide() {
		return Side.NONE;
	}

	@Override
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}

	@Override
	public void addChild(Composite child) {
		getChildren().add(child);
	}
}
