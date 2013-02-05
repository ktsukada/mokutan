/**
 * 
 */
package mobi.tongari.mokutan;

import java.util.Collections;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import mobi.tongari.mokutan.info.CarName;
import mobi.tongari.mokutan.info.CarNameList;
import mobi.tongari.mokutan.service.SekitanRestClient;
import mobi.tongari.mokutan.util.Log.ExLog;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.rest.RestService;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;

/**
 * @author k-tsukada
 * 
 */
@EActivity(R.layout.activity_top)
public class TopActivity extends Activity {

	@RestService
	SekitanRestClient sekitanRestClient;

	// @Pref
	// SharedPrefs_ mPrefs;

	// @Override
	// protected void onCreate(Bundle savedInstanceState) {
	// // TODO Auto-generated method stub
	// super.onCreate(savedInstanceState);
	//
	// setContentView(R.layout.activity_top);
	//
	// findViewById(R.id.sign_in_button).setOnClickListener(
	// new View.OnClickListener() {
	// @Override
	// public void onClick(View view) {
	// Intent intent = new Intent(TopActivity.this,
	// LoginActivity.class);
	// startActivity(intent);
	// }
	// });
	// }

	@Click(R.id.sign_in_button)
	void onClickSignInButton() {
		Intent intent = new Intent(TopActivity.this, LoginActivity.class);
		startActivity(intent);
	}

	@Click(R.id.test1_button)
	void onClickTest1Button() {
		searchCarNamesAsync2();
	}

	@Click(R.id.show_map_button)
	void onClickShowMapButton() {
		// MapActivity_.intent(getApplicationContext()).start();
		// Intent intent = new Intent(getApplicationContext(),
		// MapActivity.class);
		// startActivity(intent);

		// CarNameList aa = sekitanRestClient.getCarNames();
		// ExLog.d("mokutan", aa.toString());
		searchCarNamesAsync();
	}

	@Click(R.id.show_ensen_list_button)
	void onClickShowEnsenListButton() {
		// EnsenListActivity_.intent(getApplicationContext()).start();
		// Intent intent = new Intent(getApplicationContext(),
		// EnsenListActivity_.class);
		// startActivity(intent);
	}

	@Background
	void searchCarNamesAsync() {
		try {
			// rest call
			RestTemplate restTemplate = new RestTemplate(true);
			sekitanRestClient.setRestTemplate(restTemplate);
			GsonHttpMessageConverter messageConverter = new GsonHttpMessageConverter();
			messageConverter.setSupportedMediaTypes(Collections
					.singletonList(new MediaType("text", "javascript")));
			sekitanRestClient.getRestTemplate().getMessageConverters()
					.add(messageConverter);

			CarNameList response = sekitanRestClient.getCarNames();

			updateCarName(response);

		} catch (Exception ex) {
			String a = "aaa";
		} finally {
		}
	}

	@Background
	void searchCarNamesAsync2() {
		try {

			CarNameList response = sekitanRestClient.getCarNames();

			updateCarName(response);

		} catch (Exception ex) {
			String a = "aaa";
		} finally {
		}
	}
	
	@UiThread
	public void updateCarName(CarNameList list) {
		// TODO Auto-generated method stub
		Log.d(" ", list.toString());
	}

}
