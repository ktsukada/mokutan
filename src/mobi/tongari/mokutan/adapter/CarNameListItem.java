package mobi.tongari.mokutan.adapter;

import mobi.tongari.mokutan.R;
import mobi.tongari.mokutan.rest.info.CarName;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.car_name_list_item)
public class CarNameListItem extends FrameLayout {

	@ViewById
	TextView id;

	@ViewById
	TextView makerId;

	@ViewById
	TextView name;

	//
	// public SearchResultListItem(Context context, AttributeSet attrs,
	// int defStyle) {
	// super(context, attrs, defStyle);
	// }
	//
	// public SearchResultListItem(Context context, AttributeSet attrs) {
	// super(context, attrs);
	// }

	public CarNameListItem(Context context) {
		super(context);
	}

	@AfterViews
	void addInnerShadows() {
		// UiUtils.addTextInnerShadow(title);
		// UiUtils.addTextInnerShadow(company);
	}

	public void update(CarName item) {
		//TODO:編集などはここで行う
		
		id.setText(item.id);
		makerId.setText(item.makerId);
		name.setText(item.name);
	}

}
