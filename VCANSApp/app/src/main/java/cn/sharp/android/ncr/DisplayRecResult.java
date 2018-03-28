package cn.sharp.android.ncr;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.rtp.RtpStream;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.Contacts;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import cn.sharp.android.ncr.display.ContactPerson;
import cn.sharp.android.ncr.display.ContactPerson.OnSelectItemType;
import cn.sharp.android.ncr.ocr.OCRItems;
import cn.sharp.android.ncr.ocr.OCRManager;

import com.Vcan.activity.R;
import com.Vcan.activity.MlqdActivity4;
import com.Vcan.activity.MpsdActivity;
import com.Vcan.activity.XiangQingActivity;
import com.Vcan.activity.YPExposition;
import com.vcans.Processor.BaseActivity;
import com.vcans.Processor.MpsbUploadProcessor;
import com.vcans.model.Mpsbinfo;
import com.vcans.model.SendParam;
import com.vcans.tool.ActivityHelper;
import com.vcans.tool.PlProcessor;
					/**
					 * 
					 *  @since 2016 08
					 * @author hjw
					 */
public class DisplayRecResult extends BaseActivity implements OnSelectItemType,OnClickListener, OnItemSelectedListener {
	private final static String TAG = "DisplayRecResult";
	public final static String ACTION = "cn.sharp.android.ncr.DisplayRecResult";
	private final static int DIALOG_SHOW_CONTACT_ITEM_PHONE = 0;
	private final static int DIALOG_SHOW_CONTACT_ITEM_EMAIL = 1;
	private final static int DIALOG_SHOW_CONTACT_ITEM_ADDRESS = 2;
	private final static int DIALOG_SHOW_CONTACT_ITEM_ORG = 3;
	private final static int DIALOG_SHOW_CONTACT_ITEM_URL = 4;
	private final static int DIALOG_NAME_EMPTY = 5;
	private final int REQUEST_PHOTO_FLAG = 1;
	private final static int DIALOG_SAVING_CONTACT_PROGRESS = 6;
	private final static int DIALOG_DISCARD_CONTACT_CONFIRM = 7;
	private final static int DIALOG_CONTACT_NOT_SAVED_WARNING = 8;

	private final static int MENU_SAVE_CONTACT = 0;
	private final static int MENU_DISCARD_CONTACT = 1;
	MpsbUploadProcessor mpsbUploadProcessor=null;
	private ViewGroup phoneViewGroup, emailViewGroup, addressViewGroup,orgViewGroup, urlViewGroup;
	private EditText nameText, noteText, company, linkname ,position ,phone1, phone2, fax ,address , www ,email ,note;
	private Spinner contactGroupSpinner;
	private Button btnSave, btnDiscard;
	private ImageButton btnAddPhone, btnAddEmail, btnAddAddress, btnAddOrg,btnAddUrl,imgBtnOk,btnBack;
	private TextView nameLabel, phoneLabel, emailLabel, addressLabel, orgLabel,urlLabel, noteLabel;
	private View nameViewGroup, noteViewGroup, opViewGroup,mp;
	ListView list;
	
	String[] arr;
	String id,ok;
	String name;
	String addr,xingadd;
	Intent intent;
	String company1,company2 ,strcompany;
	private LayoutInflater inflater;
	private ContactPerson contact;
	private List<ContactGroup> contactGroupList;
	private int contactGroupIndexSelected;
	List<String> pmsb=new ArrayList<String>();
	private class DataHolder {
		public int contactGroupIndexSelected;
		public List<ContactGroup> contactGroupList;
		public ContactPerson contact;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.displayrecresult);
		this.<ImageButton>RegOnClickEvent(R.id.btnBack,"finish");
		
