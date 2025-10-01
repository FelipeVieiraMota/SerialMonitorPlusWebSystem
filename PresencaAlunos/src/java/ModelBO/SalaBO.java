/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBO;

import ModelDAO.CursoDAO;
import ModelDAO.SalaDAO;
import ModelVO.CursoVO;
import ModelVO.SalaVO;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class SalaBO {

    public boolean cadastrarSalaBo(SalaVO vo) {
        System.out.println("Dentro de cadastrarSalaBo");
        boolean status = false;
        ArrayList<SalaVO> array;
        SalaDAO daoPesquisa;
        daoPesquisa = new SalaDAO();
        array = daoPesquisa.consultarSalaPeloNumeroDaSalaDao(vo.getNumeroDaSala());
        if (!array.isEmpty()) {
            return status;
        } else {
            System.out.println("Dentro do else de cadastrarSalaBo");
            System.out.println("A sala " + vo.getNumeroDaSala() + "já está cadastrada!");
            SalaDAO daoCadastro;
            daoCadastro = new SalaDAO();
            status = daoCadastro.cadastrarSalaDao(vo);
            return status;
        }
    }

    public boolean alterarSalaBo(SalaVO vo) {
        boolean status = false;
        ArrayList<SalaVO> array;
        SalaDAO dao;
        dao = new SalaDAO();
        array = dao.pesquisarSalaPeloIdDao(vo.getIdSala());
        if (!array.isEmpty()) {
            for (SalaVO salaVo : array) {
                System.out.println("********************************");
                System.out.println("ID DA SALA = " + salaVo.getIdSala());
                System.out.println("********************************");
                if (salaVo.getIdSala() == vo.getIdSala()) {
                    SalaDAO salaDao;
                    salaDao = new SalaDAO();
                    boolean retorno = dao.alterarSalaDao(vo);
                    status = retorno;
                    return status;
                }
            }
        }
        return status;
    }

    public String gerarCodigoDaSalaBo(int idSala) {
        String codigoDaSala = "#900-" + idSala;
        return codigoDaSala;
    }

    public ArrayList<SalaVO> pesquisarTodasAsSalas() {
        ArrayList array;
        SalaDAO dao;
        dao = new SalaDAO();
        array = dao.consultarTodasAsSalas();
        return array;
    }

    public ArrayList<SalaVO> pesquisarSalaPeloNome(String nomeSala) {
        ArrayList<SalaVO> array;
        SalaDAO dao;
        dao = new SalaDAO();
        array = dao.consultarSalaPeloNomeDaSalaDao(nomeSala);
        return array;
    }
}
