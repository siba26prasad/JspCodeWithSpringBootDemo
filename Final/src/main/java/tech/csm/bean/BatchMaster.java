package tech.csm.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity

@Table(name="batch_master")
public class BatchMaster implements Serializable {
	
	@Id
	@Column(name="batch_id")
	private Integer batchId;
	
	@Column(name="batch_name")
	private String batchName;
	
	@Column(name="batch_start_date")
	private Date batchStartDate;
	
	@Column(name="batch_strength")
	private String batchStrength;
}
