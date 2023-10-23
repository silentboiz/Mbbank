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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
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
import java.util.regex.*;
import org.json.*;

public class XacnhanActivity extends AppCompatActivity {
	
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout linear1;
	private LinearLayout View;
	private LinearLayout linear8;
	private Button button1;
	private LinearLayout linear3;
	private TextView textview1;
	private TextView textview2;
	private ImageView imageview1;
	private TextView textview27;
	private ImageView imageview2;
	private LinearLayout linear28;
	private LinearLayout linear5;
	private TextView textview23;
	private LinearLayout linear29;
	private ImageView imageview6;
	private LinearLayout linear30;
	private TextView textview24;
	private TextView textview25;
	private TextView textview3;
	private LinearLayout linear6;
	private ImageView logobank;
	private LinearLayout linear7;
	private TextView textview4;
	private TextView textview5;
	private TextView namebank;
	private LinearLayout linear9;
	private LinearLayout linear12;
	private LinearLayout linearHinhThuc;
	private LinearLayout linear11;
	private LinearLayout linear25;
	private TextView textview7;
	private TextView textview8;
	private TextView textview12;
	private TextView giay;
	private TextView thoigian;
	private LinearLayout linear24;
	private LinearLayout linear23;
	private TextView textview13;
	private TextView textview14;
	private TextView textview22;
	private TextView textview10;
	private TextView textview11;
	
	private SharedPreferences tendangnhap;
	private SharedPreferences ten;
	private Intent i = new Intent();
	private SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.xacnhan);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		linear1 = findViewById(R.id.linear1);
		View = findViewById(R.id.View);
		linear8 = findViewById(R.id.linear8);
		button1 = findViewById(R.id.button1);
		linear3 = findViewById(R.id.linear3);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		imageview1 = findViewById(R.id.imageview1);
		textview27 = findViewById(R.id.textview27);
		imageview2 = findViewById(R.id.imageview2);
		linear28 = findViewById(R.id.linear28);
		linear5 = findViewById(R.id.linear5);
		textview23 = findViewById(R.id.textview23);
		linear29 = findViewById(R.id.linear29);
		imageview6 = findViewById(R.id.imageview6);
		linear30 = findViewById(R.id.linear30);
		textview24 = findViewById(R.id.textview24);
		textview25 = findViewById(R.id.textview25);
		textview3 = findViewById(R.id.textview3);
		linear6 = findViewById(R.id.linear6);
		logobank = findViewById(R.id.logobank);
		linear7 = findViewById(R.id.linear7);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		namebank = findViewById(R.id.namebank);
		linear9 = findViewById(R.id.linear9);
		linear12 = findViewById(R.id.linear12);
		linearHinhThuc = findViewById(R.id.linearHinhThuc);
		linear11 = findViewById(R.id.linear11);
		linear25 = findViewById(R.id.linear25);
		textview7 = findViewById(R.id.textview7);
		textview8 = findViewById(R.id.textview8);
		textview12 = findViewById(R.id.textview12);
		giay = findViewById(R.id.giay);
		thoigian = findViewById(R.id.thoigian);
		linear24 = findViewById(R.id.linear24);
		linear23 = findViewById(R.id.linear23);
		textview13 = findViewById(R.id.textview13);
		textview14 = findViewById(R.id.textview14);
		textview22 = findViewById(R.id.textview22);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		tendangnhap = getSharedPreferences("tendangnhap", Activity.MODE_PRIVATE);
		ten = getSharedPreferences("ten", Activity.MODE_PRIVATE);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), OtpActivity.class);
				startActivity(i);
			}
		});
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =XacnhanActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF112378);
		}
		textview24.setText(ten.getString("ten", ""));
		textview25.setText(tendangnhap.getString("tendangnhap", ""));
		textview4.setText(sp.getString("tentaikhoan", ""));
		textview5.setText(sp.getString("sotaikhoan", ""));
		textview11.setText(sp.getString("noidungchuyentien", ""));
		namebank.setText(sp.getString("tennganhang", ""));
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(30);
			View.setBackgroundDrawable(gd);
			View.setElevation(20);};
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(30);
			linear8.setBackgroundDrawable(gd);
			linear8.setElevation(20);};
		if (sp.getString("nganhang", "").equals("Quân đội (MB)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_20);
		}
		if (sp.getString("nganhang", "").equals("Ngoại thương Việt Nam (VIETCOMBANK, VCB)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_vcb);
		}
		if (sp.getString("nganhang", "").equals("Công Thương Việt Nam (VIETINBANK)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_24);
		}
		if (sp.getString("nganhang", "").equals("Kỹ Thương Việt Nam (TECHCOMBANK, TCB)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_65);
		}
		if (sp.getString("nganhang", "").equals("Việt Nam Thịnh Vượng (VPBANK)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_55);
		}
		if (sp.getString("nganhang", "").equals("Á Châu (ACB)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_14);
		}
		if (sp.getString("nganhang", "").equals("Đầu tư và phát triển Việt Nam (BIDV)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_10);
		}
		if (sp.getString("nganhang", "").equals("Tiên Phong (TPBANK, TPB)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_25);
		}
		if (sp.getString("nganhang", "").equals("Quốc tế (VIBANK, VIB)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_31);
		}
		if (sp.getString("nganhang", "").equals("Việt Á (VIET A BANK, VAB)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_28);
		}
		if (sp.getString("nganhang", "").equals("Nông nghiệp và phát triển Nông thôn Việt Nam (AGRIBANK , VPA)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_38);
		}
		if (sp.getString("nganhang", "").equals("Sài Gòn Thương Tín (SACOMBANK, STB)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_stb);
		}
		if (sp.getString("nganhang", "").equals("Đông Á (DONG A BANK, DAB)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_40);
		}
		if (sp.getString("nganhang", "").equals("Hàng hải Việt Nam (MARITIME BANK, MSB)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_msb);
		}
		if (sp.getString("nganhang", "").equals("Sài Gòn Công Thương (SAIGONBANK, SGB)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_csxh_56);
		}
		if (sp.getString("nganhang", "").equals("Xuất nhập khẩu Việt Nam (EXIMBANK, EIB)")) {
			logobank.setImageResource(R.drawable.src_assets_images_logo_bank_eib);
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