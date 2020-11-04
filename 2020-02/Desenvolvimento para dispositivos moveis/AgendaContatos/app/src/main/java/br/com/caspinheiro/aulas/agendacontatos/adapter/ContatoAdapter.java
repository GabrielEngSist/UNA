package br.com.caspinheiro.aulas.agendacontatos.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.caspinheiro.aulas.agendacontatos.R;
import br.com.caspinheiro.aulas.agendacontatos.model.Contato;
import br.com.caspinheiro.aulas.agendacontatos.model.ContatoComTipo;

public class ContatoAdapter extends BaseAdapter {

    private List<ContatoComTipo> contatos;
    private Activity activity;

    public ContatoAdapter(List<ContatoComTipo> contatos, Activity activity) {
        this.contatos = contatos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return contatos.size();
    }

    @Override
    public Object getItem(int position) {
        return contatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contatos.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = activity.getLayoutInflater().inflate(R.layout.item_contato,
            parent, false);

        TextView txtNome = v.findViewById(R.id.txtNome);

        TextView txtTipoContato = v.findViewById(R.id.txtTipoContato);
        TextView txtEmail = v.findViewById(R.id.txtEmail);
        TextView txtTelefone = v.findViewById(R.id.txtTelefone);
        TextView txtTelefoneCelular = v.findViewById(R.id.txtTelefoneCelular);

        ContatoComTipo contatoComTipo = contatos.get(position);
        txtNome.setText(contatoComTipo.getContato().getNome());
        txtTipoContato.setText(  contatoComTipo.getTipoContato() != null ?  contatoComTipo.getTipoContato().getDescricao() : "");
        txtEmail.setText(contatoComTipo.getContato().getEmail());
        txtTelefone.setText(contatoComTipo.getContato().getTelefone());
        txtTelefoneCelular.setText(contatoComTipo.getContato().getTelefoneCelular());

        return v;
    }
}
