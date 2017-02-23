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
			System.out.println("Odczyt z bazy danych pomy�lny");
		} catch (FileNotFoundException e) {
			System.out.println("Brak pliku. Start z nowa baza");
			debtorDatabase = new DebtorDatabase("baza_dlugow");

		} catch (Exception e) {
			System.out.println("B��d odczytu. Start z owa baza");
			debtorDatabase = new DebtorDatabase("baza_dlugow");

			e.printStackTrace();
		}

		do {
			System.out.println("..::MENU::..");
			System.out.println("1 - dodaj d�ug");
			System.out.println("2 - usu� d�ug");
			System.out.println("3 - oznacz d�ug jako sp�acony");
			System.out.println("4 - wy�wietl d�ugi");
			System.out.println("q - wyj�cie ");
			System.out.print("Wybierz w�a�ciw� opcj�: ");
			selection = scan.nextLine();

			switch (selection) {
			case "1":
				String selection1;
				Service pick;
				Debt newDebtor;
				do {
					System.out.println("..::Dodaj d�ug::..");
					System.out.println("1 - Dodaj d�u�nika");
					System.out.println("2 - Dodaj po�yczkodawc�");
					System.out.println("3 - cofnij");
					System.out.print("Wybierz w�a�ciw� opcj�: ");
					selection1 = scan.nextLine();
					switch (selection1) {
					case "1": // dodawanie d�u�nika
						pick = new Service();
						newDebtor = pick.form('d');
						debtorDatabase.AddDebt(newDebtor);

						break;
					case "2": // dodawanie po�yczkodawcy
						pick = new Service();
						newDebtor = pick.form('c');
						debtorDatabase.AddDebt(newDebtor);

						break;

					case "3": // powr�t do menu wy�ej

						break;

					default:
						System.out.println("Podales bledna opcje");
						break;
					}

				} while (!selection1.equals("3"));

				break;

			case "2": // usuwa d�ug
				debtorDatabase.DisplayDebtList();
				System.out.println("Podaj id do usuni�cia: ");
				int id = scan.nextInt();
				scan.hasNextLine();
				debtorDatabase.RemoveDebt(id);
				break;

			case "3": // oznacza d�ug jako sp�acony
				System.out.println("Podaj numer id kredytu do oznaczenia jako sp�acony ");
				int idRepaid = scan.nextInt();
				scan.nextLine();
				debtorDatabase.Payoff(idRepaid);
				System.out.println("d�ug oznaczono jako spa�cony");

				break;

			case "4": // wy�wietla liste
				debtorDatabase.DisplayDebtList();
				break;
			case "q": // zamyka program
				try {
					file.save(debtorDatabase);
					System.out.println("Zapis wykonany pomy�lnie");
				} catch (Exception e) {
					System.out.println("b��d zapisu do pliku");
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
