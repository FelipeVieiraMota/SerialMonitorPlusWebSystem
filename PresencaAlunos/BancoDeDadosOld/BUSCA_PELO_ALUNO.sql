/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  felipe
 * Created: Oct 28, 2017
 */

/*ENCONTRA O ALUNO PELO CODIGO DO CARTAO RFID*/
SELECT * FROM ALUNO WHERE CODIGO_CARTAO_RFID = 'VARIALVEL QUE VEM DA CLASSE QUE REALIZA A LEITURA DO CARTAO';

/*ENCONTRA A TURMA DO ALUNO PELO ID DO ALUNO E O*/
SELECT * FROM ALUNO A, TURMA T, ALUNO_TURMA ALT 
    WHERE A.ID_ALUNO = ALT.ID_ALUNO AND 
    T.ID_TURMA = ALT.ID_TURMA;