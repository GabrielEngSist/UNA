package br.com.controleDeDespesas.util;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.com.controleDeDespesas.dao.ExpenseDAO;
import br.com.controleDeDespesas.model.Expense;

@Database(entities = {Expense.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ExpenseDAO expenseDAO();
}
