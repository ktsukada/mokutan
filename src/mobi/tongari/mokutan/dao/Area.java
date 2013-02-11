package mobi.tongari.mokutan.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "area")
public class Area {

	@DatabaseField(id = true)
	private String name;
	
	public Area() {
		// ORMLite needs a no-arg constructor
	}

	public Area(String name) {
		this.name = name;
	}
}