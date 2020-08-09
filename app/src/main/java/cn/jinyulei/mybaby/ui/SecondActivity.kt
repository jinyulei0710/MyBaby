package cn.jinyulei.mybaby.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cn.jinyulei.mybaby.R
import cn.jinyulei.mybaby.data.BabyService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var service: BabyService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.v("SecondActivity", service.toString())
    }
}