package com.abhisht28.notificationapp

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID = "channel_id_example_01"
    private val notificationId = 101
    private val REQUEST_CODE = 100
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    val currentDate = sdf.format(Date())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()
       sendNotification()

//        val NotifyButton = findViewById<Button>(R.id.button)
//        NotifyButton.setOnClickListener {
//            sendNotification()
//        }

        //  val date1 = sdf.parse("2018-08-30")
        val date2 = sdf.parse("2021-09-19")
        val date3 = sdf.format(date2)


        // val dateTime = LocalDateTime.now()

        if (currentDate.equals(date3)) {
            Toast.makeText(this, "date is equal", Toast.LENGTH_LONG).show()
            val Text_Msg = "date is equal"
            sendNotification()
        } else {
            Toast.makeText(this, "date is different", Toast.LENGTH_LONG).show()
        }


    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Title"
            val descriptionText = " Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        //    val tv_current_time = ""
        //   tv_current_time.text = Date().toString()
        //currentDate.text = Date().toString()


    }

    val Text_Msg = ""
    private fun sendNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Example Title - Reminder App")
            .setContentText(Text_Msg)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, builder.build())
        }
    }


//    fun dateTime(view: android.view.View) {
//        // Creating the pending intent to send to the BroadcastReceiver
//        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
//        val intent = Intent(this, MyAlarmReceiver::class.java)
//        pendingIntent = PendingIntent.getBroadcast(
//            this,
//            REQUEST_CODE,
//            intent,
//            PendingIntent.FLAG_UPDATE_CURRENT
//        )
//
//        // Setting the specific time for the alarm manager to trigger the intent, in this example, the alarm is set to go off at 23:30, update the time according to your need
//        val calendar = Calendar.getInstance()
//        calendar.timeInMillis = System.currentTimeMillis()
//        calendar.set(Calendar.HOUR_OF_DAY, 23)
//        calendar.set(Calendar.MINUTE, 29)
//
//        // Starts the alarm manager
//        //       alarmManager.setRepeating(
////            AlarmManager.RTC_WAKEUP,
////            System.currentTimeMillis() + 1000,
////              intent
//        alarmManager.setExact(
//            AlarmManager.RTC_WAKEUP,
//            System.currentTimeMillis() + 1000,
//            pendingIntent
//        )
//
//        //  Toast.makeText(context, "Alarm Triggered", Toast.LENGTH_LONG).show()
//        Toast.makeText(this, "Alarm Set" + Date().toString(), Toast.LENGTH_LONG).show()
//
//
//    }
//
//    class MyAlarmReceiver : BroadcastReceiver() {
//        override fun onReceive(context: Context?, intent: Intent?) {
//            Toast.makeText(context, "Alarm Triggered", Toast.LENGTH_LONG).show()
//        }
//    }

//    Intent notifyIntent = new Intent(this,MyReceiver.class);
//    PendingIntent pendingIntent = PendingIntent.getBroadcast
//    (context, NOTIFICATION_REMINDER_NIGHT, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
//    1000 * 60 * 60 * 24, pendingIntent);
}