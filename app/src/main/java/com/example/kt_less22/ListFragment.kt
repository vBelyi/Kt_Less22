package com.example.kt_less22

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class ListFragment : Fragment() {
    companion object {
        fun newInstance(biographyFullName: String?, biographyFirsAppearance: String?, powerStats: String?, appearance: String?, imageUrl: String?): ListFragment {
            val fragment = ListFragment()
            val args = Bundle()
            args.putString("biographyFullName", biographyFullName ?: "N/A")
            args.putString("imageUrl", imageUrl ?: "N/A")
            args.putString("biographyFirsAppearance", biographyFirsAppearance?: "N/A")
            args.putString("powerStats", powerStats?: "N/A")
            args.putString("appearance", appearance?: "N/A")
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val biographyFullName = arguments?.getString("biographyFullName")
        val imageUrl = arguments?.getString("imageUrl")
        val biographyFirsAppearance = arguments?.getString("biographyFirsAppearance")
        val powerStats = arguments?.getString("powerStats")
        val appearance = arguments?.getString("appearance")

        val biography1: TextView = view.findViewById(R.id.fragmentText)
        val biography2: TextView = view.findViewById(R.id.fragmentText2)
        val powerStats1: TextView = view.findViewById(R.id.fragmentText4)
        val appearance1: TextView = view.findViewById(R.id.fragmentText3)

        val xxlImage: ImageView = view.findViewById(R.id.fragmentImage)

        if (biographyFullName != null) {
            biography1.text = "Full name: $biographyFullName"
        }

        if (biographyFirsAppearance != null) {
            biography2.text = "First appearance: $biographyFirsAppearance"
        }

        if (powerStats != null) {
            powerStats1.text = "Power: $powerStats"
        }

        if (appearance != null) {
            appearance1.text = "Race: $appearance"
        }


        imageUrl?.let{
            Glide.with(requireContext())
                .load(it)
                .into(xxlImage)
        }
    }
}