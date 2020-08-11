package su.leff.presentation.ui.chatinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhuinden.simplestackextensions.fragmentsktx.backstack
import kotlinx.android.synthetic.main.chat_info.*
import su.leff.presentation.navigation.BaseFragment
import su.leff.presentation.ui.chat.ChatAdapter
import su.leff.presentation.R

class ChatInfoFragment: BaseFragment() {
    val adapter = ChatAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.chat_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imgBackInfo.setOnClickListener {
            backstack.goBack()
        }


    }
}