package br.com.controleDeDespesas.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.controleDeDespesas.model.Expense;
import br.com.controleDeDespesas.R;

import static br.com.controleDeDespesas.util.Utils.doubleToCurrencyPtBR;

public class ExpenseToExpenseItemAdapter extends BaseAdapter {

    private List<Expense> _expenses;
    private Activity _activity;

    public ExpenseToExpenseItemAdapter(List<Expense> expenses, Activity activity){
        this._expenses = expenses;
        this._activity = activity;
    }
    @Override
    public int getCount() {
        return this._expenses.size();
    }

    @Override
    public Expense getItem(int position) {
        return this._expenses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this._expenses.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view           = _activity.getLayoutInflater().inflate(R.layout.activity_expense_item,parent,false);
        Expense expense     = this._expenses.get(position);
        TextView descricao  = view.findViewById(R.id.txtDescription);
        TextView valor      = view.findViewById(R.id.txtExpenseValue);

        descricao.setText(expense.getDescription());
        valor.setText(doubleToCurrencyPtBR(expense.getValue()));

        return view;
    }
}
