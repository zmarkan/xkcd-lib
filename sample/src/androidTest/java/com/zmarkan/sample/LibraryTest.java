package com.zmarkan.sample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.zmarkan.xkcdlib.ComicService;
import com.zmarkan.xkcdlib.Injector;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LibraryTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp(){
        setupMockWebServer();

        onView(withId(R.id.button)).perform(click());
    }

    private void setupMockWebServer() {
        MockWebServer mockWebServer = new MockWebServer();
        String serverBaseUrl = mockWebServer.url("/").toString();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(serverBaseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        Injector.INSTANCE.setComicService(retrofit.create(ComicService.class));

        mockWebServer.enqueue(
                new MockResponse()
        .setResponseCode(200)
        .setBody("{\"month\": \"3\", \"num\": 1652, \"link\": \"\", \"year\": \"2016\", \"news\": \"\", \"safe_title\": \"Conditionals\", \"transcript\": \"\", \"alt\": \"HELLO WORLD\", \"img\": \"http:\\/\\/imgs.xkcd.com\\/comics\\/conditionals.png\", \"title\": \"Conditionals\", \"day\": \"7\"}"));
    }

    @Test
    public void openLibrary() throws InterruptedException {
        onView(withId(R.id.title_textview)).check(matches(isDisplayed()));
        onView(withId(R.id.upvote_button)).perform(scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.downvote_button)).perform(scrollTo()).check(matches(isDisplayed()));
    }

    @Test
    public void title(){
        onView(withText("Conditionals")).check(matches(isDisplayed()));
    }

    @Test
    public void altTextOnImagePress() throws InterruptedException {
        onView(withText("HELLO WORLD")).check(doesNotExist());
        onView(withId(R.id.xkcd_imageview)).perform(click());
        onView(withText("HELLO WORLD")).check(matches(isDisplayed()));
    }

    @Test
    public void performUpvote(){
        onView(withId(R.id.upvote_button)).perform(scrollTo()).perform(click());

        onView(withId(R.id.main_container)).check(matches(isDisplayed()));
        onView(withText("UPVOTE")).check(matches(isDisplayed()));
    }

    @Test
    public void performDownvote(){
        onView(withId(R.id.downvote_button)).perform(scrollTo()).perform(click());

        onView(withId(R.id.main_container)).check(matches(isDisplayed()));
        onView(withText("DOWNVOTE")).check(matches(isDisplayed()));
    }
}
