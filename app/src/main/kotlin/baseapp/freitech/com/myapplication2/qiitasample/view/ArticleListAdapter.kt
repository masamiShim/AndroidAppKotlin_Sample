package src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.model.ArticleItem

class ArticleListAdapter(private val context: Context) : BaseAdapter() {

    var articles: List<ArticleItem> = emptyList()

    override fun getCount(): Int = articles.size

    override fun getItem(position: Int): Any? = articles[position]

    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View = ((convertView as? ArticleView)
            ?: ArticleView(context)).apply {
        setArticle(articles[position])
    }
}