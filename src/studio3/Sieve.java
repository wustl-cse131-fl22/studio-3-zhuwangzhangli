package studio3;

import java.util.Scanner;

public class Sieve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] rawArray = new int[n];
		int c = 1;
		for (int i =0; i<n; i++) {
			rawArray[i] = c;
			c++;
		}
		boolean[] labelArray = new boolean[n]; // Use a boolean array to label composite number as true
		
		int start = 2; // Start is the number we use to divide numbers in the rawArray, thus to judge whether a number is a prime number or not
		while (start <= n/2) { // Iterate start from 2 to the sqrt of n
//			System.out.println(start); // You can uncomment this to check whether start is a prime
			for (int i = start; i<n; i++) {
				if (!labelArray[i] && rawArray[i]%start == 0) 
					labelArray[i] = true; // Label composite number as true
			}
			start++; // VERY IMPORTANT ! Without update it first the outer while loop won't stop!
			while (start<=n/2 && labelArray[start-1]) {
				start++; // Update start, by accepting only prime numbers to be start, the efficiency will improve
			}
		}
		System.out.println("prime number");
		labelArray[0] = true; // Change the number 1's label to true because 1 is not prime number
		for (int i=0; i<n; i++) {
			if (!labelArray[i])
				System.out.println(rawArray[i]);
		}
	}

}
