package br.com.caspinheiro.aulas.agendacontatos.util;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import br.com.caspinheiro.aulas.agendacontatos.dao.ContatoDAO;
import br.com.caspinheiro.aulas.agendacontatos.dao.TipoContatoDAO;
import br.com.caspinheiro.aulas.agendacontatos.model.Contato;
import br.com.caspinheiro.aulas.agendacontatos.model.TipoContato;

@Database(entities = {Contato.class, TipoContato.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContatoDAO contatoDAO();
    public abstract TipoContatoDAO tipoContatoDAO();
}
