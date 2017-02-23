package files;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Debt;
import model.DebtorDatabase;

public class JsonFile {

	public void save(DebtorDatabase debtorDatabase) throws Exception {
		debtorDatabase.setSaveIndex(Debt.getIndex());
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("baza_dluznikow.json"), debtorDatabase);
	}

	public DebtorDatabase load() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		DebtorDatabase debtorDatabase = mapper.readValue(new File("baza_dluznikow.json"), DebtorDatabase.class);
		Debt.setIndex(debtorDatabase.getSaveIndex());
		return debtorDatabase;

	}

}
