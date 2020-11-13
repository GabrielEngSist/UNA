package br.com.controleDeDespesas.dao;

import androidx.room.*;

import java.util.List;

import br.com.controleDeDespesas.model.Expense;

@Dao
public interface ExpenseDAO {
    @Insert
    void insert(Expense expense);

    @Update
    void update(Expense expense);

    @Delete
    void delete(Expense expense);

    @Query("SELECT * FROM expenses ORDER BY id")
    List<Expense> getAllExpenses();
}
