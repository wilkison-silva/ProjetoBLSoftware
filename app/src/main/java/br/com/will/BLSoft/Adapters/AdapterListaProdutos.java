package br.com.will.BLSoft.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.will.BLSoft.Model.Produto;
import br.com.will.BLSoft.R;

public class AdapterListaProdutos extends BaseAdapter {


    private Context context;
    private List<Produto> produtoList;

    public AdapterListaProdutos(Context context, List<Produto> produtoList) {
        this.context = context;
        this.produtoList = produtoList;
    }

    @Override
    public int getCount() {
        return this.produtoList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.produtoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(this.context, R.layout.layout_lista_de_produtos,null);


        TextView textViewCodigoProduto = (TextView) view.findViewById(R.id.textViewCodigoProduto);
        TextView textViewNomeProduto = (TextView) view.findViewById(R.id.textViewNomeProduto);
        TextView textViewPrecoProduto = (TextView) view.findViewById(R.id.textviewPrecoProduto);
        TextView textViewEstoqueProduto = (TextView) view.findViewById(R.id.textViewEstoqueProduto);

        textViewCodigoProduto.setText(String.valueOf(this.produtoList.get(position).getId()));
        textViewNomeProduto.setText(this.produtoList.get(position).getNome());
        textViewPrecoProduto.setText(String.valueOf(this.produtoList.get(position).getPreco()));
        textViewEstoqueProduto.setText(String.valueOf(this.produtoList.get(position).getQuantidadeEmEstoque()));


        return view;
    }

    public void removerProduto(int position){
        this.produtoList.remove(position);
        notifyDataSetChanged();
    }
    public void atualizarLista(List<Produto> produtoList){
        this.produtoList.clear();
        this.produtoList = produtoList;
        this.notifyDataSetChanged();
    }

}
