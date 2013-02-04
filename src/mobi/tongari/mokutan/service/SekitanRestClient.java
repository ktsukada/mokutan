package mobi.tongari.mokutan.service;

import mobi.tongari.mokutan.info.CarName;
import mobi.tongari.mokutan.info.CarNameList;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;

@Rest(rootUrl = "http://sekitan.herokuapp.com", converters = { GsonHttpMessageConverter.class })
public interface SekitanRestClient {

	@Get("/car_names.json")
	CarNameList getCarNames();

	@Get("/car_names/{id}.json")
	CarName getCarName(String id);

	RestTemplate getRestTemplate();
	
	void setRestTemplate(RestTemplate restTemplate);
}
