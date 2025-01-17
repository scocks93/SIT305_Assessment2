package com.example.assessment2;

import android.content.Context;
import android.content.Intent;
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

        budgetEditAmount = (EditText) view.findViewById(R.id.budgetEditAmount);
        budgetEdit = (Button) view.findViewById(R.id.budgetEdit);

        // Change the allocated budget to the entered amount on click of edit button
        budgetEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newBudget = budgetEditAmount.getText().toString();
                Intent budgetIntent = new Intent(getActivity(), OverviewActivity.class);
                budgetIntent.putExtra("ALLOCATED_BUDGET", newBudget);
                startActivity(budgetIntent);
            }
        });

        return view;
    }
}
