import java.util.ArrayList;

public class ConvolutionalCode {
	
	static int[] reg = new int[6];
	static ArrayList<Integer> list=new ArrayList<Integer>();
	
	public static void main(String[] args) {
		String input = "10011010";
		int x = 0;
		for(int i = 0; i < input.length(); i++) {
			x= input.charAt(i)-'0';
			insertAndSum(x);
		}
		
	
		
		for(int i = 0; i < list.size(); i++) {
			if(i == 0 || i == 1) {
				System.out.print(list.get(i));
				continue;
			}
			if(i%2 == 0) {
				System.out.print(" ");
			}
			System.out.print(list.get(i));
		}
	}
	
	public static void insertAndSum(int input) {
		int sum1= input;
		int sum2= input;
		
		sum1 ^= reg[1];
		sum1 ^= reg[2];
		sum1 ^= reg[4];
		sum1 ^= reg[5];
		sum2 ^= reg[0];
		sum2 ^= reg[1];
		sum2 ^= reg[2];
		sum2 ^= reg[5];
		
		for(int i = reg.length -1; i > 0; i--) {
			reg[i] = reg[i-1];
		}
		reg[0] = input;
		list.add(sum1);
		list.add(sum2);
		
	}
	
	
	
	
}
