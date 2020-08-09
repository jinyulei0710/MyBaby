package cn.jinyulei.mybaby.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import cn.jinyulei.mybaby.R
import cn.jinyulei.mybaby.data.BabyService
import cn.jinyulei.mybaby.data.RegisterInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.103:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(BabyService::class.java)

        GlobalScope.launch(Dispatchers.Main) {
            try {
                service.createUser(RegisterInfo("18768143316", "1234", "123456"))
            } catch (e: Throwable) {
                Log.e("MainActivity", e.toString())
            }
        }
    }
}