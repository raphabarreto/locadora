package com.locadora.handle;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@ManagedBean
public class LoginHandle {
	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login(ActionEvent actionEvent) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage msg = null;
		boolean loggedIn = false;

		if (username != null && username.equals("admin") && password != null && password.equals("admin")) {
			loggedIn = true;
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem Vindo", username);
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("cliente.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			loggedIn = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", "Usuário e Senha Errados !");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
		context.addCallbackParam("loggedIn", loggedIn);
	}
}
