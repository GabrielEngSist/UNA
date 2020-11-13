package br.com.controleDeDespesas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.*;
import android.view.View;
import android.widget.*;

import br.com.controleDeDespesas.model.*;
import br.com.controleDeDespesas.singleton.*;
import br.com.controleDeDespesas.util.*;

import static br.com.controleDeDespesas.util.Utils.*;

public class ExpenseCrud extends AppCompatActivity {

    protected EditText              txtDescription;
    protected EditText              txtExpenseValue;
    protected Button                btnSave;
    protected Button                btnCancel;
    protected Button                btnDelete;
    protected Expense               expense;
    public static final int         OK=1;
    public static final int         NOT_OK = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_crud);
        configureView();
    }

    private void configureView() {
        initializeFields();
        configureIntent();
        configureButtons();
    }

    private void initializeFields() {
        txtDescription  = findViewById(R.id.txtDescription);
        txtExpenseValue = findViewById(R.id.txtExpenseValue);
        btnSave         = findViewById(R.id.btnSave);
        btnCancel       = findViewById(R.id.btnCancel);
        btnDelete       = findViewById(R.id.btnDelete);
        expense         = new Expense();
    }
    private void configureIntent() {
        Intent intent = getIntent();

        if(intent.hasExtra("expense")){
            expense = (Expense)intent.getSerializableExtra("expense");
            txtExpenseValue.setText(doubleToCurrencyPtBR(expense.getValue()));
            txtDescription.setText(expense.getDescription());
        }
    }
    private void configureButtons() {
        this.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(NOT_OK);
                ExpenseCrud.this.finish();
            }
        });

        this.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateExpense()) {
                    expense.setDescription(txtDescription.getText().toString());
                    expense.setValue(getDoubleFromString(txtExpenseValue.getText().toString()));
                    saveExpense(expense);
                }
            }
        });

        this.btnDelete.setOnClickListener(
               new View.OnClickListener(){
                   @Override
                   public void onClick(View v) {
                       deleteExpense(expense);
                   }
               }
        );
    }
    protected boolean validateExpense(){
        if(txtDescription.getText().toString().isEmpty()){
            Toast.makeText(ExpenseCrud.this,"A descrição é obrigatória",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(txtExpenseValue.getText().toString().isEmpty()){
            Toast.makeText(ExpenseCrud.this,"O valor é obrigatório!",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    protected void deleteExpense(Expense expense){
        new AsyncTask<Expense, Void, Boolean>(){
            @Override
            protected Boolean doInBackground(Expense... expenses){
                AppDatabase db = SingletonDatabase.getInstace(ExpenseCrud.this);
                db.expenseDAO().delete(expenses[0]);
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean){
                super.onPostExecute(aBoolean);
                ExpenseCrud.this.setResult(OK);
                ExpenseCrud.this.finish();
            }
        }.execute(expense);
    }
    protected void saveExpense(final Expense expense){
        new AsyncTask<Expense, Void, Boolean>(){

            @Override
            protected Boolean doInBackground(Expense... expenses){
                AppDatabase db = SingletonDatabase.getInstace(ExpenseCrud.this);
                if(expenses[0].getId() == null){
                    db.expenseDAO().insert(expenses[0]);
                }else{
                    db.expenseDAO().update(expenses[0]);
                }

                return true;
            }
            @Override
            protected void onPostExecute(Boolean aBoolean){
                super.onPostExecute(aBoolean);
                ExpenseCrud.this.setResult(OK);
                ExpenseCrud.this.finish();
            }
        }.execute(expense);

        }
    }
