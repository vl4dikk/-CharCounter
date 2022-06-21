package com.foxminded.count.managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.foxminded.count.cache.Cache;
import com.foxminded.count.processors.CountProcessor;
import com.foxminded.count.processors.ProxyCountProcessor;

public class ConsoleManager {

	public void run() throws IOException {
		ViewManager view = new ViewManager();
		CountProcessor processor = new ProxyCountProcessor();
		Cache cache = new Cache();
		InputStreamReader streamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(streamReader);
		try {
			System.out.println("Enter your string: ");
			final String input = bufferedReader.readLine();

			System.out.println(view.formatView(processor.count(cache, input)));
		} catch (Exception ex) {
			System.out.println("Error has been occured: " + ex.getLocalizedMessage());
			ex.printStackTrace();
		} finally {
			System.out.println("\nDo you want to try again? (Y/n)");
			String confirm = bufferedReader.readLine();
			if (confirm.equalsIgnoreCase("Y")) {
				run();
			} else if (confirm.equalsIgnoreCase("n")) {
				System.out.println("Exiting...");
				bufferedReader.close();
				streamReader.close();
			} else {
				System.out.println("Could not resolve the answer. Exiting...");
				bufferedReader.close();
				streamReader.close();
			}
		}
	}

}
