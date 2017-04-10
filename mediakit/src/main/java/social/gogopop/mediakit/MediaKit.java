package social.gogopop.mediakit;

import android.content.Context;

public class MediaKit {

    private static Context context;

    public static void init(Context context) {
        MediaKit.context = context.getApplicationContext();
    }

    static Context getContext() {
        return context;
    }

}
