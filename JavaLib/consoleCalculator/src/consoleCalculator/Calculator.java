package consoleCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Calculator {
	private Scanner input = new Scanner(System.in);
	private int firstNumber;
	private int secondNumber;
	private int currentMenuSelection;

	Test isHigherThanTen = a -> a > 10;
	private Set<Integer> numbersHigherThanTen = new TreeSet<>();

	public void start() {
		this.firstNumber = getNumbersMenu("Geben sie die erste Zahl ein: ");
		this.secondNumber = getNumbersMenu("Geben sie die zweite Zahl ein: ");

		this.currentMenuSelection = mainMenu();
		while (this.currentMenuSelection != 0) {
			this.applyCalculation();
			this.currentMenuSelection = mainMenu();
		}
		;

		this.printNumberStorage();

		System.out.println("");
		System.out.println("Programm Beendet");
	}

	private int mainMenu() {

		int selection;
		System.out.println();
		System.out.println("Wähle eine Option aus:");
		System.out.println("-------------------------\n");
		System.out.println("0 - Exit");
		System.out.println("1 - Summieren");
		System.out.println("2 - Subtrahieren");
		System.out.println("3 - Multiplizieren");
		System.out.println("4 - Dividieren");

		selection = this.input.nextInt();
		return selection;
	}

	private int getNumbersMenu(String message) {
		System.out.println(message);

		return getNextScannerInt();
	}

	private int getNextScannerInt() {
		int numberInput = 0;
		try {
			numberInput = this.input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Bitte nur Zahlen eingeben!!");
			this.input.next();
			getNextScannerInt();
		}

		return numberInput;
	}

	private void applyCalculation() {
		DoMath calculate = (a, b) -> 0.0;
		char operator = ' ';
		switch (this.currentMenuSelection) {
		case 1:
			calculate = (a, b) -> a + b;
			operator = '+';
			break;
		case 2:
			calculate = (a, b) -> a - b;
			operator = '-';
			break;
		case 3:
			calculate = (a, b) -> a * b;
			operator = '*';
			break;
		case 4:
			if (this.secondNumber == 0) {
				System.out.println("Dont divide by 0 bro, you know that");
				break;
			}
			calculate = (a, b) -> a / b;
			operator = '/';
			break;
		default:
			break;
		}
		showResult(operator, calculate.calculate(this.firstNumber, this.secondNumber));
	}

	private void showResult(char operator, double result) {
		System.out.println(this.firstNumber + " " + operator + " " + this.secondNumber + "=" + result);

		if (this.isHigherThanTen.test(result)) {
			this.numbersHigherThanTen.add((int)result);
		}
	}

	private void printNumberStorage() {
		System.out.println("");
		System.out.println("Numbers higher than 10:");
		for (Integer number : this.numbersHigherThanTen) {
			System.out.println("-     " + number + "");
		}
		System.out.println("");
	}
}
