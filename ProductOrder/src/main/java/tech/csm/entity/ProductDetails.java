package tech.csm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="product")
public class ProductDetails implements Serializable {
	
	@Id
	@Column(name="pid")
	private Integer pId;
	
	@Column(name="pname")
	private String pName;
	
	@Column(name="pqty")
	private Integer pQty;
	
	@Column(name="prate")
	private Double pRate;

}
