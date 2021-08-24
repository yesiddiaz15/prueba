package com.example.prueba;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.prueba.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

    Button btnListaUsuarios;
    Button btnAgregarUsuarios;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnListaUsuarios = findViewById(R.id.btnListaUsuarios);
        btnAgregarUsuarios = findViewById(R.id.btnAgregarUsuario);
        btnSalir = findViewById(R.id.btnSalir);

        btnListaUsuarios.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ListadoUsuarios.class);
            startActivity(intent);
        });

        btnAgregarUsuarios.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AgregarUsuario.class);
            startActivity(intent);
        });

        btnSalir.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        //Se elimina la funcion del boton atras
    }
}