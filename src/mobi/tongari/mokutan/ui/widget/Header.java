package mobi.tongari.mokutan.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.res.ColorRes;

import mobi.tongari.mokutan.R;

@EViewGroup(R.layout.header)
public class Header extends RelativeLayout{	


	public Header(Context context, AttributeSet attrs) {
		super(context, attrs);
	
	}

	@ViewById
	protected TextView title;
		
	@ViewById
	protected LinearLayout right_linerlayout;
	
	@ViewById
	protected LinearLayout left_linerlayout;
	
	@ColorRes
	protected int main_header_txt;

	public void setTexts(String titleText) {
		title.setText(titleText);
	}
	
	public void setRightLayoutParent(ViewGroup view) {	
		right_linerlayout.addView(view);
	}
	
	public void setLeftLayoutParent(ViewGroup view) {		
		left_linerlayout.addView(view);
	}
}