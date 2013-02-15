package mobi.tongari.mokutan.ui;

import mobi.tongari.mokutan.R;
import mobi.tongari.mokutan.ui.widget.Header;
import android.app.Activity;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_base_layout)
public class BaseLayoutActivity extends Activity {

	@ViewById
	protected Header main_header;
	
	@AfterViews
	void initViews() {
		main_header.setTexts("デザインベース");
	}

}
