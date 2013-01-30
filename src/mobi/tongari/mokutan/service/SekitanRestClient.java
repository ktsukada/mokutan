package mobi.tongari.mokutan.service;

import java.util.List;

import mobi.tongari.mokutan.info.CarName;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;

@Rest(rootUrl = "http://sekitan.herokuapp.com/", converters = { MappingJacksonHttpMessageConverter.class })
public interface SekitanRestClient {

	@Get("car_names.json")
	List<CarName> getCarNames();

	@Get("car_names/{id}.json")
	CarName getCarName(String id);

}
