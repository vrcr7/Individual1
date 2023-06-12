package com.example.individual1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.individual1.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    protected ActivityMainBinding binding;
    protected EditText texto1;
    protected Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       // setContentView(R.layout.activity_main);

        texto1 = binding.texto;
        boton1 = binding.boton1;


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                            mostrarFragmento();
            }
        });


    }
    private void mostrarFragmento() {
        // Crea una instancia del fragmento MessageFragment
        BlankFragment fragment = BlankFragment.newInstance(texto1.getText().toString(),"");
        // Obtiene el administrador de fragmentos
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Inicia una transacción de fragmento
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // Reemplaza el contenido del contenedor con el fragmento MessageFragment
        transaction.replace(binding.container.getId(), fragment);
        // Opcional: añade la transacción a la pila de retroceso
        transaction.addToBackStack(null);
        // Realiza la transacción
        transaction.commit();
    }






}