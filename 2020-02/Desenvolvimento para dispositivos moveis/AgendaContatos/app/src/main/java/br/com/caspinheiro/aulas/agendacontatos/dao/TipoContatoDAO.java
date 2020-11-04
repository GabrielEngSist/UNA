package br.com.caspinheiro.aulas.agendacontatos.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;
import br.com.caspinheiro.aulas.agendacontatos.model.TipoContato;

@Dao
public interface TipoContatoDAO {

    @Query("SELECT * FROM tb_tipo_contato")
    List<TipoContato>listaTodos();

}
