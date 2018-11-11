package projloja;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Funcionario objFuncionario = new Funcionario();
        Loja objLoja = new Loja();
        Venda objVenda = new Venda();
        Data objData = new Data();
        byte op;

        JOptionPane.showMessageDialog(null, "                                         Assistente de Vendas\n"
                + "Seja bem vindo ao assistente de vendas! Aperte 'OK' para continuar", "LOJA VENDAS", JOptionPane.DEFAULT_OPTION);
        do {
            op = Byte.parseByte(JOptionPane.showInputDialog("Escolha uma opção conforme a legenda abaixo: \n"
                    + "1 - Efetuar compra\n"
                    + "2 - Cadastrar entidades\n"
                    + "3 - Alteração ou exclusão de dados\n"
                    + "4 - Excluir todos os dados\n"
                    + "5 - Checar compras efetuadas\n"
                    + "0 - Encerrar o sistema"));
            switch (op) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Você escolheu 'efetuar uma compra', aperte 'OK' para continuar! ", "EFETUAR COMPRA", JOptionPane.INFORMATION_MESSAGE);
                    int confirmacao;
                    do {
                        Peca objPeca = new Peca();
                        Cliente pesquisarCliente = objVenda.procurarClientePorCpf(Long.parseLong(JOptionPane.showInputDialog("Informe o CPF do cliente (o cliente precisa estar cadastrado para efetuar a compra): ")));
                        if (pesquisarCliente == null) {
                            JOptionPane.showMessageDialog(null, "Cliente não cadastrado ou CPF digitado inválido, a compra seguirá, mas a efetuação ficará incompleta");
                        }
                        objPeca.setModeloDaPeca(JOptionPane.showInputDialog("Informe o modelo da peça: "));
                        Object[] itemPeca = {"Processador", "HD", "Memória RAM", "SSD", "Placa mãe", "Fonte de alimentação", "Placa de vídeo", "Gabinete"};
                        objPeca.setTipoPeca((String) JOptionPane.showInputDialog(null, "Escolha a Peça: ", "Menu Peça", JOptionPane.QUESTION_MESSAGE, null, itemPeca, itemPeca[0]));
                        objPeca.setCodigoPeca(Long.parseLong(JOptionPane.showInputDialog("Informe o código da peça: ")));
                        objPeca.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Quantidade: ")));
                        objPeca.setValorPeca(Double.parseDouble(JOptionPane.showInputDialog("Valor da peça: ")));
                        objVenda.getListaDePecas().add(objPeca);
                        confirmacao = JOptionPane.showConfirmDialog(null, "O cliente tem mais algum produto para comprar?", "MENU COMPRA", 0);
                    } while (confirmacao == 0);
                    JOptionPane.showMessageDialog(null, "Informe a data em que a compra está sendo efetuada");
                    do {
                        objVenda.objData.setDia(Byte.parseByte(JOptionPane.showInputDialog("Dia: ")));
                        objVenda.objData.setMes(Byte.parseByte(JOptionPane.showInputDialog("Mes: ")));
                        objVenda.objData.setAno(Integer.parseInt(JOptionPane.showInputDialog("Ano: ")));
                        if (objVenda.objData.validarData() == false) {
                            JOptionPane.showMessageDialog(null, "Data inválida\n"
                                    + "Digite novamente", "ERRO", 0);;
                        } else {
                            JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!");
                        }
                    } while (objVenda.objData.validarData() != true);
                    objLoja.getListaPedidos().add(objVenda);
                    objVenda.getDatasDeComprasEfetuadas().add(objData);
                    break;
                case 2:
                    do {
                        op = Byte.parseByte(JOptionPane.showInputDialog(null, "Escolha uma opção conforme a legenda abaixo\n"
                                + "1 - Funcionário\n"
                                + "2 - Cliente\n"
                                + "3 - Fornecedor\n"
                                + "4 - Voltar"));
                        switch (op) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Informe os dados do funcionário a seguir");
                                objFuncionario.setNome(JOptionPane.showInputDialog("Nome do funcionário: "));
                                objFuncionario.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF do funcionário: ")));
                                objFuncionario.setChapa(JOptionPane.showInputDialog("Chapa do funcionário: "));
                                objFuncionario.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Salário do funcionários: ")));
                                JOptionPane.showMessageDialog(null, "Informe o endereço do funcionário a seguir");
                                objFuncionario.objEndereco.setRua(JOptionPane.showInputDialog("Rua: "));
                                objFuncionario.objEndereco.setBairro(JOptionPane.showInputDialog("Bairro: "));
                                objFuncionario.objEndereco.setCep(Integer.parseInt(JOptionPane.showInputDialog("CEP: ")));
                                objFuncionario.objEndereco.setComplemento(JOptionPane.showInputDialog("Complemento: "));
                                JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso!");
                                objVenda.getListaDeFuncionarios().add(objFuncionario);
                                break;
                            case 2:
                                Cliente objCliente = new Cliente();
                                JOptionPane.showMessageDialog(null, "Informe os dados do cliente a seguir");
                                objCliente.setNome(JOptionPane.showInputDialog("Nome do cliente: "));
                                objCliente.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF do cliente: ")));
                                objCliente.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Código do cliente: ")));
                                JOptionPane.showMessageDialog(null, "Informe o endereço do cliente a seguir");
                                objCliente.objEndereco.setRua(JOptionPane.showInputDialog("Rua: "));
                                objCliente.objEndereco.setBairro(JOptionPane.showInputDialog("Bairro: "));
                                objCliente.objEndereco.setCep(Integer.parseInt(JOptionPane.showInputDialog("CEP: ")));
                                objCliente.objEndereco.setComplemento(JOptionPane.showInputDialog("Complemento: "));
                                JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso!");
                                objVenda.getListaDeClientes().add(objCliente);
                                break;
                            case 3:
                                Fornecedor objFornecedor = new Fornecedor();
                                JOptionPane.showMessageDialog(null, "Informe os dados do fornecedor a seguir");
                                objFornecedor.setNomeDaEmpresa(JOptionPane.showInputDialog("Nome da empresa: "));
                                objFornecedor.setCnpj(Long.parseLong(JOptionPane.showInputDialog("CNPJ: ")));
                                JOptionPane.showMessageDialog(null, "Informe o endereço da empresa a seguir");
                                objFornecedor.objEndereco.setRua(JOptionPane.showInputDialog("Rua: "));
                                objFornecedor.objEndereco.setBairro(JOptionPane.showInputDialog("Bairro: "));
                                objFornecedor.objEndereco.setCep(Integer.parseInt(JOptionPane.showInputDialog("CEP: ")));
                                objFornecedor.objEndereco.setComplemento(JOptionPane.showInputDialog("Complemento: "));
                                JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
                                objVenda.getListaDeFornecedores().add(objFornecedor);
                                break;
                            case 4:

                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Número digitado inválido\n"
                                        + "       Digite novamente", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }

                    } while (op != 4);
                    break;
                case 3:
                    do {
                        op = Byte.parseByte(JOptionPane.showInputDialog("Escolha uma opção abaixo\n"
                                + "1 - Excluir\n"
                                + "2 - Alterar\n"
                                + "3 - Voltar"));
                        switch (op) {
                            case 1:
                                do {
                                    op = Byte.parseByte(JOptionPane.showInputDialog("Escolha a entidade que você quer excluir\n"
                                            + "1 - Funcionario\n"
                                            + "2 - Cliente\n"
                                            + "3 - Fornecedor\n"
                                            + "4 - Voltar"));
                                    switch (op) {
                                        case 1:
                                            if (objVenda.getListaDeFuncionarios().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Não ha funcionarios cadastrados, sinto muito!");
                                            } else {
                                                Funcionario pesquisaF = objVenda.pesquisarFuncionarioPorChapa(JOptionPane.showInputDialog("Informe a chapa do funcionário: "));
                                                confirmacao = JOptionPane.showConfirmDialog(null, "O funcionário é: " + pesquisaF + " Deseja realmente exclui-lo?", "EXCLUSÃO FUNCIONÁRIOS", JOptionPane.YES_NO_OPTION);
                                                if (confirmacao == 0) {
                                                    objVenda.getListaDeFuncionarios().remove(pesquisaF);
                                                    JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Operação cancelada");
                                                }
                                            }
                                            break;
                                        case 2:
                                            if (objVenda.getListaDeClientes().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Não há clientes cadastrados, sinto muito!");
                                            } else {
                                                Cliente c = objVenda.procurarClientePorCpf(Long.parseLong(JOptionPane.showInputDialog("Informe o CPF do cliente: ")));
                                                confirmacao = JOptionPane.showConfirmDialog(null, "O cliente é: " + c + " Deseja realmente excluir?", "EXCLUSÃO CLIENTES", JOptionPane.YES_NO_OPTION);
                                                if (confirmacao == 0) {
                                                    objVenda.getListaDeClientes().remove(c);
                                                    JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Operação cancelada");
                                                }
                                            }
                                            break;
                                        case 3:
                                            if (objVenda.getListaDeFornecedores().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Não há fornecedores cadastrados, sinto muito!");
                                            } else {
                                                Fornecedor pesquisarFornecedor = objVenda.procurarFornecedorPorCnpj(Long.parseLong(JOptionPane.showInputDialog("Informe o CNPJ do fornecedor: ")));
                                                confirmacao = JOptionPane.showConfirmDialog(null, "O fornecedor é: " + pesquisarFornecedor + " Deseja realmente exclui-lo?", "EXCLUSÃO FUNCIONÁRIOS", JOptionPane.YES_NO_OPTION);
                                                if (confirmacao == 0) {
                                                    objVenda.getListaDeFornecedores().remove(pesquisarFornecedor);
                                                    JOptionPane.showMessageDialog(null, "Forncedor excluido");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Operação cancelada");
                                                }
                                            }
                                            break;
                                        case 4:

                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Número digitado inválido\n"
                                                    + "       Digite novamente", "ERRO", JOptionPane.ERROR_MESSAGE);
                                    }
                                } while (op != 4);
                                break;
                            case 2:
                                do {
                                    op = Byte.parseByte(JOptionPane.showInputDialog("Escolha a entidade que quer alterar\n"
                                            + "1 - Funcionario\n"
                                            + "2 - Cliente (apenas CEP)\n"
                                            + "3 - Fornecedor (Somente nome da empresa)\n"
                                            + "4 - Voltar"));
                                    switch (op) {
                                        case 1:
                                            if (objVenda.getListaDeFuncionarios().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Não há funcionários cadastrados, sinto muito!");
                                            } else {
                                                do {
                                                    op = Byte.parseByte(JOptionPane.showInputDialog("Escolha o dado a ser alterado\n"
                                                            + "1 - Salário\n"
                                                            + "2 - CEP\n"
                                                            + "3 - Voltar"));
                                                    switch (op) {
                                                        case 1:
                                                            JOptionPane.showMessageDialog(null, "Informe o novo salário do funcionário");
                                                            objVenda.pesquisarFuncionarioPorChapa(JOptionPane.showInputDialog("Digite a chapa do funcionário: ")).setSalario(Double.parseDouble(JOptionPane.showInputDialog("Digite o novo salario: ")));
                                                            JOptionPane.showMessageDialog(null, "Salário alterado com sucesso!");
                                                            break;
                                                        case 2:
                                                            JOptionPane.showMessageDialog(null, "Informe o novo endereço do funcionário");
                                                            objVenda.pesquisarFuncionarioPorChapa(JOptionPane.showInputDialog("Digite a chapa do funcionário: ")).objEndereco.setCep(Integer.parseInt(JOptionPane.showInputDialog("Informe o novo CEP: ")));
                                                            JOptionPane.showMessageDialog(null, "CEP alterado com sucesso!");
                                                            break;
                                                        case 3:

                                                            break;
                                                        default:
                                                            JOptionPane.showMessageDialog(null, "Número digitado inválido\n"
                                                                    + "       Digite novamente", "ERRO", JOptionPane.ERROR_MESSAGE);

                                                    }
                                                } while (op != 3);
                                            }
                                            break;
                                        case 2:
                                            if (objVenda.getListaDeClientes().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Não ha clientes cadastrados");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Informe o novo CEP do cliente");
                                                objVenda.procurarClientePorCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do cliente: "))).objEndereco.setCep(Integer.parseInt(JOptionPane.showInputDialog("Rua: ")));
                                                JOptionPane.showMessageDialog(null, "CEP alterado com sucesso!");
                                            }
                                            break;
                                        case 3:
                                            if (objVenda.getListaDeFornecedores().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Não ha fornecedores cadastrados");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Informe o novo CEP do fornecedor");
                                                objVenda.procurarFornecedorPorCnpj(Long.parseLong(JOptionPane.showInputDialog("Digite o CNPJ do fornecedor: "))).objEndereco.setCep(Integer.parseInt(JOptionPane.showInputDialog("Informe o novo CEP da fornecedor: ")));
                                                JOptionPane.showMessageDialog(null, "CEP alterado com sucesso!");
                                            }
                                            break;
                                        case 4:

                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Número digitado inválido\n"
                                                    + "       Digite novamente", "ERRO", JOptionPane.ERROR_MESSAGE);
                                    }
                                } while (op != 4);
                                break;
                            case 3:

                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Número digitado inválido\n"
                                        + "       Digite novamente", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (op != 3);

                    break;
                case 4:
                    if (objLoja.getListaPedidos().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há dados cadastrados, sinto muito!");
                    } else if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir todos os dados?", "EXCLUIR PEDIDOS", 0) == 0) {
                        objLoja.getListaPedidos().clear();
                        JOptionPane.showMessageDialog(null, "Todos os dados foram excluídos com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Exclusão cancelada, aperte 'OK' para volta ao menu principal");
                    }
                    break;
                case 5:
                    if (objLoja.getListaPedidos().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há pedidos efetuados, sinto muito!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista de pedidos: " + objVenda.toString());
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Sistema encerrado, até mais!", "SISTEMA ENCERRADO", JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Número digitado inválido\n"
                            + "       Digite novamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        } while (op != 0);
    }
}
