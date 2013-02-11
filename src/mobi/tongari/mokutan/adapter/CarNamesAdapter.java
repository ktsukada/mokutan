package mobi.tongari.mokutan.adapter;

import java.util.List;

import mobi.tongari.mokutan.rest.info.CarName;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;

@EBean
public class CarNamesAdapter extends BaseAdapter {

	@RootContext
	Context context;

	private List<CarName> items;

	@Override
	public int getCount() {
		return items == null ? 0 : items.size();
	}

	@Override
	public CarName getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CarNameListItem itemView;
		if (convertView == null) {
			itemView = CarNameListItem_.build(context);
		} else {
			itemView = (CarNameListItem) convertView;
		}

		CarName item = getItem(position);

		itemView.update(item);

		return itemView;
	}

	public void update(List<CarName> items) {
		this.items = items;
		notifyDataSetChanged();
	}

}
