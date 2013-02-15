package mobi.tongari.mokutan.ui;

import mobi.tongari.mokutan.R;
import mobi.tongari.mokutan.ui.widget.Header;
import android.app.Activity;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.res.StringRes;

@EActivity(R.layout.activity_base_layout)
public class NewerTopActivity extends Activity {

	@ViewById
	protected Header main_header;

	@StringRes
	String title_activity_newer_top;	
	
	@AfterViews
	void initViews() {
		main_header.setTexts(title_activity_newer_top);
	}

}
