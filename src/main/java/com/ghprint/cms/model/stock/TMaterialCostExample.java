package com.ghprint.cms.model.stock;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TMaterialCostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMaterialCostExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(Float value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(Float value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(Float value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(Float value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(Float value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(Float value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<Float> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<Float> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(Float value1, Float value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(Float value1, Float value2) {
            addCriterion("income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andOutcountIsNull() {
            addCriterion("outcount is null");
            return (Criteria) this;
        }

        public Criteria andOutcountIsNotNull() {
            addCriterion("outcount is not null");
            return (Criteria) this;
        }

        public Criteria andOutcountEqualTo(Float value) {
            addCriterion("outcount =", value, "outcount");
            return (Criteria) this;
        }

        public Criteria andOutcountNotEqualTo(Float value) {
            addCriterion("outcount <>", value, "outcount");
            return (Criteria) this;
        }

        public Criteria andOutcountGreaterThan(Float value) {
            addCriterion("outcount >", value, "outcount");
            return (Criteria) this;
        }

        public Criteria andOutcountGreaterThanOrEqualTo(Float value) {
            addCriterion("outcount >=", value, "outcount");
            return (Criteria) this;
        }

        public Criteria andOutcountLessThan(Float value) {
            addCriterion("outcount <", value, "outcount");
            return (Criteria) this;
        }

        public Criteria andOutcountLessThanOrEqualTo(Float value) {
            addCriterion("outcount <=", value, "outcount");
            return (Criteria) this;
        }

        public Criteria andOutcountIn(List<Float> values) {
            addCriterion("outcount in", values, "outcount");
            return (Criteria) this;
        }

        public Criteria andOutcountNotIn(List<Float> values) {
            addCriterion("outcount not in", values, "outcount");
            return (Criteria) this;
        }

        public Criteria andOutcountBetween(Float value1, Float value2) {
            addCriterion("outcount between", value1, value2, "outcount");
            return (Criteria) this;
        }

        public Criteria andOutcountNotBetween(Float value1, Float value2) {
            addCriterion("outcount not between", value1, value2, "outcount");
            return (Criteria) this;
        }

        public Criteria andSumcountIsNull() {
            addCriterion("sumcount is null");
            return (Criteria) this;
        }

        public Criteria andSumcountIsNotNull() {
            addCriterion("sumcount is not null");
            return (Criteria) this;
        }

        public Criteria andSumcountEqualTo(Float value) {
            addCriterion("sumcount =", value, "sumcount");
            return (Criteria) this;
        }

        public Criteria andSumcountNotEqualTo(Float value) {
            addCriterion("sumcount <>", value, "sumcount");
            return (Criteria) this;
        }

        public Criteria andSumcountGreaterThan(Float value) {
            addCriterion("sumcount >", value, "sumcount");
            return (Criteria) this;
        }

        public Criteria andSumcountGreaterThanOrEqualTo(Float value) {
            addCriterion("sumcount >=", value, "sumcount");
            return (Criteria) this;
        }

        public Criteria andSumcountLessThan(Float value) {
            addCriterion("sumcount <", value, "sumcount");
            return (Criteria) this;
        }

        public Criteria andSumcountLessThanOrEqualTo(Float value) {
            addCriterion("sumcount <=", value, "sumcount");
            return (Criteria) this;
        }

        public Criteria andSumcountIn(List<Float> values) {
            addCriterion("sumcount in", values, "sumcount");
            return (Criteria) this;
        }

        public Criteria andSumcountNotIn(List<Float> values) {
            addCriterion("sumcount not in", values, "sumcount");
            return (Criteria) this;
        }

        public Criteria andSumcountBetween(Float value1, Float value2) {
            addCriterion("sumcount between", value1, value2, "sumcount");
            return (Criteria) this;
        }

        public Criteria andSumcountNotBetween(Float value1, Float value2) {
            addCriterion("sumcount not between", value1, value2, "sumcount");
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