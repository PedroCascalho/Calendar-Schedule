package com.example.exerciciocalendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exerciciocalendar.Constants.DATE_SEND
import com.example.exerciciocalendar.Constants.SCHEDULE_
import com.example.exerciciocalendar.databinding.ActivityScheduleDetailBinding

class ScheduleDetail : AppCompatActivity() {

    lateinit var bind: ActivityScheduleDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityScheduleDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val data = intent.getStringExtra(DATE_SEND)

        bind.txtDataSchedule.text = "** $data **"

        bind.btnSaveSchedule.setOnClickListener {
            if (data != null) {
                val schedule = Schedule(data, bind.edTxtScheduleText.text.toString())
                Intent().apply {
                    putExtra(SCHEDULE_, schedule)
                    setResult(RESULT_OK, this)
                }
            }
            this.finish()
        }

    }
}