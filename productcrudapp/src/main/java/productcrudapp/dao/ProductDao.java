package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;


import productcrudapp.model.Product;

@Component
public class ProductDao {
	@Autowired
	public HibernateTemplate hibernateTemplate;
	@Transactional
	public void createproduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
		
	}
	
	public List<Product> getproducts(){
	List<Product>list=this.hibernateTemplate.loadAll(Product.class);
	return list;
	}
	@Transactional
	public void deleteproduct(int id) {
		Product product=this.hibernateTemplate.load(Product.class,id);
		this.hibernateTemplate.delete(product);
	}
	
	public Product getProduct(int id) {
		return this.hibernateTemplate.get(Product.class, id);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
