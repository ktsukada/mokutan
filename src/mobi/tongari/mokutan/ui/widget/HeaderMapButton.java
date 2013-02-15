package mobi.tongari.mokutan.ui.widget;


import mobi.tongari.mokutan.R;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.ViewById;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

@EViewGroup(R.layout.header_map_button)
public class HeaderMapButton extends LinearLayout {
	
	@ViewById
	Button map_button;
	
	String toastText = null;
	
	public HeaderMapButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public HeaderMapButton(Context context) {
		super(context);
	}	
	
	public void setText(String text){
		map_button.setText(text);
	}
	public void setToastText(String text){
		toastText = text;
	}
	
	@Click
	void mapButtonClicked(){
		Toast.makeText(getContext(), toastText==null? "マップボタンクリック": toastText, Toast.LENGTH_SHORT).show();
	}

}