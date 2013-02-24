package mobi.tongari.mokutan.ui;

import mobi.tongari.mokutan.R;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.SupportMapFragment;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.FragmentById;

@EActivity(R.layout.activity_test_fragment)
public class TestFragmentActivity extends FragmentActivity {

@FragmentById
ExMapFragment fragment1;
	
@FragmentById
SupportMapFragment mapFragment;
	
}
