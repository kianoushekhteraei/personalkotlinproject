package andriod.kianoushekhteraei.kotlinproject.Adapters

import andriod.kianoushekhteraei.kotlinproject.domain.model.Skills

import andriod.kianoushekhteraei.kotlinproject.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SkillsAdp(val list: List<Skills>) : RecyclerView.Adapter<SkillsAdp.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.sample_rv_skills, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.name_rv_skills.text=(list[position].name_skill)
        Glide.with(holder.itemView.context).load(list[position].img_skill).placeholder(R.drawable.placeholder_product).into(holder.iv_skills)

    }

    override fun getItemCount(): Int {

        return list.size
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var iv_skills: ImageView
        internal var name_rv_skills: TextView


        init {
            iv_skills = itemView.findViewById(R.id.iv_rv_skills)
            name_rv_skills = itemView.findViewById(R.id.name_rv_skills)

        }

    }
}