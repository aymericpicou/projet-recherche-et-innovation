package ejbprojet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="employee", mappedName="EmployeeBean/remote")
public class EmployeeBean implements EmployeeServiceLocal, EmployeeServiceRemote {
  @PersistenceContext(unitName="EmployeeService") private EntityManager manager;
  public void doAction(){
    Customer cust = new Customer();

    cust.setFirstName("Joe");
    manager.persist(cust);
    
    System.out.println("Saved");
    
    cust = manager.find(Customer.class,cust.getId());
    
    System.out.println(cust.getFirstName());
       
  }
}
