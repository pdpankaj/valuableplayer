package com.mvp.model.impl;

import java.util.List;
import java.util.Map;

import com.mvp.model.Sport;

/**
 * Basketball implementation.
 *
 * @author pankaj prasad
 */
public class Basketball implements Sport<BasketballPlayerMatchStats> {

	@Override
	public int calculatePlayerRaiting(
		BasketballPlayerMatchStats playerMatchStats) {

		int rating = 0;

		if (playerMatchStats.isTeamWon()) {
			rating += 10;
		}

		BasketballPosition position = playerMatchStats.getPlayerPosition();

		Map<BasketballAction, Integer> actions =
			playerMatchStats.getPlayerActions();


		for (BasketballAction action : actions.keySet()) {
			rating += position.getRating(action, actions.get(action));
		}

		return rating;
	}

	@Override
	public int calculateTeamScore(
		String teamName,
		List<BasketballPlayerMatchStats> playerMatchStatsList) {

		int teamScore = 0;

		for (BasketballPlayerMatchStats playerMatchStats :
				playerMatchStatsList) {

			// calculate team score only for appropriate team
			if (!playerMatchStats.getTeamName().equals(teamName)) {
				continue;
			}

			// basketball team score based on scored points
			teamScore += playerMatchStats.getPlayerActions().get(
				BasketballAction.SCORE);
		}

		return teamScore;
	}

	@Override
	public Class getPlayerMatchStatsClass() {
		return BasketballPlayerMatchStats.class;
	}

}
