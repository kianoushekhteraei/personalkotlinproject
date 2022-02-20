package andriod.kianoushekhteraei.kotlinproject.Adapters

import andriod.kianoushekhteraei.kotlinproject.R
import andriod.kianoushekhteraei.kotlinproject.domain.model.Cocktail
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DrinkAdp(val list: List<Cocktail>) : RecyclerView.Adapter<DrinkAdp.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.sample_rv_drinks, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.tv_name_drink.text=(list[position].strDrink)
        holder.tv_category_drink.text = list[position].strCategory
        holder.tv_alcoholic_drink.text = list[(position)].strAlcoholic
        Glide.with(holder.itemView.context).load(list[position].strDrinkThumb).placeholder(R.drawable.placeholder_product).into(holder.iv_drink)

    }

    override fun getItemCount(): Int {

        return list.size
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var iv_drink: ImageView
        internal var tv_name_drink: TextView
        internal var tv_category_drink: TextView
        internal var tv_alcoholic_drink: TextView


        init {
            iv_drink = itemView.findViewById(R.id.iv_drink)
            tv_name_drink = itemView.findViewById(R.id.tv_name_drink)
            tv_category_drink = itemView.findViewById(R.id.tv_category_drink)
            tv_alcoholic_drink = itemView.findViewById(R.id.tv_alcoholic_drink)

        }

    }
}