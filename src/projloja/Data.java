
package projloja;


public class Data {
    private byte dia;
    private byte mes;
    private int ano;

    public byte getDia() {
        return dia;
    }

    public void setDia(byte dia) {
        this.dia = dia;
    }

    public byte getMes() {
        return mes;
    }

    public void setMes(byte mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    public boolean validarData(){
        return dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && (mes != 2 || ano%4 == 0 || dia <= 28) && (mes != 2 || ano%4 != 0 || ano%100 != 0 || ano%400 == 0 || dia <= 28) && (mes != 4 || dia <= 30) && (mes != 6 || dia <= 30) && (mes != 9 || dia <= 30) && (mes != 11 || dia <= 30);
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano ;
    }
    
    
}
