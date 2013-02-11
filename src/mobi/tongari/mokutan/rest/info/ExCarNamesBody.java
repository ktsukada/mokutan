package mobi.tongari.mokutan.rest.info;

import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonAutoDetect
@JsonRootName(value = "body")
public class ExCarNamesBody {
	public Meta meta;
	public List<CarName> data;
}
