package com.foxminded.processors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.foxminded.count.cache.Cache;
import com.foxminded.count.processors.ProxyCountProcessor;

@RunWith(MockitoJUnitRunner.class)
class ProxyCountProcessorTest {

	private Cache cache = mock(Cache.class);

	@InjectMocks
	private ProxyCountProcessor processor = new ProxyCountProcessor();

	@Test
	void testCountingWithCache_ShouldNotUseRealCountProcessor_WhenAnswerIsInCache() {
		String input = "Hello World!";
		LinkedHashMap<Character, Integer> test = new LinkedHashMap<Character, Integer>();
		test.put('H', 1);
		test.put('e', 1);
		test.put('l', 3);
		test.put('o', 2);
		test.put(' ', 1);
		test.put('W', 1);
		test.put('r', 1);
		test.put('d', 1);
		test.put('!', 1);
//		cache.set(input, test);
		Mockito.when(cache.get(input)).thenReturn(test);
		assertEquals(test, processor.count(input));
		Mockito.verify(cache, atLeastOnce()).get(input);

	}

}
