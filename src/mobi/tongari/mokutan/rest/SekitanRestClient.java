package mobi.tongari.mokutan.rest;

import mobi.tongari.mokutan.rest.info.CarName;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.googlecode.androidannotations.annotations.rest.Accept;
import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;
import com.googlecode.androidannotations.api.rest.MediaType;

@Rest(rootUrl = "http://sekitan.herokuapp.com", converters = { MappingJacksonHttpMessageConverter.class })
public interface SekitanRestClient {

	@Get("/car_names.json")
	@Accept(MediaType.APPLICATION_JSON)
	CarNameResponse getCarNames();

	@Get("/car_names/{id}.json")
	@Accept(MediaType.APPLICATION_JSON)
	CarName getCarName(String id);

	@Get("/top/get_json_one")
	@Accept(MediaType.APPLICATION_JSON)
	ExCarNameResponse getExCarName();

	@Get("/top/get_json_all")
	@Accept(MediaType.APPLICATION_JSON)
	ExCarNamesResponse getExCarNames();

	RestTemplate getRestTemplate();

	void setRestTemplate(RestTemplate restTemplate);
}
