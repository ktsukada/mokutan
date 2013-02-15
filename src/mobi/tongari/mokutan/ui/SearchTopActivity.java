package mobi.tongari.mokutan.ui;

import mobi.tongari.mokutan.R;
import mobi.tongari.mokutan.R.drawable;
import mobi.tongari.mokutan.ui.widget.Header;
import mobi.tongari.mokutan.ui.widget.HeaderMapButton;
import mobi.tongari.mokutan.ui.widget.HeaderMapButton_;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.widget.Button;
import android.widget.LinearLayout;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.res.DrawableRes;
import com.googlecode.androidannotations.annotations.res.StringRes;

@EActivity(R.layout.activity_base_layout)
public class SearchTopActivity extends Activity {

	@ViewById
	protected Header main_header;

	@StringRes
	String title_activity_search_top;
	
	protected HeaderMapButton mapButton;
	
	@AfterViews
	void initViews() {
		main_header.setTexts(title_activity_search_top);
		
		mapButton = HeaderMapButton_.build(this);		
		mapButton.setToastText("検索画面からクリック");
		main_header.setRightLayoutParent(mapButton);					
	}
	
	
}
