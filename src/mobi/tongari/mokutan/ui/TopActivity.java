/**
 * 
 */
package mobi.tongari.mokutan.ui;

import mobi.tongari.mokutan.R;
import mobi.tongari.mokutan.SharedPrefs_;
import mobi.tongari.mokutan.rest.CarNameResponse;
import mobi.tongari.mokutan.rest.ExCarNameResponse;
import mobi.tongari.mokutan.rest.ExCarNamesResponse;
import mobi.tongari.mokutan.rest.SekitanRestClient;
import mobi.tongari.mokutan.rest.info.CarName;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;

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

	@Pref
	SharedPrefs_ myPrefs;

	@AfterViews
	void init() {
		// SharedPreferencesの使い方
		myPrefs.clear(); // 初期化

		myPrefs.userName().put("testTaro"); // セットするとき

		myPrefs.userName().get(); // 参照するとき
	}

	@Click(R.id.sign_in_button)
	void onClickSignInButton() {
		Intent intent = new Intent(TopActivity.this, LoginActivity.class);
		startActivity(intent);
	}

	@Click(R.id.show_map_button)
	void onClickShowMapButton() {
		MapActivity_.intent(this).start();
	}

	@Click(R.id.test1_button)
	void onClickTest1Button() {
		searchCarNamesAsync2();
	}

	@Click(R.id.test2_button)
	void onClickTest2Button() {
		test2Async();
	}

	@Background
	void test2Async() {
		try {

			ExCarNamesResponse response = sekitanRestClient.getExCarNames();

			response.toString();

		} catch (Exception ex) {
			String a = "aaa";
			a.getBytes();
		} finally {
		}
	}

	@Click(R.id.test3_button)
	void onClickTest3Button() {
		test3Async();
	}

	@Background
	void test3Async() {
		try {

			ExCarNameResponse response = sekitanRestClient.getExCarName();

			response.toString();

		} catch (Exception ex) {
			String a = "aaa";
			a.getBytes();
		} finally {
		}
	}

	@Click(R.id.test4_button)
	void onClickTest4Button() {
		CarNameListActivity_.intent(this).start();
	}

	@Click(R.id.test5_button)
	void onClickTest5Button() {
		DbTestActivity_.intent(this).start();
	}

	@Click(R.id.test6_button)
	void onClickTest6Button() {

	}

	@Click(R.id.test7_button)
	void onClickTest7Button() {

	}

	@Background
	void searchCarNamesAsync() {
		try {
			CarNameResponse response = sekitanRestClient.getCarNames();
			updateCarName(response);

		} catch (Exception ex) {
			String a = "aaa";
		} finally {
		}
	}

	@Background
	void searchCarNamesAsync2() {
		try {

			CarName response = sekitanRestClient.getCarName("4");
			updateCarName2(response);

		} catch (Exception ex) {
			String a = "aaa";
		} finally {
		}
	}

	@UiThread
	public void updateCarName(CarNameResponse list) {
		// TODO Auto-generated method stub
		Log.d(" ", list.toString());
	}

	@UiThread
	public void updateCarName2(CarName list) {
		// TODO Auto-generated method stub
		Log.d(" ", list.toString());
	}

}
