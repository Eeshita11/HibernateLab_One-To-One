package com.examplelab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="passport")
public class Passport 
{
        @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="passport_id")
		private int id;
		
		@Column(name="passport_address")
		private String address;
		
		@OneToOne
		@JoinColumn(name="person_id")
		private Person person;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Person getPerson() {
			return person;
		}

		public void setPerson(Person person) {
			this.person = person;
		}

		public Passport(int id, String address, Person person) {
			super();
			this.id = id;
			this.address = address;
			this.person = person;
		}

		public Passport() {
			super();
			// TODO Auto-generated constructor stub
		}
	}


