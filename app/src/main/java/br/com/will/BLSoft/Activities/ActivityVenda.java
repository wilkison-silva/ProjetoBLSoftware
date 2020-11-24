package br.com.will.BLSoft.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

import br.com.will.BLSoft.Controller.ProdutoController;
import br.com.will.BLSoft.DBHelper.ConexaoSQLite;
import br.com.will.BLSoft.Model.Produto;
import br.com.will.BLSoft.R;

public class ActivityVenda extends AppCompatActivity {

    private Spinner spinnerProdutos;
    private List<Produto> produtoList;
    private ProdutoController produtoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda);

        //Spinner
        this.produtoController = new ProdutoController(ConexaoSQLite.getInstancia(this));
        this.produtoList = this.produtoController.getListaProdutosController();
        this.spinnerProdutos = (Spinner) findViewById(R.id.spinnerProdutos);

        ArrayAdapter<Produto> arrayAdapterSpinnerProduto = new ArrayAdapter<Produto>(this,
                                                                                R.layout.support_simple_spinner_dropdown_item,
                                                                                this.produtoList);

        this.spinnerProdutos.setAdapter(arrayAdapterSpinnerProduto);

        //End Spinner
    }
}