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
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class TaikhoanActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double show = 0;
	
	private ScrollView vscroll2;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear10;
	private LinearLayout linear18;
	private LinearLayout linear24;
	private LinearLayout linear25;
	private LinearLayout linear19;
	private LinearLayout edit;
	private Button button9;
	private Button button6;
	private LinearLayout linear16;
	private TextView textview1;
	private ImageView imageview1;
	private LinearLayout linear9;
	private LinearLayout linear8;
	private CircleImageView circleimageview1;
	private TextView textview2;
	private LinearLayout linear7;
	private TextView textview3;
	private TextView tendangnhapedit;
	private ImageView imageview2;
	private LinearLayout linear11;
	private ImageView imageview3;
	private ImageView imageview5;
	private TextView textview10;
	private ImageView imageview6;
	private TextView textview12;
	private ImageView imageview10;
	private TextView textview13;
	private LinearLayout linear26;
	private Button button8;
	private EditText edittext9;
	private ImageView imageview11;
	private TextView textview11;
	private LinearLayout linear21;
	private LinearLayout linear20;
	private LinearLayout linear22;
	private Button button7;
	private EditText edittext6;
	private ImageView imageview7;
	private EditText edittext7;
	private ImageView imageview8;
	private EditText edittext8;
	private ImageView imageview9;
	private ImageView imageview4;
	private LinearLayout tuychinh;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear15;
	private TextView textview5;
	private EditText edittext1;
	private Button button1;
	private TextView textview6;
	private EditText edittext2;
	private Button button2;
	private TextView textview7;
	private EditText edittext3;
	private Button button3;
	private TextView textview9;
	private EditText edittext5;
	private Button button5;
	
	private Intent i = new Intent();
	private SharedPreferences ten;
	private SharedPreferences tien;
	private SharedPreferences tendangnhap;
	private SharedPreferences diem;
	private AlertDialog.Builder dialog;
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
	
	private SharedPreferences sp;
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.taikhoan);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll2 = findViewById(R.id.vscroll2);
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear10 = findViewById(R.id.linear10);
		linear18 = findViewById(R.id.linear18);
		linear24 = findViewById(R.id.linear24);
		linear25 = findViewById(R.id.linear25);
		linear19 = findViewById(R.id.linear19);
		edit = findViewById(R.id.edit);
		button9 = findViewById(R.id.button9);
		button6 = findViewById(R.id.button6);
		linear16 = findViewById(R.id.linear16);
		textview1 = findViewById(R.id.textview1);
		imageview1 = findViewById(R.id.imageview1);
		linear9 = findViewById(R.id.linear9);
		linear8 = findViewById(R.id.linear8);
		circleimageview1 = findViewById(R.id.circleimageview1);
		textview2 = findViewById(R.id.textview2);
		linear7 = findViewById(R.id.linear7);
		textview3 = findViewById(R.id.textview3);
		tendangnhapedit = findViewById(R.id.tendangnhapedit);
		imageview2 = findViewById(R.id.imageview2);
		linear11 = findViewById(R.id.linear11);
		imageview3 = findViewById(R.id.imageview3);
		imageview5 = findViewById(R.id.imageview5);
		textview10 = findViewById(R.id.textview10);
		imageview6 = findViewById(R.id.imageview6);
		textview12 = findViewById(R.id.textview12);
		imageview10 = findViewById(R.id.imageview10);
		textview13 = findViewById(R.id.textview13);
		linear26 = findViewById(R.id.linear26);
		button8 = findViewById(R.id.button8);
		edittext9 = findViewById(R.id.edittext9);
		imageview11 = findViewById(R.id.imageview11);
		textview11 = findViewById(R.id.textview11);
		linear21 = findViewById(R.id.linear21);
		linear20 = findViewById(R.id.linear20);
		linear22 = findViewById(R.id.linear22);
		button7 = findViewById(R.id.button7);
		edittext6 = findViewById(R.id.edittext6);
		imageview7 = findViewById(R.id.imageview7);
		edittext7 = findViewById(R.id.edittext7);
		imageview8 = findViewById(R.id.imageview8);
		edittext8 = findViewById(R.id.edittext8);
		imageview9 = findViewById(R.id.imageview9);
		imageview4 = findViewById(R.id.imageview4);
		tuychinh = findViewById(R.id.tuychinh);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		linear15 = findViewById(R.id.linear15);
		textview5 = findViewById(R.id.textview5);
		edittext1 = findViewById(R.id.edittext1);
		button1 = findViewById(R.id.button1);
		textview6 = findViewById(R.id.textview6);
		edittext2 = findViewById(R.id.edittext2);
		button2 = findViewById(R.id.button2);
		textview7 = findViewById(R.id.textview7);
		edittext3 = findViewById(R.id.edittext3);
		button3 = findViewById(R.id.button3);
		textview9 = findViewById(R.id.textview9);
		edittext5 = findViewById(R.id.edittext5);
		button5 = findViewById(R.id.button5);
		ten = getSharedPreferences("ten", Activity.MODE_PRIVATE);
		tien = getSharedPreferences("tien", Activity.MODE_PRIVATE);
		tendangnhap = getSharedPreferences("tendangnhap", Activity.MODE_PRIVATE);
		diem = getSharedPreferences("diem", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ChatActivity.class);
				startActivity(i);
			}
		});
		
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FirebaseAuth.getInstance().signOut();
				i.setClass(getApplicationContext(), LoginActivity.class);
				startActivity(i);
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edit.setVisibility(View.VISIBLE);
				linear10.setVisibility(View.GONE);
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear19.setVisibility(View.VISIBLE);
				linear18.setVisibility(View.GONE);
			}
		});
		
		imageview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear25.setVisibility(View.VISIBLE);
				linear24.setVisibility(View.GONE);
			}
		});
		
		textview13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear24.setVisibility(View.VISIBLE);
				linear25.setVisibility(View.GONE);
			}
		});
		
		button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext9.getText().toString().equals(sp.getString("mk", ""))) {
					dialog.setTitle("Thông báo");
					dialog.setMessage("Việc xoá tài khoản sẽ xoá hết mọi dữ liệu của bạn");
					dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							FirebaseAuth.getInstance().getCurrentUser().delete()
							.addOnCompleteListener(auth_deleteUserListener);
						}
					});
					dialog.create().show();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Mật khẩu cũ không chính xác");
				}
			}
		});
		
		imageview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (show == 0) {
					show++;
					edittext9.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
				}
				else {
					show = 0;
					edittext9.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}
			}
		});
		
		textview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear19.setVisibility(View.GONE);
				linear18.setVisibility(View.VISIBLE);
			}
		});
		
		button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext6.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Không được bỏ trống !");
				}
				else {
					if (edittext7.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Không được bỏ trống !");
					}
					else {
						if (edittext8.getText().toString().equals("")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Không được bỏ trống !");
						}
						else {
							if (edittext6.getText().toString().equals(sp.getString("mk", ""))) {
								if (edittext7.getText().toString().equals(edittext8.getText().toString())) {
									FirebaseAuth.getInstance().getCurrentUser().updatePassword(edittext8.getText().toString()).addOnCompleteListener(auth_updatePasswordListener);
									SketchwareUtil.showMessage(getApplicationContext(), "Vui lòng đợi");
									linear19.setVisibility(View.GONE);
									linear18.setVisibility(View.VISIBLE);
								}
								else {
									SketchwareUtil.showMessage(getApplicationContext(), "Mật khẩu mới không giống nhau !");
								}
							}
							else {
								SketchwareUtil.showMessage(getApplicationContext(), "Mật khẩu cũ không chính đúng !");
							}
						}
					}
				}
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (show == 0) {
					show++;
					edittext6.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
				}
				else {
					show = 0;
					edittext6.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}
			}
		});
		
		imageview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (show == 0) {
					show++;
					edittext7.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
				}
				else {
					show = 0;
					edittext7.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}
			}
		});
		
		imageview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (show == 0) {
					show++;
					edittext8.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
				}
				else {
					show = 0;
					edittext8.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edit.setVisibility(View.GONE);
				linear10.setVisibility(View.VISIBLE);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("")) {
					dialog.setTitle("Tên không được bỏ trống");
					dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
				else {
					ten.edit().putString("ten", edittext1.getText().toString()).commit();
					edittext1.setText("");
					edit.setVisibility(View.GONE);
					linear10.setVisibility(View.VISIBLE);
					SketchwareUtil.showMessage(getApplicationContext(), "Đã thay đổi tên thành: ".concat(ten.getString("ten", "")));
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext2.getText().toString().equals("")) {
					dialog.setTitle("Số tiền không được bỏ trống");
					dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
				else {
					tien.edit().putString("tien", edittext2.getText().toString()).commit();
					edit.setVisibility(View.GONE);
					edittext2.setText("");
					linear10.setVisibility(View.VISIBLE);
					SketchwareUtil.showMessage(getApplicationContext(), "Đã thay đổi tiền thành: ".concat(tien.getString("tien", "")));
				}
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext3.getText().toString().equals("")) {
					dialog.setTitle("Tên đăng nhập không được bỏ trống");
					dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
				else {
					tendangnhap.edit().putString("tendangnhap", edittext3.getText().toString()).commit();
					edit.setVisibility(View.GONE);
					edittext3.setText("");
					linear10.setVisibility(View.VISIBLE);
					SketchwareUtil.showMessage(getApplicationContext(), "Đã thay đổi tên đăng nhập thành: ".concat(tendangnhap.getString("tendangnhap", "")));
				}
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext5.getText().toString().equals("")) {
					dialog.setTitle("Điểm không được bỏ trống");
					dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
				else {
					diem.edit().putString("diem", edittext5.getText().toString()).commit();
					edit.setVisibility(View.GONE);
					edittext5.setText("");
					linear10.setVisibility(View.VISIBLE);
					SketchwareUtil.showMessage(getApplicationContext(), "Đã thay đổi điểm thành: ".concat(diem.getString("diem", "")));
				}
			}
		});
		
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
					dialog.setTitle("Thông báo");
					dialog.setMessage("Mật khẩu đã cập nhật thành công vui lòng đăng nhập lại");
					dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							FirebaseAuth.getInstance().signOut();
							i.setClass(getApplicationContext(), LoginActivity.class);
							startActivity(i);
						}
					});
					dialog.create().show();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Mật khẩu mới phải lớn hơn 6 kí tự");
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
				if (_success) {
					FirebaseAuth.getInstance().signOut();
					SketchwareUtil.showMessage(getApplicationContext(), "Tài khoản đã được xoá");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Đã xảy ra lỗi !");
				}
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
		edittext6.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		edittext7.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		edittext8.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		edittext9.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		textview2.setText(ten.getString("ten", ""));
		tendangnhapedit.setText(tendangnhap.getString("tendangnhap", ""));
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { 
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(0xFF008375); w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); }
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0, Color.TRANSPARENT, 0xFF141ED3));
		button2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0, Color.TRANSPARENT, 0xFF141ED3));
		button3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0, Color.TRANSPARENT, 0xFF141ED3));
		button5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0, Color.TRANSPARENT, 0xFF141ED3));
		button6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)0, Color.TRANSPARENT, 0xFF141ED3));
		button7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)0, Color.TRANSPARENT, 0xFF141ED3));
		edit.setVisibility(View.GONE);
		linear19.setVisibility(View.GONE);
		linear25.setVisibility(View.GONE);
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(20);
			tuychinh.setBackgroundDrawable(gd);
			tuychinh.setElevation(20);};
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(20);
			linear12.setBackgroundDrawable(gd);
			linear12.setElevation(20);};
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(20);
			linear13.setBackgroundDrawable(gd);
			linear13.setElevation(20);};
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(20);
			edit.setBackgroundDrawable(gd);
			edit.setElevation(20);};
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(20);
			linear15.setBackgroundDrawable(gd);
			linear15.setElevation(20);};
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(20);
			linear10.setBackgroundDrawable(gd);
			linear10.setElevation(20);};
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(20);
			linear18.setBackgroundDrawable(gd);
			linear18.setElevation(20);};
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(20);
			linear19.setBackgroundDrawable(gd);
			linear19.setElevation(20);};
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(20);
			linear24.setBackgroundDrawable(gd);
			linear24.setElevation(20);};
		{android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, new int[]{
				0xFFFFFFFF,
				0xFFFFFFFF,
			});
			gd.setCornerRadius(20);
			linear25.setBackgroundDrawable(gd);
			linear25.setElevation(20);};
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