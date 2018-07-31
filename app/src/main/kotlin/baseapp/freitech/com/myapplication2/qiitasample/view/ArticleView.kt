package src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import baseapp.freitech.com.myapplication2.R
import src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.extentions.bindView
import src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.model.ArticleItem

class ArticleView : FrameLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private val profileImageView: ImageView by bindView(R.id.profile_image_view)

    private val titleTextView: TextView by bindView(R.id.title_text_view)

    private val userNameTextView: TextView by bindView(R.id.user_name_text_view)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_article, this)
    }

    fun setArticle(article: ArticleItem) {
        titleTextView?.text = article.title
        userNameTextView?.text = article.user.name
        com.bumptech.glide.Glide.with(context).load(article.user.profileImageUrl).into(profileImageView)
        profileImageView?.setBackgroundColor(Color.RED)
    }

}