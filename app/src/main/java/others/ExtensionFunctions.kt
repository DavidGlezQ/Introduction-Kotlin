package others

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import android.widget.ViewAnimator
import com.example.kotlinseccion4.R
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

//ExtensionFunction basico
fun Int.isNatural() = this >= 0

//ExtensionFunction para Toast
fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, duration).show()
fun Activity.toast(resourceId: Int, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, resourceId, duration).show()

//ExtensionFunction para Snack Bar
fun Activity.snackBar(message: CharSequence, view: View? = findViewById(R.id.container),
                        duration: Int = Snackbar.LENGTH_SHORT, action: String? = null,
                        actionEvt: (v: View) -> Unit = {}){

    //Comprobacion del snackBar
    if (view != null){
        val snackbar = Snackbar.make(view, message, duration)
        if (!action.isNullOrEmpty()){
            snackbar.setAction(action, actionEvt)
        }
        snackbar.show()
    }
}

//PeronAdapter
fun ViewGroup.inflate(layoutId: Int) = LayoutInflater.from(context).inflate(layoutId, this, false)!!

//Load By URL
fun ImageView.loadByURL(url: String) = Picasso.with(context).load(url).into(this)

//Go to Activity
inline fun <reified T : Activity>Activity.goToActivity(noinline init: Intent.() -> Unit = {}){
    val intent = Intent(this, T::class.java)
    intent.init()
    startActivity(intent)
}

//Go to Activity con Result
fun Activity.goToActivityResult(action: String, requestCode: Int, init: Intent.() -> Unit = {}){
    val intent = Intent(action)
    intent.init()
    startActivityForResult(intent, requestCode)
}