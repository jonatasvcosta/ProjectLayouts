package com.example.taqtile.myapplication.activities;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.taqtile.myapplication.R;

import java.util.ArrayList;

public class CustomDrawerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView listView = (ListView) findViewById(R.id.left_drawer);
        String[] drawerItens = {"Home", "Energia Livre", "Adversidade Amiga", "GEN Vitória", "Foco", "Grupos", "Ajuda", "Configurações"};
        int [] drawerImgIds = {R.drawable.ic_drawer_home, R.drawable.ic_drawer_energia_livre, R.drawable.ic_drawer_ada, R.drawable.ic_drawer_gen_vitoria, R.drawable.ic_drawer_foco, R.drawable.ic_drawer_grupos, R.drawable.ic_drawer_ajuda, R.drawable.ic_drawer_configuracoes};
        ArrayAdapter<String> mAdapter = new CustomAdapter(this, drawerItens, drawerImgIds);
        listView.setAdapter(mAdapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public class CustomAdapter extends ArrayAdapter<String> {
        private final Activity context;
        private String[] info;
        int [] ids;
        public CustomAdapter(Activity context, String[] info, int [] ids) {
            super(context, R.layout.drawer_item, info);
            // TODO Auto-generated constructor stub

            this.context=context;
            this.info = info;
            this.ids = ids;
        }
        public View getView(int position,View view,ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View rowView;
            if(position > 0) {
                rowView = inflater.inflate(R.layout.drawer_item, null, true);
                TextView name = (TextView) rowView.findViewById(R.id.drawer_item_name);
                ImageView icon = (ImageView) rowView.findViewById(R.id.drawer_item_icon);
                name.setText(info[position]);
                icon.setImageResource(ids[position]);
            }
            else{
                rowView = inflater.inflate(R.layout.drawer_header, null, true);
                rowView.setEnabled(false);
                rowView.setOnClickListener(null);
            }

            return rowView;

        };

    }
}
