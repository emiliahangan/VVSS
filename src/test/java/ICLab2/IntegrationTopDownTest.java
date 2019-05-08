package ICLab2;

import ICLab2.Exceptions.ValidatorException;
import ICLab2.Repository.XMLFileRepository.NotaXMLRepo;
import ICLab2.Repository.XMLFileRepository.StudentXMLRepo;
import ICLab2.Repository.XMLFileRepository.TemaLabXMLRepo;
import ICLab2.Service.XMLFileService.NotaXMLService;
import ICLab2.Service.XMLFileService.StudentXMLService;
import ICLab2.Service.XMLFileService.TemaLabXMLService;
import ICLab2.Validator.NotaValidator;
import ICLab2.Validator.StudentValidator;
import ICLab2.Validator.TemaLabValidator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class IntegrationTopDownTest {

    @Test
    public void addStudent() {
        try {
            StudentXMLRepo rep = new StudentXMLRepo( new StudentValidator(), "./studenti.xml");
            StudentXMLService srv = new StudentXMLService(rep);

            String p[] = {"78", "Emilia", "933", "emilia@yahoo.ro", "Prof X"};
            srv.add(p);
            assertTrue(true);
        } catch (Error | ValidatorException e) {
            fail();
        }
    }

    @Test
    public void addAssigmentIntegration(){
        try{
            addStudent();
            addAssignment();
        }catch (Error e){
            fail();
        }
    }

    @Test
    public void addGradeIntegration(){
        try{
            addStudent();
            addAssignment();
            addGrade();
        }catch (Error e){
            fail();
        }
    }



    @Test
    public void addAssignment() {
        try {

            TemaLabXMLRepo repo = new TemaLabXMLRepo(new TemaLabValidator(), "./teme.xml");
            TemaLabXMLService serv = new TemaLabXMLService(repo);

            String p[] = {"1", "Do black box testing", "2", "3"};
            serv.add(p);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }


    @Test
    public void addGrade() {
        try {
            NotaXMLRepo r = new NotaXMLRepo(new NotaValidator(), "./note.xml");

            NotaXMLService serv = new NotaXMLService(r);
            String p[] = {"1", "1", "10", "4", "2016-03-04 11:30"};
            serv.add(p);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }
}
