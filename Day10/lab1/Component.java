package lab_11_01;

public interface Component {

	public void accept(NodeVisitor nodeVisitor);

	public Side getSide();

	public String getName();
}
