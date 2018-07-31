package baseapp.freitech.com.myapplication2.users

import android.arch.persistence.room.Room
import android.content.Context
import baseapp.freitech.com.myapplication2.configures.AppDatabase
import java.util.*
import kotlin.concurrent.thread

class UserSample(private val applicationContext: Context) {


    fun sampleUser() : String {
        val db = Room.inMemoryDatabaseBuilder(applicationContext, AppDatabase::class.java).build()

        val user = User()
        user.uid = Random().nextInt()
        user.firstName = "Masami"
        user.lastName = "Shimbuichi"
        thread{
            // data save
            db.userDao.save(user)

            // data delete
            db.userDao.delete(user)
        }
        return "うえーい"
    }
}