package mobi.tongari.mokutan.rest;

import mobi.tongari.mokutan.rest.info.ExCarNameBody;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class ExCarNameResponse {

	private ExCarNameBody body;

	public ExCarNameBody getBody() {
		return body;
	}

}
