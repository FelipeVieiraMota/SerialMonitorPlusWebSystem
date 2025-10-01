/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBO;

import ModelDAO.SemestreDAO;
import ModelVO.SemestreVO;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class SemestreBO {

    public boolean cadastrarSemestre(SemestreVO semestreVO) {
        boolean status = false;
        ArrayList<SemestreVO> arraySemestre;
        arraySemestre = pesquisarSemestrePeloNome(semestreVO.getSemestre());
        if (!arraySemestre.isEmpty()) {
            return status;
        } else {
            SemestreVO objSemestreVO;
            SemestreDAO dao;
            objSemestreVO = new SemestreVO(semestreVO.getSemestre(), semestreVO.getObservacoes());
            dao = new SemestreDAO();
            status = dao.cadastrarSemestre(objSemestreVO);
            return status;
        }
    }

    /*Terminar esse metodo , mexer no if , colocar a comparação por id e não por nome*/
    public boolean alterarSemestre(SemestreVO semestreVO) {
        System.out.println("*** Alterar Semestre BO ***");
        System.out.println("********************************");
        System.out.println("ID = " + semestreVO.getIdSemestre());
        System.out.println("SEMESTRE = " + semestreVO.getSemestre());
        System.out.println("OBSERVACOES = " + semestreVO.getObservacoes());
        System.out.println("********************************");
        boolean status = false;
        ArrayList<SemestreVO> arraySemestre;
        arraySemestre = pesquisarSemestrePeloId(semestreVO.getIdSemestre());
        if (!arraySemestre.isEmpty()) {
            for (SemestreVO vo : arraySemestre) {
                System.out.println("********************************");
                System.out.println("ID = " + vo.getIdSemestre());
                System.out.println("********************************");
                if (vo.getIdSemestre() == semestreVO.getIdSemestre()) {
                    int id = vo.getIdSemestre();
                    SemestreVO semestreVo = new SemestreVO(id, semestreVO.getSemestre(), semestreVO.getObservacoes());
                    SemestreDAO dao;
                    dao = new SemestreDAO();
                    boolean retorno = dao.alterarSemestre(semestreVo);
                    status = retorno;
                    return status;
                }
            }
        }
        return status;
    }

    public String gerarCodigoDoSemestre(int idSemestre) {
        String codigoDoSemestre = "#300-" + idSemestre;
        return codigoDoSemestre;
    }

    public int pesquisarPeloNomeDoSemestreRetornarIdDoSemestre(String nomeSemestre) {
        int idSemestre = 0;
        ArrayList<SemestreVO> arraySemestre;
        arraySemestre = pesquisarSemestrePeloNome(nomeSemestre);
        if (!arraySemestre.isEmpty()) {
            for (SemestreVO vo : arraySemestre) {
                idSemestre = vo.getIdSemestre();
            }
        }
        return idSemestre;
    }

    public ArrayList<SemestreVO> pesquisarSemestrePeloNome(String semestre) {
        ArrayList<SemestreVO> arraySemestre;
        SemestreDAO dao;
        dao = new SemestreDAO();
        arraySemestre = dao.consultarSemestrePeloNome(semestre);
        return arraySemestre;
    }

    public ArrayList<SemestreVO> pesquisarSemestrePeloId(int idSemestre) {
        ArrayList<SemestreVO> arraySemestre;
        SemestreDAO semestreDAO = new SemestreDAO();
        arraySemestre = semestreDAO.consultarSemestrePeloId(idSemestre);
        return arraySemestre;
    }

    public ArrayList<SemestreVO> pesquisarTodosSemestre() {
        ArrayList<SemestreVO> arraySemestre;
        SemestreDAO dao;
        dao = new SemestreDAO();
        arraySemestre = dao.consultarTodosSemestres();
        return arraySemestre;
    }
}
