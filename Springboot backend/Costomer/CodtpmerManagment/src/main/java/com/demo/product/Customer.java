package com.demo.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CoustomerManagement")
public class Customer {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int CoustomerId;
		@Column(name = "First_Name")
		private String Fname;
		@Column(name = "Last_Name")
		private String LName;
		private String Street;
		private String Address;
		private String state;
		private String city;
		private String email;
		private String phone;
		public int getCoustomerId() {
			return CoustomerId;
		}
		public void setCoustomerId(int coustomerId) {
			CoustomerId = coustomerId;
		}
		public String getFname() {
			return Fname;
		}
		public void setFname(String fname) {
			Fname = fname;
		}
		public String getLName() {
			return LName;
		}
		public void setLName(String lName) {
			LName = lName;
		}
		public String getStreet() {
			return Street;
		}
		public void setStreet(String street) {
			Street = street;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		@Override
		public String toString() {
			return "Coustomer [CoustomerId=" + CoustomerId + ", Fname=" + Fname + ", LName=" + LName + ", Street=" + Street
					+ ", Address=" + Address + ", state=" + state + ", city=" + city + ", email=" + email + ", phone="
					+ phone + "]";
		}
	
}

