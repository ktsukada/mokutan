package mobi.tongari.mokutan.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EViewGroup;
import mobi.tongari.mokutan.R;
import mobi.tongari.mokutan.ui.MyClipTopActivity_;
import mobi.tongari.mokutan.ui.MyPageTopActivity_;
import mobi.tongari.mokutan.ui.NewerTopActivity_;
import mobi.tongari.mokutan.ui.SearchTopActivity_;

@EViewGroup(R.layout.footer)
public class Footer extends LinearLayout{	

	public Footer(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Click
	void newerTopButtonClicked() {
		NewerTopActivity_.intent(getContext()).flags(Intent.FLAG_ACTIVITY_CLEAR_TOP).start();
	}
	
	@Click
	void searchTopButtonClicked() {
		SearchTopActivity_.intent(getContext()).flags(Intent.FLAG_ACTIVITY_CLEAR_TOP).start();
	}
	
	@Click
	void myclipTopButtonClicked() {
		MyClipTopActivity_.intent(getContext()).flags(Intent.FLAG_ACTIVITY_CLEAR_TOP).start();
	}
	
	@Click
	void mypageTopButtonClicked() {
		MyPageTopActivity_.intent(getContext()).flags(Intent.FLAG_ACTIVITY_CLEAR_TOP).start();
	}

	

}