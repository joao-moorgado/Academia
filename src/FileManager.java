import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import entities.Aluno;
import entities.Equipamento;
import entities.Instrutor;
import entities.Treino;
import entities.Turno;

public class FileManager {

    public static void main(String[] args) throws IOException {

        Instrutor instrutor1 = new Instrutor("1", "Joao", "joao@gmail.com", "12/12/1988", "11");

        Equipamento e1 = new Equipamento(1, "Pesinho", "Pesa pouco");
        Equipamento e2 = new Equipamento(2, "Peso", "Pesa mais ou menos");
        Equipamento e3 = new Equipamento(3, "Pesao", "Pesa muito");

        Scanner scanner = new Scanner(System.in);

        Integer n = 1;

        while (n != 0) {

            System.out.print("========== ACADEMIA UP ==========\n\n" +
                    "[1] - Cadastrar Aluno\n" +
                    "[2] - Registrar Treino\n" +
                    "[3] - Buscar Aluno\n" +
                    "[4] - Listar Alunos\n" +
                    "[5] - Listar Treinos\n" +
                    "[0] - Fechar Programa\n" +
                    "\n" +
                    "Comando: ");

            n = scanner.nextInt();
            scanner.nextLine();

            switch (n) {
                case 1:
                    String cpf, nome, email, dataNascimento;
                    Double peso, altura;

                    System.out.print("Digite o CPF do aluno: ");
                    cpf = scanner.nextLine();
                    System.out.print("Digite o nome do aluno: ");
                    nome = scanner.nextLine();
                    System.out.print("Digite o email do aluno: ");
                    email = scanner.nextLine();
                    System.out.print("Digite a data de nascimento do aluno: ");
                    dataNascimento = scanner.nextLine();
                    System.out.print("Digite o peso do aluno: ");
                    peso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Digite a altura do aluno: ");
                    altura = scanner.nextDouble();
                    scanner.nextLine();

                    Aluno aluno = new Aluno(cpf, nome, email, dataNascimento, peso, altura);

                    verificarAluno();
                    registrarAluno(aluno);

                    break;
                case 2:
                    Turno turno;
                    System.out.print("===============================\n" +
                            "Escolha o turno do treino:\n" +
                            "1 - DIURNO 2 - VESPERTINO 3 - NOTURNO" +
                            "\n\nComando: ");
                    n = scanner.nextInt();
                    scanner.nextLine();

                    switch (n) {
                        case 2:
                            turno = Turno.VESPERTINO;
                            break;
                        case 3:
                            turno = Turno.NOTURNO;
                            break;
                        default:
                            turno = Turno.DIURNO;
                            break;
                    }

                    System.out.println("\nSelecione o CPF do aluno:");
                    listarNomesAlunos();
                    System.out.print("\nCPF: ");
                    String cpfSelecionado = scanner.nextLine();

                    Aluno a = associarAluno(cpfSelecionado);

                    Treino treino = new Treino(LocalDate.now(), turno, a.getCpf());

                    do {

                        System.out.print("===============================\n" +
                                "Escolha os equipamentos do treino:\n" +
                                "1 - PESINHO 2 - PESO 3 - PESÃO 4 - PRONTO" +
                                "\n\nComando: ");
                        n = scanner.nextInt();
                        scanner.nextLine();

                        switch (n) {
                            case 1:
                                treino.addEquipamento(e1);
                                break;
                            case 2:
                                treino.addEquipamento(e2);
                                break;
                            case 3:
                                treino.addEquipamento(e3);
                                break;
                            default:
                                n = 4;
                        }
                    } while (n != 4);

                    verificarTreino();
                    registrarTreino(treino);
                    break;
                case 3:
                    break;
                case 4:
                    listarAlunosOrdenados();
                    break;
                case 5:
                    break;
            }
        }
    }

    private static final File diretorio = new File("/home/joao_morgado/Documents/academia/src/repositories/");

    public static void verificarAluno() throws IOException {

        File aluno =  new File(diretorio, "Alunos.txt");

        if (!aluno.exists())
            aluno.createNewFile();
    }

    public static void registrarAluno(Aluno aluno) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("/home/joao_morgado/Documents/academia/src/repositories/Alunos.txt", true))) {
            printWriter.println(aluno);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listarNomesAlunos() throws FileNotFoundException {
        File arquivo = new File("/home/joao_morgado/Documents/academia/src/repositories/Alunos.txt");
        Scanner leitor = new Scanner(arquivo);

        while (leitor.hasNextLine()) {
            String linha = leitor.nextLine();
            String[] partes = linha.split(",");
            String cpf = partes[0];
            String nome = partes[1]; // O nome está na segunda posição (índice 1) do array de partes
            System.out.println(cpf + "  " + nome);
        }
        leitor.close();
    }

    public static void listarAlunosOrdenados() throws FileNotFoundException {
        List<String> nomesAlunos = new ArrayList<>();

        // Ler os nomes dos alunos do arquivo
        try (Scanner leitor = new Scanner(new File("/home/joao_morgado/Documents/academia/src/repositories/Alunos.txt"))) {
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] partes = linha.split(",");
                if (partes.length > 1) {
                    String nome = partes[1].trim(); // O nome está na segunda posição (índice 1) do array de partes
                    nomesAlunos.add(nome);
                }
            }
        }

        // Ordenar os nomes dos alunos
        nomesAlunos.sort((x,y) -> x.compareTo(y));

        // Imprimir os nomes dos alunos ordenados
        System.out.println("======= Lista de Nomes de Alunos =======");
        for (String nome : nomesAlunos) {
            System.out.println(nome);
        }
    }

    public static void consultarAluno(String nomeAluno) throws FileNotFoundException {
        File arquivo = new File("/home/joao_morgado/Documents/academia/src/repositories/Alunos.txt");
        Scanner leitor = new Scanner(arquivo);
        boolean encontrado = false;
        while (leitor.hasNextLine()) {
            String linha = leitor.nextLine();
            if (linha.contains(nomeAluno)) {
                encontrado = true;
                String[] partes = linha.split(",");
                System.out.println("Aluno encontrado:");
                System.out.println("Nome: " + partes[1]);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aluno não encontrado.");
        }
        leitor.close();
    }

    public static Aluno associarAluno(String cpfAluno) throws FileNotFoundException {
        Aluno aluno = new Aluno();
        File arquivo = new File("/home/joao_morgado/Documents/academia/src/repositories/Alunos.txt");
        Scanner leitor = new Scanner(arquivo);
        boolean encontrado = false;
        while (leitor.hasNextLine()) {
            String linha = leitor.nextLine();
            if (linha.contains(cpfAluno)) {
                encontrado = true;
                String[] partes = linha.split(",");
                aluno = new Aluno(partes[0], partes[1], partes[2], partes[3], Double.parseDouble(partes[4]), Double.parseDouble(partes[5]));
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aluno não encontrado.");
        }
        leitor.close();
        return aluno;
    }

    public static void verificarTreino() throws IOException {

        File aluno =  new File(diretorio, "Treinos.txt");

        if (!aluno.exists())
            aluno.createNewFile();
    }

    public static void registrarTreino(Treino treino) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("/home/joao_morgado/Documents/academia/src/repositories/Treinos.txt", true))) {
            printWriter.println(treino);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void consultarTreino() throws FileNotFoundException {
        File arquivo = new File("/home/joao_morgado/Documents/academia/src/repositories/Treinos.txt");
        Scanner leitor = new Scanner(arquivo);
        while (leitor.hasNext()) {
            System.out.println(leitor.nextLine());
        }
        leitor.close();
    }

}
