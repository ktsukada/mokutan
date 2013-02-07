package mobi.tongari.mokutan.ui;

import mobi.tongari.mokutan.R;
import mobi.tongari.mokutan.R.layout;
import mobi.tongari.mokutan.R.menu;
import mobi.tongari.mokutan.dao.servece.SekitanRestClient;
import android.app.Activity;
import android.view.Menu;

import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.rest.RestService;

@EActivity(R.layout.activity_ensen_list)
public class EnsenListActivity extends Activity {

	@RestService
	SekitanRestClient sekitanRestClient;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ensen_list, menu);
		return true;
	}

	// @ItemClick(R.id)
	public void onListItemClick() {
		// List<CarName> aa = sekitanRestClient.getCarNames();
		// ExLog.d("mokutan", aa.toString());
	}

}
