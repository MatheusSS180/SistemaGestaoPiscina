import java.io.IOException;
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

    public void removerProduto(String nome) {
        produtos.removeIf(produto -> produto.getNome().equals(nome));
    }
    
    public void atualizarProduto(String nome, int novaQuantidade) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                produto.setQuantidade(novaQuantidade);
                break;
            }
        }
    }

    public void editarProduto(String nome, String novoNome, int novaQuantidade) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                produto.setNome(novoNome);
                produto.setQuantidade(novaQuantidade);
                break;
            }
        }
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public void salvarProdutos(String fileName) throws IOException {
        UtilArquivo.salvarDados(fileName, produtos);
    }

    @SuppressWarnings("unchecked")
    public void carregarProdutos(String fileName) throws IOException, ClassNotFoundException {
        produtos = (List<Produto>) UtilArquivo.carregarDados(fileName);
    }
}
