package br.com.will.BLSoft.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.ProtectionDomain;
import java.sql.BatchUpdateException;

import br.com.will.BLSoft.Model.Produto;
import br.com.will.BLSoft.R;

public class ActivityProduto extends AppCompatActivity {

    private EditText edtNomeProduto;
    private EditText edtQuantidadeProduto;
    private EditText edtPrecoProduto;
    private Button btnSalvarProduto;

    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        edtNomeProduto = (EditText) findViewById(R.id.edtNomeProduto);
        edtQuantidadeProduto = (EditText) findViewById(R.id.edtQuantidadeProduto);
        edtPrecoProduto = (EditText) findViewById(R.id.edtPrecoProduto);

        btnSalvarProduto = (Button) findViewById(R.id.btnSalvarProduto);

    }

    private Produto getDadosProdutoFormulario(){
        this.produto = new Produto();

        if (this.edtNomeProduto.getText().toString().isEmpty() == false){
            this.produto.setNome(this.edtNomeProduto.getText().toString());
        }
        else {
            return null;
        }
        if (this.edtQuantidadeProduto.getText().toString().isEmpty() == false){
            int quantidadeProduto = Integer.parseInt(this.edtQuantidadeProduto.getText().toString());
        }
        else {
            return null;
        }
        if (this.edtPrecoProduto.getText().toString().isEmpty() == false){
            double precoProduto = Integer.parseInt(this.edtQuantidadeProduto.getText().toString());
        }
        else{
            return null;
        }

        return this.produto;

    }
}