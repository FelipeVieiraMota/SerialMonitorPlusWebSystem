/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBO;

import ModelDAO.DiaDeProvaDAO;
import ModelVO.DiaDeProvaVO;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class DiaDeProvaBO {

    /*

    public ArrayList<DiaDeProvaVO> pesquisarObjetoDiaDeProvaPeloNomeRetornarObjetoDiaDeProvaBo(String nomeDiaDeProva) {
        ArrayList<DiaDeProvaVO> arrayDiaDeProva;
        DiaDeProvaDAO dao;
        dao = new DiaDeProvaDAO();
        arrayDiaDeProva = dao.pesquisarObjetoDiaDeProvaPeloNomeEmTodosOsRelacionamentosQuePossuiRetornarObjetoDiaDeProvaCompletoDao(nomeDiaDeProva);
        return arrayDiaDeProva;
    }
     */
    public boolean cadastrarObjetoDiaDeProvaBO(DiaDeProvaVO diaDeProvaVO) {
        System.out.println("*****Dentro do metodo cadastrarDiaDeProva =)");
        boolean status = false;
        DiaDeProvaDAO pesquisarDao = new DiaDeProvaDAO();
        String nomeDiaDeProva = diaDeProvaVO.getProva();
        ArrayList<DiaDeProvaVO> arrayDiaDeProva;
        arrayDiaDeProva = pesquisarDao.pesquisarDiaDeProvaDao(nomeDiaDeProva);
        if (!arrayDiaDeProva.isEmpty()) {
            System.out.println("O array não está vazio, já existe alguma diaDeProva com esse nome!!!!");
            return status;
        } else {
            System.out.println("Dentro do else no metodo cadastrarDiaDeProva BO");
            DiaDeProvaDAO dao;
            dao = new DiaDeProvaDAO();
            status = dao.cadastrarObjetoDiaDeProvaDao(diaDeProvaVO);
            System.out.println("Retorno cadastrarObjetoDiaDeProvaBO = " + status);
            return status;
        }
    }

    public boolean alterarObjetoDiaDeProvaBo(DiaDeProvaVO diaDeProvaVO) {
        System.out.println("*****Dentro do metodo alterarObjetoDiaDeProvaBo =)");
        DiaDeProvaDAO dao = new DiaDeProvaDAO();
        ArrayList<DiaDeProvaVO> array;
        boolean status = false;
        int idDiaDeProva = diaDeProvaVO.getIdDiaDeProva();
        array = dao.pesquisarDiaDeProvPeloIdaDao(idDiaDeProva);
        if (array.isEmpty()) {
            status = false;            
        } else {
            for (DiaDeProvaVO vo : array) {
                if(idDiaDeProva == vo.getIdDiaDeProva()){
                   status = true; 
                }
            }
        }
        if (status == true) {
            status = dao.alterarObjetoDiaDeProvaDao(diaDeProvaVO);
            return status;
        } else {
            status = false;
            return status;
        }
    }

    public int pesquisarObjetoDiaDeProvaPeloNomeRetornarIdDiaDeProvaBo(String nomeDiaDeProva) {
        ArrayList<DiaDeProvaVO> arrayDiaDeProva;
        DiaDeProvaDAO dao = new DiaDeProvaDAO();
        arrayDiaDeProva = dao.pesquisarDiaDeProvaDao(nomeDiaDeProva);
        if (!arrayDiaDeProva.isEmpty()) {
            int idDiaDeProva;
            for (DiaDeProvaVO vo : arrayDiaDeProva) {
                idDiaDeProva = vo.getIdDiaDeProva();
                return idDiaDeProva;
            }
        }
        return 0;
    }

    public ArrayList<DiaDeProvaVO> pesquisarDiaDeProvaBo(String nomeDiaDeProva) {
        ArrayList<DiaDeProvaVO> arrayDiaDeProva;
        DiaDeProvaDAO dao;
        dao = new DiaDeProvaDAO();
        arrayDiaDeProva = dao.pesquisarDiaDeProvaDao(nomeDiaDeProva);
        return arrayDiaDeProva;
    }

    public ArrayList<DiaDeProvaVO> pesquisarTodosOsObjetosDiaDeProvasEmTodosOsRelacionamentosRetornarObjetoDiaDeProvaCompletoBo() {
        ArrayList<DiaDeProvaVO> arrayDiaDeProva;
        DiaDeProvaDAO dao;
        dao = new DiaDeProvaDAO();
        arrayDiaDeProva = dao.pesqusarTodosOsHorariosDeProvasDao();
        return arrayDiaDeProva;
    }

    public String gerarCodigoDaDiaDeProvaBo(int idDiaDeProva) {
        String codigoDaDiaDeProva = "#1000-" + idDiaDeProva;
        return codigoDaDiaDeProva;
    }
}
