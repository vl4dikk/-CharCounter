package com.foxminded.count.managers;

import java.util.LinkedHashMap;

public class ViewManager {
	public String formatView (LinkedHashMap<Character, Integer> mapAfterProcessor) {
		StringBuilder formattedView = new StringBuilder();
		mapAfterProcessor.forEach((k, v) ->{
			formattedView.append('"').append(k).append('"').append('-').append(" ").append(v).append("\n");
		});
		return formattedView.toString();
	}

}
