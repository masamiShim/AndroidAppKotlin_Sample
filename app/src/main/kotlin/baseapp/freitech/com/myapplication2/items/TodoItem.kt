package baseapp.freitech.com.myapplication2.items

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.ColumnInfo

@Entity
class TodoItem {

    @PrimaryKey
    var id: Int? = null

    @ColumnInfo(name = "memo")
    var memo: String? = null

}