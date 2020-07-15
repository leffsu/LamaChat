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
import su.leff.androidtemplate.ui.chatinfo.ChatInfoKey
import su.leff.androidtemplate.ui.home.Dialog
import su.leff.androidtemplate.ui.home.HomeAdapter
import su.leff.androidtemplate.util.onClick
import java.util.*
import kotlin.collections.ArrayList

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
        val chat1 = Chat("cat", "taita", Calendar.getInstance())
        val cal2 = Calendar.getInstance()
        cal2.set(Calendar.DAY_OF_YEAR, cal2.get(Calendar.DAY_OF_YEAR) - 1)
        val chat2 = Chat("Таита", "кошка-картошка", cal2)
        val cal3 = Calendar.getInstance()
        cal3.set(Calendar.DAY_OF_YEAR, cal3.get(Calendar.DAY_OF_YEAR) - 2)
        val chat3 = Chat("Лев", "сочные бочка, аппетитные окорочка", cal3)
        val cal4 = Calendar.getInstance()
        cal4.set(Calendar.MONTH, cal4.get(Calendar.MONTH) - 3)
        val chat4 = Chat("Паша", "Хиро донт край. По ступенькам в рааай", cal4)
        val cal5 = Calendar.getInstance()
        cal5.set(Calendar.YEAR, cal5.get(Calendar.YEAR) - 3)
        val chat5 = Chat("Аня", "Тая, хэлп", cal5)


        list.add(chat1)
        list.add(chat2)
        list.add(chat3)
        list.add(chat4)
        list.add(chat5)

        imgBack.setOnClickListener {
            backstack.goBack()
        }

        imgChatInfo.setOnClickListener {
            backstack.goTo(ChatInfoKey())
        }


        rvChatss.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvChatss.adapter = adapter
        adapter.setList(list)
    }
}