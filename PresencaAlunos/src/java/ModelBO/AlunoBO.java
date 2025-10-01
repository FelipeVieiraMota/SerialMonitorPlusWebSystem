/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBO;

import ModelDAO.AlunoDAO;
import ModelVO.AlunoVO;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class AlunoBO {

    public boolean cadastrarObjetoAlunoBO(AlunoVO alunoVo) {
        System.out.println("Dentro do metodo cadastrarObjetoAlunoBO =)");
        boolean status = false;
        String nomeAluno = alunoVo.getNomeAluno();
        String cpfAluno = alunoVo.getCpfAluno();
        ArrayList<AlunoVO> array;
        array = pesquisarObjetoAlunoPeloNomeCpfRetornarObjetoAlunoBo(nomeAluno, cpfAluno);
        if (!array.isEmpty()) {
            System.out.println("O array não está vazio, aluno existente nos registros!!!!");
            return status;
        } else {
            System.out.println("Dentro do else no metodo cadastrarObjetoAlunoBO");
            AlunoDAO dao;
            dao = new AlunoDAO();
            status = dao.cadastrarObjetoAlunoDao(alunoVo);
            System.out.println("Retorno cadastrarObjetoTurmaBO = " + status);
            return status;
        }
    }

    public boolean alterarAlunoBo(AlunoVO alunoVo) {
        System.out.println("Dentro do metodo cadastrarObjetoAlunoBO =)");
        boolean status = false;
        String nomeAluno = alunoVo.getNomeAluno();
        String cpfAluno = alunoVo.getCpfAluno();
        int txtIdAluno = alunoVo.getIdAluno();
        System.out.println("BO --- ID ALUNO : " + txtIdAluno);
        ArrayList<AlunoVO> array;
        array = pesquisarObjetoAlunoPeloNomeCpfRetornarObjetoAlunoBo(nomeAluno, cpfAluno);
        if (!array.isEmpty()) {
            System.out.println("Dentro do if no metodo cadastrarObjetoAlunoBO = ID = " + alunoVo.getIdadeAluno());
            AlunoDAO dao;
            dao = new AlunoDAO();
            status = dao.alterarObjetoAlunoDao(alunoVo);
            System.out.println("Retorno alterarObjetoAlunoDao = " + status);
            return status;
        } else {
            System.out.println("O array  está vazio, aluno inexistente nos registros!!!!");
            return status;
        }
    }

    public ArrayList<AlunoVO> pesquisarSomenteNaTabelaAlunoPeloNomeBo(String nomeAluno) {
        ArrayList<AlunoVO> array;
        AlunoDAO dao = new AlunoDAO();
        array = dao.pesquisarSomenteNaTabelaAlunoPeloNomeDao(nomeAluno);
        return array;
    }

    public int pesquisarIdDoAlunoPeloSeuCpf(String cpfAluno) {
        ArrayList<AlunoVO> array;
        int idAluno = 0;
        AlunoDAO dao = new AlunoDAO();
        array = dao.pesquisarSomenteNaTabelaAlunoPeloCpfDao(cpfAluno);
        for (AlunoVO vo : array) {
            if (vo.getIdAluno() > 0) {
                idAluno = vo.getIdAluno();
            }
        }
        return idAluno;
    }

    public String gerarCodigoDaMatriculaDoAlunoBo(int idAluno) {
        String codigoDoAluno = "#400-" + idAluno;
        return codigoDoAluno;
    }

    public ArrayList<AlunoVO> pesquisarObjetoAlunoPeloNomeCpfRetornarObjetoAlunoBo(String nome, String cpf) {
        ArrayList<AlunoVO> array;
        AlunoDAO dao;
        dao = new AlunoDAO();
        array = dao.pesquisarObjetoAlunoNatabelaAlunoPeloNomeCpfRetornarObjetoAlunoCompletoDao(nome, cpf);
        return array;
    }

    // The methods bellow it will be need repaired!!! 
    public ArrayList<AlunoVO> pesquisarTodosOsObjetosAlunosSemParametroSomenteNaTabelaAlunoRetornarObjetoAlunoCompletoBo() {
        ArrayList<AlunoVO> arrayAluno;
        AlunoDAO dao;
        dao = new AlunoDAO();
        arrayAluno = dao.pesquisarTodosOsObjetosAlunosSemParametroSomenteNaTabelaAlunoRetornarObjetoAlunoCompletoDao();
        return arrayAluno;
    }
}
