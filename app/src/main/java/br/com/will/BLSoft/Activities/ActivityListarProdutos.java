package br.com.will.BLSoft.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.will.BLSoft.Adapters.AdapterListaProdutos;
import br.com.will.BLSoft.Controller.ProdutoController;
import br.com.will.BLSoft.DBHelper.ConexaoSQLite;
import br.com.will.BLSoft.Model.Produto;
import br.com.will.BLSoft.R;

public class ActivityListarProdutos extends AppCompatActivity {

    private ListView listViewProdutos;
    private List<Produto> produtoList;
    private AdapterListaProdutos adapterListaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        //TODO buscar os produtos no banco

        ProdutoController produtoController = new ProdutoController(ConexaoSQLite.getInstancia(ActivityListarProdutos.this));
        produtoList = produtoController.getListaProdutosController();

        this.listViewProdutos = (ListView) findViewById(R.id.listViewProdutos);
        this.adapterListaProdutos = new AdapterListaProdutos(ActivityListarProdutos.this,produtoList);
        this.listViewProdutos.setAdapter(adapterListaProdutos);

        this.listViewProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produto produto = (Produto) adapterListaProdutos.getItem(position);

                Toast.makeText(ActivityListarProdutos.this, "Produto: " + produto.getNome(), Toast.LENGTH_LONG).show();
            }
        });
    }
}