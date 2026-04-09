package br.com.ucsal.olimpiadas.ui;

import br.com.ucsal.olimpiadas.service.*;

import java.util.Scanner;

public class Menu {

    private final Scanner in = new Scanner(System.in);

    // Services (injeção simples)
    private final ParticipanteService participanteService = new ParticipanteService();
    private final ProvaService provaService = new ProvaService();
    private final QuestaoService questaoService = new QuestaoService();
    private final TentativaService tentativaService = new TentativaService();

    public void iniciar() {
        while (true) {
            System.out.println("\n=== OLIMPÍADA DE QUESTÕES ===");
            System.out.println("1) Cadastrar participante");
            System.out.println("2) Cadastrar prova");
            System.out.println("3) Cadastrar questão");
            System.out.println("4) Aplicar prova");
            System.out.println("5) Listar tentativas");
            System.out.println("0) Sair");
            System.out.print("> ");

            switch (in.nextLine()) {
                case "1" -> cadastrarParticipante();
                case "2" -> cadastrarProva();
                case "3" -> cadastrarQuestao();
                case "4" -> aplicarProva();
                case "5" -> listarTentativas();
                case "0" -> {
                    System.out.println("tchau");
                    return;
                }
                default -> System.out.println("opção inválida");
            }
        }
    }

    private void cadastrarParticipante() {
        System.out.print("Nome: ");
        String nome = in.nextLine();

        System.out.print("Email: ");
        String email = in.nextLine();

        try {
            participanteService.cadastrarParticipante(nome, email);
            System.out.println("Participante cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void cadastrarProva() {
        System.out.print("Título da prova: ");
        String titulo = in.nextLine();

        try {
            provaService.cadastrar(titulo);
            System.out.println("Prova cadastrada!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void cadastrarQuestao() {
        try {
            Long provaId = provaService.escolherProva(in);
            if (provaId == null) return;

            System.out.println("Enunciado:");
            String enunciado = in.nextLine();

            String[] alternativas = new String[5];
            for (int i = 0; i < 5; i++) {
                char letra = (char) ('A' + i);
                System.out.print("Alternativa " + letra + ": ");
                alternativas[i] = letra + ") " + in.nextLine();
            }

            System.out.print("Alternativa correta (A–E): ");
            char correta = in.nextLine().toUpperCase().charAt(0);

            questaoService.cadastrar(provaId, enunciado, alternativas, correta);

            System.out.println("Questão cadastrada!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void aplicarProva() {
        try {
            Long participanteId = participanteService.escolherParticipante(in);
            if (participanteId == null) return;

            Long provaId = provaService.escolherProva(in);
            if (provaId == null) return;

            tentativaService.aplicarProva(participanteId, provaId, in);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarTentativas() {
        tentativaService.listarTentativas();
    }
}