package activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.kotlinseccion4.R
import kotlinx.android.synthetic.main.activity_android_kotlin_extension.*

class AndroidKotlinExtensionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_kotlin_extension)

        //De esta manera que castea el boton u objeto de la UI haciendo el codigo un poco mas largo pero funcional
        val btn = findViewById<Button>(R.id.buttonById)
        btn.setOnClickListener { Toast.makeText(this, "Click By Id!", Toast.LENGTH_SHORT).show() }

        //De esta manera se puede acceder directamente al id del objeto de la UI sin tener que castear nada antes solo importando la libreria import kotlinx.android.synthetic.main.activity_android_kotlin_extension.*
        button2ByKAT.setOnClickListener {Toast.makeText(this, "Click By KAT!", Toast.LENGTH_SHORT).show() }
    }
}
