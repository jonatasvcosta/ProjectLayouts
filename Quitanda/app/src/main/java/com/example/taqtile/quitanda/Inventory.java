package com.example.taqtile.quitanda;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class Inventory extends ActionBarActivity {
    private RecyclerView rvProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Product> list = new ArrayList<Product>();
        list.add(new Product("banana",R.drawable.fruitlogo,false));
        list.add(new Product("apple",R.drawable.fruitlogo,false));
        list.add(new Product("orange",R.drawable.fruitlogo,false));
        list.add(new Product("avocado", R.drawable.fruitlogo, false));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        rvProducts = (RecyclerView) findViewById(R.id.itensList);
        rvProducts.setHasFixedSize(true);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        //rvProducts.setLayoutManager(new GridLayoutManager(this, 2));
        ProductAdapter adapter = new ProductAdapter(list);
        rvProducts.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_inventory, menu);
//        return true;
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_inventory, menu);
        MenuItem item = menu.findItem(R.id.gridButton);
        Button buttonGrid = (Button) item.getActionView();
//        buttonGrid.setText("Grid");
        Drawable icon = getResources().getDrawable(R.drawable.grid);
        buttonGrid.setBackgroundColor(Color.TRANSPARENT);
        buttonGrid.setCompoundDrawablesWithIntrinsicBounds(null, icon, null, null);
        buttonGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvProducts.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));
            }
        });
        item = menu.findItem(R.id.listButton);
        icon = getResources().getDrawable(R.drawable.list);
        Button buttonList = (Button) item.getActionView();
//        buttonList.setText("List");
        buttonList.setCompoundDrawablesWithIntrinsicBounds(null, icon, null, null);
        buttonList.setBackgroundColor(Color.TRANSPARENT);
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvProducts.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
            rvProducts.setLayoutManager(new GridLayoutManager(this,2));


        return super.onOptionsItemSelected(item);
    }
}
