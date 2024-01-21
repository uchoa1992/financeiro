package br.com.projeto_financeiro;

public class Receitas {
    private static int count = 1;
    private int id, dia, mes, ano;
    private double valor;
    private String nome, servico;

    public Receitas(String nome, String servico, double valor, int dia, int mes, int ano) {
        this.nome = nome;
        this.servico = servico;
        this.valor = valor;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        id = count;
        count++;
    }

    @Override
    public String toString() {
        return "Receitas {" +
                "nº = " + id +
                ", nome = " + nome +
                ", servico = " + servico +
                ", valor = " + valor +
                ", data = " + dia + "/" + mes + "/" + ano +
                "}";
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
}
