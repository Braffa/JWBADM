package com.braffa.sellem.webservices.admin.form;

import java.util.ArrayList;
import java.util.List;

import com.braffa.sellem.model.xml.authentication.XmlLogin;
import com.braffa.sellem.model.xml.authentication.XmlRegisteredUser;
import com.braffa.sellem.model.xml.product.XmlProduct;
import com.braffa.sellem.model.xml.product.XmlUserToProduct;
import com.braffa.sellem.model.xml.webserviceobjects.product.Product;
import com.braffa.sellem.model.xml.webserviceobjects.product.UserToCatalog;



public class DatabaseReportForm {

	private List<XmlLogin> lOfLogins;
	
	private List<XmlRegisteredUser> lOfRegisteredUser;
	
	private List<XmlProduct> lOfProducts;

	private List<XmlUserToProduct> lOfUserToCatalog;
	
	public DatabaseReportForm () {
		lOfLogins = new ArrayList<XmlLogin>();
		lOfRegisteredUser = new ArrayList<XmlRegisteredUser>();
		lOfProducts = new ArrayList<XmlProduct>();
		lOfUserToCatalog = new ArrayList<XmlUserToProduct>();
	}

	public List<XmlLogin> getlOfLogins() {
		return lOfLogins;
	}

	public void setlOfLogins(List<XmlLogin> lOfLogins) {
		this.lOfLogins = lOfLogins;
	}

	public List<XmlRegisteredUser> getlOfRegisteredUser() {
		return lOfRegisteredUser;
	}

	public void setlOfRegisteredUser(List<XmlRegisteredUser> lOfRegisteredUser) {
		this.lOfRegisteredUser = lOfRegisteredUser;
	}

	public List<XmlProduct> getlOfProducts() {
		return lOfProducts;
	}

	public void setlOfProducts(List<XmlProduct> lOfProducts) {
		this.lOfProducts = lOfProducts;
	}

	public List<XmlUserToProduct> getlOfUserToCatalog() {
		return lOfUserToCatalog;
	}

	public void setlOfUserToCatalog(List<XmlUserToProduct> lOfUserToCatalog) {
		this.lOfUserToCatalog = lOfUserToCatalog;
	} 
	
}