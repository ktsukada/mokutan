package mobi.tongari.mokutan.info;

import java.util.Date;

public class CarName {
	public String getMaker_id() {
		return maker_id;
	}
	public void setMaker_id(String maker_id) {
		this.maker_id = maker_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	String maker_id;
	String name;
	Date created_at;
	Date updated_at;
}
