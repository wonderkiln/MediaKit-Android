package social.gogopop.mediakit.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import social.gogopop.mediakit.MKWebP;
import social.gogopop.mediakit.MediaKit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaKit.init(this);

        try {
            MKWebP webp = new MKWebP(getAssets().open("test.webp"));
            ((ImageView) findViewById(R.id.imageView)).setImageBitmap(webp.get());
        } catch (Exception e) {

        }

    }
}
