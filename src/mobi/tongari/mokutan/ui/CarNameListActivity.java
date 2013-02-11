package mobi.tongari.mokutan.ui;

import java.util.List;

import mobi.tongari.mokutan.R;
import mobi.tongari.mokutan.adapter.CarNameListItem;
import mobi.tongari.mokutan.adapter.CarNamesAdapter;
import mobi.tongari.mokutan.rest.ExCarNamesResponse;
import mobi.tongari.mokutan.rest.SekitanRestClient;
import mobi.tongari.mokutan.rest.info.CarName;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ListView;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ItemClick;
import com.googlecode.androidannotations.annotations.ItemLongClick;
import com.googlecode.androidannotations.annotations.ItemSelect;
import com.googlecode.androidannotations.annotations.NoTitle;
import com.googlecode.androidannotations.annotations.NonConfigurationInstance;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.rest.RestService;

@NoTitle
@EActivity(R.layout.activity_car_name_list)
public class CarNameListActivity extends Activity {

	@ViewById
	ListView myListView;

	@RestService
	SekitanRestClient restClient;

	@Bean
	CarNamesAdapter adapter;

	@NonConfigurationInstance
	List<CarName> listItems;

	ProgressDialog progressDialog;  
	
	@AfterViews
	void initViews() {
		LayoutAnimationController layoutAnimation = AnimationUtils
				.loadLayoutAnimation(this, R.anim.list_slide_in_from_left);
		myListView.setLayoutAnimation(layoutAnimation);

		myListView.setAdapter(adapter);
	}

	@Click
	void showButton() {
		progressDialog = new ProgressDialog(CarNameListActivity.this);  
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);  
		progressDialog.setMessage("Loading...");  
		progressDialog.show();  
		getCarNamesInBackground();
	}
	
	@Background
	void getCarNamesInBackground() {
		ExCarNamesResponse response = restClient.getExCarNames();
		showList(response.getBody().data);
	}

	@UiThread
	void showList(List<CarName> items) {
		adapter.update(items);
		progressDialog.dismiss();
	}
	
	@ItemClick
	public void myListViewItemClicked(CarName clickedItem) {
	Toast.makeText(getApplicationContext(), "Clicked!",Toast.LENGTH_SHORT).show();
		
	}
	
	@ItemLongClick
	public void myListViewItemLongClicked(CarName clickedItem) {
		Toast.makeText(getApplicationContext(), "LongClicked!",Toast.LENGTH_SHORT).show();
	}

	@ItemSelect
	public void myListViewItemSelected(boolean selected, CarName selectedItem) {
		Toast.makeText(getApplicationContext(), "Selected!",Toast.LENGTH_SHORT).show();
	}

}
