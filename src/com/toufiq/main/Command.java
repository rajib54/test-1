/**
 * This class is used to execute linux commands
 */
package com.toufiq.main;

import java.io.File;
import java.util.Arrays;

import com.toufiq.tail.Tail;

public class Command {
	private String[] command;

	/**
	 * Check if command is valid
	 * @return boolean : true if valid
	 */
	private boolean isValidCommand() {
		String[] validCommands = { "tail" };
		return Arrays.asList(validCommands).contains(command[0].toLowerCase());
	}

	public String[] getCommand() {
		return command;
	}

	public void setCommand(String[] command) {
		this.command = command;
	}

	/**
	 * Execute command
	 */
	public void executeCommand() {
		if (isValidCommand()) {
			switch (command[0].toLowerCase()) {
				case "tail":
					if(command.length == 2) {
						//if length is 2 then execute tail filename (i.e tail sample.txt) command
						File file = new File(command[1]);
						if(file.exists()) {
							Tail tail = new Tail(file);
							tail.printLastSelectedLines(10);
						}
						else
							System.out.println("File doesn't exist");
					}
					else {
						if(command[1].toLowerCase().equals("-f"))
							System.out.println("Executing -f command"); //not implemented. can be done in future
						else {
							//assuming it is -n. when we will implement other commands we can put else if conditions above
							File file = new File(command[1]);
							if(file.exists()) {
								if(command[2].equals("-n")) {
									if(command.length == 4) {
										//check if 4th parameter is a number
										String regex = "[0-9]+";
										if(command[3].matches(regex)) {
											int number = Integer.parseInt(command[3]);
											Tail tail = new Tail(file);
											tail.printLastSelectedLines(number);
										}
										else
											System.out.println("Please enter a valid number");
									}
									else
										System.out.println("Enter number of lines you need to print");
								}
								else
									System.out.println("Invalid command");
							}
							else
								System.out.println("File doesn't exist");
						}
					}
					break;
				
				default:
					break;
			}
		} else
			System.out.println("Invalid command");
	}
}
