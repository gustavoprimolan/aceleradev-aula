package br.com.aceleradev.main;

import br.com.aceleradev.dao.AlunoDAO;
import br.com.aceleradev.dao.DisciplinaDAO;
import br.com.aceleradev.dao.ProfessorDAO;
import br.com.aceleradev.domain.Aluno;
import br.com.aceleradev.domain.Disciplina;
import br.com.aceleradev.domain.Professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("curso02");

        EntityManager manager = factory.createEntityManager();

        AlunoDAO alunoDAO = new AlunoDAO(manager);
        alunoDAO.save(new Aluno("José", "jose01", "123.432.123-42"));
        alunoDAO.save(new Aluno("Pedro", "pedro01", "213.442.123-42"));

        Aluno alunoNovo01 = new Aluno("Joaquim", "joaquim", "213.431.123-42");
        Aluno alunoNovo02 = new Aluno("Joao", "joaoLogin", "283.431.123-42");
        Aluno alunoNovo03 = new Aluno("Rodrigo", "rodrigologin", "655.431.123-42");

        alunoDAO.save(alunoNovo01);
        alunoDAO.save(alunoNovo02);
        alunoDAO.save(alunoNovo03);
        alunoDAO.findAll().forEach(System.out::println);

        alunoDAO.findAll().forEach(System.out::println);

        ProfessorDAO professorDAO = new ProfessorDAO(manager);

        Professor professor1 =
                new Professor("José Professor",
                        "joseprofessor01", "321.765.123-42");

        Professor professor2 =
                new Professor("Pedro Professor",
                        "pedroprof01", "321.235.123-42");

        professorDAO.save(professor1);
        professorDAO.save(professor2);

        DisciplinaDAO disciplinaDAO = new DisciplinaDAO(manager);
        Disciplina matematica = new Disciplina("Matematica", professor1);
        Disciplina literatura = new Disciplina("Literatura", professor2);

        disciplinaDAO.save(matematica);
        disciplinaDAO.save(literatura);

        disciplinaDAO.findAll().forEach(System.out::println);

        matematica.matricular(alunoNovo01);
        matematica.matricular(alunoNovo02);
        literatura.matricular(alunoNovo03);
        literatura.matricular(alunoNovo02);

        disciplinaDAO.save(matematica);
        disciplinaDAO.save(literatura);

        System.out.println("Captura Alunos pela disciplina de Literatura");
        alunoDAO.getAlunoPorDisciplina(literatura).forEach(System.out::println);
        BigInteger numeroDisciplinas = alunoDAO.getNumeroDisicplinasMatriculado(alunoNovo02.getId());
        System.out.println("O aluno " + alunoNovo02.getNome() + " está matriculado em " + numeroDisciplinas + " disciplinas");
        factory.close();
    }

}
