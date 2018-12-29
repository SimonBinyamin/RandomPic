package your.free.online.randompic;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayMsg(String  msg){
        TextView textView = (TextView)findViewById(R.id.txt1);
        textView.setText(msg);
    }

    public void onRandom(View v) {
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
    }



    private class MyAsyncTask extends AsyncTask<Void, String, Void> {
        @Override
        protected Void doInBackground(Void... params) {

            for (int i = 0; i < 7000; i++) {

                publishProgress(
                        String.valueOf(i)
                );
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {

            super.onProgressUpdate(values);

            String msg = "";
            for (String str : values) {
                msg+=str + ",";
            }
            displayMsg(msg);

        }
    }
}
