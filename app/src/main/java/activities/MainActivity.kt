package activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.kotlinseccion4.R
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se declara la variable junto con findviewbyid <aqui va el objeto que se utiliza en este caso es un boton> y al igual que en java se busca el objeto en R.
        val btnCycleEvents = findViewById<Button>(R.id.btn_to_cycle)
        val btnCLickEvents = findViewById<Button>(R.id.btn_to_click)
        val btnAndroidKotlinExtension = findViewById<Button>(R.id.btn_to_android_extension)
        val btnPicasso = findViewById<Button>(R.id.btn_to_picasso)
        val btnListView = findViewById<Button>(R.id.btn_to_ListView)
        val btnIntents = findViewById<Button>(R.id.btn_to_intents)
        val btnPermission = findViewById<Button>(R.id.btn_to_permission)
        val btnSharedPreferences = findViewById<Button>(R.id.btn_to_shared_preferences)
        val btnExtensionFunctions = findViewById<Button>(R.id.btn_to_functions)

        //Evento onClickListener en una sola linea con kotlin. Manda a llamar la funcion que manda de un activy a otro.
        btnCycleEvents.setOnClickListener{ goToCycleEventActivity() }
        btnCLickEvents.setOnClickListener{ goToClickEventsActivity() }
        btnAndroidKotlinExtension.setOnClickListener{ goToAndroidKotlinExtension() }
        btnPicasso.setOnClickListener { goToPicasso() }
        btnListView.setOnClickListener { goToListView() }
        btnIntents.setOnClickListener { goToIntents() }
        btnPermission.setOnClickListener { goToPermission() }
        btnSharedPreferences.setOnClickListener { goToSharedPreferences() }
        btnExtensionFunctions.setOnClickListener { goToExtensionFunctions() }
    }

    //Funcion que manda a llamar a la clase del activity, no es necesario el startActivity.
    private fun goToCycleEventActivity() = startActivity(Intent(this, CycleEventsActivity::class.java))
    private fun goToClickEventsActivity() = startActivity(Intent(this, CLickEventsActivity::class.java))
    private fun goToAndroidKotlinExtension() = startActivity(Intent(this, AndroidKotlinExtensionActivity::class.java))
    private fun goToPicasso() = startActivity(Intent(this, PicassoActivity::class.java))
    private fun goToListView() = startActivity(Intent(this, ListViewActivity::class.java))
    private fun goToIntents() = startActivity(Intent(this, IntentsActivity::class.java))
    private fun goToPermission() = startActivity(Intent(this, PermissionActivity::class.java))
    private fun goToSharedPreferences() = startActivity(Intent(this, SharedPreferencesActivity::class.java))
    private fun goToExtensionFunctions() = startActivity(Intent(this, ExtensionFunctionsActivity::class.java))

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