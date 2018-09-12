package ua.ck.zabochen.serviceapp.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import ua.ck.zabochen.serviceapp.R
import ua.ck.zabochen.serviceapp.utils.NOTIFICATION_CHANNEL_ID
import ua.ck.zabochen.serviceapp.utils.log
import ua.ck.zabochen.serviceapp.utils.showToast

class NotificationService : Service() {

    companion object {
        const val TAG: String = "NotificationService"
    }

    override fun onCreate() {
        log(TAG, "Service -> onCreate()")
        showToast("Service -> onCreate()")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        log(TAG, "Service -> onStartCommand(), startId: $startId")
        showToast("Service -> onStartCommand(), startId: $startId")
        createNotification(applicationContext)
        return START_STICKY
    }

    override fun onDestroy() {
        log(TAG, "Service -> onDestroy()")
        showToast("Service -> onDestroy()")
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun createNotification(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Channel name"
            val description = "Channel description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance)
            channel.description = description
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager!!.createNotificationChannel(channel)
        }

        val notificationBuilder: NotificationCompat.Builder = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher_round))
                .setContentTitle("Notification")
                .setContentText("Information")
                .setAutoCancel(true)

        val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(80, notificationBuilder.build())
    }
}