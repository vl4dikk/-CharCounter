package com.foxminded.count.managers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;

import com.foxminded.count.processors.ProxyCountProcessor;

class ViewManagerTest {

	private ViewManager view = new ViewManager();
	private ProxyCountProcessor processor = mock(ProxyCountProcessor.class);
	private LinkedHashMap<Character, Integer> test = new LinkedHashMap<Character, Integer>();

	@Test
	void testFormatting_ShouldReturnFormattedString_WhenGettingLinkedHashMap() {

		test.put('H', 1);
		test.put('e', 1);
		test.put('l', 3);
		test.put('o', 2);
		test.put(' ', 1);
		test.put('W', 1);
		test.put('r', 1);
		test.put('d', 1);
		test.put('!', 1);

		when(processor.count("Hello World!")).thenReturn(test);
		String expected = "\"H\"- 1\n" + "\"e\"- 1\n" + "\"l\"- 3\n" + "\"o\"- 2\n" + "\" \"- 1\n" + "\"W\"- 1\n"
				+ "\"r\"- 1\n" + "\"d\"- 1\n" + "\"!\"- 1\n" + "";
		assertEquals(expected, view.formatView(processor.count("Hello World!")));
		;
	}
	
	@Test
	void testEmptyString_ShouldReturnEmptyString_WhenStringIsEmpty() {
		when(processor.count("")).thenReturn(test);
		assertEquals("", view.formatView(processor.count("")));
	}
	
	@Test
	void testNullString_ShouldReturnException_WhenStringIsNull() {
		test.put(null, null);
		when(processor.count(null)).thenReturn(test);
		assertThrows(NullPointerException.class,() -> view.formatView(processor.count(null)));
	}

}
