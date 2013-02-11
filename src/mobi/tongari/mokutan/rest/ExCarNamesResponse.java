package mobi.tongari.mokutan.rest;

import mobi.tongari.mokutan.rest.info.ExCarNamesBody;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class ExCarNamesResponse {
	private ExCarNamesBody body;

	public ExCarNamesBody getBody() {
		return body;
	}
}
