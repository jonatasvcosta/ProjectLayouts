package com.example.taqtile.quitanda;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class Inventory extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Product> list = new ArrayList<Product>();
        list.add(new Product("banana",R.drawable.fruitlogo,false));
        list.add(new Product("apple",R.drawable.fruitlogo,false));
        list.add(new Product("orange",R.drawable.fruitlogo,false));
        list.add(new Product("avocado", R.drawable.fruitlogo, false));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        RecyclerView rvProducts = (RecyclerView) findViewById(R.id.itensList);
        rvProducts.setHasFixedSize(true);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        ProductAdapter adapter = new ProductAdapter(list);
        rvProducts.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inventory, menu);
        return true;
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
