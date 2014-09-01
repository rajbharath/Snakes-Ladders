package main;

import java.util.HashMap;

public class PlayersPlacements extends HashMap<Player, Cell> {
	PlayerPlacementChangedListener playerPlacementChangedListener;

	@Override
	public Cell put(Player player, Cell cell) {
		notifyPlayerPlacementChangedListener(player);
		return super.put(player, cell);
	}

	private void notifyPlayerPlacementChangedListener(Player player) {
		playerPlacementChangedListener.placementsUpdated(player);
	}
}
