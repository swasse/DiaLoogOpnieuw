package be.ehb.dialoogopnieuw.ui;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import be.ehb.dialoogopnieuw.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    private View.OnClickListener toastListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), "Hello Toast", Toast.LENGTH_SHORT).show();
        }
    };
    private View.OnClickListener simpleListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new SimpleDialogFragment().show(getParentFragmentManager(), "sdf");
        }
    };
    private View.OnClickListener fluListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new FluDialogFragment().show(getParentFragmentManager(), "fdf");
        }
    };
    private View.OnClickListener dateListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new DateOfBirthDialogFragment().show(getParentFragmentManager(), "dobdf");
        }
    };
    private View.OnClickListener snackListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar snackbar = Snackbar.make(rootView.findViewById(R.id.frag_container),
                    "Warum? Durum!",
                    Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("Gefaald", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //ok dan
                }
            });
            snackbar.setActionTextColor(Color.CYAN);

            snackbar.show();
        }
    };
    private View rootView;

    public MainFragment() {
        // Required empty public constructor
    }

//early optimalisation is the root all evil
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button btnToast = rootView.findViewById(R.id.btn_toast);
        btnToast.setOnClickListener(toastListener);

        Button btnSimple = rootView.findViewById(R.id.btn_simple);
        btnSimple.setOnClickListener(simpleListener);

        Button btnFlu = rootView.findViewById(R.id.btn_flu);
        btnFlu.setOnClickListener(fluListener);

        Button btnDate = rootView.findViewById(R.id.btn_date);
        btnDate.setOnClickListener(dateListener);

        FloatingActionButton fabSnackBar = rootView.findViewById(R.id.fab_snackbar);
        fabSnackBar.setOnClickListener(snackListener);

        return rootView;
    }

}
