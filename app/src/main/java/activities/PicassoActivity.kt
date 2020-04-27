package activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinseccion4.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picasso.*

class PicassoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        //Id del boton para cargar las imagenes mandando a llamar al medoto de picasso y aplicando KAT
        buttonLoader.setOnClickListener { loadImages() }

        Picasso.with(this).load("https://i.imgur.com/Rm3w33g.jpeg").fetch()
    }
    private fun loadImages(){
        Picasso.with(this)//Sintaxis de la libreria picasso pasandole el contexto
            .load("https://i.imgur.com/QOQdVp1.jpg")//La url de la imagen
            .resize(300, 300)
            .centerInside()//Si se utiliza centerInside o centerCrop se debe de utilizar resize obligatoriamente
            //.fit()//El fit sirve para llevar todo el espacio que tenga el imageview
            .into(imageViewTop)//El into es el id del image view donde se va a cargar

        /*Picasso.with(this)
            .load("https://i.imgur.com/jQZtIk9.jpeg")
            .resize(350,350)
            .centerInside()
            //.fit()
            .into(imageViewBottom)*/

        /*Picasso.with(this)
            .load("https://i.imgur.com/jQZtIk9.jpeg")
            .fit()
            .transform(CircleTransform())//Renderizar la imagen en circulo junto con el codigo java
            .into(imageViewBottom)*/

        //Animacion en la carga de imagen, primero la carga en cache y una vez la cargo la muestra en el onSuccess aplicando un segundo de transparencia.
        val context: Context = this
        Picasso.with(this)
            .load("https://i.imgur.com/jQZtIk9.jpeg")
            .fetch(object: Callback{
                override fun onSuccess() {
                    imageViewBottom.alpha = 0f
                    Picasso.with(context)
                        .load("https://i.imgur.com/jQZtIk9.jpeg")
                        .fit()
                        .transform(CircleTransform())
                        .into(imageViewBottom)
                    imageViewBottom.animate().setDuration(1000).alpha(1f).start()
                }
                override fun onError() {
                }
            })
    }
}
