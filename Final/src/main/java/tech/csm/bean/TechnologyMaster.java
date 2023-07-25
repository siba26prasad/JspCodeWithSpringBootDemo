package tech.csm.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="technology_mater")
public class TechnologyMaster implements Serializable {

	@Id
	@Column(name="technology_id")
	private Integer technologyId;
	@Column(name="technology_name")
	private String technologyName;
}
