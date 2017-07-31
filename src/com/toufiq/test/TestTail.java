package com.toufiq.test;


import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.toufiq.tail.Tail;

public class TestTail {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() {
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUp() {
		System.setOut(null);
	}

	@Test
	public void testNFunctionality() {
		File file = new File("sample.txt");
		Tail tail = new Tail(file);
		tail.printLastSelectedLines(5);
		String expectedString = "Line number 4\nLine number 5\nLine number 6\nLine number 7\nLine number 8".replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
		assertEquals(expectedString, outContent.toString().trim());
	}

}
