import java.io.Serializable;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private int quantidade;

    public Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }
    
    public String setNome(String NovoNome) {
    	return nome = NovoNome;
    }
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + ", Quantidade: " + quantidade;
    }
}
