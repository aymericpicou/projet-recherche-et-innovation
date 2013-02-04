package ejbprojet;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CUSTOMER_TABLE")
public class Customer implements java.io.Serializable {
  private int id;

  private String lastName;

  private String firstName;

  private Date timeCreated = new Date();

  @Id
  @GeneratedValue
  @Column(name = "CUST_ID")
  public int getId() {
    return id;
  }

  public void setId(int pk) {
    id = pk;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Temporal(TemporalType.TIME)
  public Date getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(Date time) {
    timeCreated = time;
  }

}
