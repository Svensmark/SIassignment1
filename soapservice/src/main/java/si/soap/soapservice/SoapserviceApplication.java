package si.soap.soapservice;

import org.apache.axis.AxisFault;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import si.soap.client.Calculator;
import si.soap.client.CalculatorLocator;
import si.soap.client.CalculatorSoap12Stub;
import si.soap.client.CalculatorSoap_PortType;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

@SpringBootApplication
public class SoapserviceApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SoapserviceApplication.class, args);
        DAORest rest = new DAORest();

        try {
            CalculatorLocator locater = new CalculatorLocator();
            CalculatorSoap_PortType service = locater.getCalculatorSoap12();
            int tester = service.add(3,4);
            //proving soap functionality works
            System.out.println(tester+"");
            //Proof connecting to Restful service works
            System.out.println(rest.getStudent(2).getSname());
            System.out.println(rest.getStudents()[0].getSname());
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }
}