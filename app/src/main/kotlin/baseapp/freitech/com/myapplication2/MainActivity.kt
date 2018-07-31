package baseapp.freitech.com.myapplication2

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import com.trello.rxlifecycle.kotlin.bindToLifecycle
import src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.client.ArticleClient
import src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.extentions.toast
import src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.model.ArticleItem
import src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.model.User
import src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.view.ArticleActivity
import src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.view.ArticleListAdapter
import javax.inject.Inject
class MainActivity : RxAppCompatActivity() {

    @Inject
    lateinit var articleClient: ArticleClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as QiitaClientApp).component.inject(this)
        setContentView(R.layout.article_list)

        val listView: ListView = findViewById<ListView>(R.id.list_view)
        val progressBar: ProgressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val queryEditText: android.widget.EditText = findViewById(R.id.query_edit_text)
        val searchButton: android.widget.Button = findViewById(R.id.search_button)

        val listAdapter = ArticleListAdapter(applicationContext)
        listView.adapter = listAdapter

        listView.setOnItemClickListener { adapterView, view, position, id ->
            val intent = ArticleActivity.intent(this, listAdapter.articles[position])
            startActivity(intent)
        }

        searchButton.setOnClickListener {
            progressBar.visibility = View.VISIBLE

            articleClient.search(queryEditText.text.toString())
                    .subscribeOn(rx.schedulers.Schedulers.io())
                    .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
                    .doAfterTerminate {
                        progressBar.visibility = View.GONE
                    }
                    .bindToLifecycle(this)
                    .subscribe({
                        queryEditText.text.clear()
                        listAdapter.articles = it as List<ArticleItem>
                        listAdapter.notifyDataSetChanged()
                    }, {
                        toast("エラー : $it")
                    })
        }

    }
}

private fun dummyArticle(title: String, userName: String): ArticleItem =
        ArticleItem(id = "", title = title, url = "https://kotlinlang.org/", user = User(id = "", name = userName, profileImageUrl = ""))

/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ArticleView create
        val articleView = ArticleView(applicationContext)

        // ArticleItem create and set
        articleView.setArticle(ArticleItem(id = "123"
                , title = "Kotlin入門"
                , url = "http://www.example.com/articles/123"
                , user = User(id="456", name="次郎", profileImageUrl="")))

        setContentView(articleView)
    }
    */
/*
setContentView(activity_main)
val timeText = findViewById<TextView>(R.id.timeText)
val startBtn = findViewById<Button>(R.id.startBtn)
val stopBtn = findViewById<Button>(R.id.stopBtn)
val resetBtn = findViewById<Button>(R.id.resetBtn)
val u = UserSample(applicationContext)
val s = u.sampleUser()

val runnable = object : Runnable {
    override fun run(){
        timeValue++
        timeToText(timeValue)?.let {
            timeText.text = it
        }
        timeText.text = s
        handler.postDelayed(this, 1000)
    }
}

startBtn.setOnClickListener{
    handler.post(runnable)
}
stopBtn.setOnClickListener{
    handler.removeCallbacks(runnable)
}
resetBtn.setOnClickListener{
    handler.removeCallbacks(runnable)
    timeValue = 0
    timeToText()?.let{
        timeText.text = it
    }
}
}

private fun timeToText(time: Int = 0): String? {
return if(time < 0){
    null
}else if(time == 0){
    "00:00:00"
}else {
    val h = time / 3600
    val m = time % 3600 / 60
    val s = time % 60
    "%1$02d:%2$02d:%3$02d".format(h,m,s)
}
}
*/
