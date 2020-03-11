package com.mvp.model;

/**
 * Player's position, to be implemented for the concrete sport.
 *
 * @author pankaj prasad
 */
public interface Position<A extends Action> {

	/**
	 * Calculates player's rating based on player's position, action and
	 * action times.
	 *
	 * @param action Player's action
	 * @param times Times repeated
	 *
	 * @return Action rating
	 */
	public int getRating(A action, int times);
}
