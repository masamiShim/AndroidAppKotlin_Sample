package baseapp.freitech.com.myapplication2.configures

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import baseapp.freitech.com.myapplication2.items.TodoItemDao
import baseapp.freitech.com.myapplication2.items.TodoItem
import baseapp.freitech.com.myapplication2.users.User
import baseapp.freitech.com.myapplication2.users.UserDao

@Database(entities = arrayOf(User::class , TodoItem::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    abstract val todoItemDao: TodoItemDao
}