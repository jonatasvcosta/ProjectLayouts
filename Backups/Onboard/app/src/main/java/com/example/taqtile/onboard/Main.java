package com.example.taqtile.onboard;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taqtile.onboard.User;
import com.example.taqtile.onboard.ListAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main extends ActionBarActivity{
    private User usuario = new User();
    HashMap<Integer, User.info> hash_dados;
    List<User.info> lista_dados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hash_dados = usuario.list(0);
        for(int i = 0; i < 10; i++) lista_dados.add(hash_dados.get(i));
        final ListView listView = (ListView) findViewById(R.id.lista_usuarios);
        //final ListAdapter adapter = new ListAdapter(this, lista_dados);
        final ArrayAdapter<User.info> adapter = new ArrayAdapter<User.info>(this, R.layout.item_lista, lista_dados);
        listView.setAdapter(adapter);
        final Intent intent = new Intent(this, DetalheUsuario.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int itemPosition = position;
                /*Toast.makeText(getApplicationContext(), "Position :" + itemPosition,Toast.LENGTH_SHORT).show();*/

                intent.putExtra("first_name",hash_dados.get(itemPosition).first_name);
                intent.putExtra("last_name",hash_dados.get(itemPosition).last_name);
                intent.putExtra("avatar",hash_dados.get(itemPosition).avatar);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void DetalheUsuario(View view){
        Intent intent = new Intent(this, DetalheUsuario.class);
        int id = 0;
        intent.putExtra("first_name", usuario.list(0).get(id).first_name);
        intent.putExtra("last_name", usuario.list(0).get(id).last_name);
        intent.putExtra("avatar", usuario.list(0).get(id).avatar);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
