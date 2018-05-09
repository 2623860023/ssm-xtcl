package com.jk.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class DataSourceAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice{

	// service方法执行之前被调用  
    public void before(Method method, Object[] args, Object target) throws Throwable {  
        System.out.println("切入点: " + target.getClass().getName() + "类中" + method.getName() + "方法");  
        if(method.getName().startsWith("add")   
            || method.getName().startsWith("create")  
            || method.getName().startsWith("save")  
            || method.getName().startsWith("edit")  
            || method.getName().startsWith("update")  
            || method.getName().startsWith("delete")  
            || method.getName().startsWith("remove")){  
            System.out.println("切换到: master");  
            DataSourceSwitcher.setMaster();  
        }  
        else  {  
        	
        	 if(method.getName().startsWith("userQuery")  
        	           ){  
        	            System.out.println("切换到: slave");  
        	            DataSourceSwitcher.setSlaveall("slave");   
        	        } 
        	 
        	 
        	 if( method.getName().startsWith("find2")  
     	            ){  
     	            System.out.println("切换到: slave");  
     	           DataSourceSwitcher.setSlaveall("IP衣服:181283132");  
     	     }
        	 DataSourceSwitcher.setSlaveall("slave");  
        }  
    }  
  
    // service方法执行完之后被调用  
    public void afterReturning(Object arg0, Method method, Object[] args, Object target) throws Throwable {  
    }  
  
    // 抛出Exception之后被调用  
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {  
        DataSourceSwitcher.setSlave();  
        System.out.println("出现异常,切换到: slave");  
    }  

}
