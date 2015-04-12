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
 * Last Date of Modification: 12-Apr-2015 5:00:36 pm                                        
 * Comments:                                                                         
 * Version: 1.0                                                                 
 *
 */

package com.newsfrugal.mongo.manager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class MongoBeanManager {
	private static final ApplicationContext CONTEXT;
	protected final MongoOperations mongoOperation = getMongoOperation("mongoTemplate");

	static {
		CONTEXT = new GenericXmlApplicationContext("META-INF/mongo-dao.xml");
	}

	@SuppressWarnings("unchecked")
	public <T> T getBeanBy(String beanName, Class<?> requiredType) {
		return (T) CONTEXT.getBean(beanName, requiredType);
	}

	@SuppressWarnings("unchecked")
	public <T> T getMongoOperation(String beanName) {
		return (T) CONTEXT.getBean(beanName);
	}
}