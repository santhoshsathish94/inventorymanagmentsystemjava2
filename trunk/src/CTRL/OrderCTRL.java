package CTRL;
import BLL.Orders;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class OrderCTRL {
    
    protected EntityManager em;
    
    public OrderCTRL(EntityManager em) 
    {
       this.em = em;
    }

   
    
    public Orders findOrder(int order_id) 
    {
        return em.find(Orders.class, order_id);
    }
    
    public Orders removeOrder(int order_id) 
    {
     Orders order = findOrder(order_id);
        if (order != null) 
        {
          em.remove(order);
        }
        return null;
    }
    
    public Orders updateOrderStatus(int order_id,String status) 
    {
    Orders order = em.find(Orders.class, order_id);
    if (order != null) 
    {
         order.setStatus(status);
    }
        return order;
    }
    
}
