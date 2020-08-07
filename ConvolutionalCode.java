import java.util.ArrayList;

public class ConvolutionalCode {
	
	//reg array simulates registers which will store the input values for each successive iteration
	static int[] reg = new int[6];
	//list will store the output bits
	static ArrayList<Integer> list=new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		//this program excepts any string of bits
		String input = "10011010";
		int x = 0;
		
		for(int i = 0; i < input.length(); i++) {
			//convert each character in string to a numerical int value
			x= input.charAt(i)-'0';
			//pass each converted value to insertAndSum method
			insertAndSum(x);
		}
		
	
		/* loop is responsible for formatting and printing final output 
		 * so that every 2 bit couple is separated by a space
		 */
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
	} //end main
	
	/* Method takes one binary integer value as an argument.
	 * Must be either 1 or 0 to generate correct output.
	 * The method determines sum1 and sum2 values, which are the output bits.
	 * Sum calculations are done using XOR operations on each of the register values
	 * because the the sum is a binary value. Register values are moved up one position 
	 * each time the function is called and a new input is added. 
	 */
	public static void insertAndSum(int input) {
		
		//after XOR operations, sum1 and sum2 will represent output bit one and out bit two respectively
		int sum1= input;
		int sum2= input;
		
		//bitwise XOR operation on register values to find sum
		sum1 ^= reg[1];
		sum1 ^= reg[2];
		sum1 ^= reg[4];
		sum1 ^= reg[5];
		sum2 ^= reg[0];
		sum2 ^= reg[1];
		sum2 ^= reg[2];
		sum2 ^= reg[5];
		
		//move all array values up one position 
		for(int i = reg.length -1; i > 0; i--) {
			reg[i] = reg[i-1];
		}
		//add most recent input to register array
		reg[0] = input;
		
		//add output bit one and two to the list
		list.add(sum1);
		list.add(sum2);
		
	}	
}
