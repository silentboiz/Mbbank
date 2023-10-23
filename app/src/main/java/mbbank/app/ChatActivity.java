package mbbank.app;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.beuni.screenshot.*;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.*;
import java.io.File;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class ChatActivity extends AppCompatActivity {
	
	public final int REQ_CD_PICK = 101;
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String username = "";
	private String picture = "";
	private double Last = 0;
	private double image = 0;
	private String imagePath = "";
	private String imageName = "";
	private double color = 0;
	
	private ArrayList<HashMap<String, Object>> m = new ArrayList<>();
	private ArrayList<String> key = new ArrayList<>();
	
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview2;
	private ListView listview1;
	private ImageView anh;
	private EditText tinnhan;
	private ImageView imageview3;
	private ImageView gui;
	
	private Calendar time = Calendar.getInstance();
	private DatabaseReference db = _firebase.getReference("db");
	private ChildEventListener _db_child_listener;
	private SharedPreferences sp;
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
	
	private SharedPreferences ten;
	private Intent i = new Intent();
	private AlertDialog.Builder dialog;
	private TimerTask t;
	private Intent pick = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference chat = _firebase_storage.getReference("chat");
	private OnCompleteListener<Uri> _chat_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _chat_download_success_listener;
	private OnSuccessListener _chat_delete_success_listener;
	private OnProgressListener _chat_upload_progress_listener;
	private OnProgressListener _chat_download_progress_listener;
	private OnFailureListener _chat_failure_listener;
	
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.chat);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		imageview2 = findViewById(R.id.imageview2);
		listview1 = findViewById(R.id.listview1);
		anh = findViewById(R.id.anh);
		tinnhan = findViewById(R.id.tinnhan);
		imageview3 = findViewById(R.id.imageview3);
		gui = findViewById(R.id.gui);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		ten = getSharedPreferences("ten", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		pick.setType("*/*");
		pick.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
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
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (m.get((int)_position).get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					dialog.setTitle("Bạn có muốn xoá tin nhắn này không?");
					dialog.setPositiveButton("Vâng", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							db.child(key.get((int)(_position))).removeValue();
							key.remove((int)(_position));
							SketchwareUtil.showMessage(getApplicationContext(), "Đã xoá tin nhắn");
						}
					});
					dialog.create().show();
				}
			}
		});
		
		anh.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				image = 0;
				anh.setVisibility(View.GONE);
			}
		});
		
		tinnhan.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				gui.setVisibility(View.VISIBLE);
				if (tinnhan.getText().toString().equals("")) {
					gui.setVisibility(View.GONE);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(pick, REQ_CD_PICK);
				gui.setVisibility(View.VISIBLE);
			}
		});
		
		gui.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (image == 1) {
					if (image == 0) {
						time = Calendar.getInstance();
						map = new HashMap<>();
						map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
						map.put("username", ten.getString("ten", ""));
						map.put("time", new SimpleDateFormat("HH : mm").format(time.getTime()));
						map.put("messenger", tinnhan.getText().toString());
						db.child(db.push().getKey()).updateChildren(map);
						tinnhan.setText("");
						map.clear();
					}
					else {
						gui.setVisibility(View.GONE);
						chat.child(imageName).putFile(Uri.fromFile(new File(imagePath))).addOnFailureListener(_chat_failure_listener).addOnProgressListener(_chat_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
							@Override
							public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
								return chat.child(imageName).getDownloadUrl();
							}}).addOnCompleteListener(_chat_upload_success_listener);
						SketchwareUtil.showMessage(getApplicationContext(), "Đã gửi một ảnh");
					}
				}
				else {
					if (tinnhan.getText().toString().equals("")) {
						dialog.setTitle("Hãy nhập gì đó");
						dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						dialog.create().show();
					}
					else {
						if (image == 0) {
							time = Calendar.getInstance();
							map = new HashMap<>();
							map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
							map.put("username", ten.getString("ten", ""));
							map.put("time", new SimpleDateFormat("HH : mm").format(time.getTime()));
							map.put("messenger", tinnhan.getText().toString());
							db.child(db.push().getKey()).updateChildren(map);
							tinnhan.setText("");
							map.clear();
						}
						else {
							gui.setVisibility(View.GONE);
							chat.child(imageName).putFile(Uri.fromFile(new File(imagePath))).addOnFailureListener(_chat_failure_listener).addOnProgressListener(_chat_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
								@Override
								public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
									return chat.child(imageName).getDownloadUrl();
								}}).addOnCompleteListener(_chat_upload_success_listener);
							SketchwareUtil.showMessage(getApplicationContext(), "Đã gửi một ảnh");
						}
					}
				}
				if (ten.getString("ten", "").equals("")) {
					dialog.setCancelable(false);
					dialog.setTitle("Vui lòng cập nhật tên của bạn để tham gia chat");
					dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							i.setClass(getApplicationContext(), TaikhoanActivity.class);
							startActivity(i);
						}
					});
					dialog.create().show();
				}
			}
		});
		
		_db_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				db.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						m = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								m.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						key.add(_childKey);
						listview1.setAdapter(new Listview1Adapter(m));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
				db.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						m = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								m.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(m));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		db.addChildEventListener(_db_child_listener);
		
		_chat_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_chat_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_chat_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				time = Calendar.getInstance();
				map = new HashMap<>();
				map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				map.put("username", ten.getString("ten", ""));
				map.put("time", new SimpleDateFormat("HH : mm").format(time.getTime()));
				map.put("messenger", tinnhan.getText().toString());
				map.put("image", _downloadUrl);
				db.child(db.push().getKey()).updateChildren(map);
				tinnhan.setText("");
				map.clear();
				image = 0;
				anh.setVisibility(View.GONE);
			}
		};
		
		_chat_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_chat_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_chat_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
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
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =ChatActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF112378);
		}
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		gui.setVisibility(View.GONE);
		_removeScollBar(listview1);
		image = 0;
		anh.setVisibility(View.GONE);
		linear3.setBackgroundColor(0xFF121B27);
		listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		listview1.setStackFromBottom(true);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_PICK:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				image = 1;
				anh.setVisibility(View.VISIBLE);
				anh.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(_filePath.get((int)(0)), 1024, 1024));
				imagePath = _filePath.get((int)(0));
				imageName = Uri.parse(_filePath.get((int)(0))).getLastPathSegment();
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
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
				_view = _inflater.inflate(R.layout.chat_view, null);
			}
			
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final LinearLayout linearAnh = _view.findViewById(R.id.linearAnh);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final TextView messenger = _view.findViewById(R.id.messenger);
			final TextView time = _view.findViewById(R.id.time);
			final TextView username = _view.findViewById(R.id.username);
			final LinearLayout linear9 = _view.findViewById(R.id.linear9);
			final LinearLayout linear12 = _view.findViewById(R.id.linear12);
			final TextView tinnhankemanh = _view.findViewById(R.id.tinnhankemanh);
			final LinearLayout linear11 = _view.findViewById(R.id.linear11);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView ten = _view.findViewById(R.id.ten);
			final TextView thoigiandanganh = _view.findViewById(R.id.thoigiandanganh);
			
			if (m.get((int)_position).containsKey("image")) {
				if (m.get((int)_position).get("messenger").toString().equals("")) {
					tinnhankemanh.setVisibility(View.GONE);
				}
				Glide.with(getApplicationContext()).load(Uri.parse(m.get((int)_position).get("image").toString())).into(imageview1);
				linearAnh.setVisibility(View.VISIBLE);
				linear7.setVisibility(View.GONE);
				ten.setText(m.get((int)_position).get("username").toString());
				thoigiandanganh.setText(m.get((int)_position).get("time").toString());
				tinnhankemanh.setText(m.get((int)_position).get("messenger").toString());
				if (m.get((int)_position).get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)2, 0xFF1976D2, 0xFFE1F5FE));
					linearAnh.setGravity(Gravity.RIGHT);
					ten.setVisibility(View.GONE);
					linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)0, Color.TRANSPARENT, 0xFF8448B9));
				}
				else {
					linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)0, Color.TRANSPARENT, 0xFF212D3B));
					linearAnh.setGravity(Gravity.LEFT);
					color = SketchwareUtil.getRandom((int)(0), (int)(4));
					if (color == 0) {
						ten.setTextColor(0xFFE91E63);
					}
					if (color == 1) {
						ten.setTextColor(0xFFFFC107);
					}
					if (color == 2) {
						ten.setTextColor(0xFF4CAF50);
					}
					if (color == 3) {
						ten.setTextColor(0xFFF44336);
					}
					if (color == 4) {
						ten.setTextColor(0xFF2196F3);
					}
				}
			}
			else {
				linearAnh.setVisibility(View.GONE);
				username.setText(m.get((int)_position).get("username").toString());
				time.setText(m.get((int)_position).get("time").toString());
				messenger.setText(m.get((int)_position).get("messenger").toString());
				if (m.get((int)_position).get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					linear7.setGravity(Gravity.RIGHT);
					linear6.setVisibility(View.GONE);
					linear3.setGravity(Gravity.CENTER_HORIZONTAL);
					messenger.setTextSize((float)15);
					linear3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)0, Color.TRANSPARENT, 0xFF8448B9));
				}
				else {
					linear3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)0, Color.TRANSPARENT, 0xFF212D3B));
					linear7.setGravity(Gravity.LEFT);
					color = SketchwareUtil.getRandom((int)(0), (int)(4));
					if (color == 0) {
						username.setTextColor(0xFFE91E63);
					}
					if (color == 1) {
						username.setTextColor(0xFFFFC107);
					}
					if (color == 2) {
						username.setTextColor(0xFF4CAF50);
					}
					if (color == 3) {
						username.setTextColor(0xFFF44336);
					}
					if (color == 4) {
						username.setTextColor(0xFF2196F3);
					}
				}
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