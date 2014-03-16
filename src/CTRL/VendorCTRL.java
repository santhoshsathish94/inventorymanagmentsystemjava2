package CTRL;

import BLL.Vendor;
import javax.persistence.EntityManager;


public class VendorCTRL {
    
     protected EntityManager em;
     
     public VendorCTRL(EntityManager em) 
    {
       this.em = em;
    }
     
     public Vendor createVendor(String name, String cvr, String address, int postalCode, String phone, short active)
     {
        Vendor vendor = new Vendor();
        vendor.setName(name);
        vendor.setCvr(cvr);
        vendor.setAddress(address);
        vendor.setPostalCode(postalCode);
        vendor.setPhone(phone);
        vendor.setActive(active);
        em.persist(vendor);
        return vendor;
        
     }
     
     public Vendor findVendor(int vendor_id) 
    {
        return em.find(Vendor.class, vendor_id);
    }

     public Vendor updateVendor(Integer vendorId, String name, String cvr, String address, int postalCode, String phone) 
    {
    Vendor vendor = em.find(Vendor.class, vendorId);
    if (vendor != null) 
    {
      if(name!=null) 
      {
         vendor.setName(name);
      }
      
      else if(cvr!=null) 
      {
         vendor.setCvr(cvr);
      }
       
      else if(address!=null) 
      {
         vendor.setAddress(address);
      }
      
       else if(postalCode!=0) 
      {
         vendor.setPostalCode(postalCode);
      }
      
      else if(phone!=null) 
      {
         vendor.setPhone(phone);
      }
    }
    return vendor;
}
     
     public Vendor updateVendorStatus(int vendorId,short active) 
    {
    Vendor vendor = em.find(Vendor.class, vendorId);
    if (vendor != null) 
    {
         vendor.setActive(active);
    }
        return vendor;
    }
}
