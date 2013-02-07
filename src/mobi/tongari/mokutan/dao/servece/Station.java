package mobi.tongari.mokutan.dao.servece;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Station {

	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("maker_id")
	String makerId;

	public String getMakerId() {
		return makerId;
	}

	public void setMakerId(String makerId) {
		this.makerId = makerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@JsonProperty("name")
	String name;

	@JsonProperty("created_at")
	Date createdAt;

	@JsonProperty("updated_at")
	Date updatedAt;
}
