import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtendimentoGestao {
    private List<Atendimento> atendimentos;

    public AtendimentoGestao() {
        this.atendimentos = new ArrayList<>();
    }

    public void agendarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
    }

    public List<Atendimento> listarAtendimentos() {
        return atendimentos;
    }
}
