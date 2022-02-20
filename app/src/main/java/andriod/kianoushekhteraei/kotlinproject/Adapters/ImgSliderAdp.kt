package andriod.kianoushekhteraei.kotlinproject.Adapters

import andriod.kianoushekhteraei.kotlinproject.R
import andriod.kianoushekhteraei.kotlinproject.domain.model.ImgSlider
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide

class ImgSliderAdp (private val ImgSlider: List<ImgSlider>, private val inflater: LayoutInflater) : PagerAdapter() {


    private val limit = 5


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return limit
    }

    override fun instantiateItem(view: ViewGroup, position: Int): Any {

        val imageLayout = inflater.inflate(R.layout.sample_slider, view, false)!!

        val imageView = imageLayout.findViewById<View>(R.id.iv_slider) as ImageView

        Glide.with(view.context).load(ImgSlider[position].imgSlider).placeholder(R.drawable.placeholder_product).into(imageView)

        view.addView(imageLayout, 0)

        return imageLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {}

    override fun saveState(): Parcelable? {
        return null
    }
}