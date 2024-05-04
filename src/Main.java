import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File diretorio = new File("/home/joao_morgado/Documents/Academia/src/repositories/");

        diretorio.mkdir();

        File aluno =  new File(diretorio, "Alunos.txt");

        aluno.createNewFile();

    }
}