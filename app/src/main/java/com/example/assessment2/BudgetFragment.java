package com.example.assessment2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BudgetFragment extends Fragment {

    TextView budgetAllocated;
    EditText budgetEditAmount;
    Button budgetEdit;
    SharedPreferences sharedPref;
    String SAVED_BUDGET;
    String savedBudget;


    public BudgetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Budget");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_budget, container, false);

        budgetAllocated = (TextView) view.findViewById(R.id.budgetAllocated);
        budgetEditAmount = (EditText) view.findViewById(R.id.budgetEditAmount);
        budgetEdit = (Button) view.findViewById(R.id.budgetEdit);

        sharedPref = getActivity().getSharedPreferences("com.example.assessment2", Context.MODE_PRIVATE);
        // Get the saved budget from shared preferences and append it to the budgetAllocated TextView
        savedBudget = sharedPref.getString(SAVED_BUDGET, "failed");
        budgetAllocated.setText("$" + savedBudget);

        // Change the allocated budget to the entered amount on click of edit button
        budgetEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newBudget = budgetEditAmount.getText().toString();
                budgetAllocated.setText("$" + newBudget);
            }
        });

        return view;
    }
}
