package src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import baseapp.freitech.com.myapplication2.R
import src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.model.ArticleItem

class ArticleActivity : AppCompatActivity() {
    companion object {

        private const val ARTICLE_EXTRA: String = "article"

        fun intent(context: Context, articleItem: ArticleItem): Intent =
                Intent(context, ArticleActivity::class.java).putExtra(ARTICLE_EXTRA, articleItem)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val articleView = findViewById<ArticleView>(R.id.article_view)
        val webView = findViewById<WebView>(R.id.web_view)

        val article: ArticleItem = intent.getParcelableExtra(ARTICLE_EXTRA)
        articleView.setArticle(article)
        webView.loadUrl(article.url)
    }
}