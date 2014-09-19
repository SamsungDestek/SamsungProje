package com.example.e2yazilim.samsungdestek;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;


public class QuestionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_question);
        Bundle extra = getIntent().getBundleExtra("bundle");
        Soru soru=(Soru)extra.getSerializable("soru");

        TextView tvBaslik=(TextView)findViewById(R.id.txtSoruBaslik);
        TextView tvIcerik=(TextView)findViewById(R.id.txtIcerik);
        TextView tvPuan=(TextView)findViewById(R.id.txtPuan);

        tvBaslik.setText(soru.getBaslik());
        tvIcerik.setText(soru.getIcerik());
        tvPuan.setText(Integer.toString(soru.getPuan()));

    }


    private class DownloadSoruJson extends AsyncTask<Void, Void, Void> {
        JSONArray jsonArray = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            String url = "http://android.e2yazilim.com/api/soru/";
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response;

            try {
                response = httpclient.execute(httpget);
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    InputStream instream = entity.getContent();
                    String result = ConvertStreamToString.convertStreamToString(instream);
                    jsonArray = new JSONArray(result);
                    instream.close();
                }
            } catch (ClientProtocolException e) {
                Log.e("Hata", e.getMessage());
            } catch (IOException e) {
                Log.e("Hata", e.getMessage());
            } catch (JSONException e) {
                Log.e("Hata", e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void str) {
           /* try {
                for (int i = 0; i < jsonArray.length(); ++i) {
                    Soru soru = new Soru();
                    soru.setId(Integer.parseInt(jsonArray.getJSONObject(i).getString("Id").toString()));
                    soru.setBaslik(jsonArray.getJSONObject(i).getString("Baslik").toString());
                    soru.setIcerik(jsonArray.getJSONObject(i).getString("Icerik").toString());
                    soru.setUyeId(Integer.parseInt(jsonArray.getJSONObject(i).getString("UyeId").toString()));
                    soru.setPuan(Integer.parseInt(jsonArray.getJSONObject(i).getString("Puan").toString()));
                    soru.setGoruntulenme(Integer.parseInt(jsonArray.getJSONObject(i).getString("Goruntulenme").toString()));
                    soru.setUyeAd(jsonArray.getJSONObject(i).getString("UyeAd").toString());
                    soru.setCevapSayi(Integer.parseInt(jsonArray.getJSONObject(i).getString("CevapSayi").toString()));
                    sorular.add(soru);
                }
                SorularAdapter adapter = new SorularAdapter(HomeActivity.this, sorular);
                lvSorular.setAdapter(adapter);
            } catch (JSONException e) {
                Log.e("Hata", e.getMessage());
            }*/
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.question, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
