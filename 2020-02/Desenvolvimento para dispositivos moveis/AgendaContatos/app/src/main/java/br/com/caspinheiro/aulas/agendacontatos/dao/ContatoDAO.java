package br.com.caspinheiro.aulas.agendacontatos.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import br.com.caspinheiro.aulas.agendacontatos.model.Contato;
import br.com.caspinheiro.aulas.agendacontatos.model.ContatoComTipo;

@Dao
public interface ContatoDAO {

    @Insert
    void insert(Contato contato);

    @Update
    void update(Contato contato);

    @Delete
    void delete(Contato contato);

    @Query("SELECT * FROM tb_contato ORDER BY nm_contato")
    List<ContatoComTipo> listarTodos();
}
