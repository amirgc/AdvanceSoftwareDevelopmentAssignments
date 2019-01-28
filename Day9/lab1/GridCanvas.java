package lab_10_01;

import javafx.scene.canvas.Canvas;

public class GridCanvas extends Canvas {
	private int row;
	private int column;

	public GridCanvas(double width, double height, int row, int column) {
		super(width, height);
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}
