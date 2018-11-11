package projloja;

import java.util.ArrayList;

public class Loja {

    private ArrayList<Venda> listaPedidos;
    Funcionario objFuncionario;

    public Loja() {
        this.listaPedidos = new ArrayList<>();
        this.objFuncionario = new Funcionario();
    }

    public ArrayList<Venda> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Venda> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    @Override
    public String toString() {
        return "\n"
                + "Pedidos: " + listaPedidos;
    }

}
