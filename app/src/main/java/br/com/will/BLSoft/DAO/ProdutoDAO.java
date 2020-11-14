package br.com.will.BLSoft.DAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import br.com.will.BLSoft.DBHelper.ConexaoSQLite;
import br.com.will.BLSoft.Model.Produto;

public class ProdutoDAO {

    private final ConexaoSQLite conexaoSQLite;


    public ProdutoDAO(ConexaoSQLite conexaoSQLite) {
        this.conexaoSQLite = conexaoSQLite;
    }

    public long salvarProdutoDAO(Produto pProduto){

        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();

        try{
            ContentValues contentValues = new ContentValues();
            contentValues.put("id",pProduto.getId());
            contentValues.put("nome",pProduto.getNome());
            contentValues.put("quantidade_em_estoque",pProduto.getQuantidadeEmEstoque());
            contentValues.put("preco",pProduto.getPreco());

            long idProdutoInserido = db.insert("produto", null, contentValues);

            return idProdutoInserido;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
