package br.com.caspinheiro.aulas.agendacontatos.model;

import androidx.room.Embedded;
import androidx.room.Relation;

public class ContatoComTipo
{
    @Embedded
    private Contato contato;

    @Relation(  entityColumn = "cd_tipo_contato", parentColumn = "cd_tipo_contato")
    private TipoContato tipoContato;

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }
}
