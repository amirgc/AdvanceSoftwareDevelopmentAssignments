package lab_11_01;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite implements Component {
	private String name;
	private Side side;
	private List<Composite> children = new ArrayList<Composite>();

	public abstract void accept(NodeVisitor nodeVisitor);

	public abstract void addChild(Composite child);

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Side getSide() {
		return side;
	}

	public List<Composite> getChildren() {
		return children;
	}

	public void setChildren(List<Composite> children) {
		this.children = children;
	}

	public void setSide(Side side) {
		this.side = side;
	}

}
