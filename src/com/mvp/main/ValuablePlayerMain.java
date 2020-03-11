package com.mvp.main;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvp.model.PlayerMatchStats;
import com.mvp.model.impl.Basketball;
import com.mvp.model.impl.Handball;
import com.mvp.reader.ValuablePlayerStatsReader;
import com.mvp.util.ValuablePlayerUtil;

/**
 * Valuable Player application main program.
 *
 * @author pankaj prasad
 */
public class ValuablePlayerMain {

	public static final Map<String, Class> SPORTS = new HashMap<>();

	// scope of this program for the below 2 sports only
	static {
		SPORTS.put("BASKETBALL", Basketball.class);
		SPORTS.put("HANDBALL", Handball.class);
	}

	public static void main(String[] args) throws Exception {

		// put your fileset path or user command line argument
		String filePath = "C:\\PP\\player\\data";

		File fileSet = new File(filePath);

		List<PlayerMatchStats> playerMatchStatsList = new ArrayList<>();

		// read all match files and add appropriate stats
		for (File file : fileSet.listFiles()) {
			playerMatchStatsList.addAll(
				ValuablePlayerStatsReader.readMatchStats(new FileInputStream(file)));
		}

		// get our player nickname
		System.out.println(
			"Player name: " + ValuablePlayerUtil.getValuablePlayerNick(playerMatchStatsList));
	}

}
