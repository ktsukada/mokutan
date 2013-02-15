package mobi.tongari.mokutan.ui.widget;


import mobi.tongari.mokutan.R;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

@EViewGroup(R.layout.header_close_button)
public class HeaderCloseButton extends LinearLayout {
	

	public HeaderCloseButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public HeaderCloseButton(Context context) {
		super(context);
	}	
		
	@Click
	void closeButtonClicked(){
		if(getContext() instanceof Activity){
			((Activity)getContext()).finish();
		}
	}

}