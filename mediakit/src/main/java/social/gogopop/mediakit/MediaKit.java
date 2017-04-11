package social.gogopop.mediakit;

import android.content.Context;
import android.util.Log;

public class MediaKit {

    private static Context context;

    public static void init(Context context) {
        MediaKit.context = context.getApplicationContext();

        try {
            new MKWebP(context.getAssets().open("test.webp"));
        } catch (Exception e) {
            Log.e("Flurgle", e.toString());
        }
    }

    static Context getContext() {
        return context;
    }

}
