package su.leff.androidtemplate.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.SimpleStateChanger
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.navigator.Navigator
import com.zhuinden.simplestackextensions.fragmentsktx.backstack
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.root
import me.ibrahimsn.lib.OnItemSelectedListener
import su.leff.androidtemplate.R
import su.leff.androidtemplate.navigation.BaseFragment
import su.leff.androidtemplate.navigation.FragmentStateChanger
import su.leff.androidtemplate.ui.chat.ChatKey
import su.leff.androidtemplate.ui.home.chatlist.ChatListFragment
import su.leff.androidtemplate.ui.home.chatlist.ChatListKey
import su.leff.androidtemplate.ui.home.news.NewsFragment
import su.leff.androidtemplate.util.language.LanguageState
import su.leff.translator.Translator
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : BaseFragment() {

    val adapter = HomeAdapter(this::goToChat)

    private lateinit var fragmentStateChanger: FragmentManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fragmentStateChanger = parentFragmentManager
        val fragmentChats = ChatListFragment()
        val fragmentNews = NewsFragment()

//        fragmentStateChanger.beginTransaction().add(R.id.root, fragmentChats).hide(fragmentChats)
//            .commit()
//        fragmentStateChanger.beginTransaction().add(R.id.root, fragmentNews).commit()
//
        translationViewModel.language.observe(viewLifecycleOwner, Observer {
            bottomBar.items[0].title = Translator.getString("chats")
            bottomBar.items[1].title = Translator.getString("chat_rooms")
            bottomBar.items[2].title = Translator.getString("announcements")
            bottomBar.items[3].title = Translator.getString("settings")
        })

        bottomBar.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelect(pos: Int): Boolean {
                when (pos) {
                    0 -> {
                        fragmentStateChanger.beginTransaction().add(R.id.root, fragmentChats)
                            .commit()
                    }
                    1 -> {
                        fragmentStateChanger.beginTransaction().add(R.id.root, fragmentNews)
                            .commit()
                    }
                }
                return true
            }
        }


    }

    private fun goToChat() {
        backstack.goTo(ChatKey())
    }
}