package alert.wiifialert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class MainActivity extends AppCompatActivity {
   // NetworkInfo wifiCheck;
    TextView textView = findViewById(R.id.ssid);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //wifiCheck = connectionManager.
    }

    public void scanforwifi(View view) {
        //ConnectivityManager connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        //wifiCheck = connectionManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        if(wifiCheck.isConnected())
//        {
//            textView.setText("IS CONNECTED");
//        }
//        else
//            textView.setText("NOT CONNECTED");
//
//        //textView.setText("works!!");

    }
}
