package mobi.tongari.mokutan.rest.info;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta {
	private String status;

	public String getStatus() {
		return status;
	}

	public final String STATUS_CODE_NORMAL = "200";

	public boolean isError() {
		if (getStatus() == STATUS_CODE_NORMAL) {
			return false;
		} else {
			return true;
		}
	}
}
