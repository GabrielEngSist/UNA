package br.com.caspinheiro.aulas.agendacontatos.model;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_contato")
public class Contato implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cd_contato")
    protected Integer codigo;

    @ColumnInfo(name = "nm_contato")
    protected String nome;

    @ColumnInfo(name = "ds_email")
    protected String email;

    @ColumnInfo(name = "nu_telefone")
    protected String telefone;

    @ColumnInfo(name = "nu_telefone_celular")
    protected String telefoneCelular;

    @ColumnInfo(name = "cd_tipo_contato")
    protected Integer codigoTipoContato;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public Integer getCodigoTipoContato() {
        return codigoTipoContato;
    }

    public void setCodigoTipoContato(Integer codigoTipoContato) {
        this.codigoTipoContato = codigoTipoContato;
    }
}


