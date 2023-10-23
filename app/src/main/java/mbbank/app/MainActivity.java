package mbbank.app;

import mbbank.app.SplashActivity;
import android.animation.*;
import android.animation.ObjectAnimator;
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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double exit = 0;
	private String version = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String updateversion = "";
	
	private ScrollView vscroll1;
	private LinearLayout foot;
	private LinearLayout fuck;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private ImageView xem;
	private LinearLayout linear6;
	private ImageView an;
	private LinearLayout linear24;
	private LinearLayout linear4;
	private TextView textview1;
	private TextView tentaikhoan;
	private LinearLayout linear5;
	private TextView textview3;
	private ImageView user;
	private ImageView imageview2;
	private ImageView imageview1;
	private ImageView imageview3;
	private ImageView imageview4;
	private LinearLayout linear7;
	private LinearLayout linear14;
	private ImageView imageview8;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private LinearLayout linear19;
	private LinearLayout linear22;
	private LinearLayout linear23;
	private ImageView imageview6;
	private LinearLayout linear8;
	private ImageView imageview7;
	private LinearLayout linear13;
	private LinearLayout linear12;
	private TextView textview4;
	private TextView textview5;
	private LinearLayout linear16;
	private LinearLayout linear15;
	private TextView textview6;
	private TextView sdt;
	private TextView vnd;
	private TextView textview8;
	private TextView textview9;
	private ImageView imageview9;
	private ImageView imageview10;
	private TextView textview10;
	private TextView Diem;
	private ImageView imageview11;
	private TextView textview12;
	private ImageView imageview12;
	private TextView textview15;
	private ImageView imageview14;
	private TextView textview16;
	private ImageView imageview15;
	private LinearLayout linear25;
	private LinearLayout linear31;
	private LinearLayout linear32;
	private TextView textview24;
	private LinearLayout linear50;
	private LinearLayout linear51;
	private LinearLayout linear52;
	private ImageView imagebanner;
	private LinearLayout linear53;
	private TextView textview17;
	private ImageView imageview16;
	private LinearLayout linear27;
	private LinearLayout linear29;
	private LinearLayout linear30;
	private ImageView imageview17;
	private TextView textview18;
	private ImageView imageview18;
	private TextView textview19;
	private ImageView imageview19;
	private TextView textview20;
	private LinearLayout linear33;
	private LinearLayout linear34;
	private LinearLayout linear35;
	private ImageView imageview20;
	private TextView textview21;
	private ImageView imageview21;
	private TextView textview22;
	private ImageView imageview22;
	private TextView textview23;
	private LinearLayout linear36;
	private LinearLayout linear37;
	private LinearLayout linear42;
	private LinearLayout linear38;
	private LinearLayout linear39;
	private LinearLayout linear40;
	private LinearLayout linear41;
	private ImageView imageview23;
	private TextView textview25;
	private ImageView imageview24;
	private TextView textview26;
	private ImageView imageview25;
	private TextView textview27;
	private ImageView imageview26;
	private TextView textview28;
	private LinearLayout linear43;
	private LinearLayout linear44;
	private LinearLayout linear45;
	private LinearLayout linear46;
	private ImageView imageview27;
	private TextView textview29;
	private ImageView imageview28;
	private TextView textview30;
	private ImageView imageview29;
	private TextView textview31;
	private ImageView imageview30;
	private TextView textview32;
	private TextView textview33;
	private TextView textview34;
	private LinearLayout linear54;
	private LinearLayout linear55;
	private LinearLayout linear56;
	private LinearLayout linear57;
	private LinearLayout linear58;
	private LinearLayout linear59;
	private LinearLayout linear60;
	private LinearLayout linear61;
	private LinearLayout linear62;
	
	private ObjectAnimator animation = new ObjectAnimator();
	private TimerTask t;
	private Intent i = new Intent();
	private SharedPreferences ten;
	private SharedPreferences tien;
	private SharedPreferences tendangnhap;
	private SharedPreferences diem;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private AlertDialog.Builder dialog;
	
	private OnCompleteListener cloud_onCompleteListener;
	private DatabaseReference update = _firebase.getReference("update");
	private ChildEventListener _update_child_listener;
	private SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		foot = findViewById(R.id.foot);
		fuck = findViewById(R.id.fuck);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		xem = findViewById(R.id.xem);
		linear6 = findViewById(R.id.linear6);
		an = findViewById(R.id.an);
		linear24 = findViewById(R.id.linear24);
		linear4 = findViewById(R.id.linear4);
		textview1 = findViewById(R.id.textview1);
		tentaikhoan = findViewById(R.id.tentaikhoan);
		linear5 = findViewById(R.id.linear5);
		textview3 = findViewById(R.id.textview3);
		user = findViewById(R.id.user);
		imageview2 = findViewById(R.id.imageview2);
		imageview1 = findViewById(R.id.imageview1);
		imageview3 = findViewById(R.id.imageview3);
		imageview4 = findViewById(R.id.imageview4);
		linear7 = findViewById(R.id.linear7);
		linear14 = findViewById(R.id.linear14);
		imageview8 = findViewById(R.id.imageview8);
		linear17 = findViewById(R.id.linear17);
		linear18 = findViewById(R.id.linear18);
		linear19 = findViewById(R.id.linear19);
		linear22 = findViewById(R.id.linear22);
		linear23 = findViewById(R.id.linear23);
		imageview6 = findViewById(R.id.imageview6);
		linear8 = findViewById(R.id.linear8);
		imageview7 = findViewById(R.id.imageview7);
		linear13 = findViewById(R.id.linear13);
		linear12 = findViewById(R.id.linear12);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		linear16 = findViewById(R.id.linear16);
		linear15 = findViewById(R.id.linear15);
		textview6 = findViewById(R.id.textview6);
		sdt = findViewById(R.id.sdt);
		vnd = findViewById(R.id.vnd);
		textview8 = findViewById(R.id.textview8);
		textview9 = findViewById(R.id.textview9);
		imageview9 = findViewById(R.id.imageview9);
		imageview10 = findViewById(R.id.imageview10);
		textview10 = findViewById(R.id.textview10);
		Diem = findViewById(R.id.Diem);
		imageview11 = findViewById(R.id.imageview11);
		textview12 = findViewById(R.id.textview12);
		imageview12 = findViewById(R.id.imageview12);
		textview15 = findViewById(R.id.textview15);
		imageview14 = findViewById(R.id.imageview14);
		textview16 = findViewById(R.id.textview16);
		imageview15 = findViewById(R.id.imageview15);
		linear25 = findViewById(R.id.linear25);
		linear31 = findViewById(R.id.linear31);
		linear32 = findViewById(R.id.linear32);
		textview24 = findViewById(R.id.textview24);
		linear50 = findViewById(R.id.linear50);
		linear51 = findViewById(R.id.linear51);
		linear52 = findViewById(R.id.linear52);
		imagebanner = findViewById(R.id.imagebanner);
		linear53 = findViewById(R.id.linear53);
		textview17 = findViewById(R.id.textview17);
		imageview16 = findViewById(R.id.imageview16);
		linear27 = findViewById(R.id.linear27);
		linear29 = findViewById(R.id.linear29);
		linear30 = findViewById(R.id.linear30);
		imageview17 = findViewById(R.id.imageview17);
		textview18 = findViewById(R.id.textview18);
		imageview18 = findViewById(R.id.imageview18);
		textview19 = findViewById(R.id.textview19);
		imageview19 = findViewById(R.id.imageview19);
		textview20 = findViewById(R.id.textview20);
		linear33 = findViewById(R.id.linear33);
		linear34 = findViewById(R.id.linear34);
		linear35 = findViewById(R.id.linear35);
		imageview20 = findViewById(R.id.imageview20);
		textview21 = findViewById(R.id.textview21);
		imageview21 = findViewById(R.id.imageview21);
		textview22 = findViewById(R.id.textview22);
		imageview22 = findViewById(R.id.imageview22);
		textview23 = findViewById(R.id.textview23);
		linear36 = findViewById(R.id.linear36);
		linear37 = findViewById(R.id.linear37);
		linear42 = findViewById(R.id.linear42);
		linear38 = findViewById(R.id.linear38);
		linear39 = findViewById(R.id.linear39);
		linear40 = findViewById(R.id.linear40);
		linear41 = findViewById(R.id.linear41);
		imageview23 = findViewById(R.id.imageview23);
		textview25 = findViewById(R.id.textview25);
		imageview24 = findViewById(R.id.imageview24);
		textview26 = findViewById(R.id.textview26);
		imageview25 = findViewById(R.id.imageview25);
		textview27 = findViewById(R.id.textview27);
		imageview26 = findViewById(R.id.imageview26);
		textview28 = findViewById(R.id.textview28);
		linear43 = findViewById(R.id.linear43);
		linear44 = findViewById(R.id.linear44);
		linear45 = findViewById(R.id.linear45);
		linear46 = findViewById(R.id.linear46);
		imageview27 = findViewById(R.id.imageview27);
		textview29 = findViewById(R.id.textview29);
		imageview28 = findViewById(R.id.imageview28);
		textview30 = findViewById(R.id.textview30);
		imageview29 = findViewById(R.id.imageview29);
		textview31 = findViewById(R.id.textview31);
		imageview30 = findViewById(R.id.imageview30);
		textview32 = findViewById(R.id.textview32);
		textview33 = findViewById(R.id.textview33);
		textview34 = findViewById(R.id.textview34);
		linear54 = findViewById(R.id.linear54);
		linear55 = findViewById(R.id.linear55);
		linear56 = findViewById(R.id.linear56);
		linear57 = findViewById(R.id.linear57);
		linear58 = findViewById(R.id.linear58);
		linear59 = findViewById(R.id.linear59);
		linear60 = findViewById(R.id.linear60);
		linear61 = findViewById(R.id.linear61);
		linear62 = findViewById(R.id.linear62);
		ten = getSharedPreferences("ten", Activity.MODE_PRIVATE);
		tien = getSharedPreferences("tien", Activity.MODE_PRIVATE);
		tendangnhap = getSharedPreferences("tendangnhap", Activity.MODE_PRIVATE);
		diem = getSharedPreferences("diem", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		dialog = new AlertDialog.Builder(this);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		fuck.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Sẽ sớm có !");
			}
		});
		
		xem.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				xem.setVisibility(View.GONE);
				linear6.setVisibility(View.VISIBLE);
				an.setVisibility(View.VISIBLE);
				textview3.setText("Tài khoản của tôi");
				animation.setTarget(linear6);
				animation.setPropertyName("translationY");
				animation.setFloatValues((float)(0 - 50), (float)(0));
				animation.setDuration((int)(300));
				animation.setInterpolator(new AccelerateInterpolator());
				animation.start();
			}
		});
		
		an.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				xem.setVisibility(View.VISIBLE);
				linear6.setVisibility(View.GONE);
				an.setVisibility(View.GONE);
				textview3.setText("Xem tài khoản");
			}
		});
		
		tentaikhoan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		user.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), TaikhoanActivity.class);
				startActivity(i);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ChatActivity.class);
				startActivity(i);
			}
		});
		
		imageview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), TaikhoannguonActivity.class);
				startActivity(i);
			}
		});
		
		imageview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Sẽ sớm có !");
			}
		});
		
		linear27.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ChuyentienActivity.class);
				startActivity(i);
			}
		});
		
		cloud_onCompleteListener = new OnCompleteListener<InstanceIdResult>() {
			@Override
			public void onComplete(Task<InstanceIdResult> task) {
				final boolean _success = task.isSuccessful();
				final String _token = task.getResult().getToken();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_update_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				version = "1.1";
				updateversion = _childValue.get("phienban").toString();
				if (Double.parseDouble(updateversion) == Double.parseDouble(version)) {
					
				}
				else {
					if (Double.parseDouble(updateversion) > Double.parseDouble(version)) {
						sp.edit().putString("url", _childValue.get("link").toString()).commit();
						sp.edit().putString("log", _childValue.get("log").toString()).commit();
						sp.edit().putString("phienban", _childValue.get("phienban").toString()).commit();
						i.setClass(getApplicationContext(), UpdateActivity.class);
						startActivity(i);
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		update.addChildEventListener(_update_child_listener);
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					dialog.setCancelable(false);
					dialog.setTitle("Vui lòng đăng nhập bằng mật khẩu mới của bạn !");
					dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		//TELEGRAM @NGUYENNHATNONAME
		
		QUANG NHAT TOP 1 DEVELOPER
		_bee();
		setFinishOnTouchOutside(false);
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			
		}
		else {
			dialog.setCancelable(false);
			dialog.setTitle("Thông báo");
			dialog.setMessage("Vui lòng đăng nhập để trải nghiệm ứng dụng");
			dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					i.setClass(getApplicationContext(), LoginActivity.class);
					startActivity(i);
				}
			});
			dialog.create().show();
		}
		tentaikhoan.setText(ten.getString("ten", ""));
		vnd.setText(tien.getString("tien", ""));
		sdt.setText(tendangnhap.getString("tendangnhap", ""));
		Diem.setText(diem.getString("diem", "").concat(" Point"));
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { 
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(0xFF008375); w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); }
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)20, Color.TRANSPARENT, 0xFFFFFFFF));
		linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)20, Color.TRANSPARENT, 0xFFFFFFFF));
		vnd.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		linear17.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)20, Color.TRANSPARENT, 0xFFECEFF1));
		tentaikhoan.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		linear18.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)20, Color.TRANSPARENT, 0xFFFFFFFF));
		textview12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		linear19.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)20, Color.TRANSPARENT, 0xFFFFFFFF));
		textview15.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview16.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		linear22.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)20, Color.TRANSPARENT, 0xFFFFFFFF));
		linear23.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)20, Color.TRANSPARENT, 0xFFFFFFFF));
		textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		linear6.setVisibility(View.GONE);
		an.setVisibility(View.GONE);
		textview17.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		linear27.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)2, 0xFFE0E0E0, 0xFFFFFFFF));
		textview18.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		linear29.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)2, 0xFFE0E0E0, 0xFFFFFFFF));
		textview19.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		linear30.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)2, 0xFFE0E0E0, 0xFFFFFFFF));
		textview20.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		linear33.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)2, 0xFFE0E0E0, 0xFFFFFFFF));
		textview21.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		linear34.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)2, 0xFFE0E0E0, 0xFFFFFFFF));
		textview22.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		linear35.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)2, 0xFFE0E0E0, 0xFFFFFFFF));
		textview23.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview33.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										imagebanner.setImageResource(R.drawable.hia_6);
										linear54.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)2, 0xFF141ED3, 0xFFFFFFFF));
										linear62.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
									}
								});
							}
						};
						_timer.schedule(t, (int)(0));
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										imagebanner.setImageResource(R.drawable.hia_5);
										linear55.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)2, 0xFF141ED3, 0xFFFFFFFF));
										linear54.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
									}
								});
							}
						};
						_timer.schedule(t, (int)(3000));
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										imagebanner.setImageResource(R.drawable.hia_4);
										linear56.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)2, 0xFF141ED3, 0xFFFFFFFF));
										linear55.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
									}
								});
							}
						};
						_timer.schedule(t, (int)(6000));
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										imagebanner.setImageResource(R.drawable.hia_3);
										linear57.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)2, 0xFF141ED3, 0xFFFFFFFF));
										linear56.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
									}
								});
							}
						};
						_timer.schedule(t, (int)(9000));
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										imagebanner.setImageResource(R.drawable.ass);
										linear58.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)2, 0xFF141ED3, 0xFFFFFFFF));
										linear57.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
									}
								});
							}
						};
						_timer.schedule(t, (int)(12000));
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										imagebanner.setImageResource(R.drawable.hia_2);
										linear59.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)2, 0xFF141ED3, 0xFFFFFFFF));
										linear58.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
									}
								});
							}
						};
						_timer.schedule(t, (int)(15000));
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										imagebanner.setImageResource(R.drawable.haha_3);
										linear60.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)2, 0xFF141ED3, 0xFFFFFFFF));
										linear59.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
									}
								});
							}
						};
						_timer.schedule(t, (int)(18000));
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										imagebanner.setImageResource(R.drawable.haha_2);
										linear61.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)2, 0xFF141ED3, 0xFFFFFFFF));
										linear60.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
									}
								});
							}
						};
						_timer.schedule(t, (int)(21000));
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										imagebanner.setImageResource(R.drawable.haha_1);
										linear62.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)2, 0xFF141ED3, 0xFFFFFFFF));
										linear61.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
									}
								});
							}
						};
						_timer.schedule(t, (int)(24000));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(0), (int)(28000));
		linear54.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
		linear55.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
		linear56.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
		linear57.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
		linear58.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
		linear59.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
		linear60.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
		linear61.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
		linear62.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
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
	public void _bee() {
		if (!android.provider.Settings.canDrawOverlays(MainActivity.this)){
				Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
			    startActivity(intent);
			    }
		    else{
			//direct injector app page floating window show
			
			 int LAYOUT_FLAG;
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
				    LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
			} else {
				    LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_PHONE;
			}
			
			final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
			    WindowManager.LayoutParams.WRAP_CONTENT,
			    WindowManager.LayoutParams.WRAP_CONTENT,
			    LAYOUT_FLAG,
			      WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
			     , 
			
			    PixelFormat.TRANSPARENT);
			
			  final  WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
			    LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			    //View myView = inflater.inflate(R.layout.floating, null);
			
			final View myView = (View) getLayoutInflater().inflate(R.layout.bee, null); 
			
			
			LinearLayout AndroidSketchwareMaster = (LinearLayout) myView.findViewById(R.id.menu);
			AndroidSketchwareMaster.setBackground(new android.graphics.drawable.GradientDrawable() { public android.graphics.drawable.GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)0, Color.TRANSPARENT));
			
			    AndroidSketchwareMaster.setOnTouchListener(new OnTouchListener() {
				private int x;
				private int y;
				       @Override
				       public boolean onTouch(View v, MotionEvent event) {
					LinearLayout AndroidMaster = (LinearLayout) myView.findViewById(R.id.menu);
					AndroidMaster.setAlpha((float)(1.0));
					 switch (event.getAction()) { 
						case MotionEvent.ACTION_DOWN: 
						x = (int) event.getRawX(); 
						y = (int) event.getRawY();
						
						break;
						
						case MotionEvent.ACTION_MOVE: int nowX = (int) event.getRawX(); 
						int nowY = (int) event.getRawY(); 
						int movedX = nowX - x; 
						int movedY = nowY - y; 
						x = nowX; y = nowY; 
						params.x = params.x + movedX; 
						params.y = params.y + movedY;
						 wm.updateViewLayout(myView, params);
						AndroidMaster.setAlpha((float)(0.6));
						break; 
						default: 
						break; 
					}
					 return false;
					 }
				 });
			
			   //Specify the view position
			       params.gravity = Gravity.TOP | Gravity.LEFT;        //Initially view will be added to top-left corner
			    params.x = 0;
			       params.y = 0;
			
			final LinearLayout   icons = (LinearLayout) myView.findViewById(R.id.icons);
			
			icons.setBackground(new android.graphics.drawable.GradientDrawable() { public android.graphics.drawable.GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)1, Color.TRANSPARENT));
			final LinearLayout   li = (LinearLayout) myView.findViewById(R.id.li);
			
			li.setBackground(new android.graphics.drawable.GradientDrawable() { public android.graphics.drawable.GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)1, Color.TRANSPARENT));
			final LinearLayout   linear1 = (LinearLayout) myView.findViewById(R.id.linear1);
			
			linear1.setBackground(new android.graphics.drawable.GradientDrawable() { public android.graphics.drawable.GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)1, Color.TRANSPARENT));
			linear1.setVisibility(View.GONE);         
			ImageView iexit = (ImageView) myView.findViewById(R.id.exit);
			
			iexit.setOnClickListener(new OnClickListener() { 
				@Override 
				public void onClick(View v) {
					wm.removeView(myView);
				} });
			
			wm.addView(myView, params);
		}
		/* credit by - Android sketchware master channel - https://youtube.com/@ANDROID_SKETCHWARE_MASTER telegram - @ANDROID_SKETCHWARE_MASTER It is made with care and free for you. It is for use only. Do not try to take credit for it. Credit only to this channel youtube.com/@ANDROID_SKETCHWARE_MASTER. * Code, block, name will not change. // And those who try to take credit in their own name by changing it - ********fuck./* 
credit by - Android sketchware master
channel - https://youtube.com/@ANDROID_SKETCHWARE_MASTER
telegram - @ANDROID_SKETCHWARE_MASTER

এটি অনেক যত্ন সহকারে আপনাদের জন্য ফ্রিতে বানানো হয়েছে। এটি শুধুমাত্র ব্যবহারের জন্য।এটির ক্রেডিট কেউ নিজের নামে নেওয়ার চেষ্টা করবেন না। ক্রেডিট শুধুমাত্র youtube.com/@ANDROID_SKETCHWARE_MASTER এই চ্যানেল এর উপরেই।
*কোড , ব্লক , নাম চেঞ্জ করবে না।
//আর যারা চেঞ্জ করে নিজের নামে credit নেওয়ার চেষ্টা করবে তার - ********fuck.*/
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