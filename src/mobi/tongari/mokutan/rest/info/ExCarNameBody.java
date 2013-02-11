package mobi.tongari.mokutan.rest.info;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonAutoDetect
@JsonRootName(value = "body")
public class ExCarNameBody {
	public Meta meta;
	public CarName data;
}
