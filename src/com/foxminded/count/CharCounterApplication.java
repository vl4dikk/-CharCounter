package com.foxminded.count;

import java.io.IOException;

import com.foxminded.count.managers.ConsoleManager;

public class CharCounterApplication {

	public static void main(String[] args) throws IOException {
		new ConsoleManager().run();
	}

}
