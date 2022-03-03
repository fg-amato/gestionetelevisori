package it.gestionetelevisori.utility;

public class NumberUtility {
	
	public static Integer fromStringToInt(String input) {
		try {
			Integer inputNumber = Integer.parseInt(input);
			return inputNumber;
		} catch(NumberFormatException nfe) {
			return null;
		}
	}
}
