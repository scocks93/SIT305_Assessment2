package com.example.assessment2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BankFragment extends Fragment {

    EditText amountToAdd;
    Button addToBalance;

    public BankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Bank");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bank, container, false);


        amountToAdd = (EditText) view.findViewById(R.id.amountToAdd);
        addToBalance = (Button) view.findViewById(R.id.addToBalance);
        addToBalance.setVisibility(View.VISIBLE);

        // When the add to balance button is clicked, pass the string to overview using intent
        addToBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newBalance = amountToAdd.getText().toString();
                Intent balanceIntent = new Intent(getActivity(), OverviewActivity.class);
                balanceIntent.putExtra("NEW_BALANCE", newBalance);
                startActivity(balanceIntent);
            }
        });


        return view;
    }

    public void closeFragment(View view) {
        getActivity().getFragmentManager().popBackStack();
    }
}
