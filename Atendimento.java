
import java.io.Serializable;
import java.util.Date;

public class Atendimento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Cliente cliente;
    private Servico servico;

    public Atendimento(Cliente cliente, Servico servico) {
        this.cliente = cliente;
        this.servico = servico;
    
    }


    public Cliente getCliente() {
        return cliente;
    }

    public Servico getServico() {
        return servico;
    }
    public Servico setServico(Servico NovoServico) {
    	return servico = NovoServico;
    }
    @Override
    public String toString() {
        return "Atendimento: " + cliente + ", Serviço: " + servico;
    } 
}