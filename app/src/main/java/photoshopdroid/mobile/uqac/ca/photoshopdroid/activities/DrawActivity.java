package photoshopdroid.mobile.uqac.ca.photoshopdroid.activities;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.pes.androidmaterialcolorpickerdialog.ColorPicker;
import com.pes.androidmaterialcolorpickerdialog.ColorPickerCallback;

import photoshopdroid.mobile.uqac.ca.photoshopdroid.R;
import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.SketchView;
import photoshopdroid.mobile.uqac.ca.photoshopdroid.dialogs.ThicknessDialogFragment;

public class DrawActivity extends AppCompatActivity {

    private SketchView sketch;
    private View viewColorPicker;
    private ImageView ivBrush;
    private ImageView ivDrawRectangles;
    private ImageView ivSelectShape;
    private ImageView ivThickness;
    private ImageView ivClearSketch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        sketch = (SketchView) findViewById(R.id.sketch);
        viewColorPicker = findViewById(R.id.viewColorPicker);
        ivBrush = (ImageView) findViewById(R.id.ivBrush);
        ivDrawRectangles = (ImageView) findViewById(R.id.ivDrawRectangles);
        ivSelectShape = (ImageView) findViewById(R.id.ivSelectShape);
        ivThickness = (ImageView) findViewById(R.id.ivThickness);
        ivClearSketch = (ImageView) findViewById(R.id.ivClearSketch);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        sketch.init(metrics);

        //pour plus de details, voir : https://github.com/Pes8/android-material-color-picker-dialog
        final ColorPicker cp = new ColorPicker(DrawActivity.this);

        cp.setCallback(new ColorPickerCallback() {
            @Override
            public void onColorChosen(@ColorInt int color) {
                sketch.setColor(color);
                viewColorPicker.setBackgroundColor(color);
                cp.dismiss();
            }
        });

        viewColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cp.show();
            }
        });

        viewColorPicker.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(), "Changer de couleur", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivBrush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sketch.setDrawingMode(SketchView.SketchMode.BRUSH);
                selectTool(ivBrush);
            }
        });

        ivBrush.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(), "Dessin à main levée", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivDrawRectangles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sketch.setDrawingMode(SketchView.SketchMode.RECTANGLE);
                selectTool(ivDrawRectangles);
            }
        });

        ivDrawRectangles.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(), "Dessiner des rectangles", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivClearSketch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog confirmClear = new AlertDialog.Builder(DrawActivity.this).create();
                confirmClear.setTitle("Voulez-vous vraiment effacer votre Sketch en cours ?");
                confirmClear.setButton(AlertDialog.BUTTON_NEGATIVE, "Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        confirmClear.dismiss();
                    }
                });
                confirmClear.setButton(AlertDialog.BUTTON_POSITIVE, "Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sketch.clear();
                        confirmClear.dismiss();
                    }
                });

                confirmClear.show();
            }
        });

        ivClearSketch.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(), "Effacer le Sketch", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivThickness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dfThickness = new ThicknessDialogFragment();
                dfThickness.show(getFragmentManager(), "");
            }
        });

        ivThickness.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(), "Changer l'épaisseur des tracés", Toast.LENGTH_SHORT).show();
                return true;
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

    private void selectTool(ImageView iv){
        ivBrush.setBackgroundColor(Color.TRANSPARENT);
        ivDrawRectangles.setBackgroundColor(Color.TRANSPARENT);
        ivClearSketch.setBackgroundColor(Color.TRANSPARENT);
        ivThickness.setBackgroundColor(Color.TRANSPARENT);

        switch (iv.getId()){
            case R.id.ivBrush:          ivBrush.setBackgroundColor(Color.parseColor("#CCCCCC"));            break;
            case R.id.ivDrawRectangles: ivDrawRectangles.setBackgroundColor(Color.parseColor("#CCCCCC"));   break;
            case R.id.ivClearSketch:    ivClearSketch.setBackgroundColor(Color.parseColor("#CCCCCC"));      break;
            case R.id.ivThickness:      ivThickness.setBackgroundColor(Color.parseColor("#CCCCCC"));        break;
        }
    }

}
