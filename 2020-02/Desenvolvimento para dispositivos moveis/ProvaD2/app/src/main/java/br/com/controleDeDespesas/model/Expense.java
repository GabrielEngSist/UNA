package br.com.controleDeDespesas.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "expenses")
public class Expense implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")            protected Integer id;
    @ColumnInfo(name = "description")   protected String description;
    @ColumnInfo(name = "valor")         protected Double value;

    public Integer getId(){ return id; }
    public void setId(Integer id){ this.id = id; }
    public Double getValue() { return value; }
    public void setValue(Double valor) { this.value = valor; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}
