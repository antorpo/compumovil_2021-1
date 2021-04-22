package com.raywenderlich.galacticon
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

class RecyclerAdapter(private val photos: ArrayList<Photo>) : RecyclerView.Adapter<RecyclerAdapter.PhotoHolder>() {

    /*
        Adapter: Es un mecanismo de Android que hace puente entre nuestros datos y las vistas,
        adaptar el dataset a lo que finalmente vera el usuario (traducir datos en UI).

        En este caso RecyclerAdapter sera la clase que nos permita conectar con nuestro RecyclerView,
        vemos como obtiene en el constructor principal un arreglo de objetos de tipo Photo que seran
        nuestros datos a visualizar. Dentro de esta clase tendremos metodos para manipular el dataset.

        El ViewHolder nos permite obtener referencias de los componentes visuales (views) de cada elemento de la lista,
        es decir, nos describe un view y los metadatos acerca de su ubicacion dentro del RecyclerView. Tambien nos permite
        evitar el uso de findViewById() cada vez que se tenga que mostrar un nuevo elemento de la lista.
    */

    class PhotoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var photo: Photo? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val context = itemView.context
            val showPhotoIntent = Intent(context, PhotoActivity::class.java)
            showPhotoIntent.putExtra(PHOTO_KEY, photo)
            context.startActivity(showPhotoIntent)
        }

        companion object {
            private val PHOTO_KEY = "PHOTO"
        }

        fun bindPhoto(photo: Photo) {
            this.photo = photo
            Picasso.with(view.context).load(photo.url).into(view.itemImage)
            view.itemDate.text = photo.humanDate
            view.itemDescription.text = photo.explanation
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.PhotoHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
        return PhotoHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.PhotoHolder, position: Int) {
        val itemPhoto = photos[position]
        holder.bindPhoto(itemPhoto)
    }

    override fun getItemCount(): Int = photos.size


}