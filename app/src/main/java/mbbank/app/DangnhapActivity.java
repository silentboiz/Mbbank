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
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.beuni.screenshot.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class DangnhapActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double show = 0;
	private double exit = 0;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear18;
	private LinearLayout linear20;
	private ImageView imageview9;
	private LinearLayout linear3;
	private LinearLayout linear11;
	private ImageView imageview10;
	private TextView textview9;
	private ImageView imageview1;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear19;
	private TextView textview10;
	private TextView textview11;
	private ImageView imageview11;
	private EditText edittext2;
	private Button button1;
	private LinearLayout linear5;
	private TextView textview3;
	private LinearLayout linear10;
	private TextView textview4;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private ImageView imageview3;
	private TextView textview5;
	private ImageView imageview4;
	private TextView textview6;
	private ImageView imageview5;
	private TextView textview7;
	private ImageView imageview6;
	private TextView textview8;
	
	private SharedPreferences ten;
	private Intent i = new Intent();
	private FirebaseAuth dangnhap;
	private OnCompleteListener<AuthResult> _dangnhap_create_user_listener;
	private OnCompleteListener<AuthResult> _dangnhap_sign_in_listener;
	private OnCompleteListener<Void> _dangnhap_reset_password_listener;
	private OnCompleteListener<Void> dangnhap_updateEmailListener;
	private OnCompleteListener<Void> dangnhap_updatePasswordListener;
	private OnCompleteListener<Void> dangnhap_emailVerificationSentListener;
	private OnCompleteListener<Void> dangnhap_deleteUserListener;
	private OnCompleteListener<Void> dangnhap_updateProfileListener;
	private OnCompleteListener<AuthResult> dangnhap_phoneAuthListener;
	private OnCompleteListener<AuthResult> dangnhap_googleSignInListener;
	
	private SharedPreferences sp;
	private AlertDialog.Builder dialog;
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.dangnhap);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear18 = findViewById(R.id.linear18);
		linear20 = findViewById(R.id.linear20);
		imageview9 = findViewById(R.id.imageview9);
		linear3 = findViewById(R.id.linear3);
		linear11 = findViewById(R.id.linear11);
		imageview10 = findViewById(R.id.imageview10);
		textview9 = findViewById(R.id.textview9);
		imageview1 = findViewById(R.id.imageview1);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		linear19 = findViewById(R.id.linear19);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		imageview11 = findViewById(R.id.imageview11);
		edittext2 = findViewById(R.id.edittext2);
		button1 = findViewById(R.id.button1);
		linear5 = findViewById(R.id.linear5);
		textview3 = findViewById(R.id.textview3);
		linear10 = findViewById(R.id.linear10);
		textview4 = findViewById(R.id.textview4);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		linear14 = findViewById(R.id.linear14);
		linear15 = findViewById(R.id.linear15);
		imageview3 = findViewById(R.id.imageview3);
		textview5 = findViewById(R.id.textview5);
		imageview4 = findViewById(R.id.imageview4);
		textview6 = findViewById(R.id.textview6);
		imageview5 = findViewById(R.id.imageview5);
		textview7 = findViewById(R.id.textview7);
		imageview6 = findViewById(R.id.imageview6);
		textview8 = findViewById(R.id.textview8);
		ten = getSharedPreferences("ten", Activity.MODE_PRIVATE);
		dangnhap = FirebaseAuth.getInstance();
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		
		imageview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (show == 0) {
					show++;
					edittext2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
				}
				else {
					show = 0;
					edittext2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext2.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Mật khẩu không được bỏ trống");
				}
				else {
					dangnhap.signInWithEmailAndPassword(sp.getString("tk", ""), edittext2.getText().toString()).addOnCompleteListener(DangnhapActivity.this, _dangnhap_sign_in_listener);
				}
			}
		});
		
		textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dangnhap.sendPasswordResetEmail(sp.getString("tk", "")).addOnCompleteListener(_dangnhap_reset_password_listener);
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FirebaseAuth.getInstance().signOut();
				i.setClass(getApplicationContext(), LoginActivity.class);
				startActivity(i);
			}
		});
		
		dangnhap_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		dangnhap_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		dangnhap_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		dangnhap_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		dangnhap_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		dangnhap_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		dangnhap_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_dangnhap_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_dangnhap_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					i.setClass(getApplicationContext(), MainActivity.class);
					startActivity(i);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Đã có lỗi xảy ra !");
				}
			}
		};
		
		_dangnhap_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				if (_success) {
					dialog.setTitle("Thông báo");
					dialog.setMessage("Đã gửi mật khẩu vào ".concat(sp.getString("tk", "").concat(" vui lòng kiểm tra kể cả thư rác")));
					dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Đã có lỗi xảy ra");
				}
			}
		};
	}
	
	private void initializeLogic() {
		textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview3.setPaintFlags(textview3.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
		textview4.setPaintFlags(textview4.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)70, (int)20, Color.TRANSPARENT, 0xFF80D8FF));
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { 
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(0xFF008375); w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); }
		textview11.setText(ten.getString("ten", ""));
		edittext2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
	}
	
	@Override
	public void onBackPressed() {
		exit++;
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (exit == 1) {
							SketchwareUtil.showMessage(getApplicationContext(), "Ấn quay lại một lần nữa để thoát");
							exit = 2;
						}
						else {
							if (exit > 1) {
								FirebaseAuth.getInstance().signOut();
								finishAffinity();
							}
						}
					}
				});
			}
		};
		_timer.schedule(t, (int)(300));
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