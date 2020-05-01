package activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.example.kotlinseccion4.R

class ExtensionFunctionsActivity : AppCompatActivity() {
    //Toolbar
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)
        //Toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}
