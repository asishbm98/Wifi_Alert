package alert.wiifialert;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);


            IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
            registerReceiver(wifiStateReceiver, intentFilter);


    }


    public void fn(View view) {
        scanforwifi();
    }

    public void scanforwifi() {
        NetworkInfo wifiCheck;
        TextView textView = findViewById(R.id.ssid);
        ImageView imageView= (ImageView) findViewById(R.id.img);


        ConnectivityManager connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        wifiCheck = connectionManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService (Context.WIFI_SERVICE);
        WifiInfo info = wifiManager.getConnectionInfo();
        int state =wifiManager.getWifiState();

        String ssid  = info.getSSID();

        if(wifiCheck.isConnected()) {

            imageView.setImageResource(R.drawable.f);
            imageView.setImageResource(R.drawable.f);
            textView.setText("Connected to " + ssid);
            // android.widget.Toast.makeText(this, "Wifi is connected", Toast.LENGTH_LONG).show();
        }
        else {
            imageView.setImageResource(R.drawable.n_f);
            imageView.setImageResource(R.drawable.n_f);
            textView.setText("Not connected to any network");
            final MediaPlayer alert = MediaPlayer.create(this,R.raw.alert_);
            alert.start();

            // android.widget.Toast.makeText(this, "Wifi is not connected", Toast.LENGTH_LONG).show();
        }




    }

    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            scanforwifi();

        }
    };

}
