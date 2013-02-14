package mobi.tongari.mokutan.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mobi.tongari.mokutan.R;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.FragmentById;
import com.googlecode.androidannotations.annotations.OptionsItem;
import com.googlecode.androidannotations.annotations.SystemService;

@EActivity(R.layout.activity_map)
public class MapActivity extends FragmentActivity implements
		GoogleMap.OnInfoWindowClickListener {

	@FragmentById
	SupportMapFragment mapFragment;

	GoogleMap map;

	//TODO: modelに変更
	Map<String, String> markers = new HashMap<String, String>();

	@SystemService
	LocationManager locationManager;

	@AfterViews
	void initVIews() {
	}

	@Override
	protected void onResume() {
		super.onResume();

		if (map == null) {
			map = mapFragment.getMap();
			if (map != null) {
				setupMap();
			}
		}
	}

	@OptionsItem
	void MenuSettings() {

	}

	void setupMap() {
		List<MarkerOptions> list = new ArrayList<MarkerOptions>();
		list.add(new MarkerOptions()
				.position(new LatLng(35.652772, 139.747649)).title("ぱぴぷぺぽ")
				.snippet("こまかい情報！！！！！！！！"));
		list.add(new MarkerOptions().position(new LatLng(35.648448, 139.74884))
				.title("あああああ").snippet("おおおおお"));
		list.add(new MarkerOptions()
				.position(new LatLng(35.652432, 139.749377))
				.title("うおーーーーーーいいいいいいいいいいいい").snippet("おおおおお"));
		this.protMarkers(list);
		this.configMap();

		this.moveCamera(true, getMyLocation());
	}

	void protMarkers(List<MarkerOptions> options) {
		for (MarkerOptions option : options) {
			// /marker.icon(arg0);
			Marker marker = map.addMarker(option);
			markers.put(marker.getId(), "item1");
		}
	}

	@Override
	public void onInfoWindowClick(Marker marker) {
		String mapItem = (String) markers.get(marker.getId());
		// TODO: Markerのモデル
	}

	LatLng getMyLocation() {
		// TODO: 現在地の取得で日本即位に変換しないとダメ
		Criteria criteria = new Criteria();
		String provider = locationManager.getBestProvider(criteria, false);
		Location location = locationManager.getLastKnownLocation(provider);
		return new LatLng(location.getLatitude(), location.getLongitude());
	}

	void moveCamera(boolean isAnimation, LatLng target) {
		// カメラの位置情報を作成する
		CameraUpdate camera = CameraUpdateFactory
				.newCameraPosition(new CameraPosition.Builder().target(target)
						.zoom(18.0f).build());
		if (isAnimation) {
			// アニメーション移動する
			map.animateCamera(camera);
		} else {
			// 瞬間移動する
			map.moveCamera(camera);
		}
	}

	void configMap() {
		// 航空写真に変更
		// map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		// ノーマルに変更
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		// 渋滞状況を表示
		map.setTrafficEnabled(false);
		// 現在位置表示の有効化
		map.setMyLocationEnabled(true);
		// コンパスの有効化
		map.getUiSettings().setCompassEnabled(true);
		// 現在位置に移動するボタンの有効化
		map.getUiSettings().setMyLocationButtonEnabled(true);
		// ズームイン・アウトボタンの有効化
		map.getUiSettings().setZoomControlsEnabled(true);
		// すべてのジェスチャーの有効化
		map.getUiSettings().setAllGesturesEnabled(true);
		// 回転ジェスチャーの有効化
		// map.getUiSettings().setRotateGesturesEnabled(true);
		// // スクロールジェスチャーの有効化
		// map.getUiSettings().setScrollGesturesEnabled(true);
		// // Tlitジェスチャー(立体表示)の有効化
		// map.getUiSettings().setTiltGesturesEnabled(true);
		// // ズームジェスチャー(ピンチイン・アウト)の有効化
		// map.getUiSettings().setZoomGesturesEnabled(true);
	}

}