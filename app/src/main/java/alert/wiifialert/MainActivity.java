package alert.wiifialert;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void scanforwifi(View view) {
        NetworkInfo wifiCheck;
        TextView textView = findViewById(R.id.ssid);
        ConnectivityManager connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        wifiCheck = connectionManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService (Context.WIFI_SERVICE);
        WifiInfo info = wifiManager.getConnectionInfo();
        int state =wifiManager.getWifiState();

        String ssid  = info.getSSID();




        if(wifiCheck.isConnected()) {
            textView.setText("Connected to " + ssid);

            android.widget.Toast.makeText(this, "Wifi is connected", Toast.LENGTH_LONG).show();
        }
        else {
            textView.setText("Not connected to any network");
            android.widget.Toast.makeText(this, "Wifi is not connected", Toast.LENGTH_LONG).show();
        }
        //SystemClock.sleep(5000);



    }
}
