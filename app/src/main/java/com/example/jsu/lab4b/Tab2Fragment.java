package com.example.jsu.lab4b;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2Fragment extends Fragment implements View.OnClickListener{

    public static final double KM_TO_MILE = 0.6214;
    public static final double MILE_TO_KM = 1.609;

    private EditText mileInput;
    private EditText kilometerInput;


    public Tab2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_tab2,container,false);

        mileInput = (EditText) v.findViewById(R.id.mileInput);
        kilometerInput = (EditText)v.findViewById(R.id.kilometerInput);

        Button submit = (Button)v.findViewById(R.id.submitLengthConvert);
        submit.setOnClickListener(this);

        return v;
    }

    public void onClick(View v){
        String miles = mileInput.getText().toString();
        String kilometers = kilometerInput.getText().toString();

        if(miles.isEmpty()){
            if(!kilometers.isEmpty()){
                double k = Double.parseDouble(kilometers);
                double m = k * KM_TO_MILE;

                mileInput.setText(Double.toString(m));
            }
        }
        else{
            double m = Double.parseDouble(miles);
            double k = m * MILE_TO_KM;

            kilometerInput.setText(Double.toString(k));
        }
    }

}
