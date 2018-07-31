package baseapp.freitech.com.myapplication2.dagger

import baseapp.freitech.com.myapplication2.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ClientModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}