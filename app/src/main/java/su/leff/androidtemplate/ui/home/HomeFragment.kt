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
import java.util.*
import kotlin.collections.ArrayList

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
        val dialog1 = Dialog("cat", "taita", Calendar.getInstance())
        val cal2 = Calendar.getInstance()
        cal2.set(Calendar.DAY_OF_YEAR, cal2.get(Calendar.DAY_OF_YEAR) - 1)
        val dialog2 = Dialog("taita", "кошка", cal2)
        val cal3 = Calendar.getInstance()
        cal3.set(Calendar.DAY_OF_YEAR, cal3.get(Calendar.DAY_OF_YEAR) - 2)
        val dialog3 = Dialog("Лев", "лоток", cal3)
        val cal4 = Calendar.getInstance()
        cal4.set(Calendar.MONTH, cal4.get(Calendar.MONTH) - 3)
        val dialog4 = Dialog("Паша", "Хиро донт край", cal4)
        val cal5 = Calendar.getInstance()
        cal5.set(Calendar.YEAR, cal5.get(Calendar.YEAR) - 3)
        val dialog5 = Dialog("Аня", "приблуды свои убери", cal5)


        list.add(dialog1)
        list.add(dialog2)
        list.add(dialog3)
        list.add(dialog4)
        list.add(dialog5)

        rvDialogs.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvDialogs.adapter = adapter
        adapter.setList(list)
    }

    fun goToChat() {
        backstack.goTo(ChatKey())
    }
}