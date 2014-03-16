package CTRL;

import BLL.Product;
import BLL.Vendor;
import java.math.BigDecimal;
import javax.persistence.EntityManager;

/**
 *
 * @author instance-pc
 */
public class ProductCTRL {
    
    protected EntityManager em;
    
    public ProductCTRL(EntityManager em) 
    {
       this.em = em;
    }

    public Product createProduct(String category, String name, int productIntNo, String country, int quantity, String weight, BigDecimal price,String size1,Vendor vendorId)
     {
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setProductIntNo(productIntNo);
        product.setCountry(country);
        product.setVendorId(vendorId);
        product.setQuantity(quantity);
        product.setWeight(weight);
        product.setPrice(price);
        product.setSize1(size1);
        em.persist(product);
        return product;
        
     }
    
    public Product findProduct(int product_id) 
    {
        return em.find(Product.class, product_id);
    }
    
    public Product removeCustomer(int product_id) 
    {
     Product product = findProduct(product_id);
        if (product != null) 
        {
          em.remove(product);
        }
        return null;
    }
    
     public Product updateProduct(int product_id, String category, String name, String country, int quantity, String weight, BigDecimal price,String size1,Vendor vendorId) 
    {
    Product product = em.find(Product.class, product_id);
    if (product != null) 
    {
      if(name!=null) 
      {
         product.setName(name);
      }
      
      else if(category!=null) 
      {
         product.setCategory(category);
      }
      
      else if(country!=null) 
      {
         product.setCountry(country);
      }
      
      else if(quantity!=0) 
      {
         product.setQuantity(quantity);
      }
      
      else if(weight!=null) 
      {
         product.setWeight(weight);
      }
      
      else if(price!=null) 
      {
         product.setPrice(price);
      }
      
      else if(size1!=null) 
      {
         product.setSize1(size1);
      }
      
      else if(vendorId!=null)
      {
         product.setVendorId(vendorId);
      }
      
    }
      return product;
      
    }
    
    
    
}
