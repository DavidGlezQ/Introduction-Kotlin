package activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import app.preferences
import com.example.kotlinseccion4.R
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity() {
    //Toolbar
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
        //Toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        //Para el uso de estas shred preferences es crear un archivo donde tendremos los valores que vamos a utilizar (MySharedPreferences)
        //Despues crearemos las preferences (archivo MyApp) donde podremos instanciarlas y hacer el uso de estas en cualquier parte del codigo como si fuera una variable.
        //Cuando presionemos el boton guardaremos los valores y limpiaremos

        buttonSave.setOnClickListener { setValuesSharedPreferences(); CleanEditText(); getValuesSharedPreferences(); }
        //Obtenemos los valores del SharedPreferences
        getValuesSharedPreferences()
    }

    private fun getValuesSharedPreferences(){
        //Recoger los valores del SharedPreferences
        if (preferences.name.isNotEmpty() && preferences.age >= 0){
            textViewSharedPreferences.text = "Welcome ${preferences.name}, your age is ${preferences.age}"
        }else{
            textViewSharedPreferences.text = "Welcome, please save your name and age"
        }
    }

    private fun setValuesSharedPreferences(){
        //Guarda los datos en el SharedPreferences.
        if (editTextName.text.toString().isNotEmpty() && editTextAge.toString().isNotEmpty()){
            //Guardamos los datos.
            preferences.name = editTextName.text.toString()
            preferences.age = editTextAge.text.toString().toInt()
            Toast.makeText(this, "Values has been save successfully", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Please fill the name and the age before saving", Toast.LENGTH_SHORT).show()
        }
    }

    private fun CleanEditText(){
        //Limpia una vez que guardemos
        editTextName.text.clear()
        editTextAge.text.clear()
    }
}
