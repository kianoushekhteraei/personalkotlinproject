package andriod.kianoushekhteraei.kotlinproject.Fragments.Profile

import andriod.kianoushekhteraei.kotlinproject.Adapters.SkillsAdp
import andriod.kianoushekhteraei.kotlinproject.R
import andriod.kianoushekhteraei.kotlinproject.databinding.FragmentProfileBinding
import andriod.kianoushekhteraei.kotlinproject.domain.model.Skills
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

class FragmentProfile : Fragment() {


    private lateinit var binding: FragmentProfileBinding
    private lateinit var adp: SkillsAdp


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        defineRecycler()
        return binding.root
    }


    private fun defineRecycler() {

        val skills : ArrayList<Skills> = arrayListOf()

        for (i in 1..10) {
            skills.add(Skills(1,R.drawable.ic_instagram, "ایکن و تیتر" + i))
        }

        binding.pbFrgProfile.visibility = View.GONE
        binding.rvSkillsProfile.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,true)
           adapter = SkillsAdp(skills)
        }

    }
}
