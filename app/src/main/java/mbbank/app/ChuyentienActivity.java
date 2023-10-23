package mbbank.app;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.beuni.screenshot.*;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class ChuyentienActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private HashMap<String, Object> give = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear2;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview2;
	private LinearLayout linear4;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear6;
	private LinearLayout linear5;
	private ImageView imageview3;
	private TextView textview2;
	private ImageView imageview4;
	private TextView textview3;
	private ImageView imageview5;
	private TextView textview4;
	private LinearLayout linear9;
	private LinearLayout linear13;
	private ListView listview1;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private ImageView imageview6;
	private EditText edittext1;
	
	private Intent i = new Intent();
	private TimerTask t;
	private AlertDialog.Builder dialog;
	private SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.chuyentien);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear3 = findViewById(R.id.linear3);
		linear2 = findViewById(R.id.linear2);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		imageview2 = findViewById(R.id.imageview2);
		linear4 = findViewById(R.id.linear4);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear6 = findViewById(R.id.linear6);
		linear5 = findViewById(R.id.linear5);
		imageview3 = findViewById(R.id.imageview3);
		textview2 = findViewById(R.id.textview2);
		imageview4 = findViewById(R.id.imageview4);
		textview3 = findViewById(R.id.textview3);
		imageview5 = findViewById(R.id.imageview5);
		textview4 = findViewById(R.id.textview4);
		linear9 = findViewById(R.id.linear9);
		linear13 = findViewById(R.id.linear13);
		listview1 = findViewById(R.id.listview1);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		textview7 = findViewById(R.id.textview7);
		imageview6 = findViewById(R.id.imageview6);
		edittext1 = findViewById(R.id.edittext1);
		dialog = new AlertDialog.Builder(this);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
			}
		});
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
				startActivity(i);
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == _position) {
					sp.edit().remove("chonmb").commit();
					sp.edit().putString("ttk", map.get((int)_position).get("1").toString()).commit();
					sp.edit().putString("stk", map.get((int)_position).get("2").toString()).commit();
					sp.edit().putString("nganhang", map.get((int)_position).get("3").toString()).commit();
					i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
					startActivity(i);
				}
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				dialog.setTitle("Bạn có muốn xoá người thụ hưởng này ?");
				dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						map.remove((int)(_position));
						sp.edit().putString("listdata", new Gson().toJson(map)).commit();
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
				});
				dialog.create().show();
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		if (!sp.getString("listdata", "").equals("")) {
			map = new Gson().fromJson(sp.getString("listdata", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { 
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(0xFF008375); w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); }
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFFFFFFF));
		linear6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFFFFFFF));
		linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFFFFFFF));
		linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)3, 0xFF0B2BC9, Color.TRANSPARENT));
		linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)3, 0xFFCFD8DC, Color.TRANSPARENT));
		linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)3, 0xFFCFD8DC, Color.TRANSPARENT));
		linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)3, Color.TRANSPARENT, 0xFFF5F5F5));
		if (sp.getString("1", "").equals("") || (sp.getString("2", "").equals("") || sp.getString("3", "").equals(""))) {
			sp.edit().putString("listdata", new Gson().toJson(map)).commit();
			listview1.setAdapter(new Listview1Adapter(map));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			sp.edit().remove("1").commit();
			sp.edit().remove("2").commit();
			sp.edit().remove("3").commit();
		}
		else {
			give = new HashMap<>();
			give.put("1", sp.getString("1", ""));
			give.put("2", sp.getString("2", ""));
			give.put("3", sp.getString("3", ""));
			map.add(give);
			sp.edit().putString("listdata", new Gson().toJson(map)).commit();
			listview1.setAdapter(new Listview1Adapter(map));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			sp.edit().remove("1").commit();
			sp.edit().remove("2").commit();
			sp.edit().remove("3").commit();
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
				_view = _inflater.inflate(R.layout.thuhuong_view, null);
			}
			
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final ImageView logobank = _view.findViewById(R.id.logobank);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final TextView tentaikhoan = _view.findViewById(R.id.tentaikhoan);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final TextView bankname = _view.findViewById(R.id.bankname);
			final TextView sotaikhoan = _view.findViewById(R.id.sotaikhoan);
			final TextView khoangcach = _view.findViewById(R.id.khoangcach);
			final TextView chuyennhanh = _view.findViewById(R.id.chuyennhanh);
			
			tentaikhoan.setText(_data.get((int)_position).get("1").toString());
			sotaikhoan.setText(_data.get((int)_position).get("2").toString());
			bankname.setText(_data.get((int)_position).get("3").toString());
			if (_data.get((int)_position).get("3").toString().equals("Quân đội (MB)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_20);
			}
			if (_data.get((int)_position).get("3").toString().equals("Ngoại thương Việt Nam (VIETCOMBANK, VCB)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_vcb);
			}
			if (_data.get((int)_position).get("3").toString().equals("Công Thương Việt Nam (VIETINBANK)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_24);
			}
			if (_data.get((int)_position).get("3").toString().equals("Kỹ Thương Việt Nam (TECHCOMBANK, TCB)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_65);
			}
			if (_data.get((int)_position).get("3").toString().equals("Việt Nam Thịnh Vượng (VPBANK)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_55);
			}
			if (_data.get((int)_position).get("3").toString().equals("Á Châu (ACB)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_14);
			}
			if (_data.get((int)_position).get("3").toString().equals("Đầu tư và phát triển Việt Nam (BIDV)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_10);
			}
			if (_data.get((int)_position).get("3").toString().equals("Tiên Phong (TPBANK, TPB)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_25);
			}
			if (_data.get((int)_position).get("3").toString().equals("Quốc tế (VIBANK, VIB)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_31);
			}
			if (_data.get((int)_position).get("3").toString().equals("Việt Á (VIET A BANK, VAB)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_28);
			}
			if (_data.get((int)_position).get("3").toString().equals("Nông nghiệp và phát triển Nông thôn Việt Nam (AGRIBANK , VPA)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_38);
			}
			if (_data.get((int)_position).get("3").toString().equals("Sài Gòn Thương Tín (SACOMBANK, STB)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_stb);
			}
			if (_data.get((int)_position).get("3").toString().equals("Đông Á (DONG A BANK, DAB)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_40);
			}
			if (_data.get((int)_position).get("3").toString().equals("Hàng hải Việt Nam (MARITIME BANK, MSB)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_msb);
			}
			if (_data.get((int)_position).get("3").toString().equals("Sài Gòn Công Thương (SAIGONBANK, SGB)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_56);
			}
			if (_data.get((int)_position).get("3").toString().equals("Xuất nhập khẩu Việt Nam (EXIMBANK, EIB)")) {
				logobank.setImageResource(R.drawable.src_assets_images_logo_bank_eib);
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