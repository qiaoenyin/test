package main.java.Test;

public class idCardTest {
	private static final int IDCARD_LEN = 18;
	private static final int[] INTARR = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9,
			10, 5, 8, 4, 2 };
	private static final int[] INTARR2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	private static final int[] INTARR3 = { 1, 0, 88, 9, 8, 7, 6, 5, 4, 3, 2 };
	
	
	public static boolean validator(Object input) {
		if (input == null) {
			return false;
		}
		String idCard = (String) input;
		if ((idCard == "") || (idCard.length() != 18)) {
			return false;
		}
		idCard = idCard.toUpperCase();

		int sum = 0;
		for (int i = 0; i < INTARR.length; ++i) {
			//{ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9,10, 5, 8, 4, 2 }
			//34030219980718182X
			System.out.println(idCard.charAt(i));
			System.out.println(Character.digit(idCard.charAt(i), 10));
			sum += Character.digit(idCard.charAt(i), 10) * INTARR[i];
		}
		int mod = sum % 11;
		String matchDigit = "";
		for (int i = 0; i < INTARR2.length; ++i) {
			int j = INTARR2[i];
			if (j == mod) {
				matchDigit = String.valueOf(INTARR3[i]);
				if (INTARR3[i] > 57) {
					matchDigit = String.valueOf((char) INTARR3[i]);
				}
			}
		}
		return matchDigit.equals(idCard.substring(idCard.length() - 1));
	}
	
	public static void main(String args[]){
		String idCard = "34122519900301727X";
		System.out.println(validator(idCard));
	}
}
