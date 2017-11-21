package photoshopdroid.mobile.uqac.ca.photoshopdroid;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class SketchView extends View {

    public SketchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Random rand = new Random();
        canvas.drawRGB(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    public void changeColor() {
        invalidate(); // redraws the view calling onDraw()
    }
}
