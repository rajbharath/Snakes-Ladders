package main;

public class Ladder implements Connector {

	private int top;
	private int bottom;

	public Ladder(int start, int end) {
		if (end > start) {
			this.bottom = start;
			this.top = end;
		}
	}

	@Override
	public int getDestination(int position) {
		return hasEntryAt(position) ? top : position;
	}

	@Override
	public boolean hasEntryAt(int position) {
		// TODO Auto-generated method stub
		return bottom == position;
	}

}
