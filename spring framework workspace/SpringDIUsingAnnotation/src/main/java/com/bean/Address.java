package com.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component 						//<bean class="com.bean.Address"></bean>
public class Address {			//by default id is class name using camel naming rule. 
	@Value(value="Mumbai")
	private String city;		//if class contains one word then lower case
	@Value(value = "Mh")
	private String state;		//more than one word from 2nd word onward first letter upper case

	public String getCity() {	// id is address
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + "]";
	}

}
