package com.ghprint.cms.model.order;

/**
 * Created by Administrator on 2017/4/8.
 */
public class OrderDictionary {
    private  Integer id;
    private  String note1;
    private  String note2;
    private  String note3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public String getNote2() {
        return note2;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

    public String getNote3() {
        return note3;
    }

    public void setNote3(String note3) {
        this.note3 = note3;
    }

    @Override
    public String toString() {
        return "OrderDictionary{" +
                "id=" + id +
                ", note1='" + note1 + '\'' +
                ", note2='" + note2 + '\'' +
                ", note3='" + note3 + '\'' +
                '}';
    }
}
