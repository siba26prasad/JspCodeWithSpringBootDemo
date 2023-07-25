package tech.csm.dao;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tech.csm.entity.ProductDetails;
import tech.csm.entity.Sales;
import tech.csm.util.HibernateUtil;

public class ProductDaoImpl implements ProductDao {

	public Integer placeOrder(String pdName, Integer pdQty) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Query<ProductDetails> seQuery = session.createQuery("from Product where pName=?1");
		seQuery.setParameter(1, pdName);
		List<ProductDetails> productList = seQuery.list();
//		Product num = productList.get(2);
//System.out.println(num);
		if (productList.size() != 0) {
//			Integer num1 = Array.getInt(productList, 2);
			System.out.println("football  available");
			Sales sale = new Sales();
			Integer pqty = 0;
			for (ProductDetails d : productList) {
				sale.setSalesDate(new Date());
				sale.setProductId(d.getPId());
				pqty = d.getPQty();
//				sale.setQty(d.getPQty());
				sale.setRate(d.getPRate());
//				System.out.println(sale.getRate());
//				System.out.println(pdQty);
			}
//			System.out.println(sale.getQty());
			if (pqty > pdQty) {
				sale.setQty(pdQty);
//				System.out.println((sale.getRate() * pdQty));
				sale.setAmount((sale.getRate() * pdQty));
				Integer serialNo = (int) session.save(sale);
				Query<ProductDetails> upQuery = session.createQuery("update Product set pQty =:q where pName=");
				seQuery.setParameter("q", pqty - sale.getQty());
				seQuery.setParameter("n", "football");
				List<ProductDetails> productList1 = seQuery.list();
				tx.commit();
				return serialNo;
			} else {
				tx.commit();
				return 0;
			}
		} else {
			tx.commit();
			return 0;
		}
	}

}
