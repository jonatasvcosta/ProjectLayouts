package com.example.taqtile.quitanda;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LogIn extends ActionBarActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        Button logIn = (Button) findViewById(R.id.logInButton);
        View view = findViewById(R.id.layoutLogin);
        view.getBackground().setAlpha(40);
        intent = new Intent(this, Inventory.class);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equalsIgnoreCase("user") && password.getText().toString().equalsIgnoreCase("user")){
                    intent.putExtra("mode","user");
                    startActivity(intent);
                }
                else if(username.getText().toString().equalsIgnoreCase("admin") && password.getText().toString().equalsIgnoreCase("admin")){
                    intent.putExtra("mode","admin");
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wrong username or password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
