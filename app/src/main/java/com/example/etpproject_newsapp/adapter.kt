package com.example.etpproject_newsapp

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class adapter(var context: Context, modelClassArrayList: ArrayList<modelclass>) :
    RecyclerView.Adapter<adapter.ViewHolder>() {
    var modelClassArrayList: ArrayList<modelclass>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.item,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.cardView.setOnClickListener {
            val intent = Intent(context, WebView::class.java)
            intent.putExtra("url", modelClassArrayList[position].getUrl())
            context.startActivity(intent)
        }
        holder.mtime.text = "Published At: " + modelClassArrayList[position].getPublishedAt()
        holder.mauthor.setText(modelClassArrayList[position].getAuthor())
        holder.mheading.setText(modelClassArrayList[position].getTitle())
        holder.mcontent.setText(modelClassArrayList[position].getDescription())
        Glide.with(context).load(modelClassArrayList[position].getUrlToImage())
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return modelClassArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mheading: TextView
        var mcontent: TextView
        var mauthor: TextView
        var mtime: TextView
        var cardView: CardView
        var imageView: ImageView

        init {
            mheading = itemView.findViewById(R.id.mainheading)
            mcontent = itemView.findViewById(R.id.content)
            mauthor = itemView.findViewById(R.id.author)
            mtime = itemView.findViewById(R.id.time)
            cardView = itemView.findViewById(R.id.cardview)
            imageView = itemView.findViewById(R.id.imageview)
        }
    }

    init {
        this.modelClassArrayList = modelClassArrayList
    }
}
