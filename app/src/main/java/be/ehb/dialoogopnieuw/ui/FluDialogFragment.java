package be.ehb.dialoogopnieuw.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

/**
 * Created by Banaan on 20/01/2038. ;)
 */
public class FluDialogFragment extends DialogFragment {

    String[] flues = {"Vanilla Flu", "Corona", "Spanish flu", "Sars"};
    private DialogInterface.OnClickListener itemSelectListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(getActivity(), "you caught " + flues[i] , Toast.LENGTH_SHORT  ).show();
        }
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Gotta catch 'em all");
        builder.setItems(flues, itemSelectListener);
        builder.setNegativeButton(android.R.string.cancel, null);

        return builder.create();
    }
}
