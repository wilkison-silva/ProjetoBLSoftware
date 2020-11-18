package br.com.will.BLSoft.Controller;

import java.util.List;

import br.com.will.BLSoft.DAO.ProdutoDAO;
import br.com.will.BLSoft.DBHelper.ConexaoSQLite;
import br.com.will.BLSoft.Model.Produto;

public class ProdutoController {

    private final ProdutoDAO produtoDAO;


    public ProdutoController(ConexaoSQLite conexaoSQLite) {
        this.produtoDAO = new ProdutoDAO(conexaoSQLite);
    }

    public long salvarProdutoController(Produto produto){
        return produtoDAO.salvarProdutoDAO(produto);
    }

    public List<Produto> getListaProdutosController(){
        return produtoDAO.getListaProdutosDAO();
    }

    public boolean exluirProdutoController(long idProduto){
        return this.produtoDAO.excluirProdutoDAO(idProduto);
    }
}
