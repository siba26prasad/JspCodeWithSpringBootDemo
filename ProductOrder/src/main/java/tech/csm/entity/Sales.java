
package tech.csm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
@Table(name ="sales")

public class Sales implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="slno")
	private Integer serialNo;
	
	@Column(name="sales_date")
	private Date  salesDate;
	
	@Column(name="pid")
	private Integer productId;
	
	private Integer qty;
	
	private Double rate;
	
	private Double amount;

}
