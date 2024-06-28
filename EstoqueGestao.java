import java.util.ArrayList;
import java.util.List;

public class EstoqueGestao {
    private List<Produto> produtos;

    public EstoqueGestao() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void atualizarProduto(String nome, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                produto.setQuantidade(quantidade);
                break;
            }
        }
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }
}