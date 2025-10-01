/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBO;

import ModelDAO.AlunoTurmaDAO;
import ModelVO.AlunoTurmaVO;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class AlunoTurmaBO {

    public boolean cadastrarObjetoAlunoBO(AlunoTurmaVO vo) {
        System.out.println("Dentro do metodo cadastrarObjetoAlunoBO =)");
        boolean status = false;
        int idAluno = vo.getIdAluno();
        int idTurma = vo.getIdTurma();
        ArrayList<AlunoTurmaVO> array;
        array = pesquisarAlunoTurmaBo(idAluno, idTurma);
        if (!array.isEmpty()) {
            System.out.println("O array não está vazio, existem registros!!!!");
            return status;
        } else {
            System.out.println("Dentro do else no metodo cadastrarObjetoAlunoBO");
            AlunoTurmaDAO dao;
            dao = new AlunoTurmaDAO();
            status = dao.vincularAlunoTurmaDao(vo);
            System.out.println("Retorno = " + status);
            return status;
        }
    }

    public boolean alterarAlunoBo(AlunoTurmaVO vo) {
        System.out.println("Dentro do metodo alterarAlunoBo =)");
        boolean status = false;
        int idAluno = vo.getIdAluno();
        int idTurma = vo.getIdTurma();
        ArrayList<AlunoTurmaVO> array;
        array = pesquisarAlunoTurmaBo(idAluno, idTurma);
        if (!array.isEmpty()) {
            System.out.println("Dentro do if alterarAlunoBo");
            AlunoTurmaDAO dao;
            dao = new AlunoTurmaDAO();
            status = dao.alterarVinculoEntreAlunoTurmaDao(vo);
            System.out.println("Retorno = " + status);
            return status;
        } else {
            System.out.println("O array está vazio, existem registros!!!!");
            return status;
        }
    }

    public ArrayList<AlunoTurmaVO> pesquisarAlunoTurmaBo(int idAluno, int idTurma) {
        ArrayList<AlunoTurmaVO> array;
        AlunoTurmaDAO dao;
        dao = new AlunoTurmaDAO();
        array = dao.pesquisarAlunoTurmaDao(idAluno, idTurma);
        return array;
    }

    public ArrayList<AlunoTurmaVO> pesquisarAlunoTurmaPeloNomeBo(String nomeAluno) {
        System.out.println("pesquisarAlunoTurmaPeloNomeBo");
        ArrayList<AlunoTurmaVO> array;
        AlunoTurmaDAO dao;
        dao = new AlunoTurmaDAO();
        array = dao.pesquisarAlunoTurmaPeloNomeDao(nomeAluno);
        return array;
    }
    
    // The methods bellow it will be need repaired!!! 
    public ArrayList<AlunoTurmaVO> pesquisarTodosOsAlunosTurmaBo() {
        ArrayList<AlunoTurmaVO> array;
        AlunoTurmaDAO dao;
        dao = new AlunoTurmaDAO();
        array = dao.pesquisarTodosOsAlunosTurmaDao();
        return array;
    }
}
