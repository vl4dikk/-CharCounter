package com.foxminded.count.managers;

import java.util.Map;

public class ViewManager {
	public String formatView (Map<Character, Integer> mapAfterProcessor) {
		StringBuilder formattedView = new StringBuilder();
		mapAfterProcessor.forEach((k, v) ->{
			formattedView.append('"').append(k).append('"').append('-').append(v).append("\n");
		});
		return formattedView.toString();
	}

}
