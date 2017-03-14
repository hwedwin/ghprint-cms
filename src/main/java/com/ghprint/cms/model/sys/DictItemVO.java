package com.ghprint.cms.model.sys;

import java.io.Serializable;


public class DictItemVO implements Serializable{
    private String itemName;
    private String itemValue;


	public DictItemVO() {};

    public DictItemVO(String itemValue, String itemName) {
        this.itemValue = itemValue;
        this.itemName = itemName;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemValue() {
        return this.itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     *
     * @return a <code>String</code> representation 
     * of this object.
     */
    @Override
	public String toString()
    {
        final String TAB = "    ";
        
        String retValue = "";
        
        retValue = "DictItemVO ( "
            + super.toString() + TAB
            + "itemName = " + this.itemName + TAB
            + "itemValue = " + this.itemValue + TAB + " )";
    
        return retValue;
    }

}
