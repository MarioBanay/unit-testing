package com.mariobanay.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListMockTest {

	List<String> mock = mock(List.class);

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("Mario");
		assertEquals("Mario", mock.get(0));
		assertEquals(null, mock.get(1));
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("Mario");
		assertEquals("Mario", mock.get(0));
		assertEquals("Mario", mock.get(1));
	}
	
	public void verificationBasics() {
		
		// Provjera dali je određena metoda pozvana sa odr
		// parametrima određeni broj puta
		
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		// Pozvan je mock 2 puta s any int
		verify(mock).get(0);
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, times(2)).get(anyInt());
		
		// Pozvan je mock najviše 2 puta s any int
		verify(mock, atMost(2)).get(anyInt());
		
		// nikad nije pozvan s 2
		verify(mock, never()).get(2);
		
		
		
	}
}
