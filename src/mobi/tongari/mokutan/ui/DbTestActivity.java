package mobi.tongari.mokutan.ui;

import java.sql.SQLException;

import mobi.tongari.mokutan.R;
import mobi.tongari.mokutan.dao.Area;
import mobi.tongari.mokutan.db.DatabaseHelper;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.OrmLiteDao;
import com.googlecode.androidannotations.annotations.ViewById;
import com.j256.ormlite.dao.Dao;

@EActivity(R.layout.activity_db_test)
public class DbTestActivity extends Activity {

	@OrmLiteDao(helper = DatabaseHelper.class, model = Area.class)
	Dao<Area, Long> areaDao;

	@ViewById
	Spinner areaSpinner;

	@AfterViews
	void initViews() {
		ArrayAdapter<Area> adapter = new ArrayAdapter<Area>(this,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		areaSpinner.setAdapter(adapter);
		try {
			for (Area item : areaDao.queryForAll()) {
				adapter.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Click
	void addDataButton() {
		try {
			areaDao.create(new Area("エリア"));
		} catch (SQLException e) {
			Toast.makeText(getApplicationContext(), "データが取得出来ませんでした。",
					Toast.LENGTH_SHORT).show();
		}
	}

	@Click
	void removeDataButton() {
		// try {
		//
		// } catch (SQLException e) {
		// Toast.makeText(getApplicationContext(), "データが取得出来ませんでした。",
		// Toast.LENGTH_SHORT);
		// // TODO: handle exception
		// }

	}
}
