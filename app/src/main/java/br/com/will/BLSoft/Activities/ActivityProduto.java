package br.com.will.BLSoft.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.will.BLSoft.Controller.ProdutoController;
import br.com.will.BLSoft.DBHelper.ConexaoSQLite;
import br.com.will.BLSoft.Model.Produto;
import br.com.will.BLSoft.R;

public class ActivityProduto extends AppCompatActivity {

    private EditText edtCodigoProduto;
    private EditText edtNomeProduto;
    private EditText edtQuantidadeProduto;
    private EditText edtPrecoProduto;
    private Button btnSalvarProduto;

    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        ConexaoSQLite conexaoSQLite  = ConexaoSQLite.getInstancia(ActivityProduto.this);

        edtCodigoProduto = (EditText) findViewById(R.id.edtCodigoProduto);
        edtNomeProduto = (EditText) findViewById(R.id.edtNomeProduto);
        edtQuantidadeProduto = (EditText) findViewById(R.id.edtQuantidadeProduto);
        edtPrecoProduto = (EditText) findViewById(R.id.edtPrecoProduto);

        btnSalvarProduto = (Button) findViewById(R.id.btnSalvarProduto);

        btnSalvarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produto produto = getDadosProdutoFormulario();

                if (produto != null){
                    ProdutoController produtoController = new ProdutoController(conexaoSQLite);
                    produtoController.salvarProdutoController(produto);
                    Toast.makeText(ActivityProduto.this, R.string.activity_produto_produto_salvo_com_sucesso,Toast.LENGTH_LONG).show();
                    //System.out.println("Testando");
                }
                else {
                    Toast.makeText(ActivityProduto.this, R.string.activity_produto_produto_nao_salvo_com_sucesso, Toast.LENGTH_LONG).show();
                    //System.out.println("Falhou");
                }
            }
        });

    }

    private Produto getDadosProdutoFormulario(){
        this.produto = new Produto();

        /*if(this.edtCodigoProduto.getText().toString().isEmpty() == false) {
            this.produto.setId(Long.parseLong(this.edtCodigoProduto.getText().toString()));
        }
        else {
            return null;
        }
*/
        if (this.edtNomeProduto.getText().toString().isEmpty() == false){
            this.produto.setNome(this.edtNomeProduto.getText().toString());
        }
        else {
            return null;
        }
        if (this.edtQuantidadeProduto.getText().toString().isEmpty() == false){
            int quantidadeProduto = Integer.parseInt(this.edtQuantidadeProduto.getText().toString());
            this.produto.setQuantidadeEmEstoque(quantidadeProduto);
        }
        else {
            return null;
        }
        if (this.edtPrecoProduto.getText().toString().isEmpty() == false){
            double precoProduto = Double.parseDouble(this.edtQuantidadeProduto.getText().toString());
            this.produto.setPreco(precoProduto);
        }
        else{
            return null;
        }

        return this.produto;

    }
}