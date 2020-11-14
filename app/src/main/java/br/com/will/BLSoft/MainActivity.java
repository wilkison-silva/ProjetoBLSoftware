//primeirokfodkfdopfjdsofndsjifdsfjdkn
package br.com.will.BLSoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import br.com.will.BLSoft.Activities.ActivityProduto;
import br.com.will.BLSoft.Controller.ProdutoController;
import br.com.will.BLSoft.DBHelper.ConexaoSQLite;
import br.com.will.BLSoft.Model.Produto;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastroProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexaoSQLite conexaoSQLite = ConexaoSQLite.getInstancia(MainActivity.this);

        Produto produto = new Produto();
        produto.setId(9);
        produto.setNome("Computador");
        produto.setQuantidadeEmEstoque(100);
        produto.setPreco(1500.9);

        ProdutoController produtoController = new ProdutoController(conexaoSQLite);
        //produtoController.salvarProdutoController(produto);

        System.out.println("produto id salvo: " + produtoController.salvarProdutoController(produto));

        this.btnCadastroProdutos = (Button) findViewById(R.id.btnCadastroProduto);

        this.btnCadastroProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //método executado ao clicar no botão
                Intent intent = new Intent(MainActivity.this, ActivityProduto.class);
                startActivity(intent);
            }
        });
    }
}