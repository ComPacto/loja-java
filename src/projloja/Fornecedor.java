package projloja;

public class Fornecedor {

    private String nomeDaEmpresa;
    private long cnpj;
    Endereco objEndereco;

    public Fornecedor() {
        this.objEndereco = new Endereco();
    }

    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "\n"
                + "Nome da empresa: " + nomeDaEmpresa + "\n"
                + "Cnpj: " + cnpj + "\n"
                + "Endereco: " + objEndereco;
    }

}
