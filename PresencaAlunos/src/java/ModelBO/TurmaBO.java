/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBO;

import ModelDAO.TurmaDAO;
import ModelVO.TurmaVO;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class TurmaBO {

    public boolean cadastrarObjetoTurmaBO(TurmaVO turmaVO) {
        System.out.println("Dentro do metodo cadastrarTurma =)");
        boolean status = false;
        String nomeTurma = turmaVO.getNomeTurma();
        ArrayList<TurmaVO> arrayTurma;
        arrayTurma = pesquisarObjetoTurmaPeloNomeRetornarObjetoTurmaBo(nomeTurma);
        if (!arrayTurma.isEmpty()) {
            System.out.println("O array não está vazio, já existe alguma turma com esse nome!!!!");
            return status;
        } else {
            System.out.println("Dentro do else no metodo cadastrarTurma BO");
            TurmaDAO dao;
            dao = new TurmaDAO();
            status = dao.cadastrarObjetoTurmaDao(turmaVO);
            System.out.println("Retorno cadastrarObjetoTurmaBO = " + status);
            return status;
        }
    }

    public boolean alterarObjetoTurmaBo(TurmaVO turmaVO) {
        TurmaDAO dao = new TurmaDAO();
        boolean status;
        int idTurma = turmaVO.getIdTurma();
        int idCurso = turmaVO.getIdCurso();
        int idSemestre = turmaVO.getIdSemestre();
        status = dao.pesquisarObjetoTurmaPeloIdTurmaIdCursoIdSemestreEmTodosOsRelacionamentosQuePossuiRetornarBooleanDao(idTurma, idCurso, idSemestre);
        if (status == true) {
            status = dao.alterarObjetoTurmaDao(turmaVO);
            return status;
        } else {
            status = false;
            return status;
        }
    }

    public ArrayList<TurmaVO> pesquisarObjetoTurmaPeloNomeRetornarObjetoTurmaBo(String nomeTurma) {
        ArrayList<TurmaVO> arrayTurma;
        TurmaDAO dao;
        dao = new TurmaDAO();
        arrayTurma = dao.pesquisarObjetoTurmaPeloNomeEmTodosOsRelacionamentosQuePossuiRetornarObjetoTurmaCompletoDao(nomeTurma);
        return arrayTurma;
    }

    public int pesquisarObjetoTurmaPeloNomeRetornarIdTurmaBo(String nomeTurma) {
        ArrayList<TurmaVO> arrayTurma;
        TurmaDAO dao = new TurmaDAO();
        arrayTurma = dao.pesquisarObjetoTurmaPeloNomeParaCadastroDaTurmaDao(nomeTurma);
        if (!arrayTurma.isEmpty()) {
            int idTurma;
            for (TurmaVO vo : arrayTurma) {
                idTurma = vo.getIdTurma();
                return idTurma;
            }
        }
        return 0;
    }

    public ArrayList<TurmaVO> pesquisarTodosOsObjetosTurmasEmTodosOsRelacionamentosRetornarObjetoTurmaCompletoBo() {
        ArrayList<TurmaVO> arrayTurma;
        TurmaDAO dao;
        dao = new TurmaDAO();
        arrayTurma = dao.pesquisarTodosOsObjetosTurmasSemParametrosEmTodosOsRelacionamentosRetornarObjetoTurmaCompletoDao();
        return arrayTurma;
    }

    public String gerarCodigoDaTurmaBo(int idTurma) {
        String codigoDaTurma = "#500-" + idTurma;
        return codigoDaTurma;
    }
}
