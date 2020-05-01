package others

import android.content.Context
import androidx.core.content.edit

class MySharedPreferences(context: Context){
    //Nombre fichero shared preferences.
    private val fileName = "mis preferencias"
    //Instancia de este fichero.
    private val prefs = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    //Por cada una de las variables que vamos a guardar en nuestro fichero shared preferences.
    var name: String
        get() = prefs.getString("name","")
        set(value) = prefs.edit().putString("name", value).apply()

    var age: Int
        get() = prefs.getInt("age",-1)
        set(value) = prefs.edit().putInt("age", value).apply()
}