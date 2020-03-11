package com.mvp.model.impl;

import java.util.List;
import java.util.Map;

import com.mvp.model.Sport;

/**
 * Basketball implementation.	
 *
 * @author pankaj prasad
 */
public class Handball implements Sport<HandballPlayerMatchStats> {

	@Override
	public int calculatePlayerRaiting(
		HandballPlayerMatchStats playerMatchStats) {

		int rating = 0;

		if (playerMatchStats.isTeamWon()) {
			rating += 10;
		}

		HandballPosition position = playerMatchStats.getPlayerPosition();

		Map<HandballAction, Integer> actions =
			playerMatchStats.getPlayerActions();

		for (HandballAction action : actions.keySet()) {
			rating += position.getRating(action, actions.get(action));
		}

		return rating;
	}

	@Override
	public int calculateTeamScore(
		String teamName,
		List<HandballPlayerMatchStats> playerMatchStatsList) {

		int teamScore = 0;

		for (HandballPlayerMatchStats playerMatchStats :
				playerMatchStatsList) {

			if (!playerMatchStats.getTeamName().equals(teamName)) {
				continue;
			}

			// handball team score depends on the goals made
			teamScore += playerMatchStats.getPlayerActions().get(
				HandballAction.GOAL_MADE);
		}

		return teamScore;
	}

	@Override
	public Class getPlayerMatchStatsClass() {
		return HandballPlayerMatchStats.class;
	}

}
