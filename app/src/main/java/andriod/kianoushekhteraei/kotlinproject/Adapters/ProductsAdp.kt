package andriod.kianoushekhteraei.kotlinproject.Adapters

import andriod.kianoushekhteraei.kotlinproject.R
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

class ProductsAdp(val list: List<Product>) : RecyclerView.Adapter<ProductsAdp.CustomViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_rv_products, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.tv_title_product.setText(list[position].title)
        holder.tv_price_product.setText(list[position].price.toString())
        holder.tv_category_product.setText(list[(position)].category)
        Glide.with(holder.itemView.context).load(list[position].image).placeholder(R.drawable.placeholder_product).into(holder.iv_product)

    }

    override fun getItemCount(): Int {

        return list.size
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var iv_product: ImageView
        internal var tv_title_product: TextView
        internal var tv_price_product: TextView
        internal var tv_category_product: TextView


        init {
            iv_product = itemView.findViewById(R.id.iv_product)
            tv_title_product = itemView.findViewById(R.id.tv_title_product)
            tv_price_product = itemView.findViewById(R.id.tv_price_product)
            tv_category_product = itemView.findViewById(R.id.tv_category_product)

        }

    }
}