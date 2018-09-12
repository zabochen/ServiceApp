package ua.ck.zabochen.serviceapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ua.ck.zabochen.serviceapp.R
import ua.ck.zabochen.serviceapp.service.NotificationService

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val buttonStartService: Button by lazy { findViewById<Button>(R.id.activityMain_button_startService) }
    private val buttonStopService: Button by lazy { findViewById<Button>(R.id.activityMain_button_stopService) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUi()
    }

    private fun setUi() {
        // Layout
        setContentView(R.layout.activity_main)

        // Set listeners
        buttonStartService.setOnClickListener(this)
        buttonStopService.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            buttonStartService.id -> {
                startService(Intent(this, NotificationService::class.java))
            }
            buttonStopService.id -> {
                stopService(Intent(this, NotificationService::class.java))
            }
        }
    }
}
