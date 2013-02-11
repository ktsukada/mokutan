package mobi.tongari.mokutan.rest.info;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarName {

	public String id;

	@JsonProperty("maker_id")
	public String makerId;

	@JsonProperty("name")
	public String name;
}
