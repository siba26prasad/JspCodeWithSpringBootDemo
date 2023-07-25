package tech.csm.bean;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="batch_allocate")
public class BatchAllocate implements Serializable {
	
	@Id
	@Column(name="batch_allocate_id")
	private Integer batchAllocateId;
	
	@Column(name="batch_id")
	private Integer batchId;
	
	@Column(name="technology_id")
	private Integer technologyId;
	
	@Column(name="employee_id")
	private Integer employeeId;

}
