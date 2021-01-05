import java.util.Scanner;
import java.util.Arrays;

public class Turing {
	public static void main (String[] args)
    {
		// Input
		Scanner input = new Scanner(System.in);
		String text = input.next();
		String[] parts = text.split("#");
		String machine = parts[0]; // 004
		String word = parts[1]; // 034556
		
		// Turing Machine
		String[] machine_parts = machine.split("1", -1);
		String[] copy = Arrays.copyOf(machine_parts, machine_parts.length-1); 
		
		// Output
		System.out.println("You entered turing machine " + machine);
		System.out.println("You entered word " + word);
		System.out.println("You entered turing machine parts " + Arrays.toString(copy));
		input.close();
    }
}

// Test word: 010001101#000100