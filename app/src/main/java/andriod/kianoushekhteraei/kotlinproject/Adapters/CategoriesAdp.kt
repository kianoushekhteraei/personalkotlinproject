package andriod.kianoushekhteraei.kotlinproject.Adapters

import andriod.kianoushekhteraei.kotlinproject.R
import andriod.kianoushekhteraei.kotlinproject.domain.model.Categories
import andriod.kianoushekhteraei.kotlinproject.domain.model.Product
import android.content.Context
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CategoriesAdp(val list: List<Categories>) : RecyclerView.Adapter<CategoriesAdp.CustomViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_rv_categories, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.tv_title_categories.text = list[position].title
    }

    override fun getItemCount(): Int {

        return list.size
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tv_title_categories: TextView



        init {
            tv_title_categories = itemView.findViewById(R.id.tv_title_categories)


        }

    }
}