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
public class Tab3Fragment extends Fragment implements View.OnClickListener{

    private EditText fInput;
    private EditText cInput;

    public Tab3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_tab3,container,false);

        fInput = (EditText)v.findViewById(R.id.fInput);
        cInput = (EditText)v.findViewById(R.id.cInput);

        Button submit = (Button)v.findViewById(R.id.submitTempConvert);
        submit.setOnClickListener(this);

        return v;
    }

    public void onClick(View v){
        String fahrenheit = fInput.getText().toString();
        String celsius = cInput.getText().toString();

        if(fahrenheit.isEmpty()){
            if(!celsius.isEmpty()){
                double c = Double.parseDouble(celsius);
                double f = ((c * 9 / 5) + 32);

                fInput.setText(Double.toString(f));
            }
        }
        else{
            double f = Double.parseDouble(fahrenheit);
            double c = ((f - 32) * 5 / 9);

            cInput.setText(Double.toString(c));
        }
    }

}
