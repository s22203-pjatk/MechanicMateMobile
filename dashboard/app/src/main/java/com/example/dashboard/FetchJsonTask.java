package com.example.dashboard;

import android.os.AsyncTask;
import android.util.Log;

public class FetchJsonTask extends AsyncTask<String, Void, String> {
    private Listener listener;

    public FetchJsonTask(Listener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... urls) {
        HttpHandler sh = new HttpHandler();
        String jsonStr = sh.makeServiceCall(urls[0]);
        return jsonStr;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (listener != null) {
            listener.onResultReceived(result);
        }
    }

    public interface Listener {
        void onResultReceived(String result);
    }
}
