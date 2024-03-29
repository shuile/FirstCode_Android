package cn.shui.notificationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendNotice = findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0,
                        intent, 0);

                NotificationManager manager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title")
//                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                R.mipmap.ic_launcher))
                        .setContentIntent(pi)
//                        .setAutoCancel(true)
//                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/01_Piano.ogg")))
//                        .setVibrate(new long[]{0, 1000, 1000, 1000})
//                        .setLights(Color.GREEN, 1000, 1000)
//                        .setDefaults(NotificationCompat.DEFAULT_ALL)
//                        .setContentText("Learn how to build notifications, send and sync data, and " +
//                                "use voice actions. Get the official Android IDE and developer " +
//                                "tools to build apps for Android.")
//                        .setStyle(new NotificationCompat.BigTextStyle().bigText("Learn how to build " +
//                                "notifications, send and sync data, and use voice actions. Get " +
//                                "the official Android IDE and developer tools to build apps " +
//                                "for Android."))
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory
                                .decodeResource(getResources(), R.drawable.big_image)))
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();
                manager.notify(3, notification);
                break;
            default:
                break;
        }
    }
}
