package com.astu.vk.services

import android.content.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder

import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    val receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val bundle = intent?.extras
            if (bundle != null) {
                val result = bundle.getInt(MathIntentService.RESULT_EXTRA)
                resultTextView.text = result.toString()
            }
        }
    }

    val unboundedReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val bundle = intent?.extras
            if (bundle != null) {
                val result = bundle.getInt(MathStartCommand.RESULT_EXTRA)
                resultTextView.text = result.toString()
            }
        }
    }

    var boundedService: MathBoundedService? = null
    val serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(componentName: ComponentName?, binder: IBinder?) {
            this@MainActivity.boundedService = (binder as MathBoundedService.MathBinder).service
        }

        override fun onServiceDisconnected(componentName: ComponentName?) {
            this@MainActivity.boundedService = null
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(receiver, IntentFilter(MathIntentService.RESULT_NOTIFICATION))
        registerReceiver(unboundedReceiver, IntentFilter(MathStartCommand.RESULT_NOTIFICATION))
        bindService(Intent(this, MathBoundedService::class.java), serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
        unregisterReceiver(unboundedReceiver)
        unbindService(serviceConnection)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sumIntentButton.setOnClickListener {
            MathIntentService.startActionSum(
                    this,
                    Integer.parseInt(operand1EditText.text.toString()),
                    Integer.parseInt(operand2EditText.text.toString()))
        }
        mulIntentButton.setOnClickListener {
            MathIntentService.startActionMul(
                    this,
                    Integer.parseInt(operand1EditText.text.toString()),
                    Integer.parseInt(operand2EditText.text.toString()))
        }

        boundedSumButton.setOnClickListener {
            resultTextView.text =
                    boundedService?.Sum(
                            Integer.parseInt(operand1EditText.text.toString()),
                            Integer.parseInt(operand2EditText.text.toString())).toString()
        }
        boundedMulButton.setOnClickListener {
            resultTextView.text =
                    boundedService?.Mul(
                            Integer.parseInt(operand1EditText.text.toString()),
                            Integer.parseInt(operand2EditText.text.toString())).toString()
        }

        nonboundedSumButton.setOnClickListener {
            MathStartCommand.startActionSum(
                    this,
                    Integer.parseInt(operand1EditText.text.toString()),
                    Integer.parseInt(operand2EditText.text.toString()))
        }
        nonboundedMulButton.setOnClickListener {
            MathStartCommand.startActionMul(
                    this,
                    Integer.parseInt(operand1EditText.text.toString()),
                    Integer.parseInt(operand2EditText.text.toString()))
        }
    }
}
