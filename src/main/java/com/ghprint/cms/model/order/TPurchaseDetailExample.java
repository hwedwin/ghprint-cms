package com.ghprint.cms.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TPurchaseDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPurchaseDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNull() {
            addCriterion("companyid is null");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNotNull() {
            addCriterion("companyid is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyidEqualTo(Integer value) {
            addCriterion("companyid =", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotEqualTo(Integer value) {
            addCriterion("companyid <>", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThan(Integer value) {
            addCriterion("companyid >", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("companyid >=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThan(Integer value) {
            addCriterion("companyid <", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThanOrEqualTo(Integer value) {
            addCriterion("companyid <=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIn(List<Integer> values) {
            addCriterion("companyid in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotIn(List<Integer> values) {
            addCriterion("companyid not in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidBetween(Integer value1, Integer value2) {
            addCriterion("companyid between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotBetween(Integer value1, Integer value2) {
            addCriterion("companyid not between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andProductidIsNull() {
            addCriterion("productid is null");
            return (Criteria) this;
        }

        public Criteria andProductidIsNotNull() {
            addCriterion("productid is not null");
            return (Criteria) this;
        }

        public Criteria andProductidEqualTo(Integer value) {
            addCriterion("productid =", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotEqualTo(Integer value) {
            addCriterion("productid <>", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThan(Integer value) {
            addCriterion("productid >", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThanOrEqualTo(Integer value) {
            addCriterion("productid >=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThan(Integer value) {
            addCriterion("productid <", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThanOrEqualTo(Integer value) {
            addCriterion("productid <=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidIn(List<Integer> values) {
            addCriterion("productid in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotIn(List<Integer> values) {
            addCriterion("productid not in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidBetween(Integer value1, Integer value2) {
            addCriterion("productid between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotBetween(Integer value1, Integer value2) {
            addCriterion("productid not between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andStockidIsNull() {
            addCriterion("stockid is null");
            return (Criteria) this;
        }

        public Criteria andStockidIsNotNull() {
            addCriterion("stockid is not null");
            return (Criteria) this;
        }

        public Criteria andStockidEqualTo(Integer value) {
            addCriterion("stockid =", value, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidNotEqualTo(Integer value) {
            addCriterion("stockid <>", value, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidGreaterThan(Integer value) {
            addCriterion("stockid >", value, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidGreaterThanOrEqualTo(Integer value) {
            addCriterion("stockid >=", value, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidLessThan(Integer value) {
            addCriterion("stockid <", value, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidLessThanOrEqualTo(Integer value) {
            addCriterion("stockid <=", value, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidIn(List<Integer> values) {
            addCriterion("stockid in", values, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidNotIn(List<Integer> values) {
            addCriterion("stockid not in", values, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidBetween(Integer value1, Integer value2) {
            addCriterion("stockid between", value1, value2, "stockid");
            return (Criteria) this;
        }

        public Criteria andStockidNotBetween(Integer value1, Integer value2) {
            addCriterion("stockid not between", value1, value2, "stockid");
            return (Criteria) this;
        }

        public Criteria andStandardidIsNull() {
            addCriterion("standardid is null");
            return (Criteria) this;
        }

        public Criteria andStandardidIsNotNull() {
            addCriterion("standardid is not null");
            return (Criteria) this;
        }

        public Criteria andStandardidEqualTo(Integer value) {
            addCriterion("standardid =", value, "standardid");
            return (Criteria) this;
        }

        public Criteria andStandardidNotEqualTo(Integer value) {
            addCriterion("standardid <>", value, "standardid");
            return (Criteria) this;
        }

        public Criteria andStandardidGreaterThan(Integer value) {
            addCriterion("standardid >", value, "standardid");
            return (Criteria) this;
        }

        public Criteria andStandardidGreaterThanOrEqualTo(Integer value) {
            addCriterion("standardid >=", value, "standardid");
            return (Criteria) this;
        }

        public Criteria andStandardidLessThan(Integer value) {
            addCriterion("standardid <", value, "standardid");
            return (Criteria) this;
        }

        public Criteria andStandardidLessThanOrEqualTo(Integer value) {
            addCriterion("standardid <=", value, "standardid");
            return (Criteria) this;
        }

        public Criteria andStandardidIn(List<Integer> values) {
            addCriterion("standardid in", values, "standardid");
            return (Criteria) this;
        }

        public Criteria andStandardidNotIn(List<Integer> values) {
            addCriterion("standardid not in", values, "standardid");
            return (Criteria) this;
        }

        public Criteria andStandardidBetween(Integer value1, Integer value2) {
            addCriterion("standardid between", value1, value2, "standardid");
            return (Criteria) this;
        }

        public Criteria andStandardidNotBetween(Integer value1, Integer value2) {
            addCriterion("standardid not between", value1, value2, "standardid");
            return (Criteria) this;
        }

        public Criteria andSpellcountIsNull() {
            addCriterion("spellcount is null");
            return (Criteria) this;
        }

        public Criteria andSpellcountIsNotNull() {
            addCriterion("spellcount is not null");
            return (Criteria) this;
        }

        public Criteria andSpellcountEqualTo(Integer value) {
            addCriterion("spellcount =", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountNotEqualTo(Integer value) {
            addCriterion("spellcount <>", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountGreaterThan(Integer value) {
            addCriterion("spellcount >", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("spellcount >=", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountLessThan(Integer value) {
            addCriterion("spellcount <", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountLessThanOrEqualTo(Integer value) {
            addCriterion("spellcount <=", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountIn(List<Integer> values) {
            addCriterion("spellcount in", values, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountNotIn(List<Integer> values) {
            addCriterion("spellcount not in", values, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountBetween(Integer value1, Integer value2) {
            addCriterion("spellcount between", value1, value2, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountNotBetween(Integer value1, Integer value2) {
            addCriterion("spellcount not between", value1, value2, "spellcount");
            return (Criteria) this;
        }

        public Criteria andProportionIsNull() {
            addCriterion("proportion is null");
            return (Criteria) this;
        }

        public Criteria andProportionIsNotNull() {
            addCriterion("proportion is not null");
            return (Criteria) this;
        }

        public Criteria andProportionEqualTo(Float value) {
            addCriterion("proportion =", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotEqualTo(Float value) {
            addCriterion("proportion <>", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionGreaterThan(Float value) {
            addCriterion("proportion >", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionGreaterThanOrEqualTo(Float value) {
            addCriterion("proportion >=", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLessThan(Float value) {
            addCriterion("proportion <", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLessThanOrEqualTo(Float value) {
            addCriterion("proportion <=", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionIn(List<Float> values) {
            addCriterion("proportion in", values, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotIn(List<Float> values) {
            addCriterion("proportion not in", values, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionBetween(Float value1, Float value2) {
            addCriterion("proportion between", value1, value2, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotBetween(Float value1, Float value2) {
            addCriterion("proportion not between", value1, value2, "proportion");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Float value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Float value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Float value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Float value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Float value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Float value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Float> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Float> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Float value1, Float value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Float value1, Float value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andThicknessIsNull() {
            addCriterion("thickness is null");
            return (Criteria) this;
        }

        public Criteria andThicknessIsNotNull() {
            addCriterion("thickness is not null");
            return (Criteria) this;
        }

        public Criteria andThicknessEqualTo(Float value) {
            addCriterion("thickness =", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessNotEqualTo(Float value) {
            addCriterion("thickness <>", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessGreaterThan(Float value) {
            addCriterion("thickness >", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessGreaterThanOrEqualTo(Float value) {
            addCriterion("thickness >=", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessLessThan(Float value) {
            addCriterion("thickness <", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessLessThanOrEqualTo(Float value) {
            addCriterion("thickness <=", value, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessIn(List<Float> values) {
            addCriterion("thickness in", values, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessNotIn(List<Float> values) {
            addCriterion("thickness not in", values, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessBetween(Float value1, Float value2) {
            addCriterion("thickness between", value1, value2, "thickness");
            return (Criteria) this;
        }

        public Criteria andThicknessNotBetween(Float value1, Float value2) {
            addCriterion("thickness not between", value1, value2, "thickness");
            return (Criteria) this;
        }

        public Criteria andMaterialsumIsNull() {
            addCriterion("materialsum is null");
            return (Criteria) this;
        }

        public Criteria andMaterialsumIsNotNull() {
            addCriterion("materialsum is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialsumEqualTo(Float value) {
            addCriterion("materialsum =", value, "materialsum");
            return (Criteria) this;
        }

        public Criteria andMaterialsumNotEqualTo(Float value) {
            addCriterion("materialsum <>", value, "materialsum");
            return (Criteria) this;
        }

        public Criteria andMaterialsumGreaterThan(Float value) {
            addCriterion("materialsum >", value, "materialsum");
            return (Criteria) this;
        }

        public Criteria andMaterialsumGreaterThanOrEqualTo(Float value) {
            addCriterion("materialsum >=", value, "materialsum");
            return (Criteria) this;
        }

        public Criteria andMaterialsumLessThan(Float value) {
            addCriterion("materialsum <", value, "materialsum");
            return (Criteria) this;
        }

        public Criteria andMaterialsumLessThanOrEqualTo(Float value) {
            addCriterion("materialsum <=", value, "materialsum");
            return (Criteria) this;
        }

        public Criteria andMaterialsumIn(List<Float> values) {
            addCriterion("materialsum in", values, "materialsum");
            return (Criteria) this;
        }

        public Criteria andMaterialsumNotIn(List<Float> values) {
            addCriterion("materialsum not in", values, "materialsum");
            return (Criteria) this;
        }

        public Criteria andMaterialsumBetween(Float value1, Float value2) {
            addCriterion("materialsum between", value1, value2, "materialsum");
            return (Criteria) this;
        }

        public Criteria andMaterialsumNotBetween(Float value1, Float value2) {
            addCriterion("materialsum not between", value1, value2, "materialsum");
            return (Criteria) this;
        }

        public Criteria andPurchasebuyIsNull() {
            addCriterion("purchasebuy is null");
            return (Criteria) this;
        }

        public Criteria andPurchasebuyIsNotNull() {
            addCriterion("purchasebuy is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasebuyEqualTo(Float value) {
            addCriterion("purchasebuy =", value, "purchasebuy");
            return (Criteria) this;
        }

        public Criteria andPurchasebuyNotEqualTo(Float value) {
            addCriterion("purchasebuy <>", value, "purchasebuy");
            return (Criteria) this;
        }

        public Criteria andPurchasebuyGreaterThan(Float value) {
            addCriterion("purchasebuy >", value, "purchasebuy");
            return (Criteria) this;
        }

        public Criteria andPurchasebuyGreaterThanOrEqualTo(Float value) {
            addCriterion("purchasebuy >=", value, "purchasebuy");
            return (Criteria) this;
        }

        public Criteria andPurchasebuyLessThan(Float value) {
            addCriterion("purchasebuy <", value, "purchasebuy");
            return (Criteria) this;
        }

        public Criteria andPurchasebuyLessThanOrEqualTo(Float value) {
            addCriterion("purchasebuy <=", value, "purchasebuy");
            return (Criteria) this;
        }

        public Criteria andPurchasebuyIn(List<Float> values) {
            addCriterion("purchasebuy in", values, "purchasebuy");
            return (Criteria) this;
        }

        public Criteria andPurchasebuyNotIn(List<Float> values) {
            addCriterion("purchasebuy not in", values, "purchasebuy");
            return (Criteria) this;
        }

        public Criteria andPurchasebuyBetween(Float value1, Float value2) {
            addCriterion("purchasebuy between", value1, value2, "purchasebuy");
            return (Criteria) this;
        }

        public Criteria andPurchasebuyNotBetween(Float value1, Float value2) {
            addCriterion("purchasebuy not between", value1, value2, "purchasebuy");
            return (Criteria) this;
        }

        public Criteria andOrdercountIsNull() {
            addCriterion("ordercount is null");
            return (Criteria) this;
        }

        public Criteria andOrdercountIsNotNull() {
            addCriterion("ordercount is not null");
            return (Criteria) this;
        }

        public Criteria andOrdercountEqualTo(Integer value) {
            addCriterion("ordercount =", value, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountNotEqualTo(Integer value) {
            addCriterion("ordercount <>", value, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountGreaterThan(Integer value) {
            addCriterion("ordercount >", value, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ordercount >=", value, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountLessThan(Integer value) {
            addCriterion("ordercount <", value, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountLessThanOrEqualTo(Integer value) {
            addCriterion("ordercount <=", value, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountIn(List<Integer> values) {
            addCriterion("ordercount in", values, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountNotIn(List<Integer> values) {
            addCriterion("ordercount not in", values, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountBetween(Integer value1, Integer value2) {
            addCriterion("ordercount between", value1, value2, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountNotBetween(Integer value1, Integer value2) {
            addCriterion("ordercount not between", value1, value2, "ordercount");
            return (Criteria) this;
        }

        public Criteria andStockcountIsNull() {
            addCriterion("stockcount is null");
            return (Criteria) this;
        }

        public Criteria andStockcountIsNotNull() {
            addCriterion("stockcount is not null");
            return (Criteria) this;
        }

        public Criteria andStockcountEqualTo(Integer value) {
            addCriterion("stockcount =", value, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountNotEqualTo(Integer value) {
            addCriterion("stockcount <>", value, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountGreaterThan(Integer value) {
            addCriterion("stockcount >", value, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("stockcount >=", value, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountLessThan(Integer value) {
            addCriterion("stockcount <", value, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountLessThanOrEqualTo(Integer value) {
            addCriterion("stockcount <=", value, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountIn(List<Integer> values) {
            addCriterion("stockcount in", values, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountNotIn(List<Integer> values) {
            addCriterion("stockcount not in", values, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountBetween(Integer value1, Integer value2) {
            addCriterion("stockcount between", value1, value2, "stockcount");
            return (Criteria) this;
        }

        public Criteria andStockcountNotBetween(Integer value1, Integer value2) {
            addCriterion("stockcount not between", value1, value2, "stockcount");
            return (Criteria) this;
        }

        public Criteria andProductsumIsNull() {
            addCriterion("productsum is null");
            return (Criteria) this;
        }

        public Criteria andProductsumIsNotNull() {
            addCriterion("productsum is not null");
            return (Criteria) this;
        }

        public Criteria andProductsumEqualTo(Integer value) {
            addCriterion("productsum =", value, "productsum");
            return (Criteria) this;
        }

        public Criteria andProductsumNotEqualTo(Integer value) {
            addCriterion("productsum <>", value, "productsum");
            return (Criteria) this;
        }

        public Criteria andProductsumGreaterThan(Integer value) {
            addCriterion("productsum >", value, "productsum");
            return (Criteria) this;
        }

        public Criteria andProductsumGreaterThanOrEqualTo(Integer value) {
            addCriterion("productsum >=", value, "productsum");
            return (Criteria) this;
        }

        public Criteria andProductsumLessThan(Integer value) {
            addCriterion("productsum <", value, "productsum");
            return (Criteria) this;
        }

        public Criteria andProductsumLessThanOrEqualTo(Integer value) {
            addCriterion("productsum <=", value, "productsum");
            return (Criteria) this;
        }

        public Criteria andProductsumIn(List<Integer> values) {
            addCriterion("productsum in", values, "productsum");
            return (Criteria) this;
        }

        public Criteria andProductsumNotIn(List<Integer> values) {
            addCriterion("productsum not in", values, "productsum");
            return (Criteria) this;
        }

        public Criteria andProductsumBetween(Integer value1, Integer value2) {
            addCriterion("productsum between", value1, value2, "productsum");
            return (Criteria) this;
        }

        public Criteria andProductsumNotBetween(Integer value1, Integer value2) {
            addCriterion("productsum not between", value1, value2, "productsum");
            return (Criteria) this;
        }

        public Criteria andOrderdateIsNull() {
            addCriterion("orderdate is null");
            return (Criteria) this;
        }

        public Criteria andOrderdateIsNotNull() {
            addCriterion("orderdate is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdateEqualTo(Date value) {
            addCriterionForJDBCDate("orderdate =", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("orderdate <>", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateGreaterThan(Date value) {
            addCriterionForJDBCDate("orderdate >", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("orderdate >=", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateLessThan(Date value) {
            addCriterionForJDBCDate("orderdate <", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("orderdate <=", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateIn(List<Date> values) {
            addCriterionForJDBCDate("orderdate in", values, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("orderdate not in", values, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("orderdate between", value1, value2, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("orderdate not between", value1, value2, "orderdate");
            return (Criteria) this;
        }

        public Criteria andDelineIsNull() {
            addCriterion("deline is null");
            return (Criteria) this;
        }

        public Criteria andDelineIsNotNull() {
            addCriterion("deline is not null");
            return (Criteria) this;
        }

        public Criteria andDelineEqualTo(Date value) {
            addCriterionForJDBCDate("deline =", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineNotEqualTo(Date value) {
            addCriterionForJDBCDate("deline <>", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineGreaterThan(Date value) {
            addCriterionForJDBCDate("deline >", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deline >=", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineLessThan(Date value) {
            addCriterionForJDBCDate("deline <", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deline <=", value, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineIn(List<Date> values) {
            addCriterionForJDBCDate("deline in", values, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineNotIn(List<Date> values) {
            addCriterionForJDBCDate("deline not in", values, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deline between", value1, value2, "deline");
            return (Criteria) this;
        }

        public Criteria andDelineNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deline not between", value1, value2, "deline");
            return (Criteria) this;
        }

        public Criteria andPrintIsNull() {
            addCriterion("print is null");
            return (Criteria) this;
        }

        public Criteria andPrintIsNotNull() {
            addCriterion("print is not null");
            return (Criteria) this;
        }

        public Criteria andPrintEqualTo(Integer value) {
            addCriterion("print =", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintNotEqualTo(Integer value) {
            addCriterion("print <>", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintGreaterThan(Integer value) {
            addCriterion("print >", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintGreaterThanOrEqualTo(Integer value) {
            addCriterion("print >=", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintLessThan(Integer value) {
            addCriterion("print <", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintLessThanOrEqualTo(Integer value) {
            addCriterion("print <=", value, "print");
            return (Criteria) this;
        }

        public Criteria andPrintIn(List<Integer> values) {
            addCriterion("print in", values, "print");
            return (Criteria) this;
        }

        public Criteria andPrintNotIn(List<Integer> values) {
            addCriterion("print not in", values, "print");
            return (Criteria) this;
        }

        public Criteria andPrintBetween(Integer value1, Integer value2) {
            addCriterion("print between", value1, value2, "print");
            return (Criteria) this;
        }

        public Criteria andPrintNotBetween(Integer value1, Integer value2) {
            addCriterion("print not between", value1, value2, "print");
            return (Criteria) this;
        }

        public Criteria andOpenIsNull() {
            addCriterion("open is null");
            return (Criteria) this;
        }

        public Criteria andOpenIsNotNull() {
            addCriterion("open is not null");
            return (Criteria) this;
        }

        public Criteria andOpenEqualTo(Integer value) {
            addCriterion("open =", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotEqualTo(Integer value) {
            addCriterion("open <>", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThan(Integer value) {
            addCriterion("open >", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThanOrEqualTo(Integer value) {
            addCriterion("open >=", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThan(Integer value) {
            addCriterion("open <", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThanOrEqualTo(Integer value) {
            addCriterion("open <=", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenIn(List<Integer> values) {
            addCriterion("open in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotIn(List<Integer> values) {
            addCriterion("open not in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenBetween(Integer value1, Integer value2) {
            addCriterion("open between", value1, value2, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotBetween(Integer value1, Integer value2) {
            addCriterion("open not between", value1, value2, "open");
            return (Criteria) this;
        }

        public Criteria andMergeIsNull() {
            addCriterion("merge is null");
            return (Criteria) this;
        }

        public Criteria andMergeIsNotNull() {
            addCriterion("merge is not null");
            return (Criteria) this;
        }

        public Criteria andMergeEqualTo(Integer value) {
            addCriterion("merge =", value, "merge");
            return (Criteria) this;
        }

        public Criteria andMergeNotEqualTo(Integer value) {
            addCriterion("merge <>", value, "merge");
            return (Criteria) this;
        }

        public Criteria andMergeGreaterThan(Integer value) {
            addCriterion("merge >", value, "merge");
            return (Criteria) this;
        }

        public Criteria andMergeGreaterThanOrEqualTo(Integer value) {
            addCriterion("merge >=", value, "merge");
            return (Criteria) this;
        }

        public Criteria andMergeLessThan(Integer value) {
            addCriterion("merge <", value, "merge");
            return (Criteria) this;
        }

        public Criteria andMergeLessThanOrEqualTo(Integer value) {
            addCriterion("merge <=", value, "merge");
            return (Criteria) this;
        }

        public Criteria andMergeIn(List<Integer> values) {
            addCriterion("merge in", values, "merge");
            return (Criteria) this;
        }

        public Criteria andMergeNotIn(List<Integer> values) {
            addCriterion("merge not in", values, "merge");
            return (Criteria) this;
        }

        public Criteria andMergeBetween(Integer value1, Integer value2) {
            addCriterion("merge between", value1, value2, "merge");
            return (Criteria) this;
        }

        public Criteria andMergeNotBetween(Integer value1, Integer value2) {
            addCriterion("merge not between", value1, value2, "merge");
            return (Criteria) this;
        }

        public Criteria andCutIsNull() {
            addCriterion("cut is null");
            return (Criteria) this;
        }

        public Criteria andCutIsNotNull() {
            addCriterion("cut is not null");
            return (Criteria) this;
        }

        public Criteria andCutEqualTo(Integer value) {
            addCriterion("cut =", value, "cut");
            return (Criteria) this;
        }

        public Criteria andCutNotEqualTo(Integer value) {
            addCriterion("cut <>", value, "cut");
            return (Criteria) this;
        }

        public Criteria andCutGreaterThan(Integer value) {
            addCriterion("cut >", value, "cut");
            return (Criteria) this;
        }

        public Criteria andCutGreaterThanOrEqualTo(Integer value) {
            addCriterion("cut >=", value, "cut");
            return (Criteria) this;
        }

        public Criteria andCutLessThan(Integer value) {
            addCriterion("cut <", value, "cut");
            return (Criteria) this;
        }

        public Criteria andCutLessThanOrEqualTo(Integer value) {
            addCriterion("cut <=", value, "cut");
            return (Criteria) this;
        }

        public Criteria andCutIn(List<Integer> values) {
            addCriterion("cut in", values, "cut");
            return (Criteria) this;
        }

        public Criteria andCutNotIn(List<Integer> values) {
            addCriterion("cut not in", values, "cut");
            return (Criteria) this;
        }

        public Criteria andCutBetween(Integer value1, Integer value2) {
            addCriterion("cut between", value1, value2, "cut");
            return (Criteria) this;
        }

        public Criteria andCutNotBetween(Integer value1, Integer value2) {
            addCriterion("cut not between", value1, value2, "cut");
            return (Criteria) this;
        }

        public Criteria andStableIsNull() {
            addCriterion("stable is null");
            return (Criteria) this;
        }

        public Criteria andStableIsNotNull() {
            addCriterion("stable is not null");
            return (Criteria) this;
        }

        public Criteria andStableEqualTo(Integer value) {
            addCriterion("stable =", value, "stable");
            return (Criteria) this;
        }

        public Criteria andStableNotEqualTo(Integer value) {
            addCriterion("stable <>", value, "stable");
            return (Criteria) this;
        }

        public Criteria andStableGreaterThan(Integer value) {
            addCriterion("stable >", value, "stable");
            return (Criteria) this;
        }

        public Criteria andStableGreaterThanOrEqualTo(Integer value) {
            addCriterion("stable >=", value, "stable");
            return (Criteria) this;
        }

        public Criteria andStableLessThan(Integer value) {
            addCriterion("stable <", value, "stable");
            return (Criteria) this;
        }

        public Criteria andStableLessThanOrEqualTo(Integer value) {
            addCriterion("stable <=", value, "stable");
            return (Criteria) this;
        }

        public Criteria andStableIn(List<Integer> values) {
            addCriterion("stable in", values, "stable");
            return (Criteria) this;
        }

        public Criteria andStableNotIn(List<Integer> values) {
            addCriterion("stable not in", values, "stable");
            return (Criteria) this;
        }

        public Criteria andStableBetween(Integer value1, Integer value2) {
            addCriterion("stable between", value1, value2, "stable");
            return (Criteria) this;
        }

        public Criteria andStableNotBetween(Integer value1, Integer value2) {
            addCriterion("stable not between", value1, value2, "stable");
            return (Criteria) this;
        }

        public Criteria andRepeatIsNull() {
            addCriterion("repeat is null");
            return (Criteria) this;
        }

        public Criteria andRepeatIsNotNull() {
            addCriterion("repeat is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatEqualTo(Integer value) {
            addCriterion("repeat =", value, "repeat");
            return (Criteria) this;
        }

        public Criteria andRepeatNotEqualTo(Integer value) {
            addCriterion("repeat <>", value, "repeat");
            return (Criteria) this;
        }

        public Criteria andRepeatGreaterThan(Integer value) {
            addCriterion("repeat >", value, "repeat");
            return (Criteria) this;
        }

        public Criteria andRepeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("repeat >=", value, "repeat");
            return (Criteria) this;
        }

        public Criteria andRepeatLessThan(Integer value) {
            addCriterion("repeat <", value, "repeat");
            return (Criteria) this;
        }

        public Criteria andRepeatLessThanOrEqualTo(Integer value) {
            addCriterion("repeat <=", value, "repeat");
            return (Criteria) this;
        }

        public Criteria andRepeatIn(List<Integer> values) {
            addCriterion("repeat in", values, "repeat");
            return (Criteria) this;
        }

        public Criteria andRepeatNotIn(List<Integer> values) {
            addCriterion("repeat not in", values, "repeat");
            return (Criteria) this;
        }

        public Criteria andRepeatBetween(Integer value1, Integer value2) {
            addCriterion("repeat between", value1, value2, "repeat");
            return (Criteria) this;
        }

        public Criteria andRepeatNotBetween(Integer value1, Integer value2) {
            addCriterion("repeat not between", value1, value2, "repeat");
            return (Criteria) this;
        }

        public Criteria andDeliveryIsNull() {
            addCriterion("delivery is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryIsNotNull() {
            addCriterion("delivery is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryEqualTo(String value) {
            addCriterion("delivery =", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotEqualTo(String value) {
            addCriterion("delivery <>", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryGreaterThan(String value) {
            addCriterion("delivery >", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryGreaterThanOrEqualTo(String value) {
            addCriterion("delivery >=", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryLessThan(String value) {
            addCriterion("delivery <", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryLessThanOrEqualTo(String value) {
            addCriterion("delivery <=", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryLike(String value) {
            addCriterion("delivery like", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotLike(String value) {
            addCriterion("delivery not like", value, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryIn(List<String> values) {
            addCriterion("delivery in", values, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotIn(List<String> values) {
            addCriterion("delivery not in", values, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryBetween(String value1, String value2) {
            addCriterion("delivery between", value1, value2, "delivery");
            return (Criteria) this;
        }

        public Criteria andDeliveryNotBetween(String value1, String value2) {
            addCriterion("delivery not between", value1, value2, "delivery");
            return (Criteria) this;
        }

        public Criteria andLogisticsIsNull() {
            addCriterion("logistics is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIsNotNull() {
            addCriterion("logistics is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsEqualTo(String value) {
            addCriterion("logistics =", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsNotEqualTo(String value) {
            addCriterion("logistics <>", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsGreaterThan(String value) {
            addCriterion("logistics >", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsGreaterThanOrEqualTo(String value) {
            addCriterion("logistics >=", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsLessThan(String value) {
            addCriterion("logistics <", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsLessThanOrEqualTo(String value) {
            addCriterion("logistics <=", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsLike(String value) {
            addCriterion("logistics like", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsNotLike(String value) {
            addCriterion("logistics not like", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsIn(List<String> values) {
            addCriterion("logistics in", values, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsNotIn(List<String> values) {
            addCriterion("logistics not in", values, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsBetween(String value1, String value2) {
            addCriterion("logistics between", value1, value2, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsNotBetween(String value1, String value2) {
            addCriterion("logistics not between", value1, value2, "logistics");
            return (Criteria) this;
        }

        public Criteria andExpressIsNull() {
            addCriterion("express is null");
            return (Criteria) this;
        }

        public Criteria andExpressIsNotNull() {
            addCriterion("express is not null");
            return (Criteria) this;
        }

        public Criteria andExpressEqualTo(String value) {
            addCriterion("express =", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressNotEqualTo(String value) {
            addCriterion("express <>", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressGreaterThan(String value) {
            addCriterion("express >", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressGreaterThanOrEqualTo(String value) {
            addCriterion("express >=", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressLessThan(String value) {
            addCriterion("express <", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressLessThanOrEqualTo(String value) {
            addCriterion("express <=", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressLike(String value) {
            addCriterion("express like", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressNotLike(String value) {
            addCriterion("express not like", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressIn(List<String> values) {
            addCriterion("express in", values, "express");
            return (Criteria) this;
        }

        public Criteria andExpressNotIn(List<String> values) {
            addCriterion("express not in", values, "express");
            return (Criteria) this;
        }

        public Criteria andExpressBetween(String value1, String value2) {
            addCriterion("express between", value1, value2, "express");
            return (Criteria) this;
        }

        public Criteria andExpressNotBetween(String value1, String value2) {
            addCriterion("express not between", value1, value2, "express");
            return (Criteria) this;
        }

        public Criteria andExpressnumIsNull() {
            addCriterion("expressnum is null");
            return (Criteria) this;
        }

        public Criteria andExpressnumIsNotNull() {
            addCriterion("expressnum is not null");
            return (Criteria) this;
        }

        public Criteria andExpressnumEqualTo(String value) {
            addCriterion("expressnum =", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumNotEqualTo(String value) {
            addCriterion("expressnum <>", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumGreaterThan(String value) {
            addCriterion("expressnum >", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumGreaterThanOrEqualTo(String value) {
            addCriterion("expressnum >=", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumLessThan(String value) {
            addCriterion("expressnum <", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumLessThanOrEqualTo(String value) {
            addCriterion("expressnum <=", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumLike(String value) {
            addCriterion("expressnum like", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumNotLike(String value) {
            addCriterion("expressnum not like", value, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumIn(List<String> values) {
            addCriterion("expressnum in", values, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumNotIn(List<String> values) {
            addCriterion("expressnum not in", values, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumBetween(String value1, String value2) {
            addCriterion("expressnum between", value1, value2, "expressnum");
            return (Criteria) this;
        }

        public Criteria andExpressnumNotBetween(String value1, String value2) {
            addCriterion("expressnum not between", value1, value2, "expressnum");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andInsertimeIsNull() {
            addCriterion("insertime is null");
            return (Criteria) this;
        }

        public Criteria andInsertimeIsNotNull() {
            addCriterion("insertime is not null");
            return (Criteria) this;
        }

        public Criteria andInsertimeEqualTo(Date value) {
            addCriterionForJDBCDate("insertime =", value, "insertime");
            return (Criteria) this;
        }

        public Criteria andInsertimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("insertime <>", value, "insertime");
            return (Criteria) this;
        }

        public Criteria andInsertimeGreaterThan(Date value) {
            addCriterionForJDBCDate("insertime >", value, "insertime");
            return (Criteria) this;
        }

        public Criteria andInsertimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insertime >=", value, "insertime");
            return (Criteria) this;
        }

        public Criteria andInsertimeLessThan(Date value) {
            addCriterionForJDBCDate("insertime <", value, "insertime");
            return (Criteria) this;
        }

        public Criteria andInsertimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insertime <=", value, "insertime");
            return (Criteria) this;
        }

        public Criteria andInsertimeIn(List<Date> values) {
            addCriterionForJDBCDate("insertime in", values, "insertime");
            return (Criteria) this;
        }

        public Criteria andInsertimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("insertime not in", values, "insertime");
            return (Criteria) this;
        }

        public Criteria andInsertimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insertime between", value1, value2, "insertime");
            return (Criteria) this;
        }

        public Criteria andInsertimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insertime not between", value1, value2, "insertime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}