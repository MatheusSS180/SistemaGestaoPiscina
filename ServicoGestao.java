import java.io.IOException;
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
    
    public void removerServico(String descricao) {
        servicos.removeIf(servico -> servico.getDescricao().equals(descricao));
        System.out.println("Serviço removido com sucesso!");
    }

    public void atualizarServico(String descricao, double novoPreco) {
        for (Servico servico : servicos) {
            if (servico.getDescricao().equals(descricao)) {
                servico.setPreco(novoPreco);
                break;
            }
        }
    }

    public void editarServico(String descricao, String novaDescricao, double novoPreco) {
        for (Servico servico : servicos) {
            if (servico.getDescricao().equals(descricao)) {
                servico.setDescricao(novaDescricao);
                servico.setPreco(novoPreco);
                break;
            }
        }
    }
    public List<Servico> listarServicos() {
        return servicos;
    }

    public void salvarServicos(String fileName) throws IOException {
        UtilArquivo.salvarDados(fileName, servicos);
    }

    @SuppressWarnings("unchecked")
    public void carregarServicos(String fileName) throws IOException, ClassNotFoundException {
        servicos = (List<Servico>) UtilArquivo.carregarDados(fileName);
    }
}
