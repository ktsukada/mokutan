package mobi.tongari.mokutan.dao;

import java.util.List;

import mobi.tongari.mokutan.db.DatabaseHelper;
import mobi.tongari.mokutan.util.ExLog;
import android.accounts.Account;
import android.content.Context;
import android.util.Log;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.OrmLiteDao;
import com.googlecode.androidannotations.annotations.RootContext;
import com.j256.ormlite.dao.Dao;

@EBean
public class AreaModel {

	private static final String TAG = AreaModel.class.getSimpleName();

	@RootContext
	Context context;

	@OrmLiteDao(helper = DatabaseHelper.class, model = Area.class)
	Dao<Area, Long> areaDao;
	
	public void save(Area account) {
//		DatabaseHelper helper = new DatabaseHelper(context);
		try {
			areaDao.createOrUpdate(account);
		} catch (Exception e) {
			ExLog.e(TAG, "例外が発生しました", e);
		}
//		finally {
//			helper.close();
//		}
	}
	
	public List<Area> findAll() {
		DatabaseHelper helper = new DatabaseHelper(context);
		try {
			Dao<Area, Integer> dao = helper.getDao(Account.class);
			return dao.queryForAll();
		} catch (Exception e) {
			Log.e(TAG, "例外が発生しました", e);
			return null;
		} finally {
			helper.close();
		}
	}

}