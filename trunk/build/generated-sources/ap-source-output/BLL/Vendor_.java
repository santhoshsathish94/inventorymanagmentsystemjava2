package BLL;

import BLL.Product;
import BLL.Vendor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-09T15:45:01")
@StaticMetamodel(Vendor.class)
public class Vendor_ { 

    public static volatile SingularAttribute<Vendor, String> phone;
    public static volatile SingularAttribute<Vendor, Integer> postalCode;
    public static volatile SingularAttribute<Vendor, String> address;
    public static volatile SingularAttribute<Vendor, Vendor> vendor;
    public static volatile SingularAttribute<Vendor, String> name;
    public static volatile SingularAttribute<Vendor, String> cvr;
    public static volatile SingularAttribute<Vendor, Short> active;
    public static volatile CollectionAttribute<Vendor, Product> productCollection;
    public static volatile SingularAttribute<Vendor, Integer> vendorId;
    public static volatile SingularAttribute<Vendor, Vendor> vendor1;

}