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
 * Last Date of Modification: 12-Apr-2015 3:49:15 pm                                        
 * Comments:                                                                         
 * Version: 1.0                                                                 
 *
 */

package com.news.frugal.dao;

import com.news.frugal.dao.entity.News;

public interface NewsDAO {
	public void insert(News news);
}