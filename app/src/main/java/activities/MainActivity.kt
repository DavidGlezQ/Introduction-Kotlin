package activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.kotlinseccion4.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Configuracion del toolbar.
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Para crear un toolbar se debe de crear un layout con los parametros adecuados (tamaños etc).
        //Se debe de quitar el ActionBar del Manifest y aplicar un NoActionBar, asi quitaremos el ActionBar que genera android por defecto.
        //Una vez creada se incluye en el activity principal esto se hace por separado ya que es mas limpio, ademas que si en alguna parte de la app no requerimos de esta toolbar simplementado no se incluye y listo.
        //Por ultimo se pone esta linea para agregarla al soporte del ActionBar junto con su id.
        setSupportActionBar(findViewById(R.id.toolbar))

        btn_to_cycle.setOnClickListener { startActivity(Intent(this, CycleEventsActivity::class.java)) }
        btn_to_click.setOnClickListener { startActivity(Intent(this, CLickEventsActivity::class.java)) }
        btn_to_android_extension.setOnClickListener { startActivity(Intent(this, AndroidKotlinExtensionActivity::class.java)) }
        btn_to_picasso.setOnClickListener { startActivity(Intent(this, PicassoActivity::class.java)) }
        btn_to_ListView.setOnClickListener { startActivity(Intent(this, ListViewActivity::class.java)) }
        btn_to_intents.setOnClickListener { startActivity(Intent(this, IntentsActivity::class.java)) }
        btn_to_permission.setOnClickListener { startActivity(Intent(this, PermissionActivity::class.java)) }
        btn_to_shared_preferences.setOnClickListener { startActivity(Intent(this, SharedPreferencesActivity::class.java)) }
        btn_to_functions.setOnClickListener { startActivity(Intent(this, ExtensionFunctionsActivity::class.java)) }

    }
    
    //Otas funciones
        fun showToast() {
            //Toast es igual que en java.
            Toast.makeText(this, "Hello World from Toast, Kotlin!!", Toast.LENGTH_LONG).show()
        }

        fun showSnackBar() {
            //SnackBar cambia, el ConstraintLayout debe de tener un id para poder pasarle una vista.
            val layout = findViewById<ConstraintLayout>(R.id.constraint)
            //Snackbar.make(layout, "Hello World from SnackBar, Kotlin!!", Snackbar.LENGTH_LONG).show()

            //SnackBar con mensaje, en este ejemplo se da como si hubieramos borrado algo y despues lo quisieramos recuperar, como en emal
            Snackbar.make(layout, "Hello World from SnackBar with message, Kotlin!!", Snackbar.LENGTH_LONG).setAction("UNDO") {
                Snackbar.make(layout, "Message has been restored", Snackbar.LENGTH_LONG).show()
            }.show()
        }
}