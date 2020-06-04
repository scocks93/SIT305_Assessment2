package com.example.assessment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OverviewActivity extends AppCompatActivity {

    String currentBalance, allocatedBudget, groceries, travel, rent;
    String savedBudget;
    String SAVED_BUDGET;
    TextView overviewCurrentBalance, overviewAllocatedBudget, overviewGroceries, overviewTravel, overviewRent;
    Button menuButton;
    SharedPreferences budgetSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        setTitle("Overview");

//        // Use shared preferences to save the value
//        budgetSharedPref = this.getSharedPreferences("com.example.assessment2", Context.MODE_PRIVATE);
//        // Get the saved budget value from shared preferences and append it to the text view
//        savedBudget = budgetSharedPref.getString(SAVED_BUDGET, "failed");
//        overviewCurrentBalance.setText("$" + savedBudget);

//        // Get entered bank balance, display in corresponding text view
//        overviewCurrentBalance = (TextView) findViewById(R.id.overviewCurrentBalance);
//        Intent balanceIntent = getIntent();
//        currentBalance = balanceIntent.getStringExtra("CURRENT_BALANCE");
//        overviewCurrentBalance.setText("$" + currentBalance);

        // Get allocated budget, display in corresponding text view
        overviewAllocatedBudget = (TextView) findViewById(R.id.overviewAllocatedBudget);
        //overviewAllocatedBudget.setText("$0.1");
        Intent budgetIntent = getIntent();
        allocatedBudget = budgetIntent.getStringExtra("ALLOCATED_BUDGET");
        overviewAllocatedBudget.setText("$" + allocatedBudget);

        // Get groceries expense, display in corresponding text view
        overviewGroceries = (TextView) findViewById(R.id.overviewGroceries);
        Intent groceriesIntent = getIntent();
        groceries = groceriesIntent.getStringExtra("GROCERIES_EXPENSE");
        overviewGroceries.setText("$" + groceries);

        // Get travel expense, display in corresponding text view
        overviewTravel = (TextView) findViewById(R.id.overviewTravel);
        Intent travelIntent = getIntent();
        travel = travelIntent.getStringExtra("TRAVEL_EXPENSE");
        overviewTravel.setText("$" + travel);

        // Get rent expense, display in corresponding text view
        overviewRent = (TextView) findViewById(R.id.overviewRent);
        Intent rentIntent = getIntent();
        rent = rentIntent.getStringExtra("RENT_EXPENSE");
        overviewRent.setText("$" + rent);

        menuButton = (Button) findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the menu
                Intent intent = new Intent(OverviewActivity.this, MenuActivity.class);
                startActivity(intent);

                // Save the current values so they can be displayed next time the activity is created
                //budgetSharedPref.edit().putString(SAVED_BUDGET, overviewAllocatedBudget.getText().toString()).apply();
            }
        });
    }

//    public void menuClick(View view) {
//        Intent intent = new Intent(this, MenuActivity.class);
//        startActivity(intent);
//    }

    public void logOutClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
