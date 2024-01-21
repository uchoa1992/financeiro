package br.com.projeto_financeiro;

import java.util.Calendar;

public class Despesas {
    private static int count = 1;

    private int id, dia, mes, ano, hoje;
    private String descricao, tipo, situacao;
    private double valor;
    private boolean info;

    public Despesas(String descricao, String tipo, int dia, double valor, boolean info) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.dia = dia;
        this.valor = valor;
        this.info = info;
        id = count;
        count++;
    }

//    public void CalcularDia(int dia)
//    {
//        Calendar data = Calendar.getInstance();
//        Integer hoje = data.get(Calendar.DAY_OF_MONTH);
//
//        if (!info) {
//            if (dia - hoje > 1) {
//                this.situacao = "Faltam " + (dia - hoje) + " dias para o vencimento";
//            } else if (dia - hoje == 1) {
//                this.situacao = "O vencimento é amanhã";
//            } else if (dia - hoje == 0) {
//                this.situacao = "O vencimento é hoje";
//            } else {
//                this.situacao = "Está vencido";
//            }
//        }
//        else
//        {
//            this.situacao = "Pago";;
//        }
//    }

    @Override
    public String toString() {

        String resultado;

        Calendar data = Calendar.getInstance();
        hoje = data.get(Calendar.DAY_OF_MONTH);
        mes = data.get(Calendar.MONTH) + 1;
        ano = data.get(Calendar.YEAR);

        if (!info) {
            if (dia - hoje > 1) {
                this.situacao = "Faltam " + (dia - hoje) + " dias para o vencimento";
            } else if (dia - hoje == 1) {
                this.situacao = "O vencimento é amanhã";
            } else if (dia - hoje == 0) {
                this.situacao = "O vencimento é hoje";
            } else {
                this.situacao = "Está vencido";
            }
        }
        else
        {
            this.situacao = "Pago";;
        }

        if (info)
        {
            resultado = "sim";
        }

        else
        {
            resultado = "não";
        }

        return "Contas a pagar {" +
                "nº = " + id +
                ", descricao = " + descricao +
                ", tipo = " + tipo +
                ", data = " + dia + "/" + mes + "/" + ano +
                ", valor = " + valor +
                ", pago = " + resultado +
                ", Situação = " + situacao +
                "}";
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isInfo() {
        return info;
    }

    public void setInfo(boolean info) {
        this.info = info;
    }

    public int getHoje() {
        return hoje;
    }
}
