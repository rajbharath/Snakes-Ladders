package main;

import java.util.HashMap;
import java.util.Set;

/*
 * Responsible for 
 * - association between cell and a player
 * */
public class PlayersPlacements extends HashMap<Player, Cell> {
	PlayerPlacementChangedListener playerPlacementChangedListener;
	Cell startCell = new Cell(0, -1, -1);

	public PlayersPlacements(
			PlayerPlacementChangedListener playerPlacementChangedListener) {
		this.playerPlacementChangedListener = playerPlacementChangedListener;
	}

	@Override
	public Cell put(Player player, Cell cell) {
		Cell placedCell = super.put(player, cell);
		if (placedCell!=null && !get(player).equals(placedCell)) {
			notifyPlayerPlacementChangedListener(player);
			return placedCell;
		}
		return placedCell;
	}

	private void notifyPlayerPlacementChangedListener(Player player) {
		playerPlacementChangedListener.placementsUpdated(player);
	}

	@Override
	public Cell get(Object player) {
		return super.get(player) == null ? startCell : super.get(player);
	}

	@Override
	public String toString() {
		Set<Player> keys = keySet();
		String status = "";
		for (Player player : keys) {
			status += player.getName() + " " + get(player).getPosition() + "\n";
		}
		return status;
	}
}
