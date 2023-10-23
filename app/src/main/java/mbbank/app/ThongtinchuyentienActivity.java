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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.beuni.screenshot.*;
import com.google.android.material.textfield.*;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import java.text.DecimalFormatSymbols;;

public class ThongtinchuyentienActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear2;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview2;
	private LinearLayout linear3;
	private TextView textview2;
	private LinearLayout linear4;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private TextInputLayout textinputlayout1;
	private TextInputLayout textinputlayout2;
	private TextInputLayout textinputlayout3;
	private TextInputLayout textinputlayout4;
	private TextInputLayout textinputlayout5;
	private Button button1;
	private ImageView imageview3;
	private LinearLayout linear5;
	private LinearLayout linear8;
	private LinearLayout linear7;
	private LinearLayout linear6;
	private LinearLayout linear15;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview8;
	private TextView textview9;
	private ImageView imageview4;
	private TextView textview10;
	private Switch switch1;
	private TextView textview11;
	private TextView textview12;
	private ImageView imageview5;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private TextView textview13;
	private TextView textview6;
	private TextView textview7;
	private EditText tennganhang;
	private EditText sotaikhoan;
	private EditText tentaikhoan;
	private EditText sotien;
	private EditText noidungchuyentien;
	
	private Intent i = new Intent();
	private SharedPreferences ten;
	private SharedPreferences tendangnhap;
	private SharedPreferences tien;
	private TimerTask t;
	private AlertDialog.Builder dialog;
	private SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.thongtinchuyentien);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear2 = findViewById(R.id.linear2);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		imageview2 = findViewById(R.id.imageview2);
		linear3 = findViewById(R.id.linear3);
		textview2 = findViewById(R.id.textview2);
		linear4 = findViewById(R.id.linear4);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		textinputlayout1 = findViewById(R.id.textinputlayout1);
		textinputlayout2 = findViewById(R.id.textinputlayout2);
		textinputlayout3 = findViewById(R.id.textinputlayout3);
		textinputlayout4 = findViewById(R.id.textinputlayout4);
		textinputlayout5 = findViewById(R.id.textinputlayout5);
		button1 = findViewById(R.id.button1);
		imageview3 = findViewById(R.id.imageview3);
		linear5 = findViewById(R.id.linear5);
		linear8 = findViewById(R.id.linear8);
		linear7 = findViewById(R.id.linear7);
		linear6 = findViewById(R.id.linear6);
		linear15 = findViewById(R.id.linear15);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		textview8 = findViewById(R.id.textview8);
		textview9 = findViewById(R.id.textview9);
		imageview4 = findViewById(R.id.imageview4);
		textview10 = findViewById(R.id.textview10);
		switch1 = findViewById(R.id.switch1);
		textview11 = findViewById(R.id.textview11);
		textview12 = findViewById(R.id.textview12);
		imageview5 = findViewById(R.id.imageview5);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		linear14 = findViewById(R.id.linear14);
		textview13 = findViewById(R.id.textview13);
		textview6 = findViewById(R.id.textview6);
		textview7 = findViewById(R.id.textview7);
		tennganhang = findViewById(R.id.tennganhang);
		sotaikhoan = findViewById(R.id.sotaikhoan);
		tentaikhoan = findViewById(R.id.tentaikhoan);
		sotien = findViewById(R.id.sotien);
		noidungchuyentien = findViewById(R.id.noidungchuyentien);
		ten = getSharedPreferences("ten", Activity.MODE_PRIVATE);
		tendangnhap = getSharedPreferences("tendangnhap", Activity.MODE_PRIVATE);
		tien = getSharedPreferences("tien", Activity.MODE_PRIVATE);
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
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sp.edit().putString("noidungchuyentien", noidungchuyentien.getText().toString()).commit();
				sp.edit().putString("tennganhang", tennganhang.getText().toString()).commit();
				sp.edit().putString("sotien", sotien.getText().toString()).commit();
				sp.edit().putString("tentaikhoan", tentaikhoan.getText().toString()).commit();
				sp.edit().putString("sotaikhoan", sotaikhoan.getText().toString()).commit();
				if (tennganhang.getText().toString().equals("")) {
					dialog.setTitle("Vui lòng chọn ngân hàng");
					dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
				else {
					if (sotaikhoan.getText().toString().equals("")) {
						dialog.setTitle("Vui lòng nhập số tài khoản");
						dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						dialog.create().show();
					}
					else {
						if (tentaikhoan.getText().toString().equals("")) {
							dialog.setTitle("Vui lòng nhập tên tài khoản");
							dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							dialog.create().show();
						}
						else {
							if (sotien.getText().toString().equals("")) {
								dialog.setTitle("Vui lòng nhập số tiền");
								dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										
									}
								});
								dialog.create().show();
							}
							else {
								i.setClass(getApplicationContext(), XacnhanActivity.class);
								startActivity(i);
							}
						}
					}
				}
			}
		});
		
		textview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		tennganhang.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tennganhang.setTextColor(0xFF000000);
				i.setClass(getApplicationContext(), BankActivity.class);
				startActivity(i);
			}
		});
		
		sotaikhoan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sotaikhoan.setText("");
				sotaikhoan.setTextColor(0xFF000000);
			}
		});
		
		tentaikhoan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tentaikhoan.setText("");
				tentaikhoan.setTextColor(0xFF000000);
			}
		});
		
		sotien.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sotien.setText("");
				sotien.setTextColor(0xFF000000);
			}
		});
	}
	
	private void initializeLogic() {
		if (sotien.getText().toString().equals("")) {
			
		}
		else {
			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setGroupingSeparator(',');
			DecimalFormat formatter = new DecimalFormat("#,###,###", symbols);
			sotien.setText(formatter.format(Double.parseDouble(sotien.getText().toString())));
		}
		if (sp.getString("ttk", "").equals(sp.getString("ttk", ""))) {
			sotaikhoan.setText(sp.getString("stk", ""));
			tentaikhoan.setText(sp.getString("ttk", ""));
			tennganhang.setText(sp.getString("nganhang", ""));
			sp.edit().remove("stk").commit();
			sp.edit().remove("ttk").commit();
			textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font1.ttf"), 0);
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font1.ttf"), 0);
			if (ten.getString("ten", "").equals("")) {
				dialog.setCancelable(false);
				dialog.setTitle("Vui lòng thêm tên để sử dụng !");
				dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.setClass(getApplicationContext(), TaikhoanActivity.class);
						startActivity(i);
					}
				});
				dialog.create().show();
			}
			else {
				if (tien.getString("tien", "").equals("")) {
					dialog.setCancelable(false);
					dialog.setTitle("Vui lòng thêm tiền để sử dụng !");
					dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							i.setClass(getApplicationContext(), TaikhoanActivity.class);
							startActivity(i);
						}
					});
					dialog.create().show();
				}
				else {
					if (tendangnhap.getString("tendangnhap", "").equals("")) {
						dialog.setCancelable(false);
						dialog.setTitle("Vui lòng thêm tên đăng nhập để sử dụng !");
						dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								i.setClass(getApplicationContext(), TaikhoanActivity.class);
								startActivity(i);
							}
						});
						dialog.create().show();
					}
					else {
						
					}
				}
			}
			textview3.setText(tendangnhap.getString("tendangnhap", ""));
			textview5.setText(ten.getString("ten", ""));
			textview8.setText(tien.getString("tien", ""));
			noidungchuyentien.setText(ten.getString("ten", "").concat(" chuyen khoan"));
			tennganhang.setTextColor(0xFF000000);
			sotaikhoan.setTextColor(0xFF000000);
			tentaikhoan.setTextColor(0xFF000000);
			noidungchuyentien.setTextColor(0xFF000000);
			sotien.setTextColor(0xFF000000);
			linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)3, 0xFF0B2BC9, Color.TRANSPARENT));
			linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)3, 0xFFCFD8DC, Color.TRANSPARENT));
			linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)3, 0xFFCFD8DC, Color.TRANSPARENT));
			if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
				Window w =ThongtinchuyentienActivity.this.getWindow();
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF112378);
			}
			{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, new int[]{
					0xFFFFFFFF,
					0xFFFFFFFF,
				});
				gd.setCornerRadius(30);
				linear4.setBackgroundDrawable(gd);
				linear4.setElevation(30);};
			textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font1.ttf"), 1);
			textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font1.ttf"), 1);
			textinputlayout1.setBoxBackgroundColor(Color.TRANSPARENT);
			textinputlayout1.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
			textinputlayout1.setBoxCornerRadii((float)20, (float)20, (float)20, (float)20);
			textinputlayout2.setBoxBackgroundColor(Color.TRANSPARENT);
			textinputlayout2.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
			textinputlayout2.setBoxCornerRadii((float)20, (float)20, (float)20, (float)20);
			textinputlayout4.setBoxBackgroundColor(Color.TRANSPARENT);
			textinputlayout4.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
			textinputlayout4.setBoxCornerRadii((float)20, (float)20, (float)20, (float)20);
		}
		else {
			textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font1.ttf"), 0);
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font1.ttf"), 0);
			if (ten.getString("ten", "").equals("")) {
				dialog.setCancelable(false);
				dialog.setTitle("Vui lòng thêm tên để sử dụng !");
				dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.setClass(getApplicationContext(), TaikhoanActivity.class);
						startActivity(i);
					}
				});
				dialog.create().show();
			}
			else {
				if (tien.getString("tien", "").equals("")) {
					dialog.setCancelable(false);
					dialog.setTitle("Vui lòng thêm tiền để sử dụng !");
					dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							i.setClass(getApplicationContext(), TaikhoanActivity.class);
							startActivity(i);
						}
					});
					dialog.create().show();
				}
				else {
					if (tendangnhap.getString("tendangnhap", "").equals("")) {
						dialog.setCancelable(false);
						dialog.setTitle("Vui lòng thêm tên đăng nhập để sử dụng !");
						dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								i.setClass(getApplicationContext(), TaikhoanActivity.class);
								startActivity(i);
							}
						});
						dialog.create().show();
					}
					else {
						
					}
				}
			}
			tennganhang.setText(sp.getString("nganhang", ""));
			textview3.setText(tendangnhap.getString("tendangnhap", ""));
			textview5.setText(ten.getString("ten", ""));
			textview8.setText(tien.getString("tien", ""));
			noidungchuyentien.setText(ten.getString("ten", "").concat(" chuyen khoan"));
			tennganhang.setTextColor(0xFF000000);
			sotaikhoan.setTextColor(0xFF000000);
			tentaikhoan.setTextColor(0xFF000000);
			noidungchuyentien.setTextColor(0xFF000000);
			sotien.setTextColor(0xFF000000);
			linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)3, 0xFF0B2BC9, Color.TRANSPARENT));
			linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)3, 0xFFCFD8DC, Color.TRANSPARENT));
			linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)3, 0xFFCFD8DC, Color.TRANSPARENT));
			if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
				Window w =ThongtinchuyentienActivity.this.getWindow();
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF112378);
			}
			{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, new int[]{
					0xFFFFFFFF,
					0xFFFFFFFF,
				});
				gd.setCornerRadius(30);
				linear4.setBackgroundDrawable(gd);
				linear4.setElevation(30);};
			textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 1);
			textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 1);
			textinputlayout1.setBoxBackgroundColor(Color.TRANSPARENT);
			textinputlayout1.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
			textinputlayout1.setBoxCornerRadii((float)20, (float)20, (float)20, (float)20);
			textinputlayout2.setBoxBackgroundColor(Color.TRANSPARENT);
			textinputlayout2.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
			textinputlayout2.setBoxCornerRadii((float)20, (float)20, (float)20, (float)20);
			textinputlayout4.setBoxBackgroundColor(Color.TRANSPARENT);
			textinputlayout4.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
			textinputlayout4.setBoxCornerRadii((float)20, (float)20, (float)20, (float)20);
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