package mobi.tongari.mokutan;

import android.app.Activity;
import android.view.Menu;

import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ItemClick;

@EActivity(R.layout.activity_ensen_list)
public class EnsenListActivity extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ensen_list, menu);
		return true;
	}

//	@ItemClick(R.id)
	public void onListItemClick(){
		
	}
}
