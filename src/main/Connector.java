package main;

public interface Connector {
	public boolean hasEntryAt(int position);

	public int getDestination(int position);
}
