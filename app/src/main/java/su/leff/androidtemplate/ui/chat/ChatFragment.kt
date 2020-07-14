package su.leff.androidtemplate.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhuinden.simplestackextensions.fragmentsktx.backstack
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_second.*
import su.leff.androidtemplate.R
import su.leff.androidtemplate.navigation.BaseFragment
import su.leff.androidtemplate.ui.home.Dialog
import su.leff.androidtemplate.ui.home.HomeAdapter
import su.leff.androidtemplate.util.onClick

class ChatFragment : BaseFragment() {
    val adapter = ChatAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Chat>()
        for (i in 1..20) {
            list.add(Chat(title = "Oleg", mess = "Где макет?"))
        }

        rvChatss.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvChatss.adapter = adapter
        adapter.setList(list)
    }
}