package com.example.taskreminder;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.widget.Toast;

public class NotificationService extends Service {

	private NotificationManager mManager;
	RemindersDbAdapter db;
	String n;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		// Getting Notification Service
		
		
		mManager = (NotificationManager) this.getApplicationContext()
				.getSystemService(
						this.getApplicationContext().NOTIFICATION_SERVICE);
		
		/*SharedPreferences sh = getSharedPreferences("Task Data", Context.MODE_PRIVATE);
        long rowid = sh.getLong("si", 0);
        */
		
		long row = intent.getLongExtra("rowid", 88);
		String rid = Long.toString(row);
       db = new RemindersDbAdapter(NotificationService.this);
       db.open();
       Cursor c = db.fetchReminder(row);
       if(c.moveToFirst())
   	{
			n = c.getString(1);
   	}
   	
		
		Intent intent1 = new Intent(this.getApplicationContext(), NotifyViewActivity.class);
		
		intent1.putExtra("rowid", row);
		Notification notification = new Notification(R.drawable.and_icon1,
				"", 0);

		intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP
				| Intent.FLAG_ACTIVITY_CLEAR_TOP);

		PendingIntent pendingNotificationIntent = PendingIntent.getActivity(
				this.getApplicationContext(), Integer.parseInt(rid), intent1,
				PendingIntent.FLAG_ONE_SHOT);
		
		//Toast.makeText(getApplicationContext(), Integer.toString(v), 1).show();

		notification.flags |= Notification.FLAG_AUTO_CANCEL;
        
		notification.setLatestEventInfo(this.getApplicationContext(),
				"REMINDER", n,
				pendingNotificationIntent);
		
		notification.vibrate = new long[] { 100, 250, 100, 500};
    	//notif.sound = Uri.parse("E:/Music/aaa");//Uri.parse("android.resource://"+getPackageName()+"/"+R.);
    	
    	Uri alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    	notification.sound=alarm;
		mManager.notify(0, notification);
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

}