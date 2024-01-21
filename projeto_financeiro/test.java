package br.com.projeto_financeiro;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Despesas> despesas;
    static ArrayList<Receitas> receitas;
    static boolean condicao = true;

    public static void main(String[] args)
    {
        despesas = new ArrayList<Despesas>();
        receitas = new ArrayList<Receitas>();
        menu_inicial();

    }

    private static void menu_inicial()
    {
        System.out.println("--------------------------------------");
        System.out.println("----------Sistema Financeiro----------");
        System.out.println("--------------------------------------");
        System.out.println("******* Selecione uma operação *******");
        System.out.println("|  Opção 1 - Receita     |");
        System.out.println("|  Opção 2 - Despesa     |");
        System.out.println("|  Opção 3 - Relatório   |");
        System.out.println("|  Opção 4 - Sair        |");

        int operacao = teclado.nextInt();

        switch (operacao)
        {
            case 1:
                menu_receita();
                break;

            case 2:
                menu_despesa();
                break;

            case 3:
                menu_relatorio();
                break;

            case 4:
                System.out.println("Encerrando o sistema");
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida");
                menu_inicial();
                break;
        }
    }

    public static void menu_receita()
    {
        System.out.println("----------------------------");
        System.out.println("----------Receitas----------");
        System.out.println("----------------------------");
        System.out.println("******* Selecione uma operação *******");
        System.out.println("|  Opção 1 - Adicionar Receita |");
        System.out.println("|  Opção 2 - Listar Receitas   |");
        System.out.println("|  Opção 3 - Alterar Receita   |");
        System.out.println("|  Opção 4 - Excluir Receita   |");
        System.out.println("|  Opção 5 - Voltar            |");
        System.out.println("|  Opção 6 - Sair              |");

        int operacao_receita = teclado.nextInt();

        switch (operacao_receita)
        {
            case 1:
                adicionar_receita();
                break;

            case 2:
                listar_receita();
                break;

            case 3:
                alterar_receita();
                break;

            case 4:
                excluir_receita();
                break;

            case 5:
                menu_inicial();
                break;

            case 6:
                System.out.println("Encerrando o sistema");
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida");
                menu_receita();
                break;

        }
    }

    public static void adicionar_receita()
    {
        System.out.println("Nome do paciente");
        String nome = teclado.next();

        System.out.println("Serviço contratado");
        String servico = teclado.next();

        System.out.println("Valor pago");
        double valor = teclado.nextDouble();

        System.out.println("Dia");
        int dia = teclado.nextInt();

        System.out.println("Mes");
        int mes = teclado.nextInt();

        System.out.println("Ano");
        int ano = teclado.nextInt();

        Receitas receita = new Receitas(nome, servico, valor, dia, mes, ano);
        receitas.add(receita);

        System.out.println("Receita Adicionada com sucesso");
        menu_receita();
    }

    public static void listar_receita()
    {
        if(receitas.size() > 0)
        {
            for (Receitas lista_receita : receitas)
            {
                System.out.println(lista_receita);
            }
        }

        else
        {
            System.out.println("Não há despesa cadastada");
        }

        menu_receita();
    }

    public static void alterar_receita()
    {
        if(receitas.size() > 0)
        {
            int opcao = 0;
            int continuar = 0;
            condicao = true;
            System.out.println("***** Digite a receita que você deseja alterar *****");
            opcao = teclado.nextInt();

            for (Receitas lista_receita : receitas)
            {
                if(opcao == lista_receita.getId())
                {
                    while (condicao)
                    {
                        System.out.println(lista_receita);
                        System.out.println("******* Selecione uma operação *******");
                        System.out.println("|  Opção 1 - Alterar nome     |");
                        System.out.println("|  Opção 2 - Alterar serviço  |");
                        System.out.println("|  Opção 3 - Alterar valor    |");
                        System.out.println("|  Opção 4 - Alterar dia      |");
                        System.out.println("|  Opção 5 - Alterar mes      |");
                        System.out.println("|  Opção 6 - Voltar           |");

                        int operacao = teclado.nextInt();

                        switch (operacao) {
                            case 1:
                                System.out.println("Digite o novo nome");
                                String novoNome = teclado.next();
                                lista_receita.setNome(novoNome);
                                System.out.println("******* Selecione uma operação *******");
                                System.out.println("|  Opção 1 - Fazer uma nova alteração  |");
                                System.out.println("|  Opção 2 - Alterar uma nova receita  |");
                                System.out.println("|  Opção 3 - Voltar                    |");

                                continuar = teclado.nextInt();
                                switch (continuar)
                                {
                                    case 1:
                                        break;

                                    case 2:
                                        condicao = false;
                                        alterar_receita();
                                        break;

                                    case 3:
                                        condicao = false;
                                        menu_receita();
                                        break;

                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                                break;

                            case 2:
                                System.out.println("Digite o novo serviço");
                                String novoServico = teclado.next();
                                lista_receita.setServico(novoServico);
                                System.out.println("******* Selecione uma operação *******");
                                System.out.println("|  Opção 1 - Fazer uma nova alteração  |");
                                System.out.println("|  Opção 2 - Alterar uma nova conta    |");
                                System.out.println("|  Opção 3 - Voltar                    |");

                                continuar = teclado.nextInt();
                                switch (continuar)
                                {
                                    case 1:
                                        break;

                                    case 2:
                                        condicao = false;
                                        alterar_receita();
                                        break;

                                    case 3:
                                        condicao = false;
                                        menu_receita();
                                        break;

                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                                break;

                            case 3:
                                System.out.println("Digite o novo valor");
                                int novoValor = teclado.nextInt();
                                lista_receita.setValor(novoValor);
                                System.out.println("******* Selecione uma operação *******");
                                System.out.println("|  Opção 1 - Fazer uma nova alteração  |");
                                System.out.println("|  Opção 2 - Alterar uma nova conta    |");
                                System.out.println("|  Opção 3 - Voltar                    |");

                                continuar = teclado.nextInt();
                                switch (continuar)
                                {
                                    case 1:
                                        break;

                                    case 2:
                                        condicao = false;
                                        alterar_receita();
                                        break;

                                    case 3:
                                        condicao = false;
                                        menu_receita();
                                        break;

                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                                break;

                            case 4:
                                System.out.println("Digite o novo dia");
                                int novoDia = teclado.nextInt();
                                lista_receita.setDia(novoDia);
                                System.out.println("******* Selecione uma operação *******");
                                System.out.println("|  Opção 1 - Fazer uma nova alteração  |");
                                System.out.println("|  Opção 2 - Alterar uma nova conta    |");
                                System.out.println("|  Opção 3 - Voltar                    |");

                                continuar = teclado.nextInt();
                                switch (continuar)
                                {
                                    case 1:
                                        break;

                                    case 2:
                                        condicao = false;
                                        alterar_receita();
                                        break;

                                    case 3:
                                        condicao = false;
                                        menu_receita();
                                        break;

                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                                break;

                            case 5:
                                System.out.println("Digite o novo mês");
                                int novoMes = teclado.nextInt();
                                lista_receita.setMes(novoMes);
                                System.out.println("******* Selecione uma operação *******");
                                System.out.println("|  Opção 1 - Fazer uma nova alteração  |");
                                System.out.println("|  Opção 2 - Alterar uma nova conta    |");
                                System.out.println("|  Opção 3 - Voltar                    |");

                                continuar = teclado.nextInt();
                                switch (continuar) {
                                    case 1:
                                        break;

                                    case 2:
                                        condicao = false;
                                        alterar_receita();
                                        break;

                                    case 3:
                                        condicao = false;
                                        menu_receita();
                                        break;

                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                                break;

                            case 6:
                                menu_receita();
                                break;

                            default:
                                System.out.println("Opção inválida");
                                menu_receita();
                                break;

                        }
                    }
                }
            }
            System.out.println("Receita não encontrada");
            alterar_despesa();
        }
        else
        {
            System.out.println("Não há receita cadastrada");
            menu_despesa();
        }
    }

    public static void excluir_receita()
    {
        if (receitas.size() > 0)
        {
            int opcao = 0;
            int continuar = 0;
            condicao = true;
            System.out.println("***** Digite a receita que você deseja excluir *****");
            opcao = teclado.nextInt();

            for (Receitas lista_receita : receitas)
            {
                if (opcao == lista_receita.getId())
                {
                    System.out.println(lista_receita);
                    System.out.println("***** Você tem certeza que deseja excluir? *****");
                    System.out.println("|  Opcão 1 - Sim  |");
                    System.out.println("|  Opcão 2 - Não  |");
                    continuar = teclado.nextInt();

                    switch (continuar)
                    {
                        case 1:
                            despesas.remove(lista_receita);
                            System.out.println("Receita excluída com sucesso");
                            System.out.println("******* Selecione uma operação *******");
                            System.out.println("|  Opção 1 - Fazer uma nova exclusão  |");
                            System.out.println("|  Opção 2 - Voltar                   |");
                            continuar = teclado.nextInt();

                            switch (continuar)
                            {
                                case 1:
                                    excluir_receita();
                                    break;

                                case 2:
                                    menu_receita();
                                    break;
                            }

                            break;

                        case 2:
                            System.out.println("******* Selecione uma operação *******");
                            System.out.println("|  Opção 1 - Fazer uma nova exclusão  |");
                            System.out.println("|  Opção 2 - Voltar                   |");
                            continuar = teclado.nextInt();

                            switch (continuar)
                            {
                                case 1:
                                    excluir_receita();
                                    break;

                                case 2:
                                    menu_receita();
                                    break;
                            }

                            break;

                    }

                }
            }

            System.out.println("Receita não encontrada");
            excluir_despesa();
        }

        else
        {
            System.out.println("Não há receita cadastrada");
            menu_despesa();
        }
    }

    public static void menu_despesa()
    {
        System.out.println("----------------------------");
        System.out.println("----------Despesas----------");
        System.out.println("----------------------------");
        System.out.println("******* Selecione uma operação *******");
        System.out.println("|  Opção 1 - Adicionar Despesa |");
        System.out.println("|  Opção 2 - Listar Despesas   |");
        System.out.println("|  Opção 3 - Alterar Despesa   |");
        System.out.println("|  Opção 4 - Excluir Despesa   |");
        System.out.println("|  Opção 5 - Voltar            |");
        System.out.println("|  Opção 6 - Sair              |");

        int operacao_despesa = teclado.nextInt();

        switch (operacao_despesa)
        {
            case 1:
                adicionar_despesa();
                break;

            case 2:
                listar_despesa();
                break;

            case 3:
                alterar_despesa();
                break;

            case 4:
                excluir_despesa();
                break;

            case 5:
                menu_inicial();
                break;

            case 6:
                System.out.println("Encerrando o sistema");
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida");
                menu_inicial();
                break;
        }
    }

    public static void adicionar_despesa()
    {
        System.out.println("Descrição da Despesa");
        String descricao = teclado.next();

        System.out.println("O tipo de Despesa: Fixo, Variável");
        String tipo = teclado.next();

        System.out.println("O dia do vencimento");
        int dia = teclado.nextInt();

        System.out.println("O valor da despesa");
        double valor = teclado.nextDouble();

        System.out.println("Foi pago?");
        boolean info = teclado.nextBoolean();

        Despesas despesa = new Despesas(descricao, tipo, dia, valor, info);
        despesas.add(despesa);

        System.out.println("Despesa Adicionada com sucesso");
        menu_despesa();
    }

    public static void listar_despesa()
    {
        if(despesas.size() > 0)
        {
            for (Despesas lista_despesa : despesas)
            {
                System.out.println(lista_despesa);
            }
        }

        else
        {
            System.out.println("Não há despesa cadastada");
        }

        menu_despesa();
    }

    public static void alterar_despesa()
    {
        if(despesas.size() > 0)
        {
            int opcao = 0;
            int continuar = 0;
            condicao = true;
            System.out.println("***** Digite a conta a pagar que você deseja alterar *****");
            opcao = teclado.nextInt();

            for (Despesas lista_despesa : despesas)
            {
                if(opcao == lista_despesa.getId())
                {
                    while (condicao)
                    {
                        System.out.println(lista_despesa);
                        System.out.println("******* Selecione uma operação *******");
                        System.out.println("|  Opção 1 - Alterar descrição     |");
                        System.out.println("|  Opção 2 - Alterar tipo          |");
                        System.out.println("|  Opção 3 - Alterar data          |");
                        System.out.println("|  Opção 4 - Alterar valor         |");
                        System.out.println("|  Opção 5 - Alterar pagamento     |");
                        System.out.println("|  Opção 6 - Voltar                |");

                        int operacao = teclado.nextInt();

                        switch (operacao) {
                            case 1:
                                System.out.println("Digite a nova descriçao");
                                String novaDescricao = teclado.next();
                                lista_despesa.setDescricao(novaDescricao);
                                System.out.println("******* Selecione uma operação *******");
                                System.out.println("|  Opção 1 - Fazer uma nova alteração  |");
                                System.out.println("|  Opção 2 - Alterar uma nova conta    |");
                                System.out.println("|  Opção 3 - Voltar                    |");

                                continuar = teclado.nextInt();
                                switch (continuar)
                                {
                                    case 1:
                                        break;

                                    case 2:
                                        condicao = false;
                                        alterar_despesa();
                                        break;

                                    case 3:
                                        condicao = false;
                                        menu_despesa();
                                        break;

                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                                break;

                            case 2:
                                System.out.println("Digite o novo tipo");
                                String novoTipo = teclado.next();
                                lista_despesa.setTipo(novoTipo);
                                System.out.println("******* Selecione uma operação *******");
                                System.out.println("|  Opção 1 - Fazer uma nova alteração  |");
                                System.out.println("|  Opção 2 - Alterar uma nova conta    |");
                                System.out.println("|  Opção 3 - Voltar                    |");

                                continuar = teclado.nextInt();
                                switch (continuar)
                                {
                                    case 1:
                                        break;

                                    case 2:
                                        condicao = false;
                                        alterar_despesa();
                                        break;

                                    case 3:
                                        condicao = false;
                                        menu_despesa();
                                        break;

                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                                break;

                            case 3:
                                System.out.println("Digite o novo dia");
                                int novoDia = teclado.nextInt();
                                lista_despesa.setDia(novoDia);
                                System.out.println("******* Selecione uma operação *******");
                                System.out.println("|  Opção 1 - Fazer uma nova alteração  |");
                                System.out.println("|  Opção 2 - Alterar uma nova conta    |");
                                System.out.println("|  Opção 3 - Voltar                    |");

                                continuar = teclado.nextInt();
                                switch (continuar)
                                {
                                    case 1:
                                        break;

                                    case 2:
                                        condicao = false;
                                        alterar_despesa();
                                        break;

                                    case 3:
                                        condicao = false;
                                        menu_despesa();
                                        break;

                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                                break;

                            case 4:
                                System.out.println("Digite o novo valor");
                                double novoValor = teclado.nextDouble();
                                lista_despesa.setValor(novoValor);
                                System.out.println("******* Selecione uma operação *******");
                                System.out.println("|  Opção 1 - Fazer uma nova alteração  |");
                                System.out.println("|  Opção 2 - Alterar uma nova conta    |");
                                System.out.println("|  Opção 3 - Voltar                    |");

                                continuar = teclado.nextInt();
                                switch (continuar)
                                {
                                    case 1:
                                        break;

                                    case 2:
                                        condicao = false;
                                        alterar_despesa();
                                        break;

                                    case 3:
                                        condicao = false;
                                        menu_despesa();
                                        break;

                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                                break;

                            case 5:
                                System.out.println("Situação atual: " + lista_despesa.getSituacao());
                                boolean novaSituação = lista_despesa.isInfo();
                                lista_despesa.setInfo(!novaSituação);
                                System.out.println("******* Selecione uma operação *******");
                                System.out.println("|  Opção 1 - Fazer uma nova alteração  |");
                                System.out.println("|  Opção 2 - Alterar uma nova conta    |");
                                System.out.println("|  Opção 3 - Voltar                    |");

                                continuar = teclado.nextInt();
                                switch (continuar) {
                                    case 1:
                                        break;

                                    case 2:
                                        condicao = false;
                                        alterar_despesa();
                                        break;

                                    case 3:
                                        condicao = false;
                                        menu_despesa();
                                        break;

                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                                break;

                            case 6:
                                menu_despesa();
                                break;

                            default:
                                System.out.println("Opção inválida");
                                menu_despesa();
                                break;

                        }
                    }
                }
            }
            System.out.println("Despesa não encontrada");
            alterar_despesa();
        }
        else
        {
            System.out.println("Não há despesa cadastrada");
            menu_despesa();
        }
    }

    public static void excluir_despesa()
    {
        if (despesas.size() > 0)
        {
            int opcao = 0;
            int continuar = 0;
            condicao = true;
            System.out.println("***** Digite a conta a pagar que você deseja excluir *****");
            opcao = teclado.nextInt();

            for (Despesas lista_despesa : despesas)
            {
                if (opcao == lista_despesa.getId())
                {
                    System.out.println(lista_despesa);
                    System.out.println("***** Você tem certeza que deseja excluir? *****");
                    System.out.println("|  Opcão 1 - Sim  |");
                    System.out.println("|  Opcão 2 - Não  |");
                    continuar = teclado.nextInt();

                    switch (continuar)
                    {
                        case 1:
                            despesas.remove(lista_despesa);
                            System.out.println("Despesa excluída com sucesso");
                            System.out.println("******* Selecione uma operação *******");
                            System.out.println("|  Opção 1 - Fazer uma nova exclusão  |");
                            System.out.println("|  Opção 2 - Voltar                   |");
                            continuar = teclado.nextInt();

                            switch (continuar)
                            {
                                case 1:
                                    excluir_despesa();
                                    break;

                                case 2:
                                    menu_despesa();
                                    break;
                            }

                            break;

                        case 2:
                            System.out.println("******* Selecione uma operação *******");
                            System.out.println("|  Opção 1 - Fazer uma nova exclusão  |");
                            System.out.println("|  Opção 2 - Voltar                   |");
                            continuar = teclado.nextInt();

                            switch (continuar)
                            {
                                case 1:
                                    excluir_despesa();
                                    break;

                                case 2:
                                    menu_despesa();
                                    break;
                            }

                            break;

                    }

                }
            }

            System.out.println("Despesa não encontrada");
            excluir_despesa();
        }

        else
        {
            System.out.println("Não há despesa cadastrada");
            menu_despesa();
        }
    }

    public static void menu_relatorio()
    {
        double total_a_pagar = 0;
        double total_vencido = 0;
        double total_pago = 0;
        double total_receita = 0;

        for (Despesas somas : despesas)
        {
            if (!somas.isInfo() && (somas.getDia() - somas.getHoje()) >= 0)
            {
                total_a_pagar += somas.getValor();
            }

            if(!somas.isInfo() && (somas.getDia() - somas.getHoje()) < 0)
            {
                total_vencido += somas.getValor();
            }

            if(somas.isInfo())
            {
                total_pago += somas.getValor();
            }
        }

        for (Receitas somas : receitas)
        {
            total_receita += somas.getValor();
        }

        System.out.println("Total Receita: " + total_receita);
        System.out.println("Total a pagar: " + total_a_pagar);
        System.out.println("Total vencido: " + total_vencido);
        System.out.println("Total pago: " + total_pago);
        System.out.println("Saldo: " + (total_receita - total_pago));

        menu_inicial();

    }
}
