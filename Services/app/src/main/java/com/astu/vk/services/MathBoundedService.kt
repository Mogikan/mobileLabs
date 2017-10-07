package com.astu.vk.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MathBoundedService : Service() {

    public class MathBinder(val service:MathBoundedService): Binder() {
    }
    val binder:MathBinder = MathBinder(this)

    public fun Sum(operand1:Int,operand2:Int):Int{
        return operand1+operand2
    }
    public fun Mul(operand1:Int,operand2:Int):Int{
        return operand1*operand2
    }

    override fun onBind(intent: Intent): IBinder? {
        return binder
    }


}