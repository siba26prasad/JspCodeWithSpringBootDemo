package tech.csm.service;

import tech.csm.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{

	public Integer placeOrder(String pdName, Integer pdQty) {
		// TODO Auto-generated method stub
		return new ProductDaoImpl().placeOrder(pdName,pdQty);
	}

}
