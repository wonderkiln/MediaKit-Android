package social.gogopop.mediakit;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;

public class MKCrop {

    private Rect rect;

    public MKCrop(Rect cropRect) {
        this.rect = cropRect;
    }

    public MKCrop(int x, int y, int width, int height) {
        this.rect = new Rect(x, y, x + width, y + height);
    }

    public Bitmap crop(Bitmap bitmap) {
        return Bitmap.createBitmap(
                bitmap,
                rect.left,
                rect.top,
                rect.right - rect.left,
                rect.bottom - rect.top
        );
    }

    public void crop(Bitmap bitmap, OnCroppedBitmapAvailableListener onCroppedBitmapAvailableListener) {
        new CropTask(rect, onCroppedBitmapAvailableListener).execute(bitmap);
    }

    public interface OnCroppedBitmapAvailableListener {
        void onCroppedBitmapAvailable(Bitmap bitmap);
    }

    private static class CropTask extends AsyncTask<Bitmap, Void, Bitmap> {

        private Rect rect;
        private OnCroppedBitmapAvailableListener onCroppedBitmapAvailableListener;

        public CropTask(Rect rect, OnCroppedBitmapAvailableListener onCroppedBitmapAvailableListener) {
            super();
            this.rect = rect;
            this.onCroppedBitmapAvailableListener = onCroppedBitmapAvailableListener;
        }

        @Override
        protected Bitmap doInBackground(Bitmap... bitmaps) {
            return new MKCrop(rect).crop(bitmaps[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            onCroppedBitmapAvailableListener.onCroppedBitmapAvailable(bitmap);
        }

    }

}
