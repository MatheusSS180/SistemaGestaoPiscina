import java.util.Date;

public class Atendimento {
    private Cliente cliente;
    private Servico servico;
    private Date data;

    public Atendimento(Cliente cliente, Servico servico, Date data) {
        this.cliente = cliente;
        this.servico = servico;
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Atendimento: " + cliente + ", Serviço: " + servico + ", Data: " + data;
    }
}