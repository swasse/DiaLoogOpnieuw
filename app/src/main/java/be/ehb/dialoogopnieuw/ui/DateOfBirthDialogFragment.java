package be.ehb.dialoogopnieuw.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Banaan on 20/01/2038. ;)
 */
public class DateOfBirthDialogFragment extends DialogFragment {

    private Calendar calendar;
    private Context mContext;

    private DatePickerDialog.OnDateSetListener dateSelectedListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            calendar.set(year, month, day);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String dateAsText = simpleDateFormat.format(calendar.getTime());

            Toast.makeText(getActivity(), dateAsText, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            mContext = context;
        }catch (RuntimeException re){
            throw new RuntimeException("Can only be opened in an Activity");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        calendar = Calendar.getInstance(Locale.getDefault());

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(mContext,dateSelectedListener, year, month, day);
    }
}
