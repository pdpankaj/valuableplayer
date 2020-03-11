package com.mvp.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvp.model.PlayerMatchStats;

/**
 * MVP utility methods.
 *
 * @author pankaj prasad
 */
public class ValuablePlayerUtil {

	/**
	 * Get Valuable Player nickname based on the players statistics.
	 *
	 * @param playerMatchStatsList Players statistics list.
	 * @return ValuablePlayer nickname
	 * @throws Exception
	 */
	public static String getValuablePlayerNick(
		List<PlayerMatchStats> playerMatchStatsList) throws Exception {

		Map<String, Integer> playerRatings = new HashMap<>();

		// calculate ratings for each player(assuming that nicknames are unique)
		for (PlayerMatchStats playerMatchStats : playerMatchStatsList) {
			int rating = playerRatings.getOrDefault(
				playerMatchStats.getPlayerNickName(), 0);

			rating += playerMatchStats.getRating();

			playerRatings.put(playerMatchStats.getPlayerNickName(), rating);
		}

		// get Valuable Player entry this the highest rating
		Map.Entry<String, Integer> mvpEntry = playerRatings.entrySet().stream()
			.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
			.limit(1).findFirst().get();

		return mvpEntry.getKey();
	}

}
