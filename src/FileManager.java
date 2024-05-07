import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

import entities.Aluno;
import entities.Equipamento;
import entities.Instrutor;
import entities.Treino;
import entities.Turno;

public class FileManager {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("========== ACADEMIA UP ==========\n\n" +
                "[1] - Cadastrar Aluno\n" +
                "[2] - Registrar Treino\n" +
                "[0] - Fechar Programa\n" +
                "\n" +
                "Comando: ");

        Integer n = scanner.nextInt();

        while (n != 0) {
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

                    registrarAluno(aluno);
                    break;
                case 2:
                    Turno turno;

                    System.out.print("Digite o turno do treino do aluno: ");
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

                    Treino treino = new Treino(LocalDate.now(), turno);
            }
        }


        Instrutor instrutor1 = new Instrutor("1", "Joao", "joao@gmail.com", "12/12/1988", "11");

        Equipamento e1 = new Equipamento(1, "Pesinho", "Pesa pouco");
        Equipamento e2 = new Equipamento(2, "Peso", "Pesa mais ou menos");
        Equipamento e3 = new Equipamento(3, "Pesao", "Pesa muito");

    }

    private static final File diretorio = new File("/home/joao_morgado/Documents/academia/src/repositories/");

    public static void verificarAluno() throws IOException {

        File aluno =  new File(diretorio, "Alunos.txt");

        if (!aluno.exists())
            aluno.createNewFile();
    }

    public static void registrarAluno(Aluno aluno) throws IOException {
        FileWriter arquivoEscritor = new FileWriter("/home/joao_morgado/Documents/academia/src/repositories/Alunos.txt");
        PrintWriter gravador = new PrintWriter(arquivoEscritor);

        System.out.println("Aluno registrado com sucesso!");
        gravador.format(String.valueOf(aluno));
        gravador.close();
    }

    public static void consultarAluno() throws FileNotFoundException {
        File arquivo = new File("/home/joao_morgado/Documents/academia/src/repositoriesAlunos.txt");
        Scanner leitor = new Scanner(arquivo);
        while (leitor.hasNext()) {
            System.out.println(leitor.nextLine());
        }
        leitor.close();
    }

}
