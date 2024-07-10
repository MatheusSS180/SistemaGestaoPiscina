
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoGestao {
    private List<Atendimento> atendimentos;

    public AtendimentoGestao() {
        this.atendimentos = new ArrayList<>();
    }

    public void agendarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
    }

    public void atualizarAtendimento(Atendimento atendimento, Servico novoServico) {
        for (Atendimento a : atendimentos) {
            if (a.equals(atendimento)) {
                a.setServico(novoServico);
                break;
            }
        }
    }
    public void removerAtendimento(Atendimento atendimento) {
        atendimentos.remove(atendimento);
    }
    
    public List<Atendimento> listarAtendimentos() {
        return atendimentos;
    }

    public void salvarAtendimentos(String fileName) throws IOException {
        UtilArquivo.salvarDados(fileName, atendimentos);
    }
    
    public void editarCliente(Cliente cliente, String newHora, String newData) {
        for (Atendimento a : atendimentos) {
            if (a.getCliente().equals(cliente)) {
                a.getCliente().setHora(newData);
                a.getCliente().setData(newHora);
                break;
            }
        }
    }
    @SuppressWarnings("unchecked")
    public void carregarAtendimentos(String fileName) throws IOException, ClassNotFoundException {
        atendimentos = (List<Atendimento>) UtilArquivo.carregarDados(fileName);
    }
}
