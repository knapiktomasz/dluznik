package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class DebtorDatabase implements Serializable {

	private String databaseName;
	private ArrayList<Debt> debt;
	private int saveIndex;

	public DebtorDatabase() {
	}

	public DebtorDatabase(String databaseName) {
		this.databaseName = databaseName;
		debt = new ArrayList<>();
	}

	public void AddDebt(Debt newdebt) {

		debt.add(newdebt);

	}

	public void RemoveDebt(int id) {
		Iterator<Debt> iterator = debt.iterator();
		while (iterator.hasNext()) {
			Debt debt = (Debt) iterator.next();
			if (debt.getId() == id) {
				iterator.remove();

			}

		}

	}

	public void Payoff(int id) {
		for (int i = 0; i < debt.size(); i++) {
			if (debt.get(i).id == id) {
				debt.get(i).checkPayoff = true;

			}

		}

	}

	public void DisplayDebtList() {
		for (int i = 0; i < debt.size(); i++) {
			System.out.println((i + 1) + ". " + debt.get(i));
		}

	}

	public String getDatabaseName() {
		return databaseName;
	}

	public ArrayList<Debt> getDebt() {
		return debt;
	}

	public void setDebt(ArrayList<Debt> debt) {
		this.debt = debt;
	}

	public int getSaveIndex() {
		return saveIndex;
	}

	public void setSaveIndex(int saveIndex) {
		this.saveIndex = saveIndex;
	}

}
