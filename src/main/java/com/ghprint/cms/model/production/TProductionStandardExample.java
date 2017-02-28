package com.ghprint.cms.model.production;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TProductionStandardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TProductionStandardExample() {
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

        public Criteria andCodeidIsNull() {
            addCriterion("codeid is null");
            return (Criteria) this;
        }

        public Criteria andCodeidIsNotNull() {
            addCriterion("codeid is not null");
            return (Criteria) this;
        }

        public Criteria andCodeidEqualTo(String value) {
            addCriterion("codeid =", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidNotEqualTo(String value) {
            addCriterion("codeid <>", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidGreaterThan(String value) {
            addCriterion("codeid >", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidGreaterThanOrEqualTo(String value) {
            addCriterion("codeid >=", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidLessThan(String value) {
            addCriterion("codeid <", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidLessThanOrEqualTo(String value) {
            addCriterion("codeid <=", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidLike(String value) {
            addCriterion("codeid like", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidNotLike(String value) {
            addCriterion("codeid not like", value, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidIn(List<String> values) {
            addCriterion("codeid in", values, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidNotIn(List<String> values) {
            addCriterion("codeid not in", values, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidBetween(String value1, String value2) {
            addCriterion("codeid between", value1, value2, "codeid");
            return (Criteria) this;
        }

        public Criteria andCodeidNotBetween(String value1, String value2) {
            addCriterion("codeid not between", value1, value2, "codeid");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeIsNull() {
            addCriterion("printingmode is null");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeIsNotNull() {
            addCriterion("printingmode is not null");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeEqualTo(String value) {
            addCriterion("printingmode =", value, "printingmode");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeNotEqualTo(String value) {
            addCriterion("printingmode <>", value, "printingmode");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeGreaterThan(String value) {
            addCriterion("printingmode >", value, "printingmode");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeGreaterThanOrEqualTo(String value) {
            addCriterion("printingmode >=", value, "printingmode");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeLessThan(String value) {
            addCriterion("printingmode <", value, "printingmode");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeLessThanOrEqualTo(String value) {
            addCriterion("printingmode <=", value, "printingmode");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeLike(String value) {
            addCriterion("printingmode like", value, "printingmode");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeNotLike(String value) {
            addCriterion("printingmode not like", value, "printingmode");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeIn(List<String> values) {
            addCriterion("printingmode in", values, "printingmode");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeNotIn(List<String> values) {
            addCriterion("printingmode not in", values, "printingmode");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeBetween(String value1, String value2) {
            addCriterion("printingmode between", value1, value2, "printingmode");
            return (Criteria) this;
        }

        public Criteria andPrintingmodeNotBetween(String value1, String value2) {
            addCriterion("printingmode not between", value1, value2, "printingmode");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNull() {
            addCriterion("material is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNotNull() {
            addCriterion("material is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialEqualTo(String value) {
            addCriterion("material =", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotEqualTo(String value) {
            addCriterion("material <>", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThan(String value) {
            addCriterion("material >", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("material >=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThan(String value) {
            addCriterion("material <", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThanOrEqualTo(String value) {
            addCriterion("material <=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLike(String value) {
            addCriterion("material like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotLike(String value) {
            addCriterion("material not like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIn(List<String> values) {
            addCriterion("material in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotIn(List<String> values) {
            addCriterion("material not in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialBetween(String value1, String value2) {
            addCriterion("material between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotBetween(String value1, String value2) {
            addCriterion("material not between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andCrosswiseshrinkIsNull() {
            addCriterion("crosswiseshrink is null");
            return (Criteria) this;
        }

        public Criteria andCrosswiseshrinkIsNotNull() {
            addCriterion("crosswiseshrink is not null");
            return (Criteria) this;
        }

        public Criteria andCrosswiseshrinkEqualTo(Integer value) {
            addCriterion("crosswiseshrink =", value, "crosswiseshrink");
            return (Criteria) this;
        }

        public Criteria andCrosswiseshrinkNotEqualTo(Integer value) {
            addCriterion("crosswiseshrink <>", value, "crosswiseshrink");
            return (Criteria) this;
        }

        public Criteria andCrosswiseshrinkGreaterThan(Integer value) {
            addCriterion("crosswiseshrink >", value, "crosswiseshrink");
            return (Criteria) this;
        }

        public Criteria andCrosswiseshrinkGreaterThanOrEqualTo(Integer value) {
            addCriterion("crosswiseshrink >=", value, "crosswiseshrink");
            return (Criteria) this;
        }

        public Criteria andCrosswiseshrinkLessThan(Integer value) {
            addCriterion("crosswiseshrink <", value, "crosswiseshrink");
            return (Criteria) this;
        }

        public Criteria andCrosswiseshrinkLessThanOrEqualTo(Integer value) {
            addCriterion("crosswiseshrink <=", value, "crosswiseshrink");
            return (Criteria) this;
        }

        public Criteria andCrosswiseshrinkIn(List<Integer> values) {
            addCriterion("crosswiseshrink in", values, "crosswiseshrink");
            return (Criteria) this;
        }

        public Criteria andCrosswiseshrinkNotIn(List<Integer> values) {
            addCriterion("crosswiseshrink not in", values, "crosswiseshrink");
            return (Criteria) this;
        }

        public Criteria andCrosswiseshrinkBetween(Integer value1, Integer value2) {
            addCriterion("crosswiseshrink between", value1, value2, "crosswiseshrink");
            return (Criteria) this;
        }

        public Criteria andCrosswiseshrinkNotBetween(Integer value1, Integer value2) {
            addCriterion("crosswiseshrink not between", value1, value2, "crosswiseshrink");
            return (Criteria) this;
        }

        public Criteria andPortraitshrinkIsNull() {
            addCriterion("portraitshrink is null");
            return (Criteria) this;
        }

        public Criteria andPortraitshrinkIsNotNull() {
            addCriterion("portraitshrink is not null");
            return (Criteria) this;
        }

        public Criteria andPortraitshrinkEqualTo(Integer value) {
            addCriterion("portraitshrink =", value, "portraitshrink");
            return (Criteria) this;
        }

        public Criteria andPortraitshrinkNotEqualTo(Integer value) {
            addCriterion("portraitshrink <>", value, "portraitshrink");
            return (Criteria) this;
        }

        public Criteria andPortraitshrinkGreaterThan(Integer value) {
            addCriterion("portraitshrink >", value, "portraitshrink");
            return (Criteria) this;
        }

        public Criteria andPortraitshrinkGreaterThanOrEqualTo(Integer value) {
            addCriterion("portraitshrink >=", value, "portraitshrink");
            return (Criteria) this;
        }

        public Criteria andPortraitshrinkLessThan(Integer value) {
            addCriterion("portraitshrink <", value, "portraitshrink");
            return (Criteria) this;
        }

        public Criteria andPortraitshrinkLessThanOrEqualTo(Integer value) {
            addCriterion("portraitshrink <=", value, "portraitshrink");
            return (Criteria) this;
        }

        public Criteria andPortraitshrinkIn(List<Integer> values) {
            addCriterion("portraitshrink in", values, "portraitshrink");
            return (Criteria) this;
        }

        public Criteria andPortraitshrinkNotIn(List<Integer> values) {
            addCriterion("portraitshrink not in", values, "portraitshrink");
            return (Criteria) this;
        }

        public Criteria andPortraitshrinkBetween(Integer value1, Integer value2) {
            addCriterion("portraitshrink between", value1, value2, "portraitshrink");
            return (Criteria) this;
        }

        public Criteria andPortraitshrinkNotBetween(Integer value1, Integer value2) {
            addCriterion("portraitshrink not between", value1, value2, "portraitshrink");
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

        public Criteria andPrintdataidIsNull() {
            addCriterion("printdataid is null");
            return (Criteria) this;
        }

        public Criteria andPrintdataidIsNotNull() {
            addCriterion("printdataid is not null");
            return (Criteria) this;
        }

        public Criteria andPrintdataidEqualTo(Integer value) {
            addCriterion("printdataid =", value, "printdataid");
            return (Criteria) this;
        }

        public Criteria andPrintdataidNotEqualTo(Integer value) {
            addCriterion("printdataid <>", value, "printdataid");
            return (Criteria) this;
        }

        public Criteria andPrintdataidGreaterThan(Integer value) {
            addCriterion("printdataid >", value, "printdataid");
            return (Criteria) this;
        }

        public Criteria andPrintdataidGreaterThanOrEqualTo(Integer value) {
            addCriterion("printdataid >=", value, "printdataid");
            return (Criteria) this;
        }

        public Criteria andPrintdataidLessThan(Integer value) {
            addCriterion("printdataid <", value, "printdataid");
            return (Criteria) this;
        }

        public Criteria andPrintdataidLessThanOrEqualTo(Integer value) {
            addCriterion("printdataid <=", value, "printdataid");
            return (Criteria) this;
        }

        public Criteria andPrintdataidIn(List<Integer> values) {
            addCriterion("printdataid in", values, "printdataid");
            return (Criteria) this;
        }

        public Criteria andPrintdataidNotIn(List<Integer> values) {
            addCriterion("printdataid not in", values, "printdataid");
            return (Criteria) this;
        }

        public Criteria andPrintdataidBetween(Integer value1, Integer value2) {
            addCriterion("printdataid between", value1, value2, "printdataid");
            return (Criteria) this;
        }

        public Criteria andPrintdataidNotBetween(Integer value1, Integer value2) {
            addCriterion("printdataid not between", value1, value2, "printdataid");
            return (Criteria) this;
        }

        public Criteria andProcedureidIsNull() {
            addCriterion("procedureid is null");
            return (Criteria) this;
        }

        public Criteria andProcedureidIsNotNull() {
            addCriterion("procedureid is not null");
            return (Criteria) this;
        }

        public Criteria andProcedureidEqualTo(Integer value) {
            addCriterion("procedureid =", value, "procedureid");
            return (Criteria) this;
        }

        public Criteria andProcedureidNotEqualTo(Integer value) {
            addCriterion("procedureid <>", value, "procedureid");
            return (Criteria) this;
        }

        public Criteria andProcedureidGreaterThan(Integer value) {
            addCriterion("procedureid >", value, "procedureid");
            return (Criteria) this;
        }

        public Criteria andProcedureidGreaterThanOrEqualTo(Integer value) {
            addCriterion("procedureid >=", value, "procedureid");
            return (Criteria) this;
        }

        public Criteria andProcedureidLessThan(Integer value) {
            addCriterion("procedureid <", value, "procedureid");
            return (Criteria) this;
        }

        public Criteria andProcedureidLessThanOrEqualTo(Integer value) {
            addCriterion("procedureid <=", value, "procedureid");
            return (Criteria) this;
        }

        public Criteria andProcedureidIn(List<Integer> values) {
            addCriterion("procedureid in", values, "procedureid");
            return (Criteria) this;
        }

        public Criteria andProcedureidNotIn(List<Integer> values) {
            addCriterion("procedureid not in", values, "procedureid");
            return (Criteria) this;
        }

        public Criteria andProcedureidBetween(Integer value1, Integer value2) {
            addCriterion("procedureid between", value1, value2, "procedureid");
            return (Criteria) this;
        }

        public Criteria andProcedureidNotBetween(Integer value1, Integer value2) {
            addCriterion("procedureid not between", value1, value2, "procedureid");
            return (Criteria) this;
        }

        public Criteria andProcedureafteridIsNull() {
            addCriterion("procedureafterid is null");
            return (Criteria) this;
        }

        public Criteria andProcedureafteridIsNotNull() {
            addCriterion("procedureafterid is not null");
            return (Criteria) this;
        }

        public Criteria andProcedureafteridEqualTo(Integer value) {
            addCriterion("procedureafterid =", value, "procedureafterid");
            return (Criteria) this;
        }

        public Criteria andProcedureafteridNotEqualTo(Integer value) {
            addCriterion("procedureafterid <>", value, "procedureafterid");
            return (Criteria) this;
        }

        public Criteria andProcedureafteridGreaterThan(Integer value) {
            addCriterion("procedureafterid >", value, "procedureafterid");
            return (Criteria) this;
        }

        public Criteria andProcedureafteridGreaterThanOrEqualTo(Integer value) {
            addCriterion("procedureafterid >=", value, "procedureafterid");
            return (Criteria) this;
        }

        public Criteria andProcedureafteridLessThan(Integer value) {
            addCriterion("procedureafterid <", value, "procedureafterid");
            return (Criteria) this;
        }

        public Criteria andProcedureafteridLessThanOrEqualTo(Integer value) {
            addCriterion("procedureafterid <=", value, "procedureafterid");
            return (Criteria) this;
        }

        public Criteria andProcedureafteridIn(List<Integer> values) {
            addCriterion("procedureafterid in", values, "procedureafterid");
            return (Criteria) this;
        }

        public Criteria andProcedureafteridNotIn(List<Integer> values) {
            addCriterion("procedureafterid not in", values, "procedureafterid");
            return (Criteria) this;
        }

        public Criteria andProcedureafteridBetween(Integer value1, Integer value2) {
            addCriterion("procedureafterid between", value1, value2, "procedureafterid");
            return (Criteria) this;
        }

        public Criteria andProcedureafteridNotBetween(Integer value1, Integer value2) {
            addCriterion("procedureafterid not between", value1, value2, "procedureafterid");
            return (Criteria) this;
        }

        public Criteria andPackagingIsNull() {
            addCriterion("packaging is null");
            return (Criteria) this;
        }

        public Criteria andPackagingIsNotNull() {
            addCriterion("packaging is not null");
            return (Criteria) this;
        }

        public Criteria andPackagingEqualTo(Integer value) {
            addCriterion("packaging =", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingNotEqualTo(Integer value) {
            addCriterion("packaging <>", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingGreaterThan(Integer value) {
            addCriterion("packaging >", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingGreaterThanOrEqualTo(Integer value) {
            addCriterion("packaging >=", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingLessThan(Integer value) {
            addCriterion("packaging <", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingLessThanOrEqualTo(Integer value) {
            addCriterion("packaging <=", value, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingIn(List<Integer> values) {
            addCriterion("packaging in", values, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingNotIn(List<Integer> values) {
            addCriterion("packaging not in", values, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingBetween(Integer value1, Integer value2) {
            addCriterion("packaging between", value1, value2, "packaging");
            return (Criteria) this;
        }

        public Criteria andPackagingNotBetween(Integer value1, Integer value2) {
            addCriterion("packaging not between", value1, value2, "packaging");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateauthorIsNull() {
            addCriterion("createauthor is null");
            return (Criteria) this;
        }

        public Criteria andCreateauthorIsNotNull() {
            addCriterion("createauthor is not null");
            return (Criteria) this;
        }

        public Criteria andCreateauthorEqualTo(String value) {
            addCriterion("createauthor =", value, "createauthor");
            return (Criteria) this;
        }

        public Criteria andCreateauthorNotEqualTo(String value) {
            addCriterion("createauthor <>", value, "createauthor");
            return (Criteria) this;
        }

        public Criteria andCreateauthorGreaterThan(String value) {
            addCriterion("createauthor >", value, "createauthor");
            return (Criteria) this;
        }

        public Criteria andCreateauthorGreaterThanOrEqualTo(String value) {
            addCriterion("createauthor >=", value, "createauthor");
            return (Criteria) this;
        }

        public Criteria andCreateauthorLessThan(String value) {
            addCriterion("createauthor <", value, "createauthor");
            return (Criteria) this;
        }

        public Criteria andCreateauthorLessThanOrEqualTo(String value) {
            addCriterion("createauthor <=", value, "createauthor");
            return (Criteria) this;
        }

        public Criteria andCreateauthorLike(String value) {
            addCriterion("createauthor like", value, "createauthor");
            return (Criteria) this;
        }

        public Criteria andCreateauthorNotLike(String value) {
            addCriterion("createauthor not like", value, "createauthor");
            return (Criteria) this;
        }

        public Criteria andCreateauthorIn(List<String> values) {
            addCriterion("createauthor in", values, "createauthor");
            return (Criteria) this;
        }

        public Criteria andCreateauthorNotIn(List<String> values) {
            addCriterion("createauthor not in", values, "createauthor");
            return (Criteria) this;
        }

        public Criteria andCreateauthorBetween(String value1, String value2) {
            addCriterion("createauthor between", value1, value2, "createauthor");
            return (Criteria) this;
        }

        public Criteria andCreateauthorNotBetween(String value1, String value2) {
            addCriterion("createauthor not between", value1, value2, "createauthor");
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