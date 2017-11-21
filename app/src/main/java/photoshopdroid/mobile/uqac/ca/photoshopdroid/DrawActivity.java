package photoshopdroid.mobile.uqac.ca.photoshopdroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.pes.androidmaterialcolorpickerdialog.ColorPicker;
import com.pes.androidmaterialcolorpickerdialog.ColorPickerCallback;

public class DrawActivity extends AppCompatActivity {

    private Button btnColorPicker;
    private SketchView sketch;
    private Paint mPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        mPaint = new Paint();

        btnColorPicker = (Button) findViewById(R.id.btnColorPicker);
        sketch = (SketchView) findViewById(R.id.sketch);

        sketch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sketch.set
            }
        });

        final ColorPicker cp = new ColorPicker(DrawActivity.this);

        cp.setCallback(new ColorPickerCallback() {
            @Override
            public void onColorChosen(@ColorInt int color) {
                // Do whatever you want
                // Examples
                /*
                Log.d("Alpha", Integer.toString(Color.alpha(color)));
                Log.d("Red", Integer.toString(Color.red(color)));
                Log.d("Green", Integer.toString(Color.green(color)));
                Log.d("Blue", Integer.toString(Color.blue(color)));

                Log.d("Pure Hex", Integer.toHexString(color));
                Log.d("#Hex no alpha", String.format("#%06X", (0xFFFFFF & color)));
                Log.d("#Hex with alpha", String.format("#%08X", (0xFFFFFFFF & color)));*/

                //mPaint.setColor(color);
                sketch.setColor(color);
                sketch.invalidate();

                cp.dismiss();

            }
        });

        btnColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cp.show();
            }
        });

        //LinearLayout activityRootView = (LinearLayout) findViewById(R.id.draw_layout);
        //Rect r = new Rect();
        //activityRootView.getWindowVisibleDisplayFrame(r);
        //int screenHeight = r.bottom - r.top - toolbar.getHeight();
        //int screenWidth = r.width();

        //Bitmap mBitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        //Canvas mCanvas = new Canvas(mBitmap);
    }

}
