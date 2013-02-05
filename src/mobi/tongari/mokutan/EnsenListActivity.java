package mobi.tongari.mokutan;

import java.util.List;

import mobi.tongari.mokutan.info.CarNameList;
import mobi.tongari.mokutan.service.SekitanRestClient;
import mobi.tongari.mokutan.util.Log.ExLog;
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
//		List<CarName> aa = sekitanRestClient.getCarNames();
//		ExLog.d("mokutan", aa.toString());
	}
	
	
}
