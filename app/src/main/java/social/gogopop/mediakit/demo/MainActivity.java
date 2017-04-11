package social.gogopop.mediakit.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import social.gogopop.mediakit.MediaKit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaKit.init(this);
    }
}
