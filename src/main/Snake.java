package main;

public class Snake implements Connector {
	private int head;
	private int tail;

	public Snake(int start, int end) {
		if (start > end) {
			this.head = start;
			this.tail = end;
		}
	}

	@Override
	public int getDestination(int position) {
		return hasEntryAt(position) ? tail : position;
	}

	@Override
	public boolean hasEntryAt(int position) {
		return position == head;
	}

}
