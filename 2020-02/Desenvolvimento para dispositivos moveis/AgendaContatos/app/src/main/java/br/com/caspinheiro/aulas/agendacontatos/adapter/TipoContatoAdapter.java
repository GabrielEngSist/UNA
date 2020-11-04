package br.com.caspinheiro.aulas.agendacontatos.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.caspinheiro.aulas.agendacontatos.R;
import br.com.caspinheiro.aulas.agendacontatos.model.Contato;
import br.com.caspinheiro.aulas.agendacontatos.model.TipoContato;

public class TipoContatoAdapter extends BaseAdapter {
    protected List<TipoContato> tipoContatoList;
    protected Activity context;

    public TipoContatoAdapter(Activity context, List<TipoContato> tipoContatoList) {
        this.tipoContatoList = tipoContatoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tipoContatoList.size();
    }

    @Override
    public Object getItem(int position) {
        return tipoContatoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tipoContatoList.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) context.getLayoutInflater().inflate(android.R.layout.simple_spinner_dropdown_item,
            parent, false);

        textView.setText( tipoContatoList.get(position).getDescricao() );
        return textView;
    }

}
