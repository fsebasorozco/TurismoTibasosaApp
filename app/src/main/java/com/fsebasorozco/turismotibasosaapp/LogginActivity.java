package com.fsebasorozco.turismotibasosaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LogginActivity extends AppCompatActivity implements View.OnClickListener
{
    Button Ingresar, Registro;
    EditText User, Pass;
    static int bandera=0;
    static String user, pass, repass, email;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        Ingresar = (Button)findViewById(R.id.btnIngresar);
        Registro = (Button)findViewById(R.id.btnRegistro);
        User =  (EditText)findViewById(R.id.txtLogin);
        Pass = (EditText)findViewById(R.id.txtPass);

        Ingresar.setOnClickListener(this);
        Registro.setOnClickListener(this);

       /* if(bandera != 0)
        {
            Bundle extras = getIntent().getExtras();
            //Variables para capturar los datos
            String user = extras.getString("User");
            String pass = extras.getString("Pass");
            String rePass = extras.getString("RePass");
            String email = extras.getString("Email");
        }*/
    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();

        User =  (EditText)findViewById(R.id.txtLogin);
        Pass = (EditText)findViewById(R.id.txtPass);

        if(id == R.id.btnRegistro)
        {
            Intent intent = new Intent(this,RegistroActivity.class);
            startActivityForResult(intent, 1234);
        }
        else if(id==R.id.btnIngresar)
        {
            if(bandera==0)
            {
                Toast toast1 =
                Toast.makeText(getApplicationContext(), "No hay usuarios registrados", Toast.LENGTH_SHORT);
                toast1.show();
            }
            else if(bandera==1)
            {
                String Login = User.getText().toString();
                String Passw = Pass.getText().toString();

                if(TextUtils.isEmpty(Login))
                {
                    User.setError("No hay un Login ingresado");
                    Toast.makeText(LogginActivity.this,"Ingrese Login",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(TextUtils.isEmpty(Passw))
                {
                    Pass.setError("No hay contraseña ingresada");
                    Toast.makeText(LogginActivity.this,"Ingrese Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if((User.getText().toString()).equals(user) && (Pass.getText().toString()).equals(pass))
                {
                    //Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this,MainActivity.class);
                    intent.putExtra("User2",user);
                    intent.putExtra("Pass2",pass);
                    intent.putExtra("RePass2",repass);
                    intent.putExtra("Email2",email);
                    startActivityForResult(intent, 4567);
                    setResult(RESULT_OK,intent);
                    finish();
                }
                else
                {
                    Toast.makeText(LogginActivity.this,"Usuario o contrasena incorrectos",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == 1234 && resultCode==RESULT_OK)
        {
            user = data.getExtras().getString("User");
            pass = data.getExtras().getString("Pass");
            repass = data.getExtras().getString("RePass");
            email = data.getExtras().getString("Email");

           /* Toast toast1 =
                    Toast.makeText(getApplicationContext(), "User" + user+"Pass" + pass + "Email" + email, Toast.LENGTH_SHORT);
            toast1.show();*/
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
