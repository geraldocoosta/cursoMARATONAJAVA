package br.com.ultcode.associacao.teste;

import br.com.ultcode.associacao.classes.Aluno;
import br.com.ultcode.associacao.classes.Local;
import br.com.ultcode.associacao.classes.Professor;
import br.com.ultcode.associacao.classes.Seminario;

public class Teste {

    public static void main(String[] args) {
        Aluno aluno = new Aluno("GEGE", 21);
        Aluno aluno2 = new Aluno("TETE", 19);

        Seminario seminario = new Seminario("LPIV");

        Professor prof = new Professor("Luffy", "Gomu gomu no mi");

        Local local = new Local("Rua do loco", "bairro do sem noção");

        aluno.setSeminario(seminario);
        aluno2.setSeminario(seminario);
        seminario.setProfessor(prof);
        seminario.setLocal(local);

        seminario.setAlunos(new Aluno[]{aluno, aluno2});

       prof.setSeminarios(new Seminario[]{});

        // seminario.print();
        prof.print();
        //aluno.print();
        //aluno2.print();
        //local.print();
    }
}
