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
 * Last Date of Modification: 12-Apr-2015 3:55:07 pm                                        
 * Comments:                                                                         
 * Version: 1.0                                                                 
 *
 */

package com.news.frugal.dao.entity;

import org.springframework.data.annotation.Id;

public class Person {
	@Id
	private String id;

	private String name;
	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}