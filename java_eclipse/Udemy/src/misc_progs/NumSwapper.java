package misc_progs;

public class NumSwapper {
	
	public static void main(String[] args) {
		int a = 90;
		int b = 18;	
		
		a += b;
		b = a - b;
		a = a - b;
					
		System.out.println(a);
		System.out.println(b);

	}
}
