package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.LoaderManager;
import android.support.v4.util.Pair;
import android.test.AndroidTestCase;
import android.test.LoaderTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

public class JokeAndroidTest extends LoaderTestCase {

    @Test
    public void testJokeResponse() {
        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext());
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
        assertNotSame("",result);
    }
}
