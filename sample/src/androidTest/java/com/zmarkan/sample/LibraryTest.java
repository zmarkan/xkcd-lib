package com.zmarkan.sample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

@RunWith(AndroidJUnit4.class)
public class LibraryTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    WireMockRule wiremockRule = new WireMockRule();

    @Before
    public void setUp(){

        wiremockRule.stubFor(get(urlMatching("/info.0.json/"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("{\"month\": \"3\", \"num\": 1651, \"link\": \"\", \"year\": \"2016\", \"news\": \"\", \"safe_title\": \"Robotic Garage\", \"transcript\": \"\", \"alt\": \"ALT TEXT\", \"img\": \"http:\\/\\/imgs.xkcd.com\\/comics\\/robotic_garage.png\", \"title\": \"Robotic Garage\", \"day\": \"4\"}")));
    }

    @Test
    public void sampleTest(){
        Assert.assertTrue(true);
    }

    @Test
    public void openLibrary(){
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.title_textview)).check(matches(isDisplayed()));
    }


}
