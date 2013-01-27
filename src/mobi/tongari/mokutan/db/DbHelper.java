package mobi.tongari.mokutan.db;

import java.io.IOException;

import mobi.tongari.mokutan.R;
import mobi.tongari.mokutan.dao.file.FileController;
import mobi.tongari.mokutan.util.Log.ExLog;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

final public class DbHelper extends SQLiteOpenHelper {

	private Context mContext;

	public DbHelper(final Context context) {
		super(context, context.getString(R.string.db_file_name), null, context
				.getResources().getInteger(R.integer.db_version));
		mContext = context;
	}

	@Override
	public void onCreate(final SQLiteDatabase db) {
		execSql(db, "sql/create");
	}

	@Override
	public void onUpgrade(final SQLiteDatabase db, final int oldVersion,
			final int newVersion) {
		execSql(db, "sql/drop");
		onCreate(db);
	}

	/**
	 * 引数に指定したassetsフォルダ内のsqlを実行します。
	 * 
	 * @param db
	 *            データベース
	 * @param assetsDir
	 *            assetsフォルダ内のフォルダのパス
	 * @throws IOException
	 */
	private void execSql(SQLiteDatabase db, String assetsDir) {
		AssetManager as = mContext.getResources().getAssets();
		try {
			String files[] = as.list(assetsDir);
			for (int i = 0; i < files.length; i++) {
				String str = FileController.readFile(
						as.open(assetsDir + "/" + files[i]),
						FileController.CHARACTER_CODE_SJIS);
				for (String sql : str.split(";")) {
					db.execSQL(sql);
				}
			}
		} catch (IOException e) {
			ExLog.e(e, "エラー発生：%s", e.getMessage());
			ExLog.saveLogAndPopupDialog(mContext);

		}
	}

}
