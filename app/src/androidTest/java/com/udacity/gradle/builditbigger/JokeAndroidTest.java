package com.udacity.gradle.builditbigger;

import android.test.LoaderTestCase;

import org.junit.Test;

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
