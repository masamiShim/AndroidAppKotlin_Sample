package baseapp.freitech.com.myapplication2

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.*
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.Matcher
import org.hamcrest.Matchers.not
import org.mockito.Mockito.*
import rx.Observable
import src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.client.ArticleClient

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test() {
        onView(withId(R.id.list_view)).check(matches(isDisplayed()))
        onView(withId(R.id.query_edit_text)).check(matches(isDisplayed()))
        onView(withId(R.id.search_button)).check(matches(isDisplayed()))

        onView(withId(R.id.progress_bar)).check(matches(isNotDisplayed()))
    }

    @Test
    fun tappedSearchButtonThenSearchAPI(){
        val articleClient = mock(ArticleClient::class.java).apply{
            `when`(search("user;ngsw_taro")).thenReturn(Observable.just(listOf()))
        }
         activityTestRule.activity.articleClient = articleClient

        onView(withId(R.id.query_edit_text)).perform(typeText("user:ngsw_taro"))
        onView(withId(R.id.search_button)).perform(click())

        verify(articleClient).search("user:ngsw_taro")
    }

   private fun isNotDisplayed(): Matcher<View> = not(isDisplayed())
}