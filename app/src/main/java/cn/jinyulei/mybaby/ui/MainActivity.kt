package cn.jinyulei.mybaby.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import cn.jinyulei.mybaby.R
import cn.jinyulei.mybaby.data.BabyService
import cn.jinyulei.mybaby.data.RegisterInfo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var service: BabyService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("MainActivity", service.toString())
        tv_go.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        GlobalScope.launch(Dispatchers.Main) {
            try {
                service.createUser(RegisterInfo("18768143316", "1234", "123456"))
            } catch (e: Throwable) {
                Log.e("MainActivity", e.toString())
            }
        }
    }
}