package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Debt implements Serializable {

	protected int id;
	protected Date dateCreate; // data utworzenia

	protected BigDecimal value; // kwota kredytu
	protected String currency; // waluta

	protected String debtorName; // imie d³u¿nika
	protected String debtorSurname; // nazwisko d³u¿nika
	protected String debtorPesel;

	protected String creditorName; // imie po¿yczkodawcy
	protected String creditorSurname; // imie po¿yczkodawcy
	protected String creditorPesel;

	protected char clientType; // wybór czy osoba jest d³u¿nikiem czy
								// po¿yczkodawc¹
	protected String creditType; // rodzaj po¿yczki (hopoteczna, konsumpcyjna,
									// obrotowa, etc)

	protected boolean checkPayoff; // oznaczenie sp³aconego d³ugu

	protected static int index = 1;

	public Debt() {

	}

	public Debt(BigDecimal value, String currency, String debtorName, String debtorSurname, String debtorPesel,
			String creditorName, String creditorSurname, String creditorPesel, char clientType, String creditType,
			boolean checkPayoff) {

		this.id = index++;
		this.dateCreate = new Date();
		this.value = value;
		this.currency = currency;
		this.debtorName = debtorName;
		this.debtorSurname = debtorSurname;
		this.debtorPesel = debtorPesel;
		this.creditorName = creditorName;
		this.creditorSurname = creditorSurname;
		this.creditorPesel = creditorPesel;
		this.clientType = clientType;
		this.creditType = creditType;
		this.checkPayoff = checkPayoff;
	}

	@Override
	public String toString() {
		return "Debt [id=" + id + ", dateCreate=" + dateCreate + ", value=" + value + ", currency=" + currency
				+ ", debtorName=" + debtorName + ", debtorSurname=" + debtorSurname + ", debtorPesel=" + debtorPesel
				+ ", creditorName=" + creditorName + ", creditorSurname=" + creditorSurname + ", creditorPesel="
				+ creditorPesel + ", clientType=" + clientType + ", creditType=" + creditType + ", checkPayoff="
				+ checkPayoff + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Debt other = (Debt) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getDebtorPesel() {
		return debtorPesel;
	}

	public void setDebtorPesel(String debtorPesel) {
		this.debtorPesel = debtorPesel;
	}

	public String getCreditorPesel() {
		return creditorPesel;
	}

	public void setCreditorPesel(String creditorPesel) {
		this.creditorPesel = creditorPesel;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		Debt.index = index;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDebtorName() {
		return debtorName;
	}

	public void setDebtorName(String debtorName) {
		this.debtorName = debtorName;
	}

	public String getDebtorSurname() {
		return debtorSurname;
	}

	public void setDebtorSurname(String debtorSurname) {
		this.debtorSurname = debtorSurname;
	}

	public String getCreditorName() {
		return creditorName;
	}

	public void setCreditorName(String creditorName) {
		this.creditorName = creditorName;
	}

	public String getCreditorSurname() {
		return creditorSurname;
	}

	public void setCreditorSurname(String creditorSurname) {
		this.creditorSurname = creditorSurname;
	}

	public char getClientType() {
		return clientType;
	}

	public void setClientType(char clientType) {
		this.clientType = clientType;
	}

	public String getCreditType() {
		return creditType;
	}

	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}

	public boolean isCheckPayoff() {
		return checkPayoff;
	}

	public void setCheckPayoff(boolean checkPayoff) {
		this.checkPayoff = checkPayoff;
	}

}
