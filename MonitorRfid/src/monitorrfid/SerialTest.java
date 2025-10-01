/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorrfid;

import RegraDAO.FluxoDAO;
import RegraDAO.FrequenciaAlunoDAO;
import RegraVO.AlunoTurmaCursoSemestreAnoVO;
import RegraVO.DiaDeProvaVO;
import RegraVO.FrequenciaAlunoVO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.TooManyListenersException;
import javax.swing.JOptionPane;

public class SerialTest implements SerialPortEventListener {

    public static Main mn = new Main();

    SerialPort serialPort;
    private static final String PORT_NAMES[] = {
        "/dev/tty.usbserial-A9007UX1", /* Mac OS X*/
        "/dev/ttyACM0", /* Raspberry Pi*/
        "/dev/ttyUSB0", /* Linux*/
        "/dev/ttyUSB1",/*Nem sempre sera o USB0. Pode ser USB1*/
        "COM3", /*Windows*/};
    /**
     * A BufferedReader which will be fed by a InputStreamReader converting the
     * bytes into characters making the displayed results codepage independent
     */
    private BufferedReader input;
    /**
     * The output stream to the port
     */
    private OutputStream output;
    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 9600;

    public void regra() throws ParseException {
        try {

            // 0) Formatar padrao de data
            Locale locale = new Locale("pt", "BR");
            String dataAtualFormatada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale)
                    .format(System.currentTimeMillis());
            // 1) Ler os dados do cartao
            String inputLine = input.readLine();
            // 2) Seta valores relativos à Data e o Dia da Semana
            String dataAtualDoSistema = dataAtualFormatada.substring(0, 10);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = df.parse(dataAtualDoSistema);
            DateFormat df2 = new SimpleDateFormat("EEEE");
            String diaDaSemana = df2.format(dt);
            // 3) Seta valores do horário no momento da leitura do cartão
            String horario = dataAtualFormatada.substring(11, 19);
            // 4) Divide a String com a metade do cartao
            String cartaoRfidDoAluno = inputLine.substring(8, 17);//250118440                        
            // 5) Divide a String com a metade da sala
            String sala = inputLine.substring(0, 7);

            System.out.println("Sala :" + sala);
            System.out.println("Data Atual do Sistema :" + dataAtualDoSistema);
            System.out.println("Dia da Semana : " + df2.format(dt));
            System.out.println("Hora do ponto : " + horario);
            System.out.println("Cartao do aluno:" + cartaoRfidDoAluno);
            System.out.println("Linha Completa > " + inputLine);

            Date horaInicial;// = null;
            Date horaFinal;// = null;
            String horarioInit = "";
            String horarioFin = "";
            String dataDaProva = "";
            String salaParaComparacao = "";
            String prova = "";
            String nomeAluno = "";
            String curso = "";
            String turma = "";
            String codigoMatriculaDoAluno = "";
            String diaDoPontoQueAlunoJaRegistrou = "";
            String horaDoPontoQueAlunoJaRegistrou = "";
            int idDiaDeProva = 0;
            int idAluno = 0;
            int idTurma = 0;
            int idTurmaParaCompracao = 0;
            boolean status = false;
            FluxoDAO dao = new FluxoDAO();
            ArrayList<AlunoTurmaCursoSemestreAnoVO> arrayAluno;
            ArrayList<DiaDeProvaVO> arrayDiaDeProva;

            arrayAluno = dao.pesquisarAlunoTurmaCursoSemestre(cartaoRfidDoAluno);
            if (!arrayAluno.isEmpty()) {
                System.out.println("Dentro do if arrayAluno!!!");

                for (AlunoTurmaCursoSemestreAnoVO vo : arrayAluno) {
                    idAluno = vo.getIdAluno();
                    idTurma = vo.getIdTurma();
                    nomeAluno = vo.getNomeAluno();
                    curso = vo.getNomeCurso();
                    turma = vo.getTurma();
                    codigoMatriculaDoAluno = vo.getCodigoMatriculaAluno();
                }
                arrayDiaDeProva = dao.pesquisarDataHorarioInicialHorarioFinal(dataAtualDoSistema, idTurma, sala);
                for (DiaDeProvaVO vo : arrayDiaDeProva) {
                    dataDaProva = vo.getDataDaProva();
                    idTurmaParaCompracao = vo.getIdTurma();
                    idDiaDeProva = vo.getIdDiaDeProva();
                    salaParaComparacao = vo.getSala();
                    horarioInit = vo.getHorarioInicialDaProva();
                    horarioFin = vo.getHorarioFinalDaProva();
                    prova = vo.getProva();
                }
                if ((dataAtualDoSistema.equals(dataDaProva))
                        && (idTurma == idTurmaParaCompracao)
                        && (sala.equals(salaParaComparacao))) {
                    System.out.println("Prova ok!!!!!!!!!!!!!!!!!!!!");
                    SimpleDateFormat regraHora = new SimpleDateFormat("HH:mm:ss", locale);
                    //Date horarioAtual = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", locale);
                    Date hora = Calendar.getInstance().getTime(); // obtem de novo a hora do sistema
                    //String dataFormatada = sdf.format(hora);
                    hora = regraHora.parse(horario);
                    horaInicial = regraHora.parse(horarioInit);
                    horaFinal = regraHora.parse(horarioFin);
                    if ((hora.getTime() > horaInicial.getTime()) && (hora.getTime() < horaFinal.getTime())) {
                        FrequenciaAlunoDAO freqDao = new FrequenciaAlunoDAO();
                        boolean statusAluno = freqDao.verificaSeAlunoJaBateuPonto(prova, idAluno);
                        ArrayList<FrequenciaAlunoVO> arrayFrequencia = freqDao.pesquisarNaTabelaFrequenciaDoAluno(idAluno);
                        for (FrequenciaAlunoVO vo : arrayFrequencia) {
                            System.out.println("Ponto ja batido " + diaDoPontoQueAlunoJaRegistrou);
                            horaDoPontoQueAlunoJaRegistrou = vo.getHorarioDoPonto();
                            diaDoPontoQueAlunoJaRegistrou = vo.getDataDiaDeProva();
                        }
                        if (statusAluno == false) {
                            status = true;
                            FrequenciaAlunoVO freqVo = new FrequenciaAlunoVO(
                                    idAluno,
                                    idDiaDeProva,
                                    status,
                                    nomeAluno,
                                    prova,
                                    sala,
                                    dataDaProva,
                                    horario,                                                                                                                     
                                    diaDaSemana);

                            freqDao.cadastrarFrequenciaDoAluno(freqVo);

                            mn.setTxtConsole("Data: " + dataAtualDoSistema
                                    + "\nHora: " + horario
                                    + "\nProva: " + prova
                                    + "\nSala: " + sala
                                    + "\nCurso: " + curso
                                    + "\nTurma: " + turma
                                    + "\nTag : " + cartaoRfidDoAluno
                                    + "\nCod. Matricula : " + codigoMatriculaDoAluno
                                    + "\nNome do Aluno: " + nomeAluno
                                    + "\nPresenca Computada Com Sucesso!");

                        } else {

                            JOptionPane.showMessageDialog(null, "O Aluno(a) : " + nomeAluno + " relativo(a) a Turma: (" + turma + ") \njá REGISTROU sua frequencia para a prova " + prova + " às (" + horaDoPontoQueAlunoJaRegistrou + " :hs) \nreferente a data " + diaDoPontoQueAlunoJaRegistrou + " na " + sala);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "O Aluno(a) : " + nomeAluno + " relativo(a) a Turma: (" + turma + ") \nestá fora do intervalo de tempo!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não existem provas programadas para o Aluno(a): " + nomeAluno + "\n"
                            + "Turma : " + turma + ",\naté o atual presente momento : " + dataAtualDoSistema+" às "+horario);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aluno(a) nao encontrado! (tag =" + cartaoRfidDoAluno + ")");
            }
        } catch (IOException e) {
            System.err.println("Erro de geral: " + e.toString());
        }
    }

    public void initialize(String port) throws ParseException {
        // the next line is for Raspberry Pi and 
        // gets us into the while loop and was suggested here was suggested 
        //http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
        System.setProperty("gnu.io.rxtx.SerialPorts", port);

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        Locale locale = new Locale("pt", "BR");
        String dataAtualFormatada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale)
                .format(System.currentTimeMillis());
        String dataAtualDoSistema = dataAtualFormatada.substring(0, 10);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = df.parse(dataAtualDoSistema);
        DateFormat df2 = new SimpleDateFormat("EEEE");
        String diaDaSemana = df2.format(dt);
        String horario = dataAtualFormatada.substring(11, 19);

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    mn.setTxtConsole("Porta Serial (" + port + ") inicializada!\n"
                            +"\nData de Hoje: " + dataAtualDoSistema
                            +"\nDia da Semana: "+diaDaSemana);                    
                    break;
                } else if (portId == null) {
                    mn.setTxtConsole("A Porta " + port + " retornou null!");
                } else {
                    mn.setTxtConsole("Porta " + port + " não encontrada!");
                }
            }
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);

        } catch (PortInUseException | UnsupportedCommOperationException | IOException | TooManyListenersException e) {
            System.err.println(e.toString());
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    /**
     * This should be called when you stop using the port. This will prevent
     * port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel ecerrar a comunicação com o serial monitor!");
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     *
     * @param oEvent
     */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                regra();
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro : " + ex.getMessage() + " Não foi possivel ler o dado do serial event!");
            }
        }

        // Ignore all the other eventTypes, but you should consider the other ones.
    }

    public static void main(String[] args) throws Exception {
        mn.setVisible(true);
        mn.setLocationRelativeTo(null);
        Thread t = new Thread() {
            public void run() {
                //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them (printing incoming messages to console).
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException ie) {
                    JOptionPane.showMessageDialog(null, "Erro : " + ie.getMessage() + " Nenhum dispositivo conectado!");
                }
            }
        };
        t.start();
        System.out.println("Started");
    }
}
