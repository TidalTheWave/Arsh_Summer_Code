package test;

public class FibonacciSequence {
	
	public static void main(String[] args) {
		
		int currentNum = 1;
		int prevNum = 0;
		int temp = 0;
		System.out.println(prevNum);
	
		for(int i=0; i < 20; i++) {
			System.out.println(currentNum);
			temp = currentNum;
			currentNum += prevNum;
			prevNum = temp;						
		}
	}

}
