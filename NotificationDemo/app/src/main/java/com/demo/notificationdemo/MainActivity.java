package com.demo.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button simpleNotificationButton, bigStyleNotificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleNotificationButton = (Button) findViewById(R.id.simpleNotificationButton);
        bigStyleNotificationButton = (Button) findViewById(R.id.bigStyleNotificationButton);

        simpleNotificationButton.setOnClickListener(this);
        bigStyleNotificationButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simpleNotificationButton:
                displaySimpleNotification();
                break;
            case R.id.bigStyleNotificationButton:
                displayBigStyleNotification();
                break;
        }
    }

    private void displaySimpleNotification() {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this);

        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("My notification");
        mBuilder.setContentText("Hello World!");

        NotificationManager manager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(1, mBuilder.build());
    }

    private void displayBigStyleNotification() {

        String message = "This is the example of big style notification.Big style notification is supported in Android 4.1 and above.";

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Notification!");
        builder.setContentText("Ping");
        builder.setDefaults(Notification.DEFAULT_ALL); // requires VIBRATE permission
        builder.setStyle(new NotificationCompat.BigTextStyle()
                .bigText(message));
        builder.addAction(android.R.drawable.ic_menu_add,
                "Add", null);
        builder.addAction(android.R.drawable.ic_menu_close_clear_cancel,
                "Close", null);
        NotificationManager manager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(2, builder.build());
    }
}

