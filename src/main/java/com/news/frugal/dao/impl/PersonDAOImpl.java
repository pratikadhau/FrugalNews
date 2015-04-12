/*
 * Copyright (C) Airpush India Pvt  Ltd. - All Rights Reserved                       
 *                                                                                   
 * NOTICE:  All information contained herein is, and remains                         
 * the property of Airpush India Pvt  Ltd. Incorporated and its suppliers,           
 * if any.  The intellectual and technical concepts contained                        
 * herein are proprietary to Airpush India Pvt  Ltd.                                 
 * and its suppliers and may be covered by India, U.S. and Foreign Patents,          
 * patents in process, and are protected by trade secret or copyright law.           
 * Dissemination of this information or reproduction of this material                
 * is strictly forbidden unless prior written permission is obtained                 
 * from Airpush India Pvt  Ltd. Unauthorized copying of this file, via any medium    
 * is strictly prohibited                                                            
 * Author: tushar                                                                   
 * Date: 12-Apr-2015                                                                     
 * Last Date of Modification: 12-Apr-2015 4:01:15 pm                                        
 * Comments:                                                                         
 * Version: 1.0                                                                 
 *
 */

package com.news.frugal.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.WriteResult;
import com.news.frugal.dao.PersonDAO;
import com.news.frugal.dao.entity.Person;
import com.newsfrugal.mongo.manager.MongoBeanManager;

public class PersonDAOImpl extends MongoBeanManager implements PersonDAO {

	@Override
	public void create(Person person) {
		mongoOperation.insert(person);
	}

	@Override
	public Person findBy(String personId) {
		Query query = new Query(Criteria.where("_id").is(personId));
		return mongoOperation.findOne(query, Person.class);
	}

	@Override
	public void update(Person person) {
		mongoOperation.save(person);
	}

	@Override
	public Integer deleteBy(String personId) {
		Query query = new Query(Criteria.where("_id").is(personId));
		WriteResult result = mongoOperation.remove(query, Person.class);

		return result.getN();
	}

	public static void main(String[] args) {
		PersonDAO personDAO = new PersonDAOImpl();
		Person person = new Person();
		person.setId("113");
		person.setName("PankajKr");
		person.setAddress("Bangalore, India");

		// Insert
		personDAO.create(person);
		System.out.println("Generated ID=" + person.getId());

		// Get
		Person p1 = personDAO.findBy(person.getId());
		System.out.println("Retrieved Person=" + p1);

		// Update
		p1.setName("David");
		p1.setAddress("SFO, USA");

		personDAO.update(p1);
		Person temp = personDAO.findBy(p1.getId());
		System.out.println("Retrieved Person after update=" + temp);

		// Delete
		Integer count = personDAO.deleteBy(p1.getId());
		System.out.println("Number of records deleted=" + count);
	}
}