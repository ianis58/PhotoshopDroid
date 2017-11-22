package photoshopdroid.mobile.uqac.ca.photoshopdroid.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;

import photoshopdroid.mobile.uqac.ca.photoshopdroid.R;
import photoshopdroid.mobile.uqac.ca.photoshopdroid.classes.SketchView;

public class ThicknessDialogFragment extends DialogFragment {

    private SketchView sketch;
    private SeekBar thicknessSeekBar;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        sketch = (SketchView) getActivity().findViewById(R.id.sketch);
        int oldThickness = sketch.getThickness();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View thicknessDialogLayoutView = inflater.inflate(R.layout.thickness_dialog_layout, null);

        thicknessSeekBar = (SeekBar) thicknessDialogLayoutView.findViewById(R.id.thicknessSeekBar);
        thicknessSeekBar.setProgress(oldThickness);

        builder.setMessage("Sélectionner l'épaisseur des tracés:")
                .setView(thicknessDialogLayoutView)
                .setPositiveButton("Appliquer", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        sketch.setThickness(thicknessSeekBar.getProgress());
                        dismiss();
                    }
                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dismiss();
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