		 company=(EditText)findViewById(R.id.company);
		 linkname =(EditText)findViewById(R.id.contact);
		 position =(EditText)findViewById(R.id.position);
		 phone1=(EditText)findViewById(R.id.phone1);
		 phone2 =(EditText)findViewById(R.id.phone2);
		 fax =(EditText)findViewById(R.id.fax);
		 address=(EditText)findViewById(R.id.address);
		 www =(EditText)findViewById(R.id.www);
		 email=(EditText)findViewById(R.id.email);
		 note=(EditText)findViewById(R.id.note);
		 imgBtnOk=(ImageButton)findViewById(R.id.imgBtnOk);
		 btnBack=(ImageButton)findViewById(R.id.btnBack);
		 btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 opinion();
			}
		 });
		 TextView btnOk=(TextView)findViewById(R.id.btnOk);
		 intent=this.getIntent();
		 id = (String)intent.getSerializableExtra("id"); 
		 SharedPreferences SharedPreferences= getSharedPreferences("biaozhi", Activity.MODE_PRIVATE); 
		 SharedPreferences.Editor editor1 = SharedPreferences.edit(); 
		 editor1.putString("biaozhi", id); 
		 editor1.commit(); 
		 
		 mpsbUploadProcessor=new MpsbUploadProcessor(id);
		 if (id.equals("0")) {
			 btnOk.setText("保存");
		 }else if(id.equals("2")){
			 
				 btnOk.setText("保存");
			
			 
		 }
		 imgBtnOk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				loading();
				
				if (id.equals("0")) {
					Intent intent=new Intent(DisplayRecResult.this,MpsdActivity.class);
					startActivity(intent);
					finish();
				} else if(id.equals("1")) {
					onNext();
					    	        										 			
				}else if(id.equals("2")){					
					 //if (BaseActivity.bConnected==true) {
						//  onNext();
					// }else{
						    Intent intent=new Intent(DisplayRecResult.this,MlqdActivity4.class);						    
						    ActivityHelper.arrayList.add(company.getText()+"");
						    ActivityHelper.arrayList.add(linkname.getText()+"");
						    ActivityHelper.arrayList.add(phone1.getText()+"");
						    ActivityHelper.arrayList.add(address.getText()+"");
							startActivity(intent);
					// }
					
				}
			}

		});
		 new Handler().postDelayed(new Runnable() {
		     public void run() {
		    	 updateContact();
		     }
		     }, 100 );
		inflater = LayoutInflater.from(this);
		nameViewGroup = inflater.inflate(R.layout.contact_info_name, null);
		nameViewGroup.setVisibility(View.GONE);
		contactGroupSpinner = (Spinner) nameViewGroup.findViewById(R.id.contact_group);
		nameLabel = (TextView) nameViewGroup.findViewById(R.id.contact_name_label);
		nameLabel.setText(R.string.contact_label_name);
		nameText = (EditText) nameViewGroup.findViewById(R.id.contact_name);
		
		
		
		//mpsbUploadProcessor.DisplayMpsbInfo();
		
		name = (String)intent.getSerializableExtra("name");
		SharedPreferences mySharedPreferences= getSharedPreferences("test", Activity.MODE_PRIVATE); 
		 //ʵ����SharedPreferences.Editor���󣨵ڶ����� 
		 SharedPreferences.Editor editor = mySharedPreferences.edit(); 
		 //��putString�ķ����������� 
		 editor.putString("name", name); 
		 //�ύ��ǰ���� 
		 editor.commit(); 
		 //ʹ��toast��Ϣ��ʾ����ʾ�ɹ�д������	
		phoneViewGroup = (ViewGroup) inflater.inflate(R.layout.contact_info_common, null);
		phoneViewGroup.setVisibility(View.GONE);
		phoneLabel = (TextView) phoneViewGroup.findViewById(R.id.contact_info_label);
		phoneLabel.setText(R.string.contact_label_phone);
		btnAddPhone = (ImageButton) phoneViewGroup.findViewById(R.id.contact_info_add_item);

		emailViewGroup = (ViewGroup) inflater.inflate(R.layout.contact_info_common, null);
		emailViewGroup.setVisibility(View.GONE);
		emailLabel = (TextView) emailViewGroup.findViewById(R.id.contact_info_label);
		emailLabel.setText(R.string.contact_label_email);
		btnAddEmail = (ImageButton) emailViewGroup.findViewById(R.id.contact_info_add_item);

		addressViewGroup = (ViewGroup) inflater.inflate(R.layout.contact_info_common, null);
		addressViewGroup.setVisibility(View.GONE);
		addressLabel = (TextView) addressViewGroup.findViewById(R.id.contact_info_label);
		addressLabel.setText(R.string.contact_label_address);
		btnAddAddress = (ImageButton) addressViewGroup.findViewById(R.id.contact_info_add_item);

		orgViewGroup = (ViewGroup) inflater.inflate(R.layout.contact_info_common, null);
		orgViewGroup.setVisibility(View.GONE);
		orgLabel = (TextView) orgViewGroup.findViewById(R.id.contact_info_label);
		orgLabel.setText(R.string.contact_label_org);
		btnAddOrg = (ImageButton) orgViewGroup.findViewById(R.id.contact_info_add_item);

		urlViewGroup = (ViewGroup) inflater.inflate(R.layout.contact_info_common, null);
		urlViewGroup.setVisibility(View.GONE);
		urlLabel = (TextView) urlViewGroup.findViewById(R.id.contact_info_label);
		urlLabel.setText(R.string.contact_label_url);
		btnAddUrl = (ImageButton) urlViewGroup.findViewById(R.id.contact_info_add_item);

		noteViewGroup = inflater.inflate(R.layout.rec_result_row_single2, null);
		noteViewGroup.setVisibility(View.GONE);
		noteLabel = (TextView) noteViewGroup.findViewById(R.id.contact_info_item_label);
		noteLabel.setText(R.string.contact_label_note);
		
		noteText = (EditText) noteViewGroup.findViewById(R.id.contact_info_item_value);
		opViewGroup = inflater.inflate(R.layout.contact_info_save_discard, null);
		opViewGroup.setVisibility(View.GONE);

		btnSave = (Button) opViewGroup.findViewById(R.id.btn_save_contact);
		btnDiscard = (Button) opViewGroup.findViewById(R.id.btn_discard);

		btnAddPhone.setOnClickListener(this);
		btnAddEmail.setOnClickListener(this);
		btnAddAddress.setOnClickListener(this);
		btnAddOrg.setOnClickListener(this);
		btnAddUrl.setOnClickListener(this);
		btnSave.setOnClickListener(this);
		btnDiscard.setOnClickListener(this);

		ContactInfoAdapter adapter = new ContactInfoAdapter();
		//setListAdapter(adapter);

		final Object data = getLastNonConfigurationInstance();
		if (data == null) {
			Log.i(TAG, "data==null");
			contactGroupIndexSelected = queryContactGroups();

			OCRItems ocrItems = (OCRItems) getIntent().getSerializableExtra(
					OCRManager.OCR_ITEMS);
			if (ocrItems != null) {
				Log.d(TAG, "get ocritems from intent");
				contact = new ContactPerson(this, ocrItems);
				contact.setOnSelectItemType(this);
				if (contactGroupList.size() > 0) {
					contact.setGroupId(contactGroupList
							.get(contactGroupIndexSelected).id);
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				String dateStr = dateFormat.format(Calendar.getInstance()
						.getTime());
				contact.updateItemValue(ContactPerson.ITEM_NOTE, -1,
						getResources().getString(R.string.contact_default_note)
								+ " " + dateStr);
			} else {
				Log.e(TAG, "ocritem==null, activity exit now");
				setResult(RESULT_CANCELED);
				finish();
			}
		} else {
			Log.i(TAG, "get previously saved data object");
			DataHolder dataSaved = (DataHolder) data;
			contactGroupIndexSelected = dataSaved.contactGroupIndexSelected;
			contact = dataSaved.contact;
			contactGroupList = dataSaved.contactGroupList;
			contact.registerNewContext(this);
		}

		if (contactGroupList.size() > 0) {
			List<CharSequence> groupNameList = new ArrayList<CharSequence>();
			for (int i = 0; i < contactGroupList.size(); i++) {
				groupNameList.add(contactGroupList.get(i).name);
			}
			ArrayAdapter<CharSequence> contactGroupAdapter = new ArrayAdapter<CharSequence>(
					this, android.R.layout.simple_spinner_item, groupNameList);
			contactGroupAdapter
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			contactGroupSpinner.setAdapter(contactGroupAdapter);
			if (contactGroupIndexSelected < contactGroupList.size())
				contactGroupSpinner.setSelection(contactGroupIndexSelected);
			else
				contactGroupSpinner.setSelection(0);
		} else {
			Log.e(TAG, "no contact group found");
		}

		contact.setNameView(nameText);
		contact.setPhoneViewGroup(phoneViewGroup);
		contact.setEmailViewGroup(emailViewGroup);
		contact.setAddressViewGroup(addressViewGroup);
		contact.setOrgViewGroup(orgViewGroup);
		contact.setUrlViewGroup(urlViewGroup);
		contact.setNoteView(noteText);

		contact.bindDataToView();
	}
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MessageId.SAVE_CONTACT_SUCCESS:
				 setResult(RESULT_OK);
			     
				if (id.equals("0")) {
					Intent intent=new Intent(DisplayRecResult.this,MpsdActivity.class);
					startActivity(intent);
					finish();
				} else if(id.equals("1")) {
					 new Handler().postDelayed(new Runnable() {
					     public void run() {
							finish();
					     }
					     }, 9000 );
					
				}
				break;
			}
			super.handleMessage(msg);
		}
	};
