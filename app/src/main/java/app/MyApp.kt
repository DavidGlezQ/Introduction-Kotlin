package app

import android.app.Application
import others.MySharedPreferences
//by lazy lo que hace es que el codigo que se ponga dentro nunca sera utilizado.
val preferences: MySharedPreferences by lazy { MyApp.prefs!! }

class MyApp : Application(){
    companion object{
        var prefs: MySharedPreferences? = null
    }

    override fun onCreate() {
        super.onCreate()
        prefs = MySharedPreferences(applicationContext)
    }
}