package com.astu.vk.services

import android.app.IntentService
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder

class MathStartCommand : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            val action = intent.action
            if (ACTION_SUM == action) {
                val param1 = intent.getIntExtra(EXTRA_OPERAND1,0)
                val param2 = intent.getIntExtra(EXTRA_OPERAND2,0);
                handleActionSum(param1, param2)
            } else if (ACTION_MUL == action) {
                val param1 = intent.getIntExtra(EXTRA_OPERAND1,0)
                val param2 = intent.getIntExtra(EXTRA_OPERAND2,0);
                handleActionMul(param1, param2)
            }
        }
        return Service.START_NOT_STICKY
    }

    private fun handleActionSum(operand1: Int, operand2: Int) {
        var resultIntent:Intent = Intent(RESULT_NOTIFICATION)
        resultIntent.putExtra(RESULT_EXTRA,operand1+operand2)
        sendBroadcast(resultIntent)
    }

    private fun handleActionMul(operand1: Int, operand2: Int) {
        var resultIntent:Intent = Intent(RESULT_NOTIFICATION)
        resultIntent.putExtra(RESULT_EXTRA,operand1*operand2)
        sendBroadcast(resultIntent)
    }

    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    public fun Sum(operand1:Int,operand2:Int):Int{
        return operand1+operand2
    }
    public fun Mul(operand1:Int,operand2:Int):Int{
        return operand1*operand2
    }

    companion object {
        public val RESULT_NOTIFICATION = "mathNonBoundedNotification"
        public val RESULT_EXTRA = "mathNonBounderResultExtra"

        private val ACTION_SUM = "com.astu.vk.services.action.SUM"
        private val ACTION_MUL = "com.astu.vk.services.action.MUL"

        private val EXTRA_OPERAND1 = "com.astu.vk.services.extra.OPERAND1"
        private val EXTRA_OPERAND2 = "com.astu.vk.services.extra.OPERAND2"

        fun startActionSum(context: Context, operand1: Int, operand2: Int) {
            val intent = Intent(context, MathStartCommand::class.java)
            intent.action =ACTION_SUM
            intent.putExtra(EXTRA_OPERAND1, operand1)
            intent.putExtra(EXTRA_OPERAND2, operand2)
            context.startService(intent)
        }

        /**
         * Starts this service to perform action Baz with the given parameters. If
         * the service is already performing a task this action will be queued.

         * @see IntentService
         */
        // TODO: Customize helper method
        fun startActionMul(context: Context, operand1: Int, operand2: Int) {
            val intent = Intent(context, MathStartCommand::class.java)
            intent.action = ACTION_MUL
            intent.putExtra(EXTRA_OPERAND1, operand1)
            intent.putExtra(EXTRA_OPERAND2, operand2)
            context.startService(intent)
        }
    }
}
