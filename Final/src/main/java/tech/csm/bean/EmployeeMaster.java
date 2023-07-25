package tech.csm.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity
@Table(name="employee_master")
public class EmployeeMaster implements Serializable {
	
	@Id
	@Column(name="employee_id")
	private Integer employeeID;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="employee_phone")
	private String employeePhone;
	
	@Column(name="employee_email")
	private String employeeEmail;
	

}
