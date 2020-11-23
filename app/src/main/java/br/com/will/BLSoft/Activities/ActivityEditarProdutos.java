package br.com.will.BLSoft.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.will.BLSoft.Controller.ProdutoController;
import br.com.will.BLSoft.DBHelper.ConexaoSQLite;
import br.com.will.BLSoft.Model.Produto;
import br.com.will.BLSoft.R;

public class ActivityEditarProdutos extends AppCompatActivity {

    private EditText editTextCodigoProduto;
    private EditText editTextNomeProduto;
    private EditText editTextPrecoProduto;
    private EditText editTextQuantidadeProduto;
    private Button buttonAlterarDados;


    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produtos);

        editTextCodigoProduto = (EditText) findViewById(R.id.edtCodigoProduto);
        editTextNomeProduto = (EditText) findViewById(R.id.edtNomeProduto);
        editTextPrecoProduto = (EditText) findViewById(R.id.edtPrecoProduto);
        editTextQuantidadeProduto = (EditText) findViewById(R.id.edtQuantidadeProduto);
        buttonAlterarDados = (Button) findViewById(R.id.btnSalvarProduto);


        Bundle bundle = getIntent().getExtras();
        Produto produto = new Produto();
        produto.setId(bundle.getLong("id_produto"));
        produto.setNome(bundle.getString("nome_produto"));
        produto.setQuantidadeEmEstoque(bundle.getInt("quantidade_em_estoque"));
        produto.setPreco(bundle.getDouble("preco_produto"));

        this.setDadosProdutos(produto);

        buttonAlterarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produto produto = getDadosProdutoFormulario();

                if (produto != null){
                    ProdutoController produtoController = new ProdutoController(ConexaoSQLite.getInstancia(ActivityEditarProdutos.this));
                    boolean atualizar = produtoController.atualizarProdutoController(produto);
                    if (atualizar){
                        Toast.makeText(ActivityEditarProdutos.this, R.string.activity_editar_produtos_produto_alterado,Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(ActivityEditarProdutos.this, R.string.activity_editar_produtos_nao_produto_alterado,Toast.LENGTH_LONG).show();
                    }


                }
                else {
                    Toast.makeText(ActivityEditarProdutos.this, R.string.activity_editar_produtos_preencher_todos_os_campos, Toast.LENGTH_LONG).show();
                }
            }
        });




    }

    private void setDadosProdutos(Produto produto){

        this.editTextCodigoProduto.setText(String.valueOf(produto.getId()));
        this.editTextNomeProduto.setText(produto.getNome());
        this.editTextQuantidadeProduto.setText(String.valueOf(produto.getQuantidadeEmEstoque()));
        this.editTextPrecoProduto.setText(String.valueOf(produto.getPreco()));

    }

    private Produto getDadosProdutoFormulario(){
        this.produto = new Produto();

        if(this.editTextCodigoProduto.getText().toString().isEmpty() == false) {
            this.produto.setId(Long.parseLong(this.editTextCodigoProduto.getText().toString()));
        }
        else {
            return null;
        }

        if (this.editTextNomeProduto.getText().toString().isEmpty() == false){
            this.produto.setNome(this.editTextNomeProduto.getText().toString());
        }
        else {
            return null;
        }
        if (this.editTextQuantidadeProduto.getText().toString().isEmpty() == false){
            int quantidadeProduto = Integer.parseInt(this.editTextQuantidadeProduto.getText().toString());
            this.produto.setQuantidadeEmEstoque(quantidadeProduto);
        }
        else {
            return null;
        }
        if (this.editTextPrecoProduto.getText().toString().isEmpty() == false){
            double precoProduto = Double.parseDouble(this.editTextPrecoProduto.getText().toString());
            this.produto.setPreco(precoProduto);
        }
        else{
            return null;
        }

        return this.produto;

    }
}