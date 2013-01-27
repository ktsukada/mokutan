/**
 * 
 */
package mobi.tongari.mokutan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;

/**
 * @author k-tsukada
 * 
 */
@EActivity(R.layout.activity_top)
public class TopActivity extends Activity {

	@Pref
	SharedPrefs_ mPrefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_top);

		findViewById(R.id.sign_in_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						Intent intent = new Intent(TopActivity.this,
								LoginActivity.class);
						startActivity(intent);
					}
				});
	}

	@Click(R.id.sign_in_button)
	void onClickSignInButton() {
		Intent intent = new Intent(TopActivity.this, LoginActivity.class);
		startActivity(intent);
	}

	@Click(R.id.show_map_button)
	void onClickShowMapButton() {
		// MapActivity_.intent(getApplicationContext()).start();
		Intent intent = new Intent(getApplicationContext(), MapActivity.class);
		startActivity(intent);
	}

	@Click(R.id.show_ensen_list_button)
	void onClickShowEnsenListButton() {
		// EnsenListActivity_.intent(getApplicationContext()).start();
		Intent intent = new Intent(getApplicationContext(),
				EnsenListActivity_.class);
		startActivity(intent);
	}
}
