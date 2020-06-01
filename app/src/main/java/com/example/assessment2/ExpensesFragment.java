package com.example.assessment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ExpensesFragment extends Fragment {

    Spinner expensesSpinner;
    Button groceriesAddButton;

    public ExpensesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Expenses");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expenses, container, false);

        groceriesAddButton = (Button) view.findViewById(R.id.groceriesAddButton);

        expensesSpinner = (Spinner) view.findViewById(R.id.expensesSpinner);
        // Create an array to hold the strings representing the different expenses
        String[] expenses = new String[]{"Groceries", "Travel", "Rent"};
        // Create an adapter to describe how they are displayed
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, expenses);
        // Set the spinner to use the adapter
        expensesSpinner.setAdapter(adapter);

        expensesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    // When Groceries is selected
                    case 0:
                        // Enable grocery button, pass value to overview and other totals
                        break;

                    // When Travel is selected
                    case 1:
                        // Enable travel button, pass value to overview and other totals
                        break;

                    // When Rent is selected
                    case 2:
                        // Enable rent button, pass value to overview and other totals
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                groceriesAddButton.setEnabled(false);
                groceriesAddButton.setVisibility(View.GONE);
                // travel button invisible
                // rent button invisible
            }
        });

        return view;
    }
}
