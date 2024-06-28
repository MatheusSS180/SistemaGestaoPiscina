import java.util.ArrayList;
import java.util.List;

public class ServicoGestao {
    private List<Servico> servicos;

    public ServicoGestao() {
        this.servicos = new ArrayList<>();
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public List<Servico> listarServicos() {
        return servicos;
    }
}