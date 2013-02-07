package mobi.tongari.mokutan.ui;

import mobi.tongari.mokutan.R;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.OptionsItem;
import com.googlecode.androidannotations.annotations.OptionsMenu;

@EActivity(R.layout.activity_sherlock_tab)
@OptionsMenu(R.menu.activity_sherlock_tab)
public class SherlockTabActivity extends SherlockActivity {

	@OptionsItem({ R.id.menu_forgot_password })
	void multipleMenuItems() {
	}

	@OptionsItem
	boolean menuSettings(MenuItem item) {
		return true;
	}
}
