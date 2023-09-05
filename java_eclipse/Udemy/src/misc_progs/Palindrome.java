package misc_progs;

public class Palindrome {
	
	private static String input = "racecar";
	private static String firstHalf;
	private static String secondHalf;
	
	public static void main(String[] args) {
		if (input.length() % 2 == 0) {
			for (int i = 0; i < (input.length() / 2); i++) {
				firstHalf += input.charAt(i);
			}
			for (int i = input.length() - 1; i > (input.length() / 2) - 1; i--) {
				secondHalf += input.charAt(i);
			}
		}
		else {
			for (int i = 0; i < ((input.length() - 1) / 2); i++) {
				firstHalf += input.charAt(i);
			}
			for (int i = input.length() - 1; i > ((input.length() - 1) / 2); i--) {
				secondHalf += input.charAt(i);
			}
		}
		System.out.println(firstHalf.compareTo(secondHalf) == 0);
	}
	
}
