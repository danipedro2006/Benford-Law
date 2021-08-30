package Benford;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Benford {

	private static int[] digitCounter = new int[9];
	private static double[] digitPercentage = new double[9];
	private static int lineCounter = 0;

	public static char getSignFigure(String input) {
		int index = 0;
		for (int i = 0; i < input.length(); i++) {
			if ((input.charAt(i) == '-') || (input.charAt(i) == '0') || (input.charAt(i) == '.')) {
				continue;
			} else {
				index = i;
				break;
			}
		}
		return input.charAt(index);
	}

	public static void putSigFigure(char input) {
		switch (input) {
		case '1':
			++digitCounter[0];
			break;
		case '2':
			++digitCounter[1];
			break;
		case '3':
			++digitCounter[2];
			break;
		case '4':
			++digitCounter[3];
			break;
		case '5':
			++digitCounter[4];
			break;
		case '6':
			++digitCounter[5];
			break;
		case '7':
			++digitCounter[6];
			break;
		case '8':
			++digitCounter[7];
			break;
		case '9':
			++digitCounter[8];
			break;
		}
	}

	public static void calcPercentage() {
		for (int i = 0; i < digitCounter.length; i++) {
			digitPercentage[i] = digitCounter[i] / (double) lineCounter * 100;
		}
	}

	public static String printStars(int index) {
		String stars = "*";
		long numStars = Math.round(digitPercentage[index]);
		for (int i = 0; i < numStars; i++) {
			stars += "*";
		}
		return stars;
	}

	public static void printGraph() {
		System.out.printf("%-3s %-10s %-30s \n", "#", "Percentage", "Graph");

		for (int i = 0; i < digitCounter.length; i++) {
			System.out.printf("%-3d %-10.3f %-30s \n", i + 1, digitPercentage[i], printStars(i));
		}
	}

	public static void main(String[] args) {
		String input;
		Scanner scan;
		try {
			scan = new Scanner(new File("C:\\Users\\danie\\eclipse-workspace\\Advanced\\data.txt"));

			while (scan.hasNextLine()) {
				lineCounter++;
				input = scan.nextLine();
				putSigFigure(getSignFigure(input));
			}

			calcPercentage();
			printGraph();
			scan.close();
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
