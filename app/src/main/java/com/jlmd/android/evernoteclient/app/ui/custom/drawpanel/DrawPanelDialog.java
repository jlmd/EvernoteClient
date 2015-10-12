package com.jlmd.android.evernoteclient.app.ui.custom.drawpanel;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.Window;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jlmd.android.evernoteclient.R;

/**
 * @author jlmd
 */
public class DrawPanelDialog extends Dialog {

  @Bind(R.id.drawing_panel_view) protected DrawingPanelView drawingPanelView;
  private Callback callback;

  public DrawPanelDialog(Context context, Callback callback) {
    super(context);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.draw_text_view);
    ButterKnife.bind(this);
    this.callback = callback;
  }

  @OnClick(R.id.tv_cancel)
  public void onCancelClick() {
    cancel();
  }

  @OnClick(R.id.tv_ok)
  public void onOkClick() {
    sendBitmap();
    cancel();
  }

  private void sendBitmap() {
    if (callback != null) {
      callback.onBitmapCreated(drawingPanelView.getBitmap());
    }
  }

  public interface Callback {

    void onBitmapCreated(Bitmap bitmap);
  }
}
