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
public class Tab1Fragment extends Fragment implements View.OnClickListener {

    private EditText totalBillInput;
    private EditText tipPercentageInput;
    private EditText numPeopleInput;
    private TextView totalOutput;
    private Button submit;


    public Tab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_tab1,container,false);

        totalBillInput = (EditText)v.findViewById(R.id.totalBillInput);
        tipPercentageInput = (EditText)v.findViewById(R.id.tipPercentageInput);
        numPeopleInput = (EditText)v.findViewById(R.id.numPeopleInput);
        totalOutput = (TextView)v.findViewById(R.id.totalOutput);

        submit = (Button)v.findViewById(R.id.submitTipCalculate);
        submit.setOnClickListener(this);

        return v;
    }

    public void onClick(View v){
        String totalBillString = totalBillInput.getText().toString();
        String tipPercentageString = tipPercentageInput.getText().toString();
        String numPeopleString = numPeopleInput.getText().toString();

        double totalBill = 0;
        int tipPercentage = 0;
        int numPeople = 1;

        if(!totalBillString.isEmpty())
            totalBill = Double.parseDouble(totalBillString);
        if(!tipPercentageString.isEmpty())
            tipPercentage = Integer.parseInt(tipPercentageString);
        if(!numPeopleString.isEmpty())
            numPeople = Integer.parseInt(numPeopleString);

        if(numPeople > 0){
            double tipTotal = totalBill * tipPercentage / 100;
            double groupTotal = totalBill + tipTotal;
            double individualTotal = groupTotal / numPeople;

            String total = "$" + String.format("%.2f",individualTotal);

            String output = "Cost Per Person: " + total;

            totalOutput.setText(output);
        }

       /* if((!totalBillString.isEmpty()) && (!tipPercentageString.isEmpty()) && (!numPeopleString.isEmpty())){

            double totalBill = Double.parseDouble(totalBillString);
            int tipPercentage = Integer.parseInt(tipPercentageString);
            int numPeople = Integer.parseInt(numPeopleString);

            if(numPeople > 0){
                double tipTotal = totalBill * tipPercentage / 100;
                double groupTotal = totalBill + tipTotal;
                double individualTotal = groupTotal / numPeople;

                String output = "$" + String.format("%.2f",individualTotal);

                totalOutput.setText(output);
            }
        }*/
    }
}
