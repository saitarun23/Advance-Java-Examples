package com.bean;

public class Connection {
	String url;
	String user;
	String password;

	public Connection() {
		System.out.println("[Connection] Object Created");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Connection [url=" + url + ", user=" + user + ", password=" + password + "]";
	}
}