//
//	@Override
//	public Object onRetainNonConfigurationInstance() {
//		Log.d(TAG, "onRetainNonConfigurationInstance");
//		updateContact();
//		DataHolder dataHolder = new DataHolder();
//		dataHolder.contactGroupIndexSelected = contactGroupIndexSelected;
//		dataHolder.contact = contact;
//		dataHolder.contactGroupList = contactGroupList;
//		contact.removeAllContextObject();
//		return dataHolder;
//	}

	private int queryContactGroups() {
		String[] projection = new String[] { Contacts.Groups._ID,
				Contacts.Groups.NAME, Contacts.Groups.SYSTEM_ID };
		Cursor cursor = getContentResolver().query(Contacts.Groups.CONTENT_URI,
				projection, null, null, null);
		contactGroupList = new ArrayList<ContactGroup>();
		int defaultPos = 0;
		if (cursor.moveToFirst()) {
			do {
				ContactGroup group = new ContactGroup();
				group.id = cursor.getLong(0);
				group.name = cursor.getString(1);
				group.systemId = cursor.getString(2);
				if (group.systemId != null)
					defaultPos = contactGroupList.size();
				contactGroupList.add(group);
			} while (cursor.moveToNext());
		}
		return defaultPos;
	}

	private class ContactInfoAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 9;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return super.isEmpty();
		}

		@Override
		public boolean areAllItemsEnabled() {
			return false;
		}

		@Override
		public boolean isEnabled(int position) {
			return true;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			switch (position) {
			case 0:
				return mp;
			case 1:
				return nameViewGroup;
			case 2:
				return phoneViewGroup;
			case 3:
				return emailViewGroup;
			case 4:
				return addressViewGroup;
			case 5:
				return orgViewGroup;
			case 6:
				return urlViewGroup;
			case 7:
				return noteViewGroup;
			case 8:
				return opViewGroup;
			
			}
			return convertView;
		}

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_SHOW_CONTACT_ITEM_PHONE:
		case DIALOG_SHOW_CONTACT_ITEM_EMAIL:
		case DIALOG_SHOW_CONTACT_ITEM_ADDRESS:
		case DIALOG_SHOW_CONTACT_ITEM_ORG:
		case DIALOG_SHOW_CONTACT_ITEM_URL:
			Log.v(TAG, "contact info type str[0]"
					+ currentContactInfoTypeStrs[0]);
			DialogClickListener clickListener = new DialogClickListener(id,
					currentContactInfoTypes, currentItemName, currentItemIndex);
			return new AlertDialog.Builder(this).setItems(
					currentContactInfoTypeStrs, clickListener).create();
		case DIALOG_SAVING_CONTACT_PROGRESS:
			ProgressDialog savingContactProgress = ProgressDialog.show(
					DisplayRecResult.this, "", getResources().getString(
							R.string.saving_contact_progress), true);
			savingContactProgress.setCancelable(false);
			return savingContactProgress;
		case DIALOG_DISCARD_CONTACT_CONFIRM:
			return new AlertDialog.Builder(this).setTitle(R.string.attention)
					.setMessage(R.string.discard_contact_confirm).setIcon(
							android.R.drawable.ic_dialog_alert)
					.setPositiveButton(R.string.yes,
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									//Log.d(TAG, "contact discarded by user");
									//setResult(RESULT_CANCELED);
									//finish();
								}
							}).setNegativeButton(R.string.no, null).create();
		case DIALOG_CONTACT_NOT_SAVED_WARNING:
			return new AlertDialog.Builder(this).setTitle(R.string.attention)
					.setMessage(R.string.contact_not_saved_warning).setIcon(
							android.R.drawable.ic_dialog_alert)
//					.setPositiveButton(R.string.yes,
//							new DialogInterface.OnClickListener() {
//
//								@Override
//								public void onClick(DialogInterface dialog,
//										int which) {
//									loading();
//									 new Handler().postDelayed(new Runnable() {
//									     public void run() {
//									    	    onNext();
//									     }
//									     }, 50 );
//								}
//							})
					.setNeutralButton(R.string.no,
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									Log.d(TAG, "contact discarded by user");
									setResult(RESULT_CANCELED);
									opinion();

								}
							})
					.setNegativeButton(R.string.cancel, null)
					.create();
		}
		return super.onCreateDialog(id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem itemSave = menu.add(0, MENU_SAVE_CONTACT, 0,
				R.string.save_contact);
		MenuItem itemDiscard = menu.add(0, MENU_DISCARD_CONTACT, 0,
				R.string.discard);
//		itemSave.setIcon(R.drawable.contact_save);
//		itemDiscard.setIcon(R.drawable.contact_discard);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_SAVE_CONTACT:
			saveContact();
			return true;
		case MENU_DISCARD_CONTACT:
			showDialog(DIALOG_DISCARD_CONTACT_CONFIRM);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private class DialogClickListener implements
			DialogInterface.OnClickListener {
		int dialogId;
		int[] contactInfoTypes;
		int itemName;
		int itemIndex;

		public DialogClickListener(int dialogId, int[] contactInfoTypes,
				int itemName, int itemIndex) {
			this.dialogId = dialogId;
			this.contactInfoTypes = contactInfoTypes;
			this.itemName = itemName;
			this.itemIndex = itemIndex;
		}

		@Override
		public void onClick(DialogInterface dialog, int which) {
			int newType = contactInfoTypes[which];
			if (contact.updateItemType(itemName, itemIndex, newType)) {
				/**
				 * update the label of button
				 */
				ViewGroup viewGroup = null;
				switch (dialogId) {
				case DIALOG_SHOW_CONTACT_ITEM_PHONE:
					if (itemIndex < phoneViewGroup.getChildCount()) {
						// skip the label row
						viewGroup = (ViewGroup) phoneViewGroup
								.getChildAt(itemIndex + 1);
					} else {
						Log.e(TAG, "invalid item index:" + itemIndex);
					}
					break;
				case DIALOG_SHOW_CONTACT_ITEM_EMAIL:
					if (itemIndex < emailViewGroup.getChildCount()) {
						viewGroup = (ViewGroup) emailViewGroup
								.getChildAt(itemIndex + 1);
					}
					break;
				case DIALOG_SHOW_CONTACT_ITEM_ADDRESS:
					if (itemIndex < addressViewGroup.getChildCount()) {
						viewGroup = (ViewGroup) addressViewGroup
								.getChildAt(itemIndex + 1);
					}
					break;
				case DIALOG_SHOW_CONTACT_ITEM_ORG:
					if (itemIndex < orgViewGroup.getChildCount()) {
						viewGroup = (ViewGroup) orgViewGroup
								.getChildAt(itemIndex + 1);
					}
					break;
				case DIALOG_SHOW_CONTACT_ITEM_URL:
					if (itemIndex < urlViewGroup.getChildCount()) {
						viewGroup = (ViewGroup) urlViewGroup
								.getChildAt(itemIndex + 1);
					}
					break;
				}
				if (viewGroup != null && viewGroup.getChildCount() > 0) {
					Button button = (Button) viewGroup.getChildAt(0);
					if (button != null) {
						button.setText(contact.getTypeName(newType));
						Log.d(TAG, "update label of type button with newType:"
								+ newType + ", itemName:" + itemName
								+ ", itemIndex:" + itemIndex);
					} else {
						Log.e(TAG, "button==null, update button label failed");
					}
				} else {
					Log.e(TAG,"viewGroup==null or viewGroup's child count<0, update button label failed, dialogId:"+ dialogId);
				}
			}
		}
	}

	

	public class ContactGroup {
		public long id;
		public String systemId;
		public String name;
	}

	private String[] currentContactInfoTypeStrs;
	private int[] currentContactInfoTypes;
	private int currentItemName, currentItemIndex;

	@Override
	public void displayItems(ContactPerson contact, int itemName, int index,
			int[] types, String[] typeStrs) {
		currentItemName = itemName;
		currentItemIndex = index;
		currentContactInfoTypes = types;
		currentContactInfoTypeStrs = typeStrs;

		int id = -1;

		switch (itemName) {
		case ContactPerson.ITEM_PHONE:
			// showDialog(DIALOG_SHOW_CONTACT_ITEM_PHONE);
			id = DIALOG_SHOW_CONTACT_ITEM_PHONE;
			break;
		case ContactPerson.ITEM_EMAIL:
			// showDialog(DIALOG_SHOW_CONTACT_ITEM_EMAIL);
			id = DIALOG_SHOW_CONTACT_ITEM_EMAIL;
			break;
		case ContactPerson.ITEM_ADDRESS:
			// showDialog(DIALOG_SHOW_CONTACT_ITEM_ADDRESS);
			id = DIALOG_SHOW_CONTACT_ITEM_ADDRESS;
			break;
		case ContactPerson.ITEM_ORG:
			// showDialog(DIALOG_SHOW_CONTACT_ITEM_ORG);
			id = DIALOG_SHOW_CONTACT_ITEM_ORG;
			break;
		case ContactPerson.ITEM_URL:
			// showDialog(DIALOG_SHOW_CONTACT_ITEM_URL);
			id = DIALOG_SHOW_CONTACT_ITEM_URL;
			break;
		default:
			Log.e(TAG, "itemName with no multi types:" + itemName);
		}
		if (id != -1) {
			// DialogClickListener clickListener = new DialogClickListener(id,
			// types, currentItemName, currentItemIndex);
			// AlertDialog alertDialog = new AlertDialog.Builder(this).setItems(
			// typeStrs, clickListener).create();
			// alertDialog.show();
			Log.d(TAG, "currentContactInfoTypeStrs :"
					+ currentContactInfoTypeStrs.length);
			showDialog(id);
		}
	}

	@Override
	public void onClick(View v) {
		if (v == btnSave) {
			Log.d(TAG, "Save button clicked");
			 saveContact();				
			  
		} else if (v == btnDiscard) {
			Log.d(TAG, "Discard button clicked");
			showDialog(DIALOG_DISCARD_CONTACT_CONFIRM);
		} else if (v == btnAddPhone) {
			Log.d(TAG, "insert phone-add row");
			contact.add(ContactPerson.ITEM_PHONE, null);

		} else if (v == btnAddEmail) {
			contact.add(ContactPerson.ITEM_EMAIL, null);
		} else if (v == btnAddAddress) {
			contact.add(ContactPerson.ITEM_ADDRESS, null);
		} else if (v == btnAddOrg) {
			contact.add(ContactPerson.ITEM_ORG, null);
		} else if (v == btnAddUrl) {
			contact.add(ContactPerson.ITEM_URL, null);
		}
	}

	private void saveContact() {
		
		updateContact();
		contact.startSave(false, handler);
		//showDialog(DIALOG_SAVING_CONTACT_PROGRESS);
	}
	
	private void updateContact() {
		 String CustomerName = nameText.getText().toString().trim();
		 linkname.setText(CustomerName);
		 ActivityHelper.mp.strlinkname=CustomerName;
		 SharedPreferences sharedPreferences = getSharedPreferences("test", Activity.MODE_PRIVATE); 
		 addr = sharedPreferences.getString("name", ""); 
		 ActivityHelper.mp.strImgPath=addr;	 
		 pmsb.add(CustomerName);	
		System.out.println("����"+CustomerName);
		//Toast.makeText(DisplayRecResult.this, "����"+name, Toast.LENGTH_LONG).show();                //
		contact.updateItemValue(ContactPerson.ITEM_NAME, -1, CustomerName);
		for (int i = 1; i < phoneViewGroup.getChildCount(); i++) {
			ViewGroup viewGroup = (ViewGroup) phoneViewGroup.getChildAt(i);
			EditText text = (EditText) viewGroup.getChildAt(2);
			if (text != null) {
				String Telephone = text.getText().toString().trim();
				if (i==1) {
					fax.setText(Telephone);
					ActivityHelper.mp.strfax=Telephone;
					System.out.println("�绰fax"+Telephone);
				} else if(i==2){
					phone2.setText(Telephone);
					ActivityHelper.mp.strphone1=Telephone;
					System.out.println("�绰phone2"+Telephone);
				}else{
					phone1.setText(Telephone);
					ActivityHelper.mp.strphone2=Telephone;
					System.out.println("�绰phone1"+Telephone);
				}
				
				//Toast.makeText(DisplayRecResult.this,  "�绰"+value, Toast.LENGTH_LONG).show();  
				pmsb.add(Telephone);//
				if (Telephone.length() > 0) {
					contact.updateItemValue(ContactPerson.ITEM_PHONE, i - 1,
							Telephone);
					Log.d(TAG, "update phone item " + i);
				} else {
					Log.i(TAG, "phone item " + i + " is empty, ignored");
				}
			} else {
				Log.e(TAG, "edittext is null when getting phones");
			}
		}

		for (int i = 1; i < emailViewGroup.getChildCount(); i++) {
			ViewGroup viewGroup = (ViewGroup) emailViewGroup.getChildAt(i);
			EditText text = (EditText) viewGroup.getChildAt(2);		
			if (text != null) {
				String Fax = text.getText().toString().trim();
				email.setText(Fax);
				ActivityHelper.mp.stremail=Fax;
				System.out.println("email"+Fax);
				//Toast.makeText(DisplayRecResult.this, "email"+value, Toast.LENGTH_LONG).show();  
				pmsb.add(Fax);//
				if (Fax.length() > 0) {
					contact.updateItemValue(ContactPerson.ITEM_EMAIL, i - 1,
							Fax);
					Log.d(TAG, "update email item " + i);
				} else {
					Log.i(TAG, "email item " + i + " is empty, ignored");
				}
			} else {
				Log.e(TAG, "edittext is null when getting emails");
			}
		}

		for (int i = 1; i < addressViewGroup.getChildCount(); i++) {
			ViewGroup viewGroup = (ViewGroup) addressViewGroup.getChildAt(i);
			EditText text = (EditText) viewGroup.getChildAt(2);
			
			if (text != null) {
				String  position = text.getText().toString().trim();
				address.setText(position);
				ActivityHelper.mp.straddress= position;
				System.out.println("��ַ"+position);
				//Toast.makeText(DisplayRecResult.this, "��ַ"+value, Toast.LENGTH_LONG).show();
				pmsb.add( position);//       //
				if ( position.length() > 0) {
					contact.updateItemValue(ContactPerson.ITEM_ADDRESS, i - 1,
							position);
					Log.d(TAG, "update address item " + i);
				} else {
					Log.i(TAG, "address item " + i + " is empty, ignored");
				}
			} else {
				Log.e(TAG, "edittext is null when getting address");
			}
		}

		for (int i = 1; i < orgViewGroup.getChildCount(); i++) {
			ViewGroup viewGroup = (ViewGroup) orgViewGroup.getChildAt(i);
			EditText text1 = (EditText) viewGroup.getChildAt(2);
			EditText text2 = (EditText) viewGroup.getChildAt(3);
			if (text1 != null && text2 != null) {
				 company1 = text1.getText().toString().trim();
				 company2 = text2.getText().toString().trim();
				company.setText(company1);
				position.setText(company2);
				//ActivityHelper.mp.strFax=company;
				ActivityHelper.mp.strcompany=company1;
				ActivityHelper.mp.strposition=company2;
				System.out.println("��ְ֯λ"+company1+company2+"ְλ");
				//Toast.makeText(DisplayRecResult.this, "��ְ֯λ"+value1+"___"+value2, Toast.LENGTH_LONG).show(); 
				//pmsb.add(company);////// 
				pmsb.add(company1);
				if (company2.length() > 0 || company1.length() > 0) {
					contact.updateItemValue(ContactPerson.ITEM_ORG, i - 1,
							company2, company1);
					Log.d(TAG, "update org item " + i);
				} else {
					Log.i(TAG, "org item " + (i - 1) + " is empty, ignored");
				}
			} else {
				Log.e(TAG, "edittext is null when getting org");
			}
		}

		for (int i = 1; i < urlViewGroup.getChildCount(); i++) {
			ViewGroup viewGroup = (ViewGroup) urlViewGroup.getChildAt(i);
			EditText text = (EditText) viewGroup.getChildAt(2);
			
			if (text != null) {
				String url = text.getText().toString().trim();
				www.setText(url);
				ActivityHelper.mp.strwww=url;
				System.out.println("��վ"+url);
				//Toast.makeText(DisplayRecResult.this, "��վ"+value, Toast.LENGTH_LONG).show(); 
				pmsb.add(url);////
				if (url.length() > 0) {
					contact.updateItemValue(ContactPerson.ITEM_URL, i - 1,
							url);
					Log.d(TAG, "update url item " + (i - 1));
				} else {
					Log.i(TAG, "url item " + (i - 1) + " is empty, ignored");
				}
			} else {
				Log.e(TAG, "edittext is null when getting url");
			}
		}

	    String remarks = noteText.getText().toString();
	    note.setText(remarks);
		ActivityHelper.mp.strnote=remarks;	
		
		
		 PlProcessor.SetParent(this);
		 ActivityHelper.hidesofeKeyboard(this);
		
		 System.out.println("��ע"+remarks);  
		//Toast.makeText(DisplayRecResult.this, "��ע"+note, Toast.LENGTH_LONG).show();
		pmsb.add(remarks);//
		
		if (remarks.length() >= 0) {
			Log.d(TAG, "update note:" + remarks);
			contact.updateItemValue(ContactPerson.ITEM_NOTE, -1, remarks);
		} else {
			Log.i(TAG, "note is empty, ignored");
			// do *NOT* remove note whether it is empty
		}		
		 
	} 

	//�ϴ�
	 public void onUpload()
	 {  
		 if(pmsb.size()!=0){
			SendParam sendParam = new SendParam();
			sendParam.parent =this;
			//sendParam.bSendEndNotify=true;
			sendParam.processor = mpsbUploadProcessor;
			getDataTrunsfer().beginUploadFile(sendParam);
		 }
		 else
		 {
			 ActivityHelper.showDialog(this,"����",getString(R.string.noData));
		 }
	 }
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			showDialog(DIALOG_CONTACT_NOT_SAVED_WARNING);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		if (arg2 < contactGroupList.size()) {
			Log.d(TAG, "update contact group id to "
					+ contactGroupList.get(arg2).id);
			contact.setGroupId(contactGroupList.get(arg2).id);
			contactGroupIndexSelected = arg2;
		} else {
			Log.e(TAG, "invalid group id");
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

	@Override
	    public void processMessage(int msgId, String msg) {
		// TODO Auto-generated method stub
		
	}

	   public void onNext()
	 {     
		 onUpload();
	 }
	 
	 
	    public void opinion()
	 {
	    	if (id.equals("0")) {
				 Intent intent=new Intent(DisplayRecResult.this,MpsdActivity.class);						
					startActivity(intent);
					finish();
			} else if(id.equals("1")) {
				Intent intent=new Intent(DisplayRecResult.this,YPExposition.class);
				startActivity(intent);
				finish();
			}else if(id.equals("1")) {
				Intent intent=new Intent(DisplayRecResult.this,MlqdActivity4.class);
				startActivity(intent);
				finish();
			}
	 }
	    
	    
	 public void loading()
	 {
		strcompany=company.getText().toString();
		              String strcompany1=strcompany.replaceAll("~",".");
		String strlinkname=linkname.getText().toString();
		              String strlinkname1=strlinkname.replaceAll("~",".");
		String strposition =position.getText().toString();
		              String strposition1=strposition.replaceAll("~",".");
		String strphone1=phone1.getText().toString();
		              String strphone11=strphone1.replaceAll("~",".");
		String strphone2=phone2.getText().toString();
		              String strphone21=strphone2.replaceAll("~",".");
		String strfax =fax.getText().toString();
		              String strfax1=strfax.replaceAll("~",".");
		String straddress=address.getText().toString();
		              String straddress1=straddress.replaceAll("~",".");
		String strwww=www.getText().toString();
		              String strwww1=strwww.replaceAll("~",".");
		String stremail =email.getText().toString();
		              String stremail1=stremail.replaceAll("~",".");
		String strnote=note.getText().toString();
		ActivityHelper.mp.strcompany=strcompany1;	
		ActivityHelper.mp.strlinkname=strlinkname1;	
		ActivityHelper.mp.strposition=strposition1;	
		ActivityHelper.mp.strphone1=strphone11;	
		ActivityHelper.mp.strphone2=strphone21;	
		ActivityHelper.mp.strfax=strfax1;	
		ActivityHelper.mp.straddress=straddress1;	
		ActivityHelper.mp.strwww=strwww1;	
		ActivityHelper.mp.stremail=stremail1;	
		ActivityHelper.mp.strnote=strnote;	
		 //����
		 mpsbUploadProcessor.SaveToupeiInfo();
		 //������
		 mpsbUploadProcessor.DisplayMpsbInfo();
		
	 }
	 public void onAction(View v) {
		 Intent intent = null;
	 switch (v.getId()) {
	case R.id.company:
		String Company=company.getText().toString();
		intent=new Intent(DisplayRecResult.this,XiangQingActivity.class);
		intent.putExtra("data", Company);
		intent.putExtra("name", "company");
		//startActivity(intent);
		break;
	case R.id.contact:
		String Linkname=linkname.getText().toString();
		 intent=new Intent(DisplayRecResult.this,XiangQingActivity.class);
		intent.putExtra("data", Linkname);
		intent.putExtra("name", "linkname");
		//startActivity(intent);
		break;
	case R.id.position:
		String Position=position.getText().toString();
		intent=new Intent(DisplayRecResult.this,XiangQingActivity.class);
		intent.putExtra("data", Position);
		intent.putExtra("name", "position");
		//startActivity(intent);
			break;
	case R.id.phone1:
		String Phone1=phone1.getText().toString();
		intent=new Intent(DisplayRecResult.this,XiangQingActivity.class);
		intent.putExtra("data", Phone1);
		intent.putExtra("name", "Phone1");
		//startActivity(intent);
		break;
	case R.id.phone2:
		String Phone2=phone2.getText().toString();
	    intent=new Intent(DisplayRecResult.this,XiangQingActivity.class);
		intent.putExtra("data", Phone2);
		intent.putExtra("name", "phone2");
		//startActivity(intent);
		break;
	case R.id.fax:
		String Fax=fax.getText().toString();
	    intent=new Intent(DisplayRecResult.this,XiangQingActivity.class);
		intent.putExtra("data", Fax);
		intent.putExtra("name", "fax");
		//startActivity(intent);
		break;
	case R.id.address:
		String Address=address.getText().toString();
	    intent=new Intent(DisplayRecResult.this,XiangQingActivity.class);
		intent.putExtra("data", Address);
		intent.putExtra("name", "address");
		//startActivity(intent);
		break;
	case R.id.www:
		String Www=www.getText().toString();
		intent=new Intent(DisplayRecResult.this,XiangQingActivity.class);
		intent.putExtra("data", Www);
		intent.putExtra("name", "www");
		//startActivity(intent);
		break;
	case R.id.email:
		String Email=email.getText().toString();
	    intent=new Intent(DisplayRecResult.this,XiangQingActivity.class);
		intent.putExtra("data", Email);
		intent.putExtra("name", "email");
		//startActivity(intent);
		break;
	case R.id.note:
		String Note=note.getText().toString();
	    intent=new Intent(DisplayRecResult.this,XiangQingActivity.class);
		intent.putExtra("data", Note);
		intent.putExtra("name", "note");
		//startActivity(intent);
		break;
	}
	 startActivity(intent);
	 }
	 
	@Override
	protected void onRestart() {
//		         SharedPreferences sharedPreferences =getSharedPreferences("addres",Activity.MODE_PRIVATE); 
//				 String data = sharedPreferences.getString("data", ""); 
//				 String name = sharedPreferences.getString("name", ""); 
		if (XiangQingActivity.data1==null&&XiangQingActivity.name1==null) {
		//	ActivityHelper.ToastShow(DisplayRecResult.this, "..");
		}else {
		//	ActivityHelper.ToastShow(DisplayRecResult.this, ".");
			 String data=XiangQingActivity.data1;
	         String name=XiangQingActivity.name1;
			 if (name.equals("company")) {
				 company.setText(data);
			}else if(name.equals("linkname")){
				linkname.setText(data);
			}else if(name.equals("position")){
				position.setText(data);
			}else if(name.equals("phone1")){
				phone1.setText(data);
			}else if(name.equals("phone2")){
				phone2.setText(data);
			}else if(name.equals("fax")){
				fax.setText(data);
			}else if(name.equals("address")){
				address.setText(data);
			}else if(name.equals("www")){
				www.setText(data);
			}else if(name.equals("email")){
				email.setText(data);
			}else if(name.equals("note")){
				note.setText(data);
			}
			 XiangQingActivity.data1=null;
			 XiangQingActivity.name1=null;
		}
		        
				 
		super.onRestart();
	}
	
	
}
