package com.fsebasorozco.turismotibasosaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends LogginActivity implements View.OnClickListener
{

    TextureView User, Email;
    //static String user, pass, repass, email;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        TextView txtUser = (TextView)findViewById(R.id.txtLogin2);
        txtUser.setText(user);

        TextView txtEmail = (TextView)findViewById(R.id.txtEmail2);
        txtEmail.setText(email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.menumain)
        {
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("User2",user);
            intent.putExtra("Pass2",pass);
            intent.putExtra("RePass2",repass);
            intent.putExtra("Email2",email);
            startActivityForResult(intent, 4567);
            setResult(RESULT_OK,intent);
            finish();
        }
        else if(id == R.id.menu2)
        {
            Intent intent = new Intent(this,MenuActivity.class);
            intent.putExtra("User2",user);
            intent.putExtra("Pass2",pass);
            intent.putExtra("RePass2",repass);
            intent.putExtra("Email2",email);
            startActivityForResult(intent, 4567);
            setResult(RESULT_OK,intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == 4567 && resultCode==RESULT_OK)
        {
            Bundle Extras = getIntent().getExtras();
            //Variables para capturar los datos
            String user2 = data.getExtras().getString("User2");
            String pass2 = data.getExtras().getString("Pass2");
            String repass2 = data.getExtras().getString("RePass2");
            String email2 = data.getExtras().getString("Email2");

           /* Toast toast1 =
                    Toast.makeText(getApplicationContext(), "User" + user2+"Pass" + pass2 + "Email" + email2, Toast.LENGTH_SHORT);
            toast1.show();*/        }
        //super.onActivityResult(requestCode, resultCode, data);
    }
}
