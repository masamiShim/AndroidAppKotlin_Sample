package src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.model

import android.os.Parcel
import android.os.Parcelable

class ArticleItem(val id: String, val title: String, val url: String, val user: User) : Parcelable {
    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ArticleItem> = object : Parcelable.Creator<ArticleItem> {
            override fun createFromParcel(source: Parcel): ArticleItem = source.run {
                ArticleItem(readString(), readString(), readString(), readParcelable(ArticleItem::class.java.classLoader))
            }

            override fun newArray(size: Int): Array<ArticleItem?> = arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.run {
            writeString(id)
            writeString(title)
            writeString(url)
            writeParcelable(user, flags)
        }
    }
}