package com.example.exerciciocalendar

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult

import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.example.exerciciocalendar.Constants.DATE_SEND
import com.example.exerciciocalendar.Constants.SCHEDULE_
import com.example.exerciciocalendar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val data = "$dayOfMonth/$month/$year"
            val intent = Intent(this, ScheduleDetail::class.java)
            intent.putExtra(DATE_SEND, data)
            register.launch(intent)
        }
    }


    private val register = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { resul: ActivityResult ->
        if (resul.resultCode == Activity.RESULT_OK){

            val schedule = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                resul.data?.getParcelableExtra(SCHEDULE_, Schedule::class.java)
            } else {
                resul.data?.getParcelableExtra<Schedule>(SCHEDULE_)
            }

            bind.imgCalendarIcon.visibility = View.VISIBLE
            bind.txtScheduleText.visibility = View.VISIBLE
            bind.txtScheduleText. text = "${schedule?.data} \n ${schedule?.description}"

        }

    }
}