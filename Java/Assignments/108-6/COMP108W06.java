//
// Enter your name: Killian Carolan
// Enter your student ID: 201823073
//
// The complexity of notExists() is O(n^2) as it contains a nested loop
//
// The complexity of count() is also O(n^2) as it contains another nested loop

import java.util.*;
import java.io.*;

class COMP108W06 {

	// print the content of an array of size n
	static void printArray(int[] data, int n) {
		int i;

		for (i=0; i < n; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}

	// Input: array1[] with size1 entries and array2[] with size2 entries
	// print all entries of array1[] that does not exist in array2[]
	static void notExists(int array1[], int size1, int array2[], int size2) {
		for (int i = 0; i < size1; i++) {
			boolean found = false;
			int j = 0;
			
			while (j < size2 && found != true) {
				if (array1[i] == array2[j]) {
					found = true;
				}
				j++;
			}

			if (found != true) {
				System.out.print(array1[i] + " ");
			}
		}
	}
		
	// Input: array1[] with size1 entries and array2[] with size2 entries
	// for each entry in array2[], count how many times it appears in array1[]
	static void count(int array1[], int size1, int array2[], int size2) {
		for (int i = 0; i < size2; i++) {
			int count = 0;

			for (int j = 0; j < size1; j++) {
				if (array2[i] == array1[j]) {
					count++;
				}
			}
			System.out.print(count + " ");
		}
	}
}
