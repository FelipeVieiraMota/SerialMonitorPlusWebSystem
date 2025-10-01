/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBO;

import ModelDAO.ProfessorDAO;
import ModelVO.ProfessorVO;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ProfessorBO {

    public boolean cadastrarObjetoProfessorBO(ProfessorVO professorVo) {
        System.out.println("Dentro do metodo cadastrarObjetoProfessorBO =)");
        boolean status = false;
        String nomeProfessor = professorVo.getNomeProfessor();
        String cpfProfessor = professorVo.getCpfProfessor();
        ArrayList<ProfessorVO> array;
        array = pesquisarObjetoProfessorPeloNomeCpfRetornarObjetoProfessorBo(nomeProfessor, cpfProfessor);
        if (!array.isEmpty()) {
            System.out.println("O array não está vazio, professor existente nos registros!!!!");
            return status;
        } else {
            System.out.println("Dentro do else no metodo cadastrarObjetoProfessorBO");
            ProfessorDAO dao;
            dao = new ProfessorDAO();
            status = dao.cadastrarObjetoProfessorDao(professorVo);
            System.out.println("Retorno cadastrarObjetoTurmaBO = " + status);
            return status;
        }
    }

    public boolean alterarProfessorBo(ProfessorVO professorVo) {
        System.out.println("Dentro do metodo cadastrarObjetoProfessorBO =)");
        boolean status = false;
        String nomeProfessor = professorVo.getNomeProfessor();
        String cpfProfessor = professorVo.getCpfProfessor();
        int txtIdProfessor = professorVo.getIdProfessor();
        System.out.println("BO --- ID PROFESSOR : "+txtIdProfessor);
        ArrayList<ProfessorVO> array;
        array = pesquisarObjetoProfessorPeloNomeCpfRetornarObjetoProfessorBo(nomeProfessor, cpfProfessor);
        if (!array.isEmpty()) {
            System.out.println("Dentro do if no metodo cadastrarObjetoProfessorBO = ID = "+professorVo.getIdadeProfessor());
            ProfessorDAO dao;
            dao = new ProfessorDAO();
            status = dao.alterarObjetoProfessorDao(professorVo);
            System.out.println("Retorno alterarObjetoProfessorDao = " + status);
            return status;                        
        } else {
            System.out.println("O array  está vazio, professor inexistente nos registros!!!!");
            return status;
        }
    }

    public ArrayList<ProfessorVO> pesquisarSomenteNaTabelaProfessorPeloNomeBo(String nomeProfessor) {
        ArrayList<ProfessorVO> array;
        ProfessorDAO dao = new ProfessorDAO();
        array = dao.pesquisarSomenteNaTabelaProfessorPeloNomeDao(nomeProfessor);
        return array;
    }

    public int pesquisarIdDoProfessorPeloSeuCpf(String cpfProfessor) {
        ArrayList<ProfessorVO> array;
        int idProfessor = 0;
        ProfessorDAO dao = new ProfessorDAO();
        array = dao.pesquisarSomenteNaTabelaProfessorPeloCpfDao(cpfProfessor);
        for (ProfessorVO vo : array) {
            if (vo.getIdProfessor() > 0) {
                idProfessor = vo.getIdProfessor();
            }
        }
        return idProfessor;
    }

    public String gerarCodigoDaMatriculaDoProfessorBo(int idProfessor) {
        String codigoDoProfessor = "#800-" + idProfessor;
        return codigoDoProfessor;
    }

    public ArrayList<ProfessorVO> pesquisarObjetoProfessorPeloNomeCpfRetornarObjetoProfessorBo(String nome, String cpf) {
        ArrayList<ProfessorVO> array;
        ProfessorDAO dao;
        dao = new ProfessorDAO();
        array = dao.pesquisarObjetoProfessorNatabelaProfessorPeloNomeCpfRetornarObjetoProfesssorCompletoDao(nome, cpf);
        return array;
    }

    // The methods bellow it will be need repaired!!! 
    public ArrayList<ProfessorVO> pesquisarTodosOsObjetosProfessoresSemParametroSomenteNaTabelaProfessorRetornarObjetoProfessorCompletoBo() {
        ArrayList<ProfessorVO> arrayProfessor;
        ProfessorDAO dao;
        dao = new ProfessorDAO();
        arrayProfessor = dao.pesquisarTodosOsObjetosProfessoresSemParametroSomenteNaTabelaProfessorRetornarObjetoProfessorCompletoDao();
        return arrayProfessor;
    }
}
