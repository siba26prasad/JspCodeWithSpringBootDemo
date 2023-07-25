package tech.csm.entity;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter

public class BatchDetailsBean implements Serializable {

	private String slNo;
	private Integer batchId;
	private Integer uBatchId;
	private String startDate;
	private String batchStrength;
	private String batchName;
	private String batchStartDate;
	private Integer technologyId;
	private String technologyName;
	private String employeeName;
	private Integer empId;
	private String employeePhone;
	private String mark;
	private String grade;
	private String status;

}
