package projloja;

import java.util.ArrayList;

public class Venda {

    private ArrayList<Peca> listaDePecas;
    private ArrayList<Funcionario> listaDeFuncionarios;
    private ArrayList<Cliente> listaDeClientes;
    private ArrayList<Fornecedor> listaDeFornecedores;
    private ArrayList<Data> datasDeComprasEfetuadas;
    Funcionario objFuncionario;
    Cliente objCliente;
    Data objData;

    public Venda() {
        this.listaDePecas = new ArrayList<>();
        this.listaDeFuncionarios = new ArrayList<>();
        this.listaDeClientes = new ArrayList<>();
        this.listaDeFornecedores = new ArrayList<>();
        this.datasDeComprasEfetuadas = new ArrayList<>();
        this.objFuncionario = new Funcionario();
        this.objCliente = new Cliente();
        this.objData = new Data();
    }

    public ArrayList<Peca> getListaDePecas() {
        return listaDePecas;
    }

    public void setListaDePecas(ArrayList<Peca> listaDePecas) {
        this.listaDePecas = listaDePecas;
    }

    public ArrayList<Funcionario> getListaDeFuncionarios() {
        return listaDeFuncionarios;
    }

    public void setListaDeFuncionarios(ArrayList<Funcionario> listaDeFuncionarios) {
        this.listaDeFuncionarios = listaDeFuncionarios;
    }

    public ArrayList<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(ArrayList<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

    public ArrayList<Fornecedor> getListaDeFornecedores() {
        return listaDeFornecedores;
    }

    public void setListaDeFornecedores(ArrayList<Fornecedor> listaDeFornecedores) {
        this.listaDeFornecedores = listaDeFornecedores;
    }
    
    public ArrayList<Data> getDatasDeComprasEfetuadas() {
        return datasDeComprasEfetuadas;
    }

    public void setDatasDeComprasEfetuadas(ArrayList<Data> datasDeComprasEfetuadas) {
        this.datasDeComprasEfetuadas = datasDeComprasEfetuadas;
    }

    public String legendaListaPecas() {
        String legenda = "";
        for (int i = 0; i < listaDePecas.size(); i++) {
            legenda += "\n::::::::::::::: PEÇA " + (i + 1) + " ::::::::::::::"
                    + this.listaDePecas.get(i) + "\n";

        }
        return legenda;
    }
    
    public String legendaListaClientes() {
        String legenda = "";
        for (int i = 0; i < listaDeClientes.size(); i++) {
            legenda += "\n::::::::::::::: CLIENTE " + (i + 1) + " ::::::::::::::"
                    + this.listaDeClientes.get(i) + "\n";
        }
        return legenda;
    }
    
    public String legendaListaFuncionarios() {
        String legenda = "";
        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
            legenda += "\n::::::::::::::: FUNCIONÁRIO " + (i + 1) + " ::::::::::::::"
                    + this.listaDeFuncionarios.get(i) + "\n";
        }
        return legenda;
    }

    public Peca pesquisarPecaPeloCodigo(long codigoPeca) {
        for (int i = 0; i < this.listaDePecas.size(); i++) {
            if (this.listaDePecas.get(i).getCodigoPeca() == codigoPeca) {
                return this.listaDePecas.get(i);
            }
        }
        return null;
    }
    
    public String legendaDatas() {
        String legenda = "";
        for (int i = 0; i < datasDeComprasEfetuadas.size(); i++) {
            legenda += "\n::::::::::::::: DATA " + (i + 1) + " ::::::::::::::"
                    + this.datasDeComprasEfetuadas.get(i) + "\n";

        }
        return legenda;
    }

    public ArrayList<Peca> pesquisarTiposDePeca(String modeloPeca) {
        ArrayList<Peca> tiposDePeca = new ArrayList<>();
        for (int i = 0; i < this.listaDePecas.size(); i++) {
            if (this.listaDePecas.get(i).getModeloDaPeca().equals(modeloPeca)) {
                tiposDePeca.add(this.listaDePecas.get(i));
            }
        }
        return tiposDePeca;
    }

    public Peca alterarModeloPeloCodigo(long codigoPeca) {
        for (int i = 0; i < this.listaDePecas.size(); i++) {
            if (this.listaDePecas.get(i).getCodigoPeca() == codigoPeca) {
                return this.listaDePecas.get(i);
            }
        }
        return null;
    }

    public Peca removerPecaPeloCodigo(long codigoPeca) {
        for (int i = 0; i < this.listaDePecas.size(); i++) {
            if (this.listaDePecas.get(i).getCodigoPeca() == codigoPeca) {
                return this.listaDePecas.get(i);
            }
        }
        return null;
    }

    public Funcionario pesquisarFuncionarioPorChapa(String chapa) {
        for (int i = 0; i < this.listaDeFuncionarios.size(); i++) {
            if (this.listaDeFuncionarios.get(i).getChapa().equalsIgnoreCase(chapa)) {
                return this.listaDeFuncionarios.get(i);
            }

        }
        return null;
    }

    public Cliente procurarClientePorCpf(long cpf) {
        for (int i = 0; i < this.listaDeClientes.size(); i++) {
            if (this.listaDeClientes.get(i).getCpf() == cpf) {
                return this.listaDeClientes.get(i);
            }
        }
        return null;
    }

    public Fornecedor procurarFornecedorPorCnpj(long cnpj) {
        for (int i = 0; i < this.listaDeFornecedores.size(); i++) {
            if (this.listaDeFornecedores.get(i).getCnpj() == cnpj) {
                return this.listaDeFornecedores.get(i);
            }

        }
        return null;
    }
    

    @Override
    public String toString() {
        return "\n"
                + "Peças: \n" + this.legendaListaPecas() + "\n"
                + "\nClientes que efetuaram as compras: " + this.legendaListaClientes() + "\n"
                + "\nFuncionários que efetuaram as compras: \n" + this.legendaListaFuncionarios() + "\n"
                + "\nData de compras efetuadas: " + this.legendaDatas() + "\n"
                + "Data em que a compra foi efetuada: " + objData;
    }

}
