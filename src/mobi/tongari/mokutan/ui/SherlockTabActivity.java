package mobi.tongari.mokutan.ui;

import mobi.tongari.mokutan.R;
import android.support.v4.app.FragmentTransaction;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.OptionsItem;
import com.googlecode.androidannotations.annotations.OptionsMenu;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_sherlock_tab)
@OptionsMenu(R.menu.activity_sherlock_tab)
public class SherlockTabActivity extends SherlockActivity implements ActionBar.TabListener {

	@ViewById
	TextView text;
	
	@AfterViews
	void initViews(){
		text.setText("first!");
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		//getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
        for (int i = 1; i <= 3; i++) {
            ActionBar.Tab tab = getSupportActionBar().newTab();
            tab.setText("Tab " + i);
            tab.setTabListener(this);
            getSupportActionBar().addTab(tab);
        }
	}
	
	@OptionsItem({ R.id.menu_forgot_password })
	void multipleMenuItems() {
	}

	@OptionsItem
	boolean menuSettings(MenuItem item) {
		return true;
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		 text.setText("Selected: " + tab.getText());
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
}
