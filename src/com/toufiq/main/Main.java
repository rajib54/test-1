/**
 * This class implements main method
 */
package com.toufiq.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {		
		/**
		 * If any command line argument is passed execute the program based on that, else take input from user
		 */
		
		Command command = new Command();
		
		if(args.length > 0) {
			command.setCommand(args);
		}
		else {
			System.out.println("Enter the command");
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			try {
				String input = buf.readLine();
				command.setCommand(input.split(" "));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		command.executeCommand();
	}

}
