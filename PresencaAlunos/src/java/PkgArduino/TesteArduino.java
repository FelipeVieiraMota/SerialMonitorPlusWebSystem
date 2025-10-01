/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgArduino;

import gnu.io.CommPortIdentifier;
import java.util.Enumeration;

/**
 *
 * @author felipe
 */
public class TesteArduino {

    public static void main(String args[]) {
        Sensor arduino;
        arduino = new Sensor("/dev/ttyACM0", 9600);//Linux - porta e taxa de transmissão
        arduino.enviaDados('2');
       // arduino.enviaDados(2);
        arduino.close();
       /*Enumeration ports = CommPortIdentifier.getPortIdentifiers();
        while (ports.hasMoreElements()) {
            CommPortIdentifier port = (CommPortIdentifier) ports.nextElement();
            String type;
            switch (port.getPortType()) {
                case CommPortIdentifier.PORT_PARALLEL:
                    type = "Parallel";
                    break;
                case CommPortIdentifier.PORT_SERIAL:
                    type = "Serial";
                    break;
                default: /// Shouldn't happen
                    type = "Unknown";
                    break;
            }
            System.out.println(port.getName() + ": " + type);
        }*/
    }
}
