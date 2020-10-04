package su.leff.presentation.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhuinden.simplestackextensions.fragmentsktx.backstack
import kotlinx.android.synthetic.main.fragment_home.*
import me.ibrahimsn.lib.OnItemSelectedListener
import su.leff.presentation.navigation.BaseFragment
import su.leff.presentation.R
import su.leff.presentation.ui.chat.ChatKey
import su.leff.presentation.ui.home.subview.core.SubViewWithListParent
import su.leff.presentation.ui.home.subview.chatlist.Chat
import su.leff.presentation.ui.home.subview.chatlist.ChatListController
import su.leff.presentation.ui.home.subview.news.News
import su.leff.presentation.ui.home.subview.news.NewsController
import su.leff.presentation.ui.home.subview.settings.SettingsController
import su.leff.presentation.ui.home.subview.settings.SettingsSubViewParent
import su.leff.core.util.*

class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private lateinit var chatParent:
            SubViewWithListParent<Chat>

    private lateinit var groupChatParent:
            SubViewWithListParent<Chat>

    private lateinit var newsParent:
            SubViewWithListParent<News>

    private lateinit var settingsParent:
            SettingsSubViewParent

    lateinit var chatListController: ChatListController
    lateinit var groupListController: ChatListController
    lateinit var newsListController: NewsController
    lateinit var settingsController: SettingsController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeSubViews()

        setState(HomeState.CHAT)

        setupListeners()
    }

    private fun setupListeners(){
        bottomBar.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelect(pos: Int): Boolean {
                when (pos) {
                    0 -> {
                        setState(HomeState.CHAT)
                    }
                    1 -> {
                        setState(HomeState.GROUP_CHAT)
                    }
                    2 -> {
                        setState(HomeState.NEWS)
                    }
                    3 -> {
                        setState(HomeState.SETTINGS)
                    }
                }
                return true
            }
        }
    }

    private fun initializeSubViews(){
        chatParent = object :
            SubViewWithListParent<Chat> {
            override fun onItemClick(t: Chat) {

            }

            override val context: Context? = this@HomeFragment.requireContext()
        }

        groupChatParent = object :
            SubViewWithListParent<Chat> {
            override fun onItemClick(t: Chat) {

            }

            override val context: Context? = this@HomeFragment.requireContext()
        }

        newsParent = object :
            SubViewWithListParent<News> {
            override fun onItemClick(t: News) {

            }

            override val context: Context? = this@HomeFragment.requireContext()
        }

        settingsParent = object :
            SettingsSubViewParent {

        }

        chatListController = ChatListController(chatList.toConstraintLayout(), chatParent)
        groupListController =
            ChatListController(groupChatList.toConstraintLayout(), groupChatParent)
        newsListController = NewsController(newsList.toConstraintLayout(), newsParent)
        settingsController = SettingsController(settings.toConstraintLayout(), settingsParent)
    }

    private fun setState(homeState: HomeState) {
        chatListController.showIf { homeState == HomeState.CHAT }
        groupListController.showIf { homeState == HomeState.GROUP_CHAT }
        newsListController.showIf { homeState == HomeState.NEWS }
        settingsController.showIf { homeState == HomeState.SETTINGS }
    }

    private fun goToChat(string: String) {
        backstack.goTo(ChatKey())
    }

    private fun openNews(string: String) {

    }
}