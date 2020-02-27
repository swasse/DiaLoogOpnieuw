package be.ehb.dialoogopnieuw.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import be.ehb.dialoogopnieuw.R;

/**
 * Created by Banaan on 20/01/2038. ;)
 */
public class SimpleDialogFragment extends DialogFragment {


    private DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(getActivity(), "Thanks for rating us, your data is safe with us.", Toast.LENGTH_LONG).show();
        }
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Kebapp");
        builder.setMessage("Please rate us on Google Play");
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.setPositiveButton(android.R.string.ok, okListener);

        return builder.create();
    }
}
