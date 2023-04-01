package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

@Entity
@NamedNativeQuery(name = "get_All_Products", query = "SELECT pid,pname,pcost,pqty FROM Product WHERE pcost>=:cost")
public class Product implements Serializable {
	
	@Id
	private Integer pid;
	private String pname;
	private Integer pcost;
	private Integer pqty;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPcost() {
		return pcost;
	}

	public void setPcost(Integer pcost) {
		this.pcost = pcost;
	}

	public Integer getPqty() {
		return pqty;
	}

	public void setPqty(Integer pqty) {
		this.pqty = pqty;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pcost=" + pcost + ", pqty=" + pqty + "]";
	}

}
