//package com.sch.common.entity;
//
//import java.io.Serializable;
//import java.time.LocalDate;
//import java.util.Properties;
//
//import org.hibernate.HibernateException;
//import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.id.enhanced.SequenceStyleGenerator;
//import org.hibernate.service.ServiceRegistry;
//
//public class StudentAdmissionNumberGenerator extends SequenceStyleGenerator{
//
//	public static final String CODE_NUMBER_SEPARATOR_PARAMETER = "codeNumberSeprator";
//	public static final String CODE_NUMBER_SEPARATOR_DEFAULT = "_";
//	
//	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
//	public static final String NUMBER_FORMAT_DEFAULT = "%05";
//	
//	
//	private String format;
//	
//	@Override
//	public Serializable generate(SharedSessionContractImplementor session,
//			Object object) throws HibernateException{
//		return String.format(format, LocalDate.now(), super.generate(session, object));
//	}
//	
//	@Override
//	public void configure(Type type, Properties params,
//			ServiceRegistry serviceRegistry) throws Mapp
//}
