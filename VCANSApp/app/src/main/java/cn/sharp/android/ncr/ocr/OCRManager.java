package cn.sharp.android.ncr.ocr;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.PopupWindow;
import cn.sharp.android.ncr.MessageId;
import cn.sharp.android.ncr.image.PgmImage;

public class OCRManager {

	private static final String TAG = "OCRManager";
	public static final String OCR_ITEMS = "ocritems";
	private Handler handler;
	public native int[] native_ncr(NativeOCRItems items, byte[] pgmContent,
			int width, int height);

	public native int[] native_ncr_from_jpeg(NativeOCRItems items,
			byte[] jpegData);

	public OCRManager() {
	}

	public OCRManager(Handler handler) {
		this.handler = handler;
	}

	public synchronized void startRecNamecard(PgmImage pgmImage, Handler handler) {
		PgmOCRThread thread = new PgmOCRThread(pgmImage, handler);
		thread.start();
		Log.e(TAG, "ocr thread started");
	}

	public OCRItems rec(PgmImage pgmImage) {
		return doRec(pgmImage);
	}


	private OCRItems doRec(PgmImage pgmImage) {
		NativeOCRItems nativeOCRItems = new NativeOCRItems();
		int[] fieldLength = native_ncr(nativeOCRItems, pgmImage.getContent(),
				pgmImage.getWidth(), pgmImage.getHeight());
		if (fieldLength == null) {
			Log.e(TAG, "rec failure");
			return null;
		} else {
			Log.e(TAG, "rec success");
			OCRItems ocrItems = new OCRItems(nativeOCRItems, fieldLength);
			return ocrItems;
		}
	}

	public OCRItems rec(byte[] jpeg) {
		if (jpeg == null) {
			return null;
		}
		return doRec(jpeg);
	}

	private OCRItems doRec(byte[] jpeg) {
		NativeOCRItems nativeOcrItems = new NativeOCRItems();
		int[] fieldLength = native_ncr_from_jpeg(nativeOcrItems, jpeg);
		if (fieldLength == null) {
			Log.e(TAG, "rec failure");
			return null;
		} else {
			Log.d(TAG, "rec success");
			OCRItems ocrItems = new OCRItems(nativeOcrItems, fieldLength);
			return ocrItems;
		}
	}

	private class PgmOCRThread extends Thread {
		private PgmImage pgmImage;
		private Handler handler;

		public PgmOCRThread(PgmImage pgmImage, Handler handler) {
			this.pgmImage = pgmImage;
			this.handler = handler;
		}

		@Override
		public void run() {
			OCRItems ocrItems = doRec(pgmImage);
			if (ocrItems == null) {
				Log.e(TAG, "rec failure");
				if (handler != null) {
					Message msg = new Message();
					msg.what = MessageId.NAMECARD_REC_FAILURE;
					handler.sendMessage(msg);
				}
			} else {
				Log.d(TAG, "rec success");
				if (handler != null) {
					Message msg = new Message();
					msg.what = MessageId.NAMECARD_REC_SUCCESS;
					msg.obj = ocrItems;
					handler.sendMessage(msg);
				}
			}
		}
	};

	static {
		System.loadLibrary("namecardrec");
	}
}
