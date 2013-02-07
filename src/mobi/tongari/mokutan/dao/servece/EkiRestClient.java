package mobi.tongari.mokutan.dao.servece;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.googlecode.androidannotations.annotations.rest.Accept;
import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;
import com.googlecode.androidannotations.api.rest.MediaType;

@Rest(rootUrl = "http://www.ekidata.jp/api", converters = { MappingJacksonHttpMessageConverter.class })
public interface EkiRestClient {

	@Get("/{id}")
	@Accept(MediaType.APPLICATION_JSON)
	void getEkilist(String id);

	RestTemplate getRestTemplate();

	void setRestTemplate(RestTemplate restTemplate);
}
