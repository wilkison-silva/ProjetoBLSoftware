package br.com.will.BLSoft.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ConexaoSQLite extends SQLiteOpenHelper {

    private static ConexaoSQLite INSTANCIA_CONEXAO;
    private static final int VERSAO_DB = 1;
    private static final String NOME_DB = "bl_produtos_app";

    public ConexaoSQLite(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }

    public static ConexaoSQLite getInstancia(Context context){
        if (INSTANCIA_CONEXAO == null){
            INSTANCIA_CONEXAO = new ConexaoSQLite(context);
        }
        return INSTANCIA_CONEXAO;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i("Banco de Dados", "Criado pela primeira vez");

        String sqlTabelaProduto = "CREATE TABLE produto" +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nome TEXT,"+
                "quantidade_em_estoque INTEGER,"+
                "preco REAL"+
                ")";

        db.execSQL(sqlTabelaProduto);

        String sqlTabelaVenda = "CREATE TABLE venda" +
                "("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "data INTEGER"+
                ")";

        db.execSQL(sqlTabelaVenda);

        String sqlTabelaItemDaVenda = "CREATE TABLE item_da_venda"+
                "("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "quantidade_vendida INTEGER,"+
                "id_produto INTEGER,"+
                "id_venda INTEGER"+
                ")";

        db.execSQL(sqlTabelaItemDaVenda);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
