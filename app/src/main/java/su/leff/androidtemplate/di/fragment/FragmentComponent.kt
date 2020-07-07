package su.leff.androidtemplate.di.fragment

import dagger.Component
import su.leff.androidtemplate.navigation.BaseFragment

@Component(
    modules = [FragmentModule::class]
)
interface FragmentComponent {
    fun inject(fragment: BaseFragment)
}