package si.soap.soapservice;

import org.apache.axis.AxisFault;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import si.soap.client.CalculatorLocator;
import si.soap.client.CalculatorSoap_PortType;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

@SpringBootApplication
public class SoapserviceApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SoapserviceApplication.class, args);
        DAORestStu restStu = new DAORestStu();
        DAORestEx restEx = new DAORestEx();
        DAORestTea restTea = new DAORestTea();


        try {
            CalculatorLocator locater = new CalculatorLocator();
            CalculatorSoap_PortType service = locater.getCalculatorSoap12();
            int tester = service.add(3,4);
            //proving soap functionality works
            System.out.println(tester+"");
            //Proof connecting to Restful service works
            System.out.println(restStu.getStudent(2).getSname());
            System.out.println(restStu.getStudents()[0].getSname());
            System.out.println(restEx.getExam(2).getEname());
            System.out.println(restEx.getExams()[0].getEname());
            System.out.println(restTea.getTeacher(2).getTname());
            System.out.println(restTea.getTeachers()[0].getTname());
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }
}