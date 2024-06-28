import java.util.Date;
import java.util.Scanner;

public class SistemaGestaoPiscinas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ServicoGestao servicoGestao = new ServicoGestao();
        EstoqueGestao estoqueGestao = new EstoqueGestao();
        AtendimentoGestao atendimentoGestao = new AtendimentoGestao();

        while (true) {
            System.out.println("Sistema de Gestão de Piscinas");
            System.out.println("1. Adicionar Serviço");
            System.out.println("2. Listar Serviços");
            System.out.println("3. Adicionar Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Agendar Atendimento");
            System.out.println("6. Listar Atendimentos");
            System.out.println("7. Sair");
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
                    break;
                case 2:
                    System.out.println("Serviços:");
                    for (Servico servico : servicoGestao.listarServicos()) {
                        System.out.println(servico);
                    }
                    break;
                case 3:
                    System.out.print("Nome do Produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Quantidade do Produto: ");
                    int quantidade = scanner.nextInt();
                    estoqueGestao.adicionarProduto(new Produto(nomeProduto, quantidade));
                    break;
                case 4:
                    System.out.println("Produtos:");
                    for (Produto produto : estoqueGestao.listarProdutos()) {
                        System.out.println(produto);
                    }
                    break;
                case 5:
                    System.out.print("Nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Endereço do Cliente: ");
                    String enderecoCliente = scanner.nextLine();
                    System.out.print("Telefone do Cliente: ");
                    String telefoneCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nomeCliente, enderecoCliente, telefoneCliente);

                    System.out.println("Serviços Disponíveis:");
                    for (int i = 0; i < servicoGestao.listarServicos().size(); i++) {
                        System.out.println((i + 1) + ". " + servicoGestao.listarServicos().get(i));
                    }
                    System.out.print("Escolha o Serviço (Número): ");
                    int servicoEscolhido = scanner.nextInt();
                    Servico servico = servicoGestao.listarServicos().get(servicoEscolhido - 1);

                    Atendimento atendimento = new Atendimento(cliente, servico, new Date());
                    atendimentoGestao.agendarAtendimento(atendimento);
                    break;
                case 6:
                    System.out.println("Atendimentos:");
                    for (Atendimento at : atendimentoGestao.listarAtendimentos()) {
                        System.out.println(at);
                    }
                    break;
                case 7:
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