package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class JokeEndpointsAsyncTask extends AsyncTask<Void, Void, String>  {

    private static MyApi myApiService = null;
    private JokeEndpointsAsyncTaskListener mListener = null;

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            myApiService = builder.build();
        }

        try {
            return myApiService.makeAJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public JokeEndpointsAsyncTask setListener(JokeEndpointsAsyncTaskListener listener) {
        this.mListener = listener;
        return this;
    }


    @Override
    protected void onPostExecute(String result) {
        if(this.mListener != null) {
            mListener.onComplete(result);
        }
    }

    public static interface JokeEndpointsAsyncTaskListener {
        public void onComplete(String result);
    }
}
