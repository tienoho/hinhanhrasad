package viewhinh.tien.tienoho.loadhinh;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imgLoadHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgLoadHinh=(ImageView)findViewById(R.id.imageViewLoadHinh);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new LoadHinh().execute("https://scontent.fhan1-1.fna.fbcdn.net/v/t1.0-9/16508387_1183219341793647_2948138073667429802_n.jpg?oh=1a7b2276591da540eed6ef8ed657ce1f&oe=59B82A9C");
            }
        });
    }

    private class LoadHinh extends AsyncTask<String , Integer, String>{

        Bitmap bmp;
        @Override
        protected String doInBackground(String... params) {
            try {
                URL u=new URL(params[0]);
                bmp= BitmapFactory.decodeStream(u.openConnection().getInputStream());


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            imgLoadHinh.setImageBitmap(bmp);
            Toast.makeText(MainActivity.this,"Load Xong ",Toast.LENGTH_LONG).show();
            super.onPostExecute(s);
        }
    }
}
