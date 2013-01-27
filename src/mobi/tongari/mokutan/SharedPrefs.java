package mobi.tongari.mokutan;

import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultString;
import com.googlecode.androidannotations.annotations.sharedpreferences.SharedPref;

@SharedPref
public interface SharedPrefs {
	@DefaultString("")
	String userName();
}
