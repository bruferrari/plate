package com.plate.main;

import com.plate.util.hibernate.HibernateUtil;

public class GeraTabela {
		
			
			public static void main(String[] args){
				HibernateUtil.getSessionFactory(); 
				HibernateUtil.getSessionFactory().close(); 
			}
}
