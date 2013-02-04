package client;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class note {
	private String lieu;
	private String desc;
	@Id
	@GeneratedValue
	private String id;
	protected note() {
	}
	public note(String Lieu,String Desc,String Id){
		this.lieu=Lieu;
		this.desc=Desc;
		this.id=Id;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
