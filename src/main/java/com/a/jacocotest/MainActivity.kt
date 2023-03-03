package com.a.jacocotest

import android.content.Intent
import android.content.pm.PackageManager.GET_META_DATA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.OnClickListener
import com.a.jacocotest.databinding.ActivityMainBinding
import com.a.other.OtherActivity
import com.a.privacy_sample.PrivacyVisitor

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn1.setOnClickListener { valueClick.onOkClick2() }
        binding.btn2.setOnClickListener { valueClick.onBadClick()  }
        binding.btnStartComposeActivity.setOnClickListener {
//            startActivity(Intent(this@MainActivity,ComposeActivity::class.java))
        }
        binding.btnStartOtherActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity,OtherActivity::class.java))
        }

        binding.btnApkMd5.setOnClickListener (listener)
        binding.btnBuildNum.setOnClickListener {
            getMetaBuildNum2()
        }
        binding.btnGenJacoco.setOnClickListener { JacocoHelper.generateCoverageFile(this@MainActivity) }

        Log.d("alvin","oncreate")
    }

    private fun getMetaBuildNum2() {
        val context = this
        val appInfo = context.packageManager.getApplicationInfo(context.packageName, GET_META_DATA);
        val buildNum = appInfo.metaData.getInt("JENKINS_BUILD_NUM");
        binding.tv.text = "buildNum:${buildNum}"


    }

    override fun onResume() {
        super.onResume()
        Log.d("alvin","onResume")
    }


    private fun updateText3(ok: Boolean) {
        val text = if (ok) {
            getOKText()
        } else {
            getBadCode()
        }
        binding.tv.text = text
    }

    private fun getOKText(): String = "OK!!!!"

    private fun getBadCode(): String {
        return "Bad!"
    }

    val listener = OnClickListener {
        ApkUtil.getApkMD5H(this@MainActivity)
        PrivacyVisitor.visitPrivacy(this@MainActivity)
    }
    val valueClick = object :OnEventListener{
        override fun onOkClick2() {
            updateText3(true)
        }

        override fun onBadClick() {
            updateText3(false)
        }

    }

    interface OnEventListener {
        fun onOkClick2()
        fun onBadClick()
    }

}