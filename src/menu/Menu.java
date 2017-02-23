package menu;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

import files.JsonFile;
import model.Debt;
import model.DebtorDatabase;
import model.Service;

public class Menu {

	public void displayMenu() {
		Scanner scan = new Scanner(System.in);

		String selection;
		DebtorDatabase debtorDatabase;

		JsonFile file = new JsonFile();
		try {

			debtorDatabase = file.load();
			System.out.println("Odczyt z bazy danych pomyœlny");
		} catch (FileNotFoundException e) {
			System.out.println("Brak pliku. Start z nowa baza");
			debtorDatabase = new DebtorDatabase("baza_dlugow");

		} catch (Exception e) {
			System.out.println("B³¹d odczytu. Start z owa baza");
			debtorDatabase = new DebtorDatabase("baza_dlugow");

			e.printStackTrace();
		}

		do {
			System.out.println("..::MENU::..");
			System.out.println("1 - dodaj d³ug");
			System.out.println("2 - usuñ d³ug");
			System.out.println("3 - oznacz d³ug jako sp³acony");
			System.out.println("4 - wyœwietl d³ugi");
			System.out.println("q - wyjœcie ");
			System.out.print("Wybierz w³aœciw¹ opcjê: ");
			selection = scan.nextLine();

			switch (selection) {
			case "1":
				String selection1;
				Service pick;
				Debt newDebtor;
				do {
					System.out.println("..::Dodaj d³ug::..");
					System.out.println("1 - Dodaj d³u¿nika");
					System.out.println("2 - Dodaj po¿yczkodawcê");
					System.out.println("3 - cofnij");
					System.out.print("Wybierz w³aœciw¹ opcjê: ");
					selection1 = scan.nextLine();
					switch (selection1) {
					case "1": // dodawanie d³u¿nika
						pick = new Service();
						newDebtor = pick.form('d');
						debtorDatabase.AddDebt(newDebtor);

						break;
					case "2": // dodawanie po¿yczkodawcy
						pick = new Service();
						newDebtor = pick.form('c');
						debtorDatabase.AddDebt(newDebtor);

						break;

					case "3": // powrót do menu wy¿ej

						break;

					default:
						System.out.println("Podales bledna opcje");
						break;
					}

				} while (!selection1.equals("3"));

				break;

			case "2": // usuwa d³ug
				debtorDatabase.DisplayDebtList();
				System.out.println("Podaj id do usuniêcia: ");
				int id = scan.nextInt();
				scan.hasNextLine();
				debtorDatabase.RemoveDebt(id);
				break;

			case "3": // oznacza d³ug jako sp³acony
				System.out.println("Podaj numer id kredytu do oznaczenia jako sp³acony ");
				int idRepaid = scan.nextInt();
				scan.nextLine();
				debtorDatabase.Payoff(idRepaid);
				System.out.println("d³ug oznaczono jako spa³cony");

				break;

			case "4": // wyœwietla liste
				debtorDatabase.DisplayDebtList();
				break;
			case "q": // zamyka program
				try {
					file.save(debtorDatabase);
					System.out.println("Zapis wykonany pomyœlnie");
				} catch (Exception e) {
					System.out.println("b³¹d zapisu do pliku");
					e.printStackTrace();
				}
				System.out.println("Koniec programu");

				break;

			default:
				System.out.println("Podales bledna opcje");
				break;
			}

		} while (!selection.equals("q"));

		scan.close();
	}

}
