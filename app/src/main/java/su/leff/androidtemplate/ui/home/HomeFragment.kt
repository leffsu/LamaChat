package su.leff.androidtemplate.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhuinden.simplestackextensions.fragmentsktx.backstack
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_home.*
import su.leff.androidtemplate.R
import su.leff.androidtemplate.navigation.BaseFragment
import su.leff.androidtemplate.ui.auth.AuthKey
import su.leff.androidtemplate.ui.chat.ChatKey
import su.leff.androidtemplate.util.onClick

class HomeFragment : BaseFragment() {
    val adapter = HomeAdapter(this::goToChat)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Dialog>()
        for (i in 1..20) {
           list.add(Dialog(name= "Cotleta", text="Pojarskaya"))
        }

        rvDialogs.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvDialogs.adapter = adapter
        adapter.setList(list)
    }

    fun goToChat(){
        backstack.goTo(ChatKey())
    }
}