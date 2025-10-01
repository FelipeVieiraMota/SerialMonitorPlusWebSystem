/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBO;

import ModelDAO.FrequenciaAlunoDAO;
import ModelVO.FrequenciaVO;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class FrequenciaBO {

    public ArrayList<FrequenciaVO> pesquisarFrequenciaDoAlunoBo(String nomeAluno) {
        ArrayList<FrequenciaVO> array;        
        FrequenciaAlunoDAO dao = new FrequenciaAlunoDAO();
        array = dao.pesquisarFrequenciaDoAlunoDao(nomeAluno);
        return array;
    }
}
