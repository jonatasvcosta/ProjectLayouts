package com.example.taqtile.onboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by taqtile on 1/6/16.
 */
public class ListAdapter extends ArrayAdapter<User.info> {
    private Context context;
    private List<User.info> lista_dados = null;
    public ListAdapter(Context context,  List<User.info> lista_dados) {
        super(context,0, lista_dados);
        this.lista_dados = lista_dados;
        this.context = context;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent){
        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item_lista, null);
        ImageView marcador = (ImageView) view.findViewById(R.id.bolinha);
        TextView id_item = (TextView) view.findViewById(R.id.item_id);
        TextView texto_item = (TextView) view.findViewById(R.id.texto_item);
        //texto_item.setText(lista_dados.get(position).first_name+" "+lista_dados.get(position).last_name);
        //id_item.setText("ID: "+position);

        return view;
    }

}
