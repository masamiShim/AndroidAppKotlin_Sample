package src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.client

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Observable
import src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.model.ArticleItem

interface ArticleClient{

    @GET("/api/v2/items")
    fun search(@Query("query") query: String): rx.Observable<List<ArticleItem>>

}
