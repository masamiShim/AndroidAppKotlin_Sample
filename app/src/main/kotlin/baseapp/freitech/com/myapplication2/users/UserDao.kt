package baseapp.freitech.com.myapplication2.users

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds) ")
    fun loadAllByIds(vararg userIds: Int): List<User>

    @Query("SELECT * FROM user WHERE firstName LIKE :first AND lastName LIKE :last LIMIT 1")
    fun findByName(first: String,  last: String): User

    @Insert
    fun save(user: User)

    @Insert
    fun saveAll(vararg users: User)

    @Insert
    fun saveAll(users: List<User>)

    @Delete
    fun delete(user: User)

    @Query("DELETE FROM user WHERE age < :age")
    fun deleteYoungerThan(age: Int)
}