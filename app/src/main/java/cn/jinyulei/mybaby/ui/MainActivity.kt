package cn.jinyulei.mybaby.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import cn.jinyulei.mybaby.R
import cn.jinyulei.mybaby.data.BabyService
import cn.jinyulei.mybaby.data.RegisterInfo
import cn.jinyulei.mybaby.databinding.ActivityMainBinding
import cn.jinyulei.mybaby.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var service: BabyService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("MainActivity", service.toString())
        val biding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        biding.viewModel = MainViewModel()
        biding.lifecycleOwner = this
        GlobalScope.launch(Dispatchers.Main) {
            try {
                service.createUser(RegisterInfo("18768143316", "1234", "123456"))
            } catch (e: Throwable) {
                Log.e("MainActivity", e.toString())
            }
        }
    }
}