package br.com.will.BLSoft.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

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
            //contentValues.put("id",pProduto.getId());
            contentValues.put("nome",pProduto.getNome());
            contentValues.put("quantidade_em_estoque",pProduto.getQuantidadeEmEstoque());
            contentValues.put("preco",pProduto.getPreco());

            long idProdutoInserido = db.insert("produto", null, contentValues);

            return idProdutoInserido;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null){
                db.close();
            }
        }

        return 0;
    }

    public List<Produto> getListaProdutosDAO(){

        List<Produto> produtoList = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;
        String query = "SELECT * FROM produto;";

        try {
            db = this.conexaoSQLite.getReadableDatabase();
            cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()){
                do{
                    Produto produto = new Produto();
                    produto.setId(cursor.getLong(0));
                    produto.setNome(cursor.getString(1));
                    produto.setQuantidadeEmEstoque(cursor.getInt(2));
                    produto.setPreco(cursor.getDouble(3));

                    produtoList.add(produto);
                }while (cursor.moveToNext());
            }
        }
        catch (Exception e){
            e.printStackTrace();
            Log.e("ERRO LISTA DE PRODUTOS", "ERRO AO FAZER O SQL");
        }
        finally {
            if(db != null) {
                db.close();
            }
        }
        return produtoList;


    }

   public boolean excluirProdutoDAO(long idProduto){
        SQLiteDatabase db = null;

        try{
            db = this.conexaoSQLite.getWritableDatabase();

            db.delete("produto","id = ?", new String[]{String.valueOf(idProduto)});



        }
        catch (Exception e){
            Log.e("Erro ao deletar: ", "Erro ao deletar");
            return false;
        }
        finally {
            if (db != null){
                db.close();
            }
        }

        return true;
   }

   public boolean atualizarProdutoDAO(Produto produto) {
       SQLiteDatabase db = null;

       try {
           db = this.conexaoSQLite.getWritableDatabase();
           ContentValues contentValues = new ContentValues();

           contentValues.put("nome", produto.getNome());
           contentValues.put("quantidade_em_estoque", produto.getQuantidadeEmEstoque());
           contentValues.put("preco", produto.getPreco());

           int atualizou = db.update("produto", contentValues, "id = ?", new String[]{String.valueOf(produto.getId())});
           System.out.println("PRODUTO = "+produto.getId());
           System.out.println("UPDATE = "+atualizou);
           if (atualizou > 0){
               return true;
           }

       }
       catch (Exception e) {
           Log.e("PRODUTO DAO", e.getMessage());
           return false;
       }
       finally {
           if (db != null) {
               db.close();
           }
       }
       return false;
   }
}
