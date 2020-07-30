package su.leff.presentation.di.fragment

import dagger.Component
import su.leff.presentation.navigation.BaseFragment

@Component(
    modules = [FragmentModule::class]
)
interface FragmentComponent {
    fun inject(fragment: BaseFragment)
}