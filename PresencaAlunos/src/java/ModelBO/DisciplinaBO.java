/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBO;

import ModelDAO.DisciplinaDAO;
import ModelVO.DisciplinaVO;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class DisciplinaBO {

    public boolean cadastrarDisciplina(DisciplinaVO disciplinaVO) {
        boolean status = false;
        ArrayList<DisciplinaVO> arrayDisciplina;
        arrayDisciplina = pesquisarsDisciplinaPeloNome(disciplinaVO.getNomeDisciplina());
        if (!arrayDisciplina.isEmpty()) {
            return status;
        } else {
            DisciplinaDAO dao;
            dao = new DisciplinaDAO();
            status = dao.cadastrarDisciplina(disciplinaVO);
            return status;
        }
    }

    public boolean alterarDisciplina(DisciplinaVO disciplinaVO) {
        System.out.println("**ID DA DISCIPLINA*** = " + disciplinaVO.getIdDisciplina());
        boolean status = false;
        ArrayList<DisciplinaVO> arrayDisciplina;
        arrayDisciplina = pesquisarsDisciplinaPeloId(disciplinaVO.getIdDisciplina());
        if (!arrayDisciplina.isEmpty()) {
            for (DisciplinaVO vo : arrayDisciplina) {
                System.out.println("********************************");
                System.out.println("ID DA DISCIPLINA = " + vo.getIdDisciplina());
                System.out.println("********************************");
                if (vo.getIdDisciplina() == disciplinaVO.getIdDisciplina()) {
                    DisciplinaDAO dao;
                    dao = new DisciplinaDAO();
                    boolean retorno = dao.alterarDisciplina(disciplinaVO);
                    status = retorno;
                    return status;
                }
            }
        }
        return status;
    }

    public String gerarCodigoDaDisciplina(int idDisciplina) {
        String codigoDaDisciplina = "#100-" + idDisciplina;
        return codigoDaDisciplina;
    }

    public int pesquisarPeloNomeDaDisciplinaRetornarIdDaDisciplina(String nomeDisciplina) {
        int idDisciplina = 0;
        ArrayList<DisciplinaVO> arrayDisciplina;
        arrayDisciplina = pesquisarsDisciplinaPeloNome(nomeDisciplina);
        if (!arrayDisciplina.isEmpty()) {
            for (DisciplinaVO vo : arrayDisciplina) {
                idDisciplina = vo.getIdDisciplina();
            }
        }else{
            System.out.println("Array Vazio =( =(");
        }
        return idDisciplina;
    }

    public ArrayList<DisciplinaVO> pesquisarTodasAsDisciplinas() {
        ArrayList<DisciplinaVO> arrayDisciplina;
        DisciplinaDAO dao;
        dao = new DisciplinaDAO();
        arrayDisciplina = dao.consultarTodasAsDisciplinas();
        return arrayDisciplina;
    }

    public ArrayList<DisciplinaVO> pesquisarsDisciplinaPeloNome(String nomeDisciplina) {
        ArrayList<DisciplinaVO> arrayDisicplina;
        DisciplinaDAO dao;
        dao = new DisciplinaDAO();
        arrayDisicplina = dao.consultarDisciplinaPeloNome(nomeDisciplina);
        return arrayDisicplina;
    }

    public ArrayList<DisciplinaVO> pesquisarsDisciplinaPeloId(int id) {
        ArrayList<DisciplinaVO> arrayDisicplina;
        DisciplinaDAO dao;
        dao = new DisciplinaDAO();
        arrayDisicplina = dao.consultarDisciplinaPeloId(id);
        return arrayDisicplina;
    }
}
