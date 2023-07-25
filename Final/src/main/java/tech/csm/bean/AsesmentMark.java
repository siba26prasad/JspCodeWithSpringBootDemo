package tech.csm.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="asesment_mark")
public class AsesmentMark implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "slno")
	private Integer slNo;
	
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "mark")
	private Integer marks;
}
