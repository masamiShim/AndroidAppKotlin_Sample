package baseapp.freitech.com.myapplication2.items

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface TodoItemDao {

    @Query("SELECT * FROM todoItem")
    fun getAll(): List<TodoItem>

    @Query("SELECT * FROM todoItem WHERE id IN (:ids) ")
    fun loadAllByIds(vararg ids: Int): List<TodoItem>

    @Query("SELECT * FROM todoItem WHERE id = :id ")
    fun loadById(vararg id: Int): TodoItem

    @Insert
    fun save(todoItem: TodoItem)

    @Delete
    fun delete(todoItem: TodoItem)

}