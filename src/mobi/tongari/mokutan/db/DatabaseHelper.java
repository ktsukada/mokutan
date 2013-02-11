package mobi.tongari.mokutan.db;

import java.sql.SQLException;

import mobi.tongari.mokutan.R;
import mobi.tongari.mokutan.dao.Area;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.googlecode.androidannotations.annotations.EBean;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

@EBean
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	public DatabaseHelper(Context context) {
		super(context, context.getString(R.string.db_file_name), null, context
				.getResources().getInteger(R.integer.db_version));
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(this.getConnectionSource(), Area.class);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase database,
			ConnectionSource connectionSource, int oldVar, int newVar) {
		try {
			TableUtils.dropTable(connectionSource, Area.class, true);
			onCreate(database, connectionSource);
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}