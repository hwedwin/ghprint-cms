package com.ghprint.cms.model.order;

import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
public class OrderInit {

    private List<OrderDictionary>  company ;
    private List<OrderDictionary>  product ;
    private List<OrderDictionary>  material ;
    private List<OrderDictionary>  standard ;

    public List<OrderDictionary> getCompany() {
        return company;
    }

    public void setCompany(List<OrderDictionary> company) {
        this.company = company;
    }

    public List<OrderDictionary> getProduct() {
        return product;
    }

    public void setProduct(List<OrderDictionary> product) {
        this.product = product;
    }

    public List<OrderDictionary> getMaterial() {
        return material;
    }

    public void setMaterial(List<OrderDictionary> material) {
        this.material = material;
    }

    public List<OrderDictionary> getStandard() {
        return standard;
    }

    public void setStandard(List<OrderDictionary> standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "OrderInit{" +
                "company=" + company +
                ", product=" + product +
                ", material=" + material +
                ", standard=" + standard +
                '}';
    }
}
