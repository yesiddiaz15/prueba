package com.example.prueba;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoUsuarios extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Usuario> listUsuarios;
    AdaptadorUsuario adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_usuarios);

        recyclerView = findViewById(R.id.recyclerUsuario);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listUsuarios = new ArrayList<>();
        adapter = new AdaptadorUsuario(listUsuarios);
        recyclerView.setAdapter(adapter);

        find();
    }

    private void find(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/todos/").addConverterFactory(GsonConverterFactory.create()).build();

        UsuarioAPI usuarioAPI = retrofit.create(UsuarioAPI.class);
        Call<List<Usuario>> call = usuarioAPI.getUsuarios();
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                try {
                    if(response.isSuccessful()){
                        if (!listUsuarios.isEmpty()){
                            listUsuarios.clear();
                        }
                        listUsuarios.addAll(response.body());
                        adapter.notifyDataSetChanged();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {

            }
        });
    }
}