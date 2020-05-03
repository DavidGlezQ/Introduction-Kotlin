package activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.example.kotlinseccion4.R
import kotlinx.android.synthetic.main.activity_extension_functions.*
import others.goToActivity
import others.loadByURL
import others.snackBar
import others.toast

class ExtensionFunctionsActivity : AppCompatActivity() {
    //Toolbar
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)
        //Toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        //Estas extension estan declaradas en ExtensionFunction

        //Eventos
        buttonToast.setOnClickListener { toast("I Love Extension Function!") }
        buttonSnackBar.setOnClickListener { snackBar("I Love Extension Function!", action = "Undo") {toast("Undo!")} }
        buttonLoadByURL.setOnClickListener { imageViewLoadByURL.loadByURL("https://i.imgur.com/Rm3w33g.jpeg") }
        buttonGoToActivity.setOnClickListener { goToActivity<MainActivity>() }
    }
}