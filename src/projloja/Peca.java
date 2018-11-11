package projloja;

public class Peca {

    private String modeloDaPeca;
    private String tipoPeca;
    private double valorPeca;
    private long codigoPeca;
    private int quantidade;
    Fornecedor objFornecedor;
    Cliente objCliente;

    public Peca() {
        this.objFornecedor = new Fornecedor();
        this.objCliente = new Cliente();
    }

    public String getModeloDaPeca() {
        return modeloDaPeca;
    }

    public void setModeloDaPeca(String modeloDaPeca) {
        this.modeloDaPeca = modeloDaPeca;
    }

    public String getTipoPeca() {
        return tipoPeca;
    }

    public void setTipoPeca(String tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    public double getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(double valorPeca) {
        this.valorPeca = valorPeca;
    }

    public long getCodigoPeca() {
        return codigoPeca;
    }

    public void setCodigoPeca(long codigoPeca) {
        this.codigoPeca = codigoPeca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularValorTotal() {
        return this.valorPeca * this.quantidade;
    }

    @Override
    public String toString() {
        return "\n"
                + "CPF do cliente que efetuou a compra: " + objCliente.getCpf() + "\n"
                + "Modelo da peça: " + modeloDaPeca + "\n"
                + "Tipo de peça: " + tipoPeca + "\n"
                + "Valor da peça: " + valorPeca + "\n"
                + "Codigo da peça: " + codigoPeca + "\n"
                + "Quantidade: " + quantidade + "\n"
                + "Valor total: " + this.calcularValorTotal();
    }

}
