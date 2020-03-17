package player36.itheima.com.myapplication

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder


/**
 * ClassName:MyService
 * Description:
 */
class MyService: Service() {
    override fun onCreate() {
        super.onCreate()
        println("onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(p0: Intent?): IBinder {
        println("onBind")
        return MyBinder()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        println("onUnbind")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }
    fun sayHello(){
        println("hello from servie")
    }
    inner class MyBinder:Binder(),IService{
        override fun callSayHello(){
            sayHello()
        }
    }
}