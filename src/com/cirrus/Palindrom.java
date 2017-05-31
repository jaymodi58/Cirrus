package com.cirrus;

import java.util.Scanner;

public class Palindrom {

	public static void main(String[] args) {

		int min = 0, max = 0;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("Enter min number: ");
			min = scanner.nextInt();
			System.out.print("Enter max number: ");
			max = scanner.nextInt();
			if (min <= max)
				break;
			else
				System.out.println("Please enter valid range.");
		} while (true);

		scanner.close();

		boolean isFound = false;

		for (int num = max; num >= min; num--) {
			int reminder, sum = 0;
			int original = num;
			int temp = num;

			while (temp > 0) {

				reminder = temp % 10;
				sum = (sum * 10) + reminder;
				temp /= 10;
			}

			if (sum == original) {
				System.out.println(	"The biggest palindrom number between " + min + " and " + max + " is " + original + ".");
				isFound = true;
				break;
			}

		}

		if (!isFound)
			System.out.println("No palindrom found!!!");

	}

}
