package com.example.assessment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    Integer[] imageList = {R.drawable.bankicon, R.drawable.budgeticon, R.drawable.expensesicon, R.drawable.helpicon};
    String[] itemNameList = {"Bank", "Budget", "Expenses", "Help"};

    RecyclerView menuItemRecyclerView;
    MenuItemAdapter menuItemAdapter;
    List<MenuItem> itemList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("Menu");

        menuItemRecyclerView = findViewById(R.id.menuItemRecyclerView);
        // Create adapter to pass in the data
        menuItemAdapter = new MenuItemAdapter(itemList, MenuActivity.this);
        // Attach the adapter to the recycler view to populate the items
        menuItemRecyclerView.setAdapter(menuItemAdapter);
        // Set layout manager to position the items
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        menuItemRecyclerView.setLayoutManager(layoutManager);

        // Populate the recycler view list
        for (int i = 0; i < imageList.length; i++) {
            int image = imageList[i];
            String name = itemNameList[i];

            com.example.assessment2.MenuItem menuItem = new com.example.assessment2.MenuItem(i, image, name);
            itemList.add(menuItem);
        }

        // Hide the fragment initially
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment frag = fragmentManager.findFragmentById(R.id.menuItemFragment);
        fragmentTransaction.hide(frag);
        fragmentTransaction.commit();

        menuItemAdapter.setOnItemClickListener(new MenuItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Fragment frag;
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                frag = fragmentManager.findFragmentById(R.id.menuItemFragment);
                fragmentTransaction.show(frag);

                switch (position) {
                    case 0:
                        //display the Bank fragment
                        frag = new BankFragment();
                        break;
                    case 1:
                        // display the Budget Fragment
                        frag = new BudgetFragment();
                        break;
                    case 2:
                        // display the Expenses Fragment
                        frag = new ExpensesFragment();
                        break;
                    case 3:
                        // display the Help fragment
                        frag = new HelpFragment();
                        break;
                }

                fragmentTransaction.replace(R.id.menuItemFragment, frag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}
