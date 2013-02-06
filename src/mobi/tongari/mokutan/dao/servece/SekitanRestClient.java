package mobi.tongari.mokutan.dao.servece;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.googlecode.androidannotations.annotations.rest.Accept;
import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;
import com.googlecode.androidannotations.api.rest.MediaType;

//@Rest(rootUrl = "http://sekitan.herokuapp.com", converters = { GsonHttpMessageConverter.class })
@Rest(rootUrl = "http://sekitan.herokuapp.com", converters = { MappingJacksonHttpMessageConverter.class })
public interface SekitanRestClient {

	@Get("/car_names.json")
	@Accept(MediaType.APPLICATION_JSON)
	ResponseEntity<CarName> getCarNames();

	@Get("/car_names/{id}.json")
	CarName getCarName(String id);

	RestTemplate getRestTemplate();

	void setRestTemplate(RestTemplate restTemplate);
}