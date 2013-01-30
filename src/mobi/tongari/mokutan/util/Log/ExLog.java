package mobi.tongari.mokutan.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import mobi.tongari.mokutan.util.EnvironmentUtil;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

public class ExLog {

	public final static String TAG = "SlcAssessment";

	private ExLog() {
	}

	// 順位
	// ERROR
	// WARN
	// INFO
	// DEBUG
	// VERBOSE

	// ERROR
	public static void e(String message) {
		Log.e(TAG, message);
	}

	public static void e(String format, Object... args) {
		Log.e(TAG, String.format(format, args));
	}

	public static void e(Throwable tr, String format, Object... args) {
		Log.e(TAG, String.format(format, args), tr);
	}

	// WARN

	public static void w(String message) {
		Log.w(TAG, message);
	}

	public static void w(String format, Object... args) {
		Log.w(TAG, String.format(format, args));
	}

	public static void w(Throwable tr, String format, Object... args) {
		Log.w(TAG, String.format(format, args), tr);
	}

	// INFO

	public static void i(String message) {
		Log.i(TAG, message);
	}

	public static void i(String format, Object... args) {
		Log.i(TAG, String.format(format, args));
	}

	public static void i(Throwable tr, String format, Object... args) {
		Log.i(TAG, String.format(format, args), tr);
	}

	// DEBUG

	public static void d(String message) {
		Log.d(TAG, message);
	}

	public static void d(String format, Object... args) {
		Log.d(TAG, String.format(format, args));
	}

	public static void d(Throwable tr, String format, Object... args) {
		Log.d(TAG, String.format(format, args), tr);
	}

	// VERBOSE

	public static void v(String message) {
		Log.v(TAG, message);
	}

	public static void v(String format, Object... args) {
		Log.v(TAG, String.format(format, args));
	}

	public static void v(Throwable tr, String format, Object... args) {
		Log.v(TAG, String.format(format, args), tr);
	}

	/**
	 * 現在のlogcatの内容をログファイルに出力する。
	 */
	public static void saveLogAndPopupDialog(final Context context) {
		saveLog();

		AlertDialog.Builder ad = new AlertDialog.Builder(context);
		ad.setMessage("システムエラーが発生しました。\n管理者に問い合わせてください。");
		ad.setPositiveButton(context.getString(android.R.string.ok),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {

						if (context instanceof Activity) {
							((Activity) context).finish();
						}

					}
				});
		ad.create();
		ad.show();
	}

	public static void saveLog() {
		Process proc = null;
		BufferedReader reader = null;
		BufferedWriter bw = null;
		try {
			ArrayList<String> commandLine = new ArrayList<String>();
			commandLine.add("logcat");
			commandLine.add("-d");
			commandLine.add("-v");
			commandLine.add("time");
			commandLine.add(TAG + ":I");
			commandLine.add(TAG + ":W");
			commandLine.add(TAG + ":D");
			commandLine.add("*:E");

			proc = Runtime.getRuntime().exec(
					commandLine.toArray(new String[commandLine.size()]));
			reader = new BufferedReader(new InputStreamReader(
					proc.getInputStream()), 1024);
			String line;

			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(EnvironmentUtil.getStoragePath()
							+ "/SlcAssessment.log"), "UTF-8"));
			while ((line = reader.readLine()) != null) {
				bw.write(line);
				bw.write(System.getProperty("line.separator"));
			}

			bw.flush();

		} catch (IOException e) {
			e(e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e(e, "log作成時にエラー発生:%s", e.getMessage());
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e(e, "log作成時にエラー発生:%s", e.getMessage());
				}
			}

		}
	}
}