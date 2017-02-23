package model;

import java.math.BigDecimal;
import java.util.Scanner;

public class Service {

	public Debt form(char clientType) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj kwotê kredytu");
		BigDecimal value = scan.nextBigDecimal();
		scan.nextLine();
		String selectionD;
		System.out.println("Wybierz walutê kredytu: ");
		System.out.println("1 - PLN");
		System.out.println("2 - USD");
		System.out.println("3 - EUR");
		System.out.println("wybierz opcjê:");
		selectionD = scan.nextLine();
		String currency = null;
		if (selectionD.equals("1")) {

			currency = "PLN";
		}
		if (selectionD.equals("2")) {

			currency = "USD";
		}
		if (selectionD.equals("3")) {

			currency = "EUR";
		}
		System.out.println("Podaj imie d³u¿nika");
		String debtorName = scan.nextLine();
		System.out.println("Podaj nazwisko d³u¿nika");
		String debtorSurname = scan.nextLine();
		System.out.println("Podaj Pesel d³u¿nika");
		String debtorPesel = scan.nextLine();
		System.out.println("Podaj imie po¿yczkodawcy");
		String creditorName = scan.nextLine();
		System.out.println("Podaj nazwisko po¿yczkodawcy");
		String creditorSurname = scan.nextLine();
		System.out.println("Podaj Pesel po¿yczkodawcy");
		String creditorPesel = scan.nextLine();
		System.out.println("Podaj rodzaj kredytu ");
		String creditType = scan.nextLine();
		Debt newDebtor = new Debt(value, currency, debtorName, debtorSurname, debtorPesel, creditorName,
				creditorSurname, creditorPesel, clientType, creditType, false);
		return newDebtor;

	}

}
