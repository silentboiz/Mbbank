package mbbank.app;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
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

public class XacthucActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview2;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private TextView textview2;
	private LinearLayout linear6;
	private TextView textview3;
	private TextView giay;
	private TextView otp1;
	private TextView otp2;
	private TextView otp3;
	private TextView otp4;
	private TextView otp5;
	private TextView otp6;
	private TextView otp7;
	private TextView otp8;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private TextView textview8;
	private TextView textview9;
	private TextView textview10;
	private TextView textview11;
	private TextView textview12;
	private Button button1;
	
	private Intent i = new Intent();
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.xacthuc);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		imageview2 = findViewById(R.id.imageview2);
		linear5 = findViewById(R.id.linear5);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		textview2 = findViewById(R.id.textview2);
		linear6 = findViewById(R.id.linear6);
		textview3 = findViewById(R.id.textview3);
		giay = findViewById(R.id.giay);
		otp1 = findViewById(R.id.otp1);
		otp2 = findViewById(R.id.otp2);
		otp3 = findViewById(R.id.otp3);
		otp4 = findViewById(R.id.otp4);
		otp5 = findViewById(R.id.otp5);
		otp6 = findViewById(R.id.otp6);
		otp7 = findViewById(R.id.otp7);
		otp8 = findViewById(R.id.otp8);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		textview7 = findViewById(R.id.textview7);
		textview8 = findViewById(R.id.textview8);
		textview9 = findViewById(R.id.textview9);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		textview12 = findViewById(R.id.textview12);
		button1 = findViewById(R.id.button1);
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				textview5.setVisibility(View.VISIBLE);
				textview6.setVisibility(View.VISIBLE);
				textview7.setVisibility(View.VISIBLE);
				textview8.setVisibility(View.VISIBLE);
				textview9.setVisibility(View.VISIBLE);
				textview10.setVisibility(View.VISIBLE);
				textview11.setVisibility(View.VISIBLE);
				textview12.setVisibility(View.VISIBLE);
				textview5.setText(otp1.getText().toString());
				textview6.setText(otp2.getText().toString());
				textview7.setText(otp3.getText().toString());
				textview8.setText(otp4.getText().toString());
				textview9.setText(otp5.getText().toString());
				textview10.setText(otp6.getText().toString());
				textview11.setText(otp7.getText().toString());
				textview12.setText(otp8.getText().toString());
				button1.setVisibility(View.VISIBLE);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), BillActivity.class);
				startActivity(i);
			}
		});
	}
	
	private void initializeLogic() {
		button1.setVisibility(View.GONE);
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =XacthucActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF112378);
		}
		otp1.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))));
		otp2.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))));
		otp3.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))));
		otp4.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))));
		otp5.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))));
		otp6.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))));
		otp7.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))));
		otp8.setText(String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(9)))));
		otp1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		otp2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		otp3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		otp4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		otp5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		otp6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		otp7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		otp8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)0, Color.TRANSPARENT, 0xFFFFFFFF));
		linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)3, 0xFF40C4FF, 0xFFFFFFFF));
		linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)0, Color.TRANSPARENT, 0xFFFFFFFF));
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font1.ttf"), 0);
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						giay.setText("99 giây");
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										giay.setText("98 giây");
										t = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														giay.setText("97 giây");
														t = new TimerTask() {
															@Override
															public void run() {
																runOnUiThread(new Runnable() {
																	@Override
																	public void run() {
																		giay.setText("96 giây");
																		t = new TimerTask() {
																			@Override
																			public void run() {
																				runOnUiThread(new Runnable() {
																					@Override
																					public void run() {
																						giay.setText("95 giây");
																						t = new TimerTask() {
																							@Override
																							public void run() {
																								runOnUiThread(new Runnable() {
																									@Override
																									public void run() {
																										giay.setText("94 giây");
																										t = new TimerTask() {
																											@Override
																											public void run() {
																												runOnUiThread(new Runnable() {
																													@Override
																													public void run() {
																														giay.setText("93 giây");
																														t = new TimerTask() {
																															@Override
																															public void run() {
																																runOnUiThread(new Runnable() {
																																	@Override
																																	public void run() {
																																		giay.setText("92 giây");
																																		t = new TimerTask() {
																																			@Override
																																			public void run() {
																																				runOnUiThread(new Runnable() {
																																					@Override
																																					public void run() {
																																						giay.setText("91 giây");
																																						t = new TimerTask() {
																																							@Override
																																							public void run() {
																																								runOnUiThread(new Runnable() {
																																									@Override
																																									public void run() {
																																										giay.setText("90 giây");
																																									}
																																								});
																																							}
																																						};
																																						_timer.schedule(t, (int)(1000));
																																					}
																																				});
																																			}
																																		};
																																		_timer.schedule(t, (int)(1000));
																																	}
																																});
																															}
																														};
																														_timer.schedule(t, (int)(1000));
																													}
																												});
																											}
																										};
																										_timer.schedule(t, (int)(1000));
																									}
																								});
																							}
																						};
																						_timer.schedule(t, (int)(1000));
																					}
																				});
																			}
																		};
																		_timer.schedule(t, (int)(1000));
																	}
																});
															}
														};
														_timer.schedule(t, (int)(1000));
													}
												});
											}
										};
										_timer.schedule(t, (int)(1000));
									}
								});
							}
						};
						_timer.schedule(t, (int)(1000));
					}
				});
			}
		};
		_timer.schedule(t, (int)(1000));
		textview5.setVisibility(View.GONE);
		textview6.setVisibility(View.GONE);
		textview7.setVisibility(View.GONE);
		textview8.setVisibility(View.GONE);
		textview9.setVisibility(View.GONE);
		textview10.setVisibility(View.GONE);
		textview11.setVisibility(View.GONE);
		textview12.setVisibility(View.GONE);
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