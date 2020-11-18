package br.com.will.BLSoft.Activities;
//primeirokfodkfdopfjdsofndsjifdsfjdkn
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import br.com.will.BLSoft.Activities.ActivityListarProdutos;
import br.com.will.BLSoft.Activities.ActivityProduto;
import br.com.will.BLSoft.Controller.ProdutoController;
import br.com.will.BLSoft.DBHelper.ConexaoSQLite;
import br.com.will.BLSoft.Model.Produto;
import br.com.will.BLSoft.R;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastroProdutos;
    private Button btnListarProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deleteDatabase("bl_produtos_app");
        System.out.println("Excluindo o banco de dados");

        ConexaoSQLite conexaoSQLite = ConexaoSQLite.getInstancia(MainActivity.this);

        this.btnCadastroProdutos = (Button) findViewById(R.id.btnCadastroProduto);
        this.btnListarProdutos = (Button) findViewById(R.id.btnCListarProduto);

        this.btnCadastroProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //método executado ao clicar no botão
                Intent intent = new Intent(MainActivity.this, ActivityProduto.class);
                startActivity(intent);
            }
        });

        this.btnListarProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityListarProdutos.class);
                startActivity(intent);
            }
        });
    }
}