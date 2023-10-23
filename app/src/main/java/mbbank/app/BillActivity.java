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
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.regex.*;
import org.json.*;
import java.text.DecimalFormatSymbols;;

public class BillActivity extends AppCompatActivity {
	
	private String Path = "";
	private String FileName = "";
	
	private LinearLayout linear2;
	private LinearLayout linear1;
	private LinearLayout linear5;
	private LinearLayout linear8;
	private LinearLayout linear15;
	private LinearLayout linear18;
	private LinearLayout linear3;
	private TextView textview1;
	private LinearLayout linear25;
	private LinearLayout linear4;
	private ImageView imageview1;
	private TextView textview2;
	private TextView textview23;
	private LinearLayout linear21;
	private ImageView imageview5;
	private TextView textview21;
	private TextView textview3;
	private LinearLayout linear6;
	private ImageView logobank;
	private LinearLayout linear7;
	private TextView textview4;
	private TextView textview5;
	private TextView namebank;
	private LinearLayout linear9;
	private TextView textview9;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linearHinhThuc;
	private LinearLayout linear14;
	private TextView textview7;
	private TextView textview8;
	private TextView textview10;
	private TextView textview11;
	private TextView textview12;
	private TextView giay;
	private TextView thoigian;
	private LinearLayout linear24;
	private LinearLayout linear23;
	private TextView textview13;
	private TextView textview14;
	private TextView textview22;
	private TextView textview15;
	private TextView textview16;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private ImageView imageview3;
	private TextView textview17;
	private ImageView imageview4;
	private TextView textview18;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private TextView textview19;
	private TextView textview20;
	
	private SharedPreferences sp;
	private Calendar time = Calendar.getInstance();
	private Intent i = new Intent();
	private AlertDialog.Builder dialog;
	private SharedPreferences ten;
	private SharedPreferences tendangnhap;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.bill);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear2 = findViewById(R.id.linear2);
		linear1 = findViewById(R.id.linear1);
		linear5 = findViewById(R.id.linear5);
		linear8 = findViewById(R.id.linear8);
		linear15 = findViewById(R.id.linear15);
		linear18 = findViewById(R.id.linear18);
		linear3 = findViewById(R.id.linear3);
		textview1 = findViewById(R.id.textview1);
		linear25 = findViewById(R.id.linear25);
		linear4 = findViewById(R.id.linear4);
		imageview1 = findViewById(R.id.imageview1);
		textview2 = findViewById(R.id.textview2);
		textview23 = findViewById(R.id.textview23);
		linear21 = findViewById(R.id.linear21);
		imageview5 = findViewById(R.id.imageview5);
		textview21 = findViewById(R.id.textview21);
		textview3 = findViewById(R.id.textview3);
		linear6 = findViewById(R.id.linear6);
		logobank = findViewById(R.id.logobank);
		linear7 = findViewById(R.id.linear7);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		namebank = findViewById(R.id.namebank);
		linear9 = findViewById(R.id.linear9);
		textview9 = findViewById(R.id.textview9);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		linearHinhThuc = findViewById(R.id.linearHinhThuc);
		linear14 = findViewById(R.id.linear14);
		textview7 = findViewById(R.id.textview7);
		textview8 = findViewById(R.id.textview8);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		textview12 = findViewById(R.id.textview12);
		giay = findViewById(R.id.giay);
		thoigian = findViewById(R.id.thoigian);
		linear24 = findViewById(R.id.linear24);
		linear23 = findViewById(R.id.linear23);
		textview13 = findViewById(R.id.textview13);
		textview14 = findViewById(R.id.textview14);
		textview22 = findViewById(R.id.textview22);
		textview15 = findViewById(R.id.textview15);
		textview16 = findViewById(R.id.textview16);
		linear16 = findViewById(R.id.linear16);
		linear17 = findViewById(R.id.linear17);
		imageview3 = findViewById(R.id.imageview3);
		textview17 = findViewById(R.id.textview17);
		imageview4 = findViewById(R.id.imageview4);
		textview18 = findViewById(R.id.textview18);
		linear19 = findViewById(R.id.linear19);
		linear20 = findViewById(R.id.linear20);
		textview19 = findViewById(R.id.textview19);
		textview20 = findViewById(R.id.textview20);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		ten = getSharedPreferences("ten", Activity.MODE_PRIVATE);
		tendangnhap = getSharedPreferences("tendangnhap", Activity.MODE_PRIVATE);
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sp.edit().putString("1", textview4.getText().toString()).commit();
				sp.edit().putString("2", textview5.getText().toString()).commit();
				sp.edit().putString("3", namebank.getText().toString()).commit();
				SketchwareUtil.showMessage(getApplicationContext(), "Đã lưu người thụ hưởng");
			}
		});
		
		linear17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					final String getFileAddress = new ScreenShot.Builder(getApplicationContext()).setQuality(Quality.HIGH).setView(getWindow().getDecorView().getRootView()).setPath(Path).setFileCompressType(CompressType.PNG).setFileNameWithExtension(FileName).build().getScreenShotFileAddress();
				} catch(Exception e) {
				}
				dialog.setTitle("Đã lưu lại tại ".concat(Path.concat(" Tên ".concat(FileName))));
				dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				dialog.create().show();
			}
		});
		
		linear19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
			}
		});
		
		linear20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ThongtinchuyentienActivity.class);
				startActivity(i);
			}
		});
	}
	
	private void initializeLogic() {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		DecimalFormat formatter = new DecimalFormat("#,###,###,###", symbols);
		textview2.setText(formatter.format(Double.parseDouble(textview2.getText().toString())));
		if (sp.getString("trongmb", "").equals("trongmb")) {
			linear23.setVisibility(View.GONE);
			textview14.setText("Trong MB");
			sp.edit().remove("trongmb").commit();
		}
		namebank.setText(sp.getString("tennganhang", ""));
		textview11.setText(sp.getString("noidungchuyentien", ""));
		textview2.setText(sp.getString("sotien", ""));
		textview4.setText(sp.getString("tentaikhoan", ""));
		textview5.setText(sp.getString("sotaikhoan", ""));
		textview8.setText(tendangnhap.getString("tendangnhap", ""));
		textview9.setText(ten.getString("ten", ""));
		Path = "/storage/emulated/0/Download/Mbbank/";
		FileName = "bill.png";
		textview16.setText("FT".concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9))).concat(String.valueOf(SketchwareUtil.getRandom((int)(0), (int)(9)))))))))))))))))));
		time = Calendar.getInstance();
		giay.setText(new SimpleDateFormat("HH:mm:ss").format(time.getTime()).concat(", "));
		thoigian.setText(new SimpleDateFormat("MM/dd/yyyy").format(time.getTime()));
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { 
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(0xFF008375); w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); }
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(30);
			linear5.setBackgroundDrawable(gd);
			linear5.setElevation(20);};
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(30);
			linear8.setBackgroundDrawable(gd);
			linear8.setElevation(20);};
		linear16.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)55, (int)3, 0xFFCFD8DC, 0xFFFFFFFF));
		linear17.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)55, (int)3, 0xFFCFD8DC, 0xFFFFFFFF));
		linear20.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFF0B2BC9));
		linear19.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)3, 0xFF0B2BC9, 0xFFFFFFFF));
		linear21.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)55, (int)0, Color.TRANSPARENT, 0xFFFFFFFF));
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