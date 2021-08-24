package com.example.prueba;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AgregarUsuario extends AppCompatActivity {

    EditText etUserId;
    EditText etId;
    EditText etTitle;
    Spinner spnCompleted;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_usuario);

        etUserId = findViewById(R.id.etUserId);
        etId = findViewById(R.id.etId);
        etTitle = findViewById(R.id.etTitle);
        spnCompleted = findViewById(R.id.spnCompleted);

        btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(v -> {
            if (isEmpty(etUserId) || isEmpty(etId) || isEmpty(etTitle))
                Toast.makeText(getApplicationContext(), "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
            else if (spnCompleted.getSelectedItemPosition() == 0)
                Toast.makeText(getApplicationContext(), "Seleccione una opción", Toast.LENGTH_SHORT).show();
            else
                limpiar();
        });
    }

    private boolean isEmpty(EditText editText){
        return editText.getText().toString().isEmpty();
    }

    private void limpiar(){
        Toast.makeText(getApplicationContext(), "Informacion enviada", Toast.LENGTH_LONG).show();
        etUserId.setText("");
        etId.setText("");
        etTitle.setText("");
        spnCompleted.setSelection(0);
    }
}