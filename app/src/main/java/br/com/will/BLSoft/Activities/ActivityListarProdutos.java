package br.com.will.BLSoft.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.will.BLSoft.Adapters.AdapterListaProdutos;
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

        Produto p = new Produto();
        p.setId(123);
        p.setNome("Guaraná");
        p.setQuantidadeEmEstoque(10);
        p.setPreco(50);

        this.produtoList = new ArrayList<>();
        produtoList.add(p);
        produtoList.add(p);
        produtoList.add(p);
        produtoList.add(p);
        produtoList.add(p);



        this.listViewProdutos = (ListView) findViewById(R.id.listViewProdutos);

        this.adapterListaProdutos = new AdapterListaProdutos(ActivityListarProdutos.this,produtoList);

        this.listViewProdutos.setAdapter(adapterListaProdutos);
    }
}