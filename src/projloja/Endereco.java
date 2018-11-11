
package projloja;


public class Endereco {
    private String rua;
    private String bairro;
    private int cep;
    private String complemento;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "\n"
                + "Rua: " + rua + "\n"
                + "Bairro: " + bairro + "\n"
                + "Cep: " + cep + "\n"
                + "Complemento: " + complemento;
    }
    
    
}
