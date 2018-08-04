package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.udacity.gradle.jokes.Joker;


public class MainActivity extends AppCompatActivity {

    private static final int LOADER_ID = 1;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBarWaiting);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        Joker joker = new Joker();
        Toast.makeText(this, joker.getJoke(), Toast.LENGTH_SHORT).show();

        new EndpointsAsyncTask(this,progressBar).execute(new Pair<Context, String>(this, "Manfred"));

//      I did not know how to test loader
//        LoaderManager.LoaderCallbacks<String> callback = this;
//        getSupportLoaderManager().initLoader(LOADER_ID,null,callback);
//        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
    }

//    @Override
//    public Loader<String> onCreateLoader(int i, Bundle bundle) {
//        return new AsyncTaskLoader<String>(this) {
//
//            String joke = null;
//            private MyApi myApiService = null;
//
//
//            @Override
//            protected void onStartLoading() {
//                forceLoad();
//            }
//
//            @Override
//            public String loadInBackground() {
//                if(myApiService == null) {  // Only do this once
//                    MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                            new AndroidJsonFactory(), null)
//                            // options for running against local devappserver
//                            // - 10.0.2.2 is localhost's IP address in Android emulator
//                            // - turn off compression when running against local devappserver
//                            .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                            .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                                @Override
//                                public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                                    abstractGoogleClientRequest.setDisableGZipContent(true);
//                                }
//                            });
//                    // end options for devappserver
//
//                    myApiService = builder.build();
//                }
//
//                try {
//                    return myApiService.sayHi("test").execute().getData();
//                } catch (IOException e) {
//                    return e.getMessage();
//                }
//            }
//        };
//    }
//
//    @Override
//    public void onLoadFinished(Loader<String> loader, String joke) {
//        Intent intent = new Intent(MainActivity.this, DisplayJokeActivity.class);
//        intent.putExtra(DisplayJokeActivity.JOKE_INTENT, joke);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//    }
//
//    @Override
//    public void onLoaderReset(Loader<String> loader) {
//
//    }


}
