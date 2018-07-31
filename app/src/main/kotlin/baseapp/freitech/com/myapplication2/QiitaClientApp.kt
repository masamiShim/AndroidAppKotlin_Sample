package baseapp.freitech.com.myapplication2

import android.app.Application
import baseapp.freitech.com.myapplication2.dagger.DaggerAppComponent
import baseapp.freitech.com.myapplication2.dagger.AppComponent

class QiitaClientApp : Application() {
    val component: AppComponent by lazy{
        DaggerAppComponent.create()
    }
}