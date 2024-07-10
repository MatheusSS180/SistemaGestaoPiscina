import java.io.Serializable;

public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String descricao;
    private double preco;

    public Servico(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }
    public double setPreco(double NovoPreco) {
    	return preco = NovoPreco;
    }
    public String setDescricao(String novaDescricao) {
    	return descricao = novaDescricao;
    }
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Serviço: " + descricao + ", Preço: " + preco;
    }
}
