package br.com.controleDeDespesas;

import android.content.Intent;
import android.os.*;
import android.view.View;
import android.widget.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.controleDeDespesas.adapter.*;
import br.com.controleDeDespesas.model.*;
import br.com.controleDeDespesas.singleton.*;
import br.com.controleDeDespesas.util.*;

import static br.com.controleDeDespesas.util.Utils.doubleToCurrencyPtBR;

public class MainActivity extends AppCompatActivity {

    protected Button                        btnCreateExpense;
    protected ListView                      lstvExpenses;
    protected final int                     CRUD_EXPENSE = 100;
    protected ExpenseToExpenseItemAdapter   expenseAdapter;
    protected TextView                      txtTotalExpenses;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CRUD_EXPENSE && resultCode == ExpenseCrud.OK) {
            showAllExpenses();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
        configureClickListeners();
        showAllExpenses();
    }
    private void initializeComponents() {
        btnCreateExpense = (Button) findViewById(R.id.btnCreateExpense);
        lstvExpenses = findViewById(R.id.lstvExpenses);
        txtTotalExpenses = findViewById(R.id.txtTotalExpenses);
    }
    private void configureClickListeners() {
        btnCreateExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExpenseCrud.class);
                startActivityForResult(intent, CRUD_EXPENSE);
            }
        });

        lstvExpenses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Expense expense = (Expense) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, ExpenseCrud.class);
                intent.putExtra("expense", expense);
                startActivityForResult(intent, CRUD_EXPENSE);
            }
        });
    }
    protected void fillTotalExpenses(List<Expense> expenses) {
        Double total = 0.00;
        for (Expense expense :
                expenses) {
            total += expense.getValue();
        }
        txtTotalExpenses.setText("TOTAL: " + doubleToCurrencyPtBR(total));
    }
    protected void showAllExpenses() {
        new AsyncTask<Void, Void, List<Expense>>() {

            @Override
            protected List<Expense> doInBackground(Void... voids) {
                AppDatabase db = SingletonDatabase.getInstace(MainActivity.this);
                List<Expense> expenses = db.expenseDAO().getAllExpenses();
                return expenses;
            }

            @Override
            protected void onPostExecute(List<Expense> expenses) {
                super.onPostExecute(expenses);
                expenseAdapter = new ExpenseToExpenseItemAdapter(expenses, MainActivity.this);
                lstvExpenses.setAdapter(expenseAdapter);
                fillTotalExpenses(expenses);
            }
        }.execute();
    }
}