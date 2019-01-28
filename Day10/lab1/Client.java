package lab_11_01;

public class Client {

	public static void main(String[] arg) {
		Composite root = buildData();

		NodeVisitor nodeVisitor = new DisplayNodeVisitor();
		root.accept(nodeVisitor);
	}

	private static Composite buildData() {
		Composite root = new Root("Topic");
		Composite nodeA = new Node("A", Side.RIGHT);
		Composite nodeA1 = new Node("A1");
		nodeA.addChild(nodeA1);
		Composite nodeAA1 = new Node("AA1");
		nodeA1.addChild(nodeAA1);
		Composite nodeAA2 = new Node("AA2");
		nodeA1.addChild(nodeAA2);
		Composite nodeAA3 = new Node("AA3");
		nodeA1.addChild(nodeAA3);

		Composite nodeA2 = new Node("A2");
		nodeA.addChild(nodeA2);

		Composite nodeB = new Node("B", Side.RIGHT);
		Composite nodeB1 = new Node("B1");
		nodeB.addChild(nodeB1);
		Composite nodeB2 = new Node("B2");
		nodeB.addChild(nodeB2);

		Composite nodeC = new Node("C", Side.RIGHT);
		Composite nodeC1 = new Node("C1");
		nodeC.addChild(nodeC1);
		Composite nodeC2 = new Node("C2");
		nodeC.addChild(nodeC2);

		Composite nodeD = new Node("D", Side.LEFT);
		Composite nodeD1 = new Node("D1");
		nodeD.addChild(nodeD1);
		Composite nodeD2 = new Node("D2");
		nodeD.addChild(nodeD2);
		Composite nodeE = new Node("E", Side.LEFT);
		Composite nodeE1 = new Node("E1");
		nodeE.addChild(nodeE1);
		Composite nodeE2 = new Node("E2");
		nodeE.addChild(nodeE2);
		Composite nodeE3 = new Node("E3");
		nodeE.addChild(nodeE3);
		Composite nodeF = new Node("F", Side.LEFT);
		Composite nodeF1 = new Node("F1");
		nodeF.addChild(nodeF1);
		Composite nodeF2 = new Node("F2");
		nodeF.addChild(nodeF2);
		root.addChild(nodeA);
		root.addChild(nodeB);
		root.addChild(nodeC);
		root.addChild(nodeD);
		root.addChild(nodeE);
		root.addChild(nodeF);

		return root;
	}
}
