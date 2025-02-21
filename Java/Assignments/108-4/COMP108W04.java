//
// Enter your name: Killian Ferdinand Carolan
// Enter your student ID: 201823073
//
import java.util.*;
import java.io.*;

class COMP108W04 {

	static void sumFromOne(int number) {
		int i;
		int sum = 0;
		
		i = 1;
		sum = 0;
		while (i <= number) {
			sum = sum + i;
			i = i + 1;
		}
 		System.out.println("Sum from 1 to " + number + " equals to " + sum); 

	}

	static void sumFromTo(int numberX, int numberY) {
		int sum = 0;
		for (int i = numberX; i <= numberY; i++) {
			sum += i;
		}
 		System.out.println("Sum from " + numberX + " to " + numberY + " equals to " + sum);
	}
	
	static void isFactor(int numberX, int numberY) {
		if (numberX % numberY == 0)
			System.out.println(numberY + " is a factor of " + numberX);
		else
			System.out.println(numberY + " is not a factor of " + numberX);
	}

	static void multipleFactor(int numberX, int numberY) {
	
		for (int i = numberX; i <= numberY; i += numberX) {
			if (numberY % i == 0) {
				System.out.print(i + " ");
			}
		}
	

	}

	static void bugOne(int numberX, int numberY) {
		int i, bound;
		
		i = numberY;
		bound = 100;
		System.out.print("Common Multiples up to " + bound + ": ");
		while (i <= bound) {
			if (i % numberX == 0)
				System.out.print(i + " ");
			i+=numberY;
		}
		System.out.println();
	}

}
