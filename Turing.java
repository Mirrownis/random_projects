import java.util.Scanner;
import java.util.Arrays;

public class Turing {
	public static void main (String[] args)
    {
		// Input
		Scanner input = new Scanner(System.in);
		String text = input.next();
		String[] parts = text.split("#");
		String [] tmp = parts[0].split("1", -1);
		String[] machine = Arrays.copyOf(tmp, tmp.length-1); 
		String word = parts[1];
		
		// Turing Machine
		
		// Output
		System.out.println("You entered turing machine " + parts[0]);
		System.out.println(Arrays.toString(machine));
		System.out.println("You entered word " + word);
		input.close();
    }
}

// Test word: 010001101#000100
