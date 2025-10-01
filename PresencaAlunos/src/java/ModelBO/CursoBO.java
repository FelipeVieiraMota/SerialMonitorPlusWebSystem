/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBO;

import ModelDAO.CursoDAO;
import ModelVO.CursoVO;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class CursoBO {

    public boolean cadastrarCurso(CursoVO cursoVO) {
        System.out.println("Dentro de cadastrarCurso");
        boolean status = false;
        ArrayList<CursoVO> array;
        array = pesquisarCursoPeloNome(cursoVO.getNomeCurso());
        if (!array.isEmpty()) {
            return status;
        } else {
            System.out.println("Dentro do else de cadastrarCurso");
            CursoDAO dao;
            dao = new CursoDAO();
            status = dao.cadastrarCurso(cursoVO);
            return status;
        }
    }

    public boolean alterarCurso(CursoVO cursoVO) {
        System.out.println("**ID DA CURSO *** = " + cursoVO.getIdCurso());
        boolean status = false;
        ArrayList<CursoVO> arrayCurso;
        arrayCurso = pesquisarCursoPeloId(cursoVO.getIdCurso());
        if (!arrayCurso.isEmpty()) {
            for (CursoVO vo : arrayCurso) {
                System.out.println("********************************");
                System.out.println("ID DA CURSO = " + vo.getIdCurso());
                System.out.println("********************************");
                if (vo.getIdCurso() == cursoVO.getIdCurso()) {
                    CursoDAO dao;
                    dao = new CursoDAO();
                    boolean retorno = dao.alterarCurso(cursoVO);
                    status = retorno;
                    return status;
                }
            }
        }
        return status;
    }

    
    public String gerarCodigoDoCurso(int idCurso) {
        String codigoDocurso = "#200-" + idCurso;
        return codigoDocurso;
    }    
        
    public int pesquisarPeloNomeDoCursoRetornarIdDoCurso(String nomeCurso) {
        int idCurso = 0;
        ArrayList<CursoVO> arrayCurso;
        arrayCurso = pesquisarCursoPeloNome(nomeCurso);
        if (!arrayCurso.isEmpty()) {
            for (CursoVO vo : arrayCurso) {
                idCurso = vo.getIdCurso();
            }
        }
        return idCurso;
    }

    public ArrayList<CursoVO> pesquisarTodosCurso() {
        ArrayList<CursoVO> arrayCurso;
        CursoDAO dao;
        dao = new CursoDAO();
        arrayCurso = dao.consultarTodosCursos();
        return arrayCurso;
    }

    public ArrayList<CursoVO> pesquisarCursoPeloNome(String nomeCurso) {
        ArrayList<CursoVO> arrayCurso;
        CursoDAO dao;
        dao = new CursoDAO();
        arrayCurso = dao.consultarCursoPeloNome(nomeCurso);
        return arrayCurso;
    }

    public ArrayList<CursoVO> pesquisarCursoPeloId(int id) {
        ArrayList<CursoVO> arrayCurso;
        CursoDAO dao;
        dao = new CursoDAO();
        arrayCurso = dao.consultarCursoPeloId(id);
        return arrayCurso;
    }

}
