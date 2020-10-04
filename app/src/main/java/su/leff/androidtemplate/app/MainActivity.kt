package su.leff.androidtemplate.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.SimpleStateChanger
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.navigator.Navigator
import kotlinx.android.synthetic.main.activity_main.*
import su.leff.androidtemplate.R
import su.leff.presentation.navigation.FragmentStateChanger
import su.leff.feature_login.presentation.AuthKey
import su.leff.presentation.ui.home.HomeKey
import su.leff.core.util.backstack

class MainActivity : AppCompatActivity(), SimpleStateChanger.NavigationHandler {
    private lateinit var fragmentStateChanger: FragmentStateChanger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentStateChanger = FragmentStateChanger(supportFragmentManager, R.id.root)

        val loggedIn = false

        val baseKey = if (loggedIn) HomeKey() else su.leff.feature_login.presentation.AuthKey()

        Navigator.configure()
            .setStateChanger(SimpleStateChanger(this))
            .install(this, root, History.single(baseKey))
    }

    override fun onBackPressed() {
        if (!backstack.goBack()) {
            super.onBackPressed()
        }
    }

    override fun onNavigationEvent(stateChange: StateChange) {
        fragmentStateChanger.handleStateChange(stateChange)
    }
}