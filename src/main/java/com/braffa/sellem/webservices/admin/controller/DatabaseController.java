package com.braffa.sellem.webservices.admin.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.braffa.sellem.dao.utility.mysql.MySQLSetUp;
import com.braffa.sellem.model.xml.authentication.XmlLogin;
import com.braffa.sellem.model.xml.authentication.XmlLoginMsg;
import com.braffa.sellem.model.xml.authentication.XmlRegisteredUser;
import com.braffa.sellem.model.xml.authentication.XmlRegisteredUserMsg;
import com.braffa.sellem.model.xml.product.XmlProduct;
import com.braffa.sellem.model.xml.product.XmlProductMsg;
import com.braffa.sellem.model.xml.product.XmlUserToProduct;
import com.braffa.sellem.model.xml.product.XmlUserToProductMsg;
import com.braffa.sellem.webservices.admin.form.DatabaseReportForm;
import com.braffa.sellem.xml.parser.ConvertXMLToObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Controller
@SessionAttributes("loggedin")
public class DatabaseController {

	private static final Logger logger = Logger
			.getLogger(DatabaseController.class);

	@RequestMapping("/initdatabasemenu.html")
	public String initDatabaseMenu() {
		if (logger.isDebugEnabled()) {
			logger.debug("initDatabaseMenu");
		}
		return "databasemenu";
	}

	@RequestMapping("/recreateDatabase.html")
	public String recreateDatabase(Map<String, Object> model) {
		if (logger.isDebugEnabled()) {
			logger.debug("recreateDatabase");
		}
		DatabaseReportForm databaseReportForm = new DatabaseReportForm();
		try {
			MySQLSetUp mySQLSetUp = new MySQLSetUp();
			mySQLSetUp.setUpLogin();
			mySQLSetUp.setUpRegisteredUser();
			mySQLSetUp.setUpUserToProductTable();
			mySQLSetUp.setUpProduct();
			
			
			databaseReportForm.setlOfLogins(getAllLogins());
			databaseReportForm.setlOfRegisteredUser(getLOfRegisteredUser());
			databaseReportForm.setlOfProducts(getLOfProducts());
			databaseReportForm.setlOfUserToCatalog(getUserToProduct());

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.put("databaseReportForm", databaseReportForm);
		return "databasereport";
	}

	private List<XmlLogin> getAllLogins() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAllLogins");
		}
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		String xml = service.path("rest").path("login").path("findall")
				.accept(MediaType.TEXT_XML).get(String.class);
		ConvertXMLToObject convertXMLToObject = new ConvertXMLToObject(xml);
		XmlLoginMsg loginMsg = convertXMLToObject.xmlloginMsgToObjects();
		List<XmlLogin> lOfLogins = loginMsg.getLOfLogins();
		return lOfLogins;
	}

	@RequestMapping("/viewlogin.html")
	public String viewLogin(Map<String, Object> model) {
		if (logger.isDebugEnabled()) {
			logger.debug("viewlogin");
		}
		try {
			DatabaseReportForm databaseReportForm = new DatabaseReportForm();
			databaseReportForm.setlOfLogins(getAllLogins());
			model.put("databaseReportForm", databaseReportForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "databasereport";
	}

	private List<XmlRegisteredUser> getLOfRegisteredUser() {
		if (logger.isDebugEnabled()) {
			logger.debug("getLOfRegisteredUser");
		}
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		String xml = service.path("rest").path("registeredusers")
				.path("findall").accept(MediaType.TEXT_XML).get(String.class);
		ConvertXMLToObject convertXMLToObject = new ConvertXMLToObject(xml);
		XmlRegisteredUserMsg registeredUserMsg = convertXMLToObject
				.xmlRegisteredUserMsgToObjects();
		List<XmlRegisteredUser> lOfRegisteredUser = registeredUserMsg
				.getLOfRegisteredUsers();
		return lOfRegisteredUser;
	}

	@RequestMapping("/viewregistereduser.html")
	public String viewRegisteredUser(Map<String, Object> model) {
		if (logger.isDebugEnabled()) {
			logger.debug("viewRegisteredUser");
		}
		try {
			DatabaseReportForm databaseReportForm = new DatabaseReportForm();
			databaseReportForm.setlOfRegisteredUser(getLOfRegisteredUser());
			model.put("databaseReportForm", databaseReportForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "databasereport";
	}

	private List<XmlProduct> getLOfProducts() {
		if (logger.isDebugEnabled()) {
			logger.debug("getLOfProducts");
		}
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		String xml = service.path("rest").path("product").path("findall")
				.accept(MediaType.TEXT_XML).get(String.class);
		ConvertXMLToObject convertXMLToObject = new ConvertXMLToObject(xml);
		XmlProductMsg productMsg = convertXMLToObject.xmlProductMsgToObjects();
		List<XmlProduct> lOfProducts = productMsg.getLOfProducts();
		return lOfProducts;
	}

	@RequestMapping("/viewcatalog.html")
	public String viewCatalog(Map<String, Object> model) {
		if (logger.isDebugEnabled()) {
			logger.debug("viewcatalog");
		}
		try {
			DatabaseReportForm databaseReportForm = new DatabaseReportForm();
			databaseReportForm.setlOfProducts(getLOfProducts());
			model.put("databaseReportForm", databaseReportForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "databasereport";
	}
	
	private List<XmlUserToProduct> getUserToProduct() {
		if (logger.isDebugEnabled()) {
			logger.debug("getUserToProduct");
		}
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		String xml = service.path("rest").path("usertoproduct")
				.path("findall").accept(MediaType.TEXT_XML)
				.get(String.class);
		ConvertXMLToObject convertXMLToObject = new ConvertXMLToObject(xml);
		XmlUserToProductMsg userToProductMsg = convertXMLToObject
				.xmlUserToProductMsgToObjects();
		List<XmlUserToProduct> lOfUsertoProducts = userToProductMsg
				.getLOfXmlUserToProduct();
		return lOfUsertoProducts;
	}

	@RequestMapping("/viewusertocatalog.html")
	public String viewUserToCatalog(Map<String, Object> model) {
		if (logger.isDebugEnabled()) {
			logger.debug("viewUserToCatalog");
		}
		try {
			DatabaseReportForm databaseReportForm = new DatabaseReportForm();
			databaseReportForm.setlOfUserToCatalog(getUserToProduct());
			model.put("databaseReportForm", databaseReportForm);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "databasereport";
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/sellemws").build();
	}
}
