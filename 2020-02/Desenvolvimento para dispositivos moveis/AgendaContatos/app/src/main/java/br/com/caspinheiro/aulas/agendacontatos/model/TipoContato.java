package br.com.caspinheiro.aulas.agendacontatos.model;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_tipo_contato")
public class TipoContato implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "cd_tipo_contato")
    private Integer codigo;

    @ColumnInfo(name = "ds_tipo_contato")
    private String descricao;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
