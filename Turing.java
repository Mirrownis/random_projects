import java.util.Scanner;
import java.util.Arrays;

public class Turing {
	public static void main (String[] args)
    {
		// Input
		Scanner input = new Scanner(System.in);
		String text = input.next();
		String[] parts = text.split("#");
		String [] tmp1 = parts[0].split("1", -1);
		String[] machine = Arrays.copyOf(tmp1, tmp1.length-1); 
		char[] word = parts[1].toCharArray();
		
		
		// Definition Turing Machine
		
		// Number of states
		String states = machine[0];
		// Number of input characters
		String symbols = machine[1];
		// Number of accepting states
		int k = machine[2].length();
		// Array of accepting states
		int[] f = new int[k];
		for (int i = 0; i < k; i++) {
			  f[i] = machine[i+3].length();
			}
		
		// Working the Turing Machine
		int done = 0;
		int accepted = 0;
		int q = 1;	//current state
		int p = 0; //head position
		int a = 0; //symbol at head position
		while (done == 0) {
			
			//arm 'done' to default to machine stopping
			done = 1;
			
			//check if current state is accepting
			for (int i = 0; i < k; i++) {
				if (q == f[i]) {
					accepted = 1;
				} else {
					accepted = 0;
				}
			}
			
			//update what the head reads
			switch (Integer.parseInt(String.valueOf(word[p]))) {
			case 0: a = 1; break;
			case 1: a = 2; break;
			default: a = 3; break;
			}
			
			//check if there is a transition from the current state
			//then check if it also is for the current symbol
			//if able, do the transition and disarm 'done'
			for (int i = k+3; i < machine.length; i = i+5) {
				if (machine[i].length() == q) {
						if (machine[i+1].length() == a) {
							
							//change to new state
							q = machine[i+2].length();
							
							//write new symbol on word
							switch (machine[i+3].length()) {
							case 1: word[p] = '0'; break;
							case 2: word[p] = '1'; break;
							default: word[p] = 'U'; break;
							}
							
							//change head position
							switch (machine[i+4].length()) {
							case 1: p--; break;
							case 2: p++; break;
							default: break;
							}
							
							// disarm 'done', since transition was possible
							done = 0;
						}
					}
				}
			}
		
		// Output
		System.out.println("You entered turing machine " + parts[0]);
		System.out.println(Arrays.toString(machine));
		System.out.println("You entered word " + new String(word));
		System.out.println("Word was accepted: " + Integer.toString(accepted));
		input.close();
    }
}

// Test word: 0100010101#1
