package photoshopdroid.mobile.uqac.ca.photoshopdroid;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;

public class DrawActivity extends AppCompatActivity {

    private GridView toolbar;
    private SketchView sketch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        toolbar = (GridView) findViewById(R.id.gridToolbar);
        sketch = (SketchView) findViewById(R.id.sketch);

        sketch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sketch.changeColor();
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
