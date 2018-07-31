package baseapp.freitech.com.myapplication2.users

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class User {
    @PrimaryKey
    var uid: Int = 0

    @ColumnInfo(name = "firstName")
    var firstName: String? = null

    @ColumnInfo(name = "lastName")
    var lastName: String? = null

    var age: Int = 0
}