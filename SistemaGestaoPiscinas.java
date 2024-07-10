import java.util.Date;
import java.util.Scanner;
import java.io.IOException;

public class SistemaGestaoPiscinas {
    private static final String SERVICOS_FILE = "servicos.dat";
    private static final String PRODUTOS_FILE = "produtos.dat";
    private static final String ATENDIMENTOS_FILE = "atendimentos.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ServicoGestao servicoGestao = new ServicoGestao();
        EstoqueGestao estoqueGestao = new EstoqueGestao();
        AtendimentoGestao atendimentoGestao = new AtendimentoGestao();

        // Carregar dados ao iniciar
        try {
            servicoGestao.carregarServicos(SERVICOS_FILE);
            estoqueGestao.carregarProdutos(PRODUTOS_FILE);
            atendimentoGestao.carregarAtendimentos(ATENDIMENTOS_FILE);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhum dado salvo encontrado. Iniciando com dados vazios.");
        }

        while (true) {
            System.out.println("Sistema de Gestão de Piscinas");
            System.out.println("1. Adicionar Serviço");
            System.out.println("2. Editar Serviço");
            System.out.println("3. Listar Serviços");
            System.out.println("4. Remover Serviços");
            System.out.println("5. Adicionar Produto");
            System.out.println("6. Editar Produto");
            System.out.println("7. Listar Produtos");
            System.out.println("8. Remover Produtos");
            System.out.println("9. Agendar Atendimento");
            System.out.println("10. Editar Atendimento");
            System.out.println("11. Listar Atendimentos");
            System.out.println("12. Remover Atendimentos");
            System.out.println("13. Salvar Dados");
            System.out.println("14. Carregar Dados");
            System.out.println("15. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Descrição do Serviço: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Preço do Serviço: ");
                    double preco = scanner.nextDouble();
                    servicoGestao.adicionarServico(new Servico(descricao, preco));
                    System.out.println("Tecle enter para voltar ao menu principal:");
                    String enter1 = scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Serviços:");
                    for (Servico servico : servicoGestao.listarServicos()) {
                        System.out.println(servico);
                    }
                    System.out.println("Tecle enter para voltar ao menu principal:");
                    String enter2 = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Descrição do Serviço a ser editado: ");
                    String descricaoEditar = scanner.nextLine();
                    System.out.print("Nova Descrição do Serviço: ");
                    String novaDescricao = scanner.nextLine();
                    System.out.print("Novo Preço do Serviço: ");
                    double novoPreco = scanner.nextDouble();
                    scanner.nextLine();  // Consumir nova linha
                    servicoGestao.editarServico(descricaoEditar, novaDescricao, novoPreco);
                    System.out.println("Serviço editado com succeso!:");
                    System.out.println("Tecle enter para voltar ao menu principal:");
                    String enter80 = scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Descrição do Serviço a ser removido: ");
                    String descricaoRemover = scanner.nextLine();
                    servicoGestao.removerServico(descricaoRemover);
                    System.out.println("Tecle enter para voltar ao menu principal:");
                    String enter99 = scanner.nextLine();
                    
                    break;
                case 5:
                    System.out.print("Nome do Produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Quantidade do Produto: ");
                    int quantidade = scanner.nextInt();
                    estoqueGestao.adicionarProduto(new Produto(nomeProduto, quantidade));
                    System.out.println("Tecle enter para voltar ao menu principal:");
                    String enter3 = scanner.nextLine();
                    break;
                case 7:
                    System.out.println("Produtos:");
                    for (Produto produto : estoqueGestao.listarProdutos()) {
                        System.out.println(produto);
                    }
                    System.out.println("Tecle enter para voltar ao menu principal:");
                    String enter4 = scanner.nextLine();
                    break;
                case 6:
                    System.out.print("Nome do Produto a ser editado: ");
                    String nomeProdutoEditar = scanner.nextLine();
                    System.out.print("Novo Nome do Produto: ");
                    String novoNomeProduto = scanner.nextLine();
                    System.out.print("Nova Quantidade do Produto: ");
                    int novaQuantidade = scanner.nextInt();
                    scanner.nextLine();  // Consumir nova linha
                    estoqueGestao.editarProduto(nomeProdutoEditar, novoNomeProduto, novaQuantidade);
                    System.out.println("Produto editado com succeso!:");
                    System.out.println("Tecle enter para voltar ao menu principal:");
                    String enter81 = scanner.nextLine();
                    break;
                case 8:
                    System.out.print("Nome do Produto a ser removido: ");
                    String nomeProdutoRemover = scanner.nextLine();
                    estoqueGestao.removerProduto(nomeProdutoRemover);
                    System.out.println("Produto removido com sucesso!");
                    System.out.println("Tecle enter para voltar ao menu principal:");
                    String enter98 = scanner.nextLine();
                    break;
                case 9:
                    System.out.print("Nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Endereço do Cliente: ");
                    String enderecoCliente = scanner.nextLine();
                    System.out.print("Telefone do Cliente: ");
                    String telefoneCliente = scanner.nextLine();
                    System.out.print("Data do atendimento: ");
                    String data_atendimento = scanner.nextLine();
                    System.out.print("Hora do atendimento: ");
                    String hora_atendimento = scanner.nextLine();
                    Cliente cliente = new Cliente(nomeCliente, enderecoCliente, telefoneCliente, data_atendimento, hora_atendimento);

                    System.out.println("Serviços Disponíveis:");
                    for (int i = 0; i < servicoGestao.listarServicos().size(); i++) {
                        System.out.println((i + 1) + ". " + servicoGestao.listarServicos().get(i));
                    }
                    System.out.print("Escolha o Serviço (Número): ");
                    int servicoEscolhido = scanner.nextInt();
                    Servico servico = servicoGestao.listarServicos().get(servicoEscolhido - 1);

                    Atendimento atendimento = new Atendimento(cliente, servico);
                    atendimentoGestao.agendarAtendimento(atendimento);
                    System.out.println("Tecle enter para voltar ao menu principal:");
                    String enter5 = scanner.nextLine();
                    break;
                case 11:
                    System.out.println("Atendimentos:");
                    for (Atendimento at : atendimentoGestao.listarAtendimentos()) {
                        System.out.println(at);
                    }
                    System.out.println("Tecle enter para voltar ao menu principal:");
                    String enter6 = scanner.nextLine();
                    break;
                case 10:
                    System.out.print("Nome do Cliente do Atendimento a ser editado: ");
                    String nomeClienteEditar = scanner.nextLine();
                    Atendimento atendimentoParaEditar = null;
                    for (Atendimento atendimentos : atendimentoGestao.listarAtendimentos()) {
                        if (atendimentos.getCliente().getNome().equals(nomeClienteEditar)) {
                            atendimentoParaEditar = atendimentos;
                            break;
                        }
                    }
                    if (atendimentoParaEditar == null) {
                        System.out.println("Atendimento não encontrado.");
                        break;
                    }
                    System.out.print("Nova Hora do Atendimento: ");
                    String novaHoraAtendimento = scanner.nextLine();
                    atendimentoParaEditar.getCliente().setHora(novaHoraAtendimento);
                    
                    System.out.print("Nova Data do Atendimento: ");
                    String novaDataAtendimento = scanner.nextLine();
                    atendimentoParaEditar.getCliente().setData(novaDataAtendimento);
                   
                    		
                    System.out.println("Escolha um novo Serviço:");
                    for (int i = 0; i < servicoGestao.listarServicos().size(); i++) {
                        System.out.println(i + 1 + ". " + servicoGestao.listarServicos().get(i));
                    }
                    int novoServicoEscolhido = scanner.nextInt();
                    scanner.nextLine();  // Consumir nova linha
                    Servico novoServico = servicoGestao.listarServicos().get(novoServicoEscolhido - 1);

                    atendimentoGestao.atualizarAtendimento(atendimentoParaEditar, novoServico);
                    break;
                case 12:
                    System.out.print("Nome do Cliente do Atendimento a ser removido: ");
                    String nomeClienteRemover = scanner.nextLine();
                    System.out.print("Descrição do Serviço do Atendimento a ser removido: ");
                    String servicoDescricaoRemover = scanner.nextLine();
                    Atendimento atendimentoRemover = null;
                    for (Atendimento atendimentos : atendimentoGestao.listarAtendimentos()) {
                        if (atendimentos.getCliente().getNome().equals(nomeClienteRemover) &&
                            atendimentos.getServico().getDescricao().equals(servicoDescricaoRemover)) {
                            atendimentoRemover = atendimentos;
                            break;
                        }
                    }
                    if (atendimentoRemover != null) {
                        atendimentoGestao.removerAtendimento(atendimentoRemover);
                        System.out.println("Atendimento removido com sucesso.");
                    } else {
                        System.out.println("Atendimento não encontrado.");
                    }
                    System.out.println("Tecle enter para voltar ao menu principal:");
                    String enter97 = scanner.nextLine();
                    break;    
                case 13:
                    try {
                        servicoGestao.salvarServicos(SERVICOS_FILE);
                        estoqueGestao.salvarProdutos(PRODUTOS_FILE);
                        atendimentoGestao.salvarAtendimentos(ATENDIMENTOS_FILE);
                        System.out.println("Dados salvos com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar dados: " + e.getMessage());
                    }
                    System.out.println("Tecle enter para voltar ao menu principal:");
                    String enter7 = scanner.nextLine();
                    break;
                case 14:
                    try {
                        servicoGestao.carregarServicos(SERVICOS_FILE);
                        estoqueGestao.carregarProdutos(PRODUTOS_FILE);
                        atendimentoGestao.carregarAtendimentos(ATENDIMENTOS_FILE);
                        System.out.println("Dados carregados com sucesso!");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao carregar dados: " + e.getMessage());
                    }
                    System.out.println("Tecle enter para voltar ao menu principal:");
                    String enter8 = scanner.nextLine();
                    break;
                case 15:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
