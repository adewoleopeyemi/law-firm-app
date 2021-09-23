package com.example.successsynergyapp.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.successsynergyapp.R;
import com.example.successsynergyapp.dashboard.form.ViewFormActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFireBaseMessagingService extends FirebaseMessagingService {
    String title,message, userType, id, bulletPoint;
    int requestID = 100;
    Intent notificationIntent;
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        title=remoteMessage.getData().get("Title");
        message=remoteMessage.getData().get("Message");
        id = remoteMessage.getData().get("Id");
        userType = remoteMessage.getData().get("UserType");
        bulletPoint = remoteMessage.getData().get("BulletPoint");

        Log.d("Message", "onMessageReceived: "+id + " UserType "+userType);
        if (userType.equals("ServiceProvider")){
            notificationIntent = new Intent(getApplicationContext(), ViewFormActivity.class);
            notificationIntent.putExtra("for", userType);
            notificationIntent.putExtra("id", id);
            notificationIntent.putExtra("bulletPoint", bulletPoint);
        }


        //**add this line**
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        //**edit this line to put requestID as requestCode**
        PendingIntent contentIntent = PendingIntent.getActivity(this, requestID,notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.ic_outline_person_outline)
                        .setContentIntent(contentIntent)
                        .setContentTitle(title)
                        .setContentText(message);

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelId = "SuccessSynergy";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "My Lawyer App",
                    NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }
        manager.notify(0, builder.build());
    }

}