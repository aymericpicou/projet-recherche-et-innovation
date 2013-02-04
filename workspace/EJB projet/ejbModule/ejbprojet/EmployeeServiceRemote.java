package ejbprojet;
import javax.ejb.Remote;


@Remote
public interface EmployeeServiceRemote {
  public void doAction();
}
