package mbbank.app;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.beuni.screenshot.*;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class BankActivity extends AppCompatActivity {
	
	private ArrayList<HashMap<String, Object>> view_bank = new ArrayList<>();
	
	private ListView listview1;
	
	private SharedPreferences sp;
	private Intent i = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.bank);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		listview1 = findViewById(R.id.listview1);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					sp.edit().putString("trongmb", "trongmb").commit();
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("0").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 1) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("1").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 2) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("2").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 3) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("3").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 4) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("4").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 5) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("5").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 6) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("6").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 7) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("7").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 8) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("8").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 9) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("9").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 10) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("10").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 11) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("11").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 12) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("12").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 13) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("13").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 14) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("14").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
				if (_position == 15) {
					sp.edit().putString("nganhang", view_bank.get((int)_position).get("15").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
			}
		});
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =BankActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF112378);
		}
		listview1.setAdapter(new Listview1Adapter(view_bank));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("0", "Quân đội (MB)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("1", "Ngoại thương Việt Nam (VIETCOMBANK, VCB)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("2", "Công Thương Việt Nam (VIETINBANK)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("3", "Kỹ Thương Việt Nam (TECHCOMBANK, TCB)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("4", "Việt Nam Thịnh Vượng (VPBANK)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("5", "Á Châu (ACB)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("6", "Đầu tư và phát triển Việt Nam (BIDV)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("7", "Tiên Phong (TPBANK, TPB)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("8", "Quốc tế (VIBANK, VIB)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("9", "Việt Á (VIET A BANK, VAB)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("10", "Nông nghiệp và phát triển Nông thôn Việt Nam (AGRIBANK , VPA)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("11", "Sài Gòn Thương Tín (SACOMBANK, STB)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("12", "Đông Á (DONG A BANK, DAB)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("13", "Hàng hải Việt Nam (MARITIME BANK, MSB)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("14", "Sài Gòn Công Thương (SAIGONBANK, SGB)");
			view_bank.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("15", "Xuất nhập khẩu Việt Nam (EXIMBANK, EIB)");
			view_bank.add(_item);
		}
		
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.bank_view, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			if (view_bank.get((int)_position).containsKey("0")) {
				textview1.setText(view_bank.get((int)_position).get("0").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_20);
			}
			if (view_bank.get((int)_position).containsKey("1")) {
				textview1.setText(view_bank.get((int)_position).get("1").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_vcb);
			}
			if (view_bank.get((int)_position).containsKey("2")) {
				textview1.setText(view_bank.get((int)_position).get("2").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_24);
			}
			if (view_bank.get((int)_position).containsKey("3")) {
				textview1.setText(view_bank.get((int)_position).get("3").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_65);
			}
			if (view_bank.get((int)_position).containsKey("4")) {
				textview1.setText(view_bank.get((int)_position).get("4").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_55);
			}
			if (view_bank.get((int)_position).containsKey("5")) {
				textview1.setText(view_bank.get((int)_position).get("5").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_14);
			}
			if (view_bank.get((int)_position).containsKey("6")) {
				textview1.setText(view_bank.get((int)_position).get("6").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_10);
			}
			if (view_bank.get((int)_position).containsKey("7")) {
				textview1.setText(view_bank.get((int)_position).get("7").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_25);
			}
			if (view_bank.get((int)_position).containsKey("8")) {
				textview1.setText(view_bank.get((int)_position).get("8").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_31);
			}
			if (view_bank.get((int)_position).containsKey("9")) {
				textview1.setText(view_bank.get((int)_position).get("9").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_28);
			}
			if (view_bank.get((int)_position).containsKey("10")) {
				textview1.setText(view_bank.get((int)_position).get("10").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_38);
			}
			if (view_bank.get((int)_position).containsKey("11")) {
				textview1.setText(view_bank.get((int)_position).get("11").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_stb);
			}
			if (view_bank.get((int)_position).containsKey("12")) {
				textview1.setText(view_bank.get((int)_position).get("12").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_40);
			}
			if (view_bank.get((int)_position).containsKey("13")) {
				textview1.setText(view_bank.get((int)_position).get("13").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_msb);
			}
			if (view_bank.get((int)_position).containsKey("14")) {
				textview1.setText(view_bank.get((int)_position).get("14").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_56);
			}
			if (view_bank.get((int)_position).containsKey("15")) {
				textview1.setText(view_bank.get((int)_position).get("15").toString());
				imageview1.setImageResource(R.drawable.src_assets_images_logo_bank_eib);
			}
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}