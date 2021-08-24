package com.example.prueba;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsuarioAPI {
    @GET("https://jsonplaceholder.typicode.com/todos/")
    Call<List<Usuario>> getUsuarios();
}
