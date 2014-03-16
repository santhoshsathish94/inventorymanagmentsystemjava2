package CTRL;
import BLL.Customer;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;


/**
 *
 * @author instance-pc
 */
public class CustomerCTRL {
    
    protected EntityManager em;
    
    public CustomerCTRL(EntityManager em) 
    {
       this.em = em;
    }
    
    public Customer createCustomer(String address,String country,String f_name,String l_name,String password,String phone,int postal_code,String username) 
    {
        
    Customer customer = new Customer();
    customer.setFName(f_name);
    customer.setLName(l_name);
    customer.setCountry(country);
    customer.setPostalCode(postal_code);
    customer.setAddress(address);
    customer.setPhone(phone);
    customer.setPassword(password);
    customer.setUsername(username);
    em.persist(customer);
    return customer;
    
   }
    
     public Customer findCustomer(int customer_id) 
    {
        return em.find(Customer.class, customer_id);
    }
    
    public Customer removeCustomer(int customer_id) 
    {
     Customer customer = findCustomer(customer_id);
        if (customer != null) 
        {
          em.remove(customer);
        }
        return null;
    }
    
    public Customer updateCustomer(int customer_id,String address,String country,String f_name,String l_name,String password,String phone,int postal_code,String username) 
    {
    Customer customer = em.find(Customer.class, customer_id);
    if (customer != null) 
    {
      if(address!=null) 
      {
         customer.setAddress(address);
      }
      
      else if(country!=null) 
      {
         customer.setCountry(country);
      }
       
      else if(f_name!=null) 
      {
         customer.setFName(f_name);
      }
        
      else if(l_name!=null) 
      {
         customer.setFName(l_name);
      }
      
      else if(phone!=null) 
      {
         customer.setPhone(phone);
      }
       
      else if(password!=null) 
      {
         customer.setPassword(password);
      }
       
      else if(postal_code!=0) 
      {
         customer.setPostalCode(postal_code);
      }
       
      else if(username!=null) 
      {
         customer.setUsername(username);
      }
    }
     return customer;
  }
    
    
  }
    
    

