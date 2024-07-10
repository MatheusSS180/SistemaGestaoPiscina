import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String endereco;
    private String telefone;
    private String data;
    private String hora;

    public Cliente(String nome, String endereco, String telefone, String data, String hora) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.data = data;
        this.hora = hora;
    }


    public String getNome() {
        return nome;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public String getData() {
        return data;
    }
    public String setData(String newData) {
    	return data = newData;
    }
    public String getHora() {
            return hora;
    }
    public String setHora(String newHora) {
    	return hora = newHora;
    }
    @Override
    public String toString() {
        return "Cliente: " + nome + ", Endereço: " + endereco + ", Telefone: " + telefone + ", Data: " + data + ", Hora: " + hora;
    }
    
}
