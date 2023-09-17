package com.edu.susethsandovalexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.edu.susethsandovalexamen.model.Costo;

public class MainActivity extends AppCompatActivity {
    Spinner spnTipo;
    EditText txtCant;
    Button btnCalcular;
    Button btnNuevo;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCant = findViewById(R.id.etxtCant);
        btnCalcular = findViewById(R.id.buttonTotal);
        btnNuevo = findViewById(R.id.buttonNuevo);
        btnSalir = findViewById(R.id.buttonSalir);
        spnTipo =findViewById(R.id.spnTipoLamp);
        ArrayAdapter<CharSequence> adap = ArrayAdapter.createFromResource(
                this,
                R.array.tipoLamparas,
                android.R.layout.simple_spinner_dropdown_item);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTipo.setAdapter(adap);

        //SALIR
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //NUEVO
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCant.setText(null);
                spnTipo.setSelection(0);
            }
        });

        //CALCULAR
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Costo cos = new Costo();
                cos.setCantLamp(Double.parseDouble(txtCant.getText().toString().trim()));
                cos.setTipoLamp(spnTipo.getSelectedItemPosition());
                Toast.makeText(getApplicationContext(),
                        cos.venta(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}