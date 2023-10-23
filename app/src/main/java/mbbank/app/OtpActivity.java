package mbbank.app;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class OtpActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear4;
	private LinearLayout linear3;
	private LinearLayout linear40;
	private LinearLayout linear6;
	private LinearLayout linear39;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear5;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear7;
	private LinearLayout linear10;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private TextView magiaodich;
	private TextView textview9;
	private LinearLayout otp1;
	private LinearLayout otp2;
	private LinearLayout otp3;
	private LinearLayout otp4;
	private LinearLayout otp5;
	private LinearLayout otp6;
	private Button button1;
	private LinearLayout banphim;
	private LinearLayout linear41;
	private LinearLayout linear46;
	private LinearLayout linear51;
	private LinearLayout phim;
	private LinearLayout linear42;
	private LinearLayout linear43;
	private LinearLayout linear44;
	private LinearLayout linear45;
	private TextView textview14;
	private TextView textview15;
	private TextView textview16;
	private TextView textview17;
	private LinearLayout linear47;
	private LinearLayout linear48;
	private LinearLayout linear49;
	private LinearLayout linear50;
	private TextView textview18;
	private TextView textview19;
	private TextView textview20;
	private ImageView imageview4;
	private LinearLayout linear52;
	private LinearLayout linear53;
	private LinearLayout linear54;
	private LinearLayout linear55;
	private TextView textview22;
	private TextView textview23;
	private TextView textview24;
	private ImageView imageview3;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private TextView textview10;
	private TextView textview11;
	private TextView textview12;
	private ImageView imageview2;
	
	private TimerTask t;
	private Intent i = new Intent();
	private SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.otp);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear4 = findViewById(R.id.linear4);
		linear3 = findViewById(R.id.linear3);
		linear40 = findViewById(R.id.linear40);
		linear6 = findViewById(R.id.linear6);
		linear39 = findViewById(R.id.linear39);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		linear5 = findViewById(R.id.linear5);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear7 = findViewById(R.id.linear7);
		linear10 = findViewById(R.id.linear10);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		magiaodich = findViewById(R.id.magiaodich);
		textview9 = findViewById(R.id.textview9);
		otp1 = findViewById(R.id.otp1);
		otp2 = findViewById(R.id.otp2);
		otp3 = findViewById(R.id.otp3);
		otp4 = findViewById(R.id.otp4);
		otp5 = findViewById(R.id.otp5);
		otp6 = findViewById(R.id.otp6);
		button1 = findViewById(R.id.button1);
		banphim = findViewById(R.id.banphim);
		linear41 = findViewById(R.id.linear41);
		linear46 = findViewById(R.id.linear46);
		linear51 = findViewById(R.id.linear51);
		phim = findViewById(R.id.phim);
		linear42 = findViewById(R.id.linear42);
		linear43 = findViewById(R.id.linear43);
		linear44 = findViewById(R.id.linear44);
		linear45 = findViewById(R.id.linear45);
		textview14 = findViewById(R.id.textview14);
		textview15 = findViewById(R.id.textview15);
		textview16 = findViewById(R.id.textview16);
		textview17 = findViewById(R.id.textview17);
		linear47 = findViewById(R.id.linear47);
		linear48 = findViewById(R.id.linear48);
		linear49 = findViewById(R.id.linear49);
		linear50 = findViewById(R.id.linear50);
		textview18 = findViewById(R.id.textview18);
		textview19 = findViewById(R.id.textview19);
		textview20 = findViewById(R.id.textview20);
		imageview4 = findViewById(R.id.imageview4);
		linear52 = findViewById(R.id.linear52);
		linear53 = findViewById(R.id.linear53);
		linear54 = findViewById(R.id.linear54);
		linear55 = findViewById(R.id.linear55);
		textview22 = findViewById(R.id.textview22);
		textview23 = findViewById(R.id.textview23);
		textview24 = findViewById(R.id.textview24);
		imageview3 = findViewById(R.id.imageview3);
		linear17 = findViewById(R.id.linear17);
		linear18 = findViewById(R.id.linear18);
		linear19 = findViewById(R.id.linear19);
		linear20 = findViewById(R.id.linear20);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		textview12 = findViewById(R.id.textview12);
		imageview2 = findViewById(R.id.imageview2);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				banphim.setVisibility(View.VISIBLE);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sp.getString("otp", "").equals("true")) {
					sp.edit().remove("otp").commit();
					i.setClass(getApplicationContext(), XacthucActivity.class);
					startActivity(i);
				}
			}
		});
		
		linear42.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				otp1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)0, Color.TRANSPARENT, 0xFF0B2BC9));
			}
		});
		
		linear43.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				otp2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)0, Color.TRANSPARENT, 0xFF0B2BC9));
			}
		});
		
		linear44.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				otp3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)0, Color.TRANSPARENT, 0xFF0B2BC9));
			}
		});
		
		linear47.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				otp4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)0, Color.TRANSPARENT, 0xFF0B2BC9));
			}
		});
		
		linear48.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				otp5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)0, Color.TRANSPARENT, 0xFF0B2BC9));
			}
		});
		
		linear49.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				otp6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)0, Color.TRANSPARENT, 0xFF0B2BC9));
				button1.setBackgroundColor(0xFF0B2BC9);
				sp.edit().putString("otp", "true").commit();
			}
		});
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =OtpActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF112378);
		}
		magiaodich.setText("GD".concat(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))).concat(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))).concat(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))).concat(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))).concat(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))).concat(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))).concat(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9))))))))))));
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font1.ttf"), 0);
		banphim.setVisibility(View.GONE);
		otp1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)3, 0xFF9E9E9E, 0xFFFFFFFF));
		otp2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)3, 0xFF9E9E9E, 0xFFFFFFFF));
		otp3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)3, 0xFF9E9E9E, 0xFFFFFFFF));
		otp4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)3, 0xFF9E9E9E, 0xFFFFFFFF));
		otp5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)3, 0xFF9E9E9E, 0xFFFFFFFF));
		otp6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)3, 0xFF9E9E9E, 0xFFFFFFFF));
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