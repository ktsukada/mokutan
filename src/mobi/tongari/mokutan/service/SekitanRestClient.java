package mobi.tongari.mokutan.service;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;

@Rest(rootUrl = "http://sekitan.herokuapp.com/", converters = { MappingJacksonHttpMessageConverter.class })
public interface SekitanRestClient {

	@Get("car_names.json")
	Void getCarNames();

	@Get("car_names/{id}.json")
	Void getCarName(String id);

}
