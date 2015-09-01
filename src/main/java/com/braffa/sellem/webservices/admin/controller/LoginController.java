package com.braffa.sellem.webservices.admin.controller;

import java.net.URI;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.braffa.sellem.model.xml.authentication.XmlLogin;
import com.braffa.sellem.model.xml.authentication.XmlLoginMsg;
import com.braffa.sellem.model.xml.webserviceobjects.authentication.Login;
import com.braffa.sellem.webservices.admin.form.LoginForm;
import com.braffa.sellem.xml.parser.ConvertXMLToObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Controller
@SessionAttributes("loggedin")
public class LoginController {

	private static final Logger logger = Logger
			.getLogger(LoginController.class);

	@RequestMapping("/login.html")
	public String showForm(Map<String, LoginForm> model) {
		if (logger.isDebugEnabled()) {
			logger.debug("showForm");
		}
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "login";
	}

	@RequestMapping("/attemptlogin.html")
	public Object processForm(@Valid LoginForm loginForm, BindingResult result,
			Map<String, LoginForm> model, Model myModel) {
		if (logger.isDebugEnabled()) {
			logger.debug("processForm");
		}
		if (result.hasErrors()) {
			return "login";
		}
		loginForm = (LoginForm) model.get("loginForm");
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		String xml = service.path("rest").path("login").path("find")
				.path(loginForm.getUserName())
				.accept(MediaType.TEXT_XML).get(String.class);

		ConvertXMLToObject convertXMLToObject = new ConvertXMLToObject(xml);
		XmlLoginMsg loginMsg = convertXMLToObject.xmlloginMsgToObjects();
		XmlLogin login = loginMsg.getLOfLogins().get(0);

		ModelAndView mv = new ModelAndView("redirect:login.html");

		if (login.getUserId().equals("9999")) {
			result.addError(new FieldError("loginForm", "userName", "Invalid userName" + " ( " + loginForm.getUserName() +  " does not exist" + " )")); 
			return "login";
		} else {
			if (login.getUserId().equals("Braffa") && login.getPassword().equals(loginForm.getPassword())) {
				myModel.addAttribute("loggedin", login);
				mv = new ModelAndView("redirect:/initdatabasemenu.html");
			} else {
				result.addError(new FieldError("loginForm", "password", "Invalid " + "password" + " ( " + "Invalid password" + " )")); 
				return "login";
			}
		}
		myModel.addAttribute("userId", login.getUserId());
		return mv;
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/sellemws").build();
	}
}
