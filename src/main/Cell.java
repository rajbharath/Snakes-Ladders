package main;

/*
 * Cell is responsible for
 * -  wrapping position with its row and column 
 * */

public class Cell {

	private int position;
	private int row;
	private int column;

	public Cell(int position, int row, int column) {
		this.position = position;
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public boolean equals(Object obj) {
		Cell otherObj = (Cell) obj;
		return otherObj.getPosition() == getPosition()
				&& otherObj.getRow() == getRow()
				&& otherObj.getColumn() == getColumn();
	}

}
