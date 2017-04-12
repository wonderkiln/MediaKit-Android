package social.gogopop.mediakit;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.webp.libwebp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class MKWebP {

    private Bitmap bitmap;

    public MKWebP(InputStream inputStream) {
        byte[] bytes = null;
        try {
            bytes = readInputStream(inputStream);
        } catch (IOException e) {
            Log.e("Flurgle", e.toString());
        }


        if (bytes != null) {
            bitmap = webpToBitmap(bytes);
            Log.v("Flurgle", bitmap.getWidth() + " " + bitmap.getHeight());
        } else {
            Log.v("Flurgle", "bytes null");
        }
    }

    public Bitmap get() {
        return bitmap;
    }

    private byte[] readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        return buffer.toByteArray();
    }

    static{
        System.loadLibrary("webp");
    }

    private static Bitmap webpToBitmap(byte[] encoded) {
        int[] width = new int[] { 0 };
        int[] height = new int[] { 0 };
        byte[] decoded = libwebp.WebPDecodeARGB(encoded, encoded.length, width, height);

        int[] pixels = new int[decoded.length / 4];
        ByteBuffer.wrap(decoded).asIntBuffer().get(pixels);

        return Bitmap.createBitmap(pixels, width[0], height[0], Bitmap.Config.ARGB_8888);
    }

}
