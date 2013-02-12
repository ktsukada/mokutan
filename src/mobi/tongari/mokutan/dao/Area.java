package mobi.tongari.mokutan.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "area")
public class Area {

	@DatabaseField(generatedId = true)
	private Integer id;

	public Integer getId() {
		return id;
	}

	@DatabaseField(canBeNull = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Area() {
		// ORMLite needs a no-arg constructor
	}

	public Area(String name) {
		this.name = name;
	}
}