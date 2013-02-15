package mobi.tongari.mokutan.ui;

import mobi.tongari.mokutan.R;
import mobi.tongari.mokutan.ui.widget.Header;
import mobi.tongari.mokutan.ui.widget.HeaderCloseButton;
import mobi.tongari.mokutan.ui.widget.HeaderCloseButton_;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.res.AnimationRes;
import com.googlecode.androidannotations.annotations.res.StringRes;

import android.app.Activity;
import android.content.Intent;
import android.opengl.Visibility;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;

@EActivity(R.layout.activity_register_top_layout)
public class RegisterTopActivity extends Activity {
	
	@ViewById
	protected Header main_header;
	
	@ViewById
	FrameLayout popup_frame;
	
	@AnimationRes
	Animation fadeIn;
	
	@AnimationRes
	Animation fadeOut;

	@StringRes
	String title_activity_register;	
	
	protected HeaderCloseButton closeButton;
	
	@AfterViews
	void initViews() {
		main_header.setTexts(title_activity_register);
		closeButton = HeaderCloseButton_.build(this);
		main_header.setRightLayoutParent(closeButton);		
	}
	
	@Click
	void registButtonClicked(){
		fadeIn.setStartTime(0);
		fadeIn.setDuration(1000);
		popup_frame.setVisibility(View.VISIBLE);
		popup_frame.setAnimation(fadeIn);
		
	}
	

	@Click
	void loginButtonClicked(){
		
	}
	
	/* ユーザ登録方法の選択 */
	@Click
	void registMailButtonClicked(){
		
		// Intentインスタンスを生成
		Intent intent = new Intent();

		// アクションを指定(ACTION_SENDTOではないところがミソ)
		intent.setAction(Intent.ACTION_SEND);
		// データタイプを指定
		intent.setType("message/rfc822");
		// 宛先を指定
		intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"foo@example.com"});
		// 件名を指定
		intent.putExtra(Intent.EXTRA_SUBJECT, "件名");
		// 本文を指定
		intent.putExtra(Intent.EXTRA_TEXT, "本文の内容");

		// Intentを発行
		startActivity(intent);

	}
	
	@Click
	void registTwitterButtonClicked(){
		
	}
	
	@Click
	void registFacebookButtonClicked(){
		
	}
	
	@Click
	void registMixiButtonClicked(){
		
	}
	
	@Click
	void registCancelButtonClicked(){
		fadeOut.setStartTime(0);
		fadeOut.setDuration(1000);
		popup_frame.setAnimation(fadeOut);
		popup_frame.setVisibility(View.GONE);
	}


}
