package activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kotlinseccion4.R
import kotlinx.android.synthetic.main.activity_permission.*

class PermissionActivity : AppCompatActivity() {
    //Tollbar
    private lateinit var toolbar: Toolbar

    private val requestCameraPermission = 100
    private val requestCameraPicture = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        //Toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        buttonPicture.setOnClickListener { getPictureFromCameraAskingPermission() }
    }

    //Tomar fotos sin permisos
    private fun getCameraFromPicture(){
        //Debemos de asegurarnos de no tener los permisos en el Manifest ya que si no hariamos que la app no funcione.
        //Crear intente para capturar la foto
        val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        //Comprobar que podemos tomar fotos (es decir que tenemos una app con cámara o el mismo telefono tiene cámara).
        if (pictureIntent.resolveActivity(packageManager) != null){

        }else{
            //No hay un activity que pueda manejar el intent(por ejemplo cin cámara).
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, requestCameraPicture)
        }
    }

    //Nota los permisos en Run Time solo aplican a partir de la versiones de la 6.0 en adelante, las versiones anteriores pregunta desde la store.
    private fun getPictureFromCameraAskingPermission(){
        ////Añadir permiso al Manifest
        //Comprobar el permiso de la camara
        //PERMISSION_GRANTED es igual a que si acepto el permiso con valo 0, en caso de DENIED su valor es -1.
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //Si no ha sido acpetado previamente, se vuelve a preguntar con el requestPermission (esto solo aplica en versiones desde la API 23 (6.0) en adelante).
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), requestCameraPermission)
        }else{
            //Si ha sido aceptado previamente (esto tambien influye para las versiones inferiores a la 6.0)
            //De esta manera lanzamos la camara del telefono.
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, requestCameraPicture)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            requestCameraPermission -> {
                if(grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //Permiso aceptado
                    //De esta manera lanzamos la camara del telefono.
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, requestCameraPicture)
                }else{
                    //Permiso denegado
                    Toast.makeText(this, "No has aceptado el permiso de tu cámara.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            requestCameraPicture -> {
                //Comprobar si el resultado es bueno, es decir si se tomo la foto
                if (resultCode == Activity.RESULT_OK){
                    //Obtenemos los extras del intent recibido por parametros
                    val extras = data!!.extras
                    //Formamos el bitmap a partir de los extras
                    val imageBitMap = extras.get("data") as Bitmap
                    //Cargamos la foto com Bitmap en el imageView
                    imageViewPicture.setImageBitmap(imageBitMap)
                }else{
                    //La foto no ha sido tomada con exito
                    Toast.makeText(this, "La foto no se ha tomado con exito.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
