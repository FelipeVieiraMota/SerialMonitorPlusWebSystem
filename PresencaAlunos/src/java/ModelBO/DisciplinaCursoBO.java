/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBO;

import ModelDAO.DisciplinaCursoDAO;
import ModelVO.DisciplinaCursoVO;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class DisciplinaCursoBO {

    public boolean cadastrarDisciplinaCurso(DisciplinaCursoVO disciplinaCursoVO) {
        System.out.println("Dentro de cadastrarDisciplinaCurso");
        boolean status = false;
        int idCurso = disciplinaCursoVO.getIdCurso();
        int idDisciplina = disciplinaCursoVO.getIdDisciplina();
        ArrayList<DisciplinaCursoVO> arrayDisciplinaCurso;
        arrayDisciplinaCurso = pesquisarDisciplinaCursoPelosSeusDoisIds(idCurso,idDisciplina);
        if (!arrayDisciplinaCurso.isEmpty()) {
            return status;
        } else {
            System.out.println("Dentro do else de cadastrarDisciplinaCurso");
            DisciplinaCursoDAO dao;
            dao = new DisciplinaCursoDAO();
            status = dao.cadastrarDisciplinaCurso(disciplinaCursoVO);
            return status;
        }
    }
    

    public ArrayList<DisciplinaCursoVO> pesquisarDisciplinaCursoPelosSeusDoisIds(int idCurso, int idDisciplina) {
        ArrayList<DisciplinaCursoVO> arrayDisciplinaCurso;
        DisciplinaCursoDAO dao;
        dao = new DisciplinaCursoDAO();
        arrayDisciplinaCurso = dao.pesquisarDisciplinaCursoPelosSeusDoisIds(idCurso, idDisciplina);
        return arrayDisciplinaCurso;
    }

    public ArrayList<DisciplinaCursoVO> pesquisarDisciplinaCursoPeloNome(String disciplinaCurso) {
        ArrayList<DisciplinaCursoVO> arrayDisciplinaCurso;
        DisciplinaCursoDAO dao;
        dao = new DisciplinaCursoDAO();
        arrayDisciplinaCurso = dao.pesquisarDisciplinaCursoPeloNome(disciplinaCurso);
        return arrayDisciplinaCurso;
    }

    public ArrayList<DisciplinaCursoVO> pesquisarTodasAsDisciplinasCadastradasEmAgumCurso() {
        ArrayList<DisciplinaCursoVO> arrayDisciplinaCurso;
        DisciplinaCursoDAO dao;
        dao = new DisciplinaCursoDAO();
        arrayDisciplinaCurso = dao.pesquisarTodasAsDisciplinasCadastradasEmAgumCurso();
        return arrayDisciplinaCurso;
    }

}
