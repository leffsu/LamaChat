package su.leff.androidtemplate.ui.home.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zhuinden.simplestack.SimpleStateChanger
import su.leff.androidtemplate.R
import su.leff.androidtemplate.navigation.BaseFragment
import su.leff.androidtemplate.navigation.FragmentStateChanger
import su.leff.androidtemplate.ui.home.HomeAdapter

class NewsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
