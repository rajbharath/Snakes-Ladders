package main;

/*
 * IRule Interface is responsible for
 * - applying any rule between player and board class
 * */
public interface IRule {

	boolean isApplicable(Player player, Board board);
}
