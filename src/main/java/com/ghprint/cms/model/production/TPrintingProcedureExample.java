package com.ghprint.cms.model.production;

import java.util.ArrayList;
import java.util.List;

public class TPrintingProcedureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPrintingProcedureExample() {
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

        public Criteria andPrintdirectIsNull() {
            addCriterion("printdirect is null");
            return (Criteria) this;
        }

        public Criteria andPrintdirectIsNotNull() {
            addCriterion("printdirect is not null");
            return (Criteria) this;
        }

        public Criteria andPrintdirectEqualTo(String value) {
            addCriterion("printdirect =", value, "printdirect");
            return (Criteria) this;
        }

        public Criteria andPrintdirectNotEqualTo(String value) {
            addCriterion("printdirect <>", value, "printdirect");
            return (Criteria) this;
        }

        public Criteria andPrintdirectGreaterThan(String value) {
            addCriterion("printdirect >", value, "printdirect");
            return (Criteria) this;
        }

        public Criteria andPrintdirectGreaterThanOrEqualTo(String value) {
            addCriterion("printdirect >=", value, "printdirect");
            return (Criteria) this;
        }

        public Criteria andPrintdirectLessThan(String value) {
            addCriterion("printdirect <", value, "printdirect");
            return (Criteria) this;
        }

        public Criteria andPrintdirectLessThanOrEqualTo(String value) {
            addCriterion("printdirect <=", value, "printdirect");
            return (Criteria) this;
        }

        public Criteria andPrintdirectLike(String value) {
            addCriterion("printdirect like", value, "printdirect");
            return (Criteria) this;
        }

        public Criteria andPrintdirectNotLike(String value) {
            addCriterion("printdirect not like", value, "printdirect");
            return (Criteria) this;
        }

        public Criteria andPrintdirectIn(List<String> values) {
            addCriterion("printdirect in", values, "printdirect");
            return (Criteria) this;
        }

        public Criteria andPrintdirectNotIn(List<String> values) {
            addCriterion("printdirect not in", values, "printdirect");
            return (Criteria) this;
        }

        public Criteria andPrintdirectBetween(String value1, String value2) {
            addCriterion("printdirect between", value1, value2, "printdirect");
            return (Criteria) this;
        }

        public Criteria andPrintdirectNotBetween(String value1, String value2) {
            addCriterion("printdirect not between", value1, value2, "printdirect");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNull() {
            addCriterion("specification is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNotNull() {
            addCriterion("specification is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationEqualTo(String value) {
            addCriterion("specification =", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotEqualTo(String value) {
            addCriterion("specification <>", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThan(String value) {
            addCriterion("specification >", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("specification >=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThan(String value) {
            addCriterion("specification <", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThanOrEqualTo(String value) {
            addCriterion("specification <=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLike(String value) {
            addCriterion("specification like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotLike(String value) {
            addCriterion("specification not like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationIn(List<String> values) {
            addCriterion("specification in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotIn(List<String> values) {
            addCriterion("specification not in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationBetween(String value1, String value2) {
            addCriterion("specification between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotBetween(String value1, String value2) {
            addCriterion("specification not between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andPrintamountIsNull() {
            addCriterion("printamount is null");
            return (Criteria) this;
        }

        public Criteria andPrintamountIsNotNull() {
            addCriterion("printamount is not null");
            return (Criteria) this;
        }

        public Criteria andPrintamountEqualTo(Integer value) {
            addCriterion("printamount =", value, "printamount");
            return (Criteria) this;
        }

        public Criteria andPrintamountNotEqualTo(Integer value) {
            addCriterion("printamount <>", value, "printamount");
            return (Criteria) this;
        }

        public Criteria andPrintamountGreaterThan(Integer value) {
            addCriterion("printamount >", value, "printamount");
            return (Criteria) this;
        }

        public Criteria andPrintamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("printamount >=", value, "printamount");
            return (Criteria) this;
        }

        public Criteria andPrintamountLessThan(Integer value) {
            addCriterion("printamount <", value, "printamount");
            return (Criteria) this;
        }

        public Criteria andPrintamountLessThanOrEqualTo(Integer value) {
            addCriterion("printamount <=", value, "printamount");
            return (Criteria) this;
        }

        public Criteria andPrintamountIn(List<Integer> values) {
            addCriterion("printamount in", values, "printamount");
            return (Criteria) this;
        }

        public Criteria andPrintamountNotIn(List<Integer> values) {
            addCriterion("printamount not in", values, "printamount");
            return (Criteria) this;
        }

        public Criteria andPrintamountBetween(Integer value1, Integer value2) {
            addCriterion("printamount between", value1, value2, "printamount");
            return (Criteria) this;
        }

        public Criteria andPrintamountNotBetween(Integer value1, Integer value2) {
            addCriterion("printamount not between", value1, value2, "printamount");
            return (Criteria) this;
        }

        public Criteria andPrintweightIsNull() {
            addCriterion("printweight is null");
            return (Criteria) this;
        }

        public Criteria andPrintweightIsNotNull() {
            addCriterion("printweight is not null");
            return (Criteria) this;
        }

        public Criteria andPrintweightEqualTo(Float value) {
            addCriterion("printweight =", value, "printweight");
            return (Criteria) this;
        }

        public Criteria andPrintweightNotEqualTo(Float value) {
            addCriterion("printweight <>", value, "printweight");
            return (Criteria) this;
        }

        public Criteria andPrintweightGreaterThan(Float value) {
            addCriterion("printweight >", value, "printweight");
            return (Criteria) this;
        }

        public Criteria andPrintweightGreaterThanOrEqualTo(Float value) {
            addCriterion("printweight >=", value, "printweight");
            return (Criteria) this;
        }

        public Criteria andPrintweightLessThan(Float value) {
            addCriterion("printweight <", value, "printweight");
            return (Criteria) this;
        }

        public Criteria andPrintweightLessThanOrEqualTo(Float value) {
            addCriterion("printweight <=", value, "printweight");
            return (Criteria) this;
        }

        public Criteria andPrintweightIn(List<Float> values) {
            addCriterion("printweight in", values, "printweight");
            return (Criteria) this;
        }

        public Criteria andPrintweightNotIn(List<Float> values) {
            addCriterion("printweight not in", values, "printweight");
            return (Criteria) this;
        }

        public Criteria andPrintweightBetween(Float value1, Float value2) {
            addCriterion("printweight between", value1, value2, "printweight");
            return (Criteria) this;
        }

        public Criteria andPrintweightNotBetween(Float value1, Float value2) {
            addCriterion("printweight not between", value1, value2, "printweight");
            return (Criteria) this;
        }

        public Criteria andPrintmeterIsNull() {
            addCriterion("printmeter is null");
            return (Criteria) this;
        }

        public Criteria andPrintmeterIsNotNull() {
            addCriterion("printmeter is not null");
            return (Criteria) this;
        }

        public Criteria andPrintmeterEqualTo(Integer value) {
            addCriterion("printmeter =", value, "printmeter");
            return (Criteria) this;
        }

        public Criteria andPrintmeterNotEqualTo(Integer value) {
            addCriterion("printmeter <>", value, "printmeter");
            return (Criteria) this;
        }

        public Criteria andPrintmeterGreaterThan(Integer value) {
            addCriterion("printmeter >", value, "printmeter");
            return (Criteria) this;
        }

        public Criteria andPrintmeterGreaterThanOrEqualTo(Integer value) {
            addCriterion("printmeter >=", value, "printmeter");
            return (Criteria) this;
        }

        public Criteria andPrintmeterLessThan(Integer value) {
            addCriterion("printmeter <", value, "printmeter");
            return (Criteria) this;
        }

        public Criteria andPrintmeterLessThanOrEqualTo(Integer value) {
            addCriterion("printmeter <=", value, "printmeter");
            return (Criteria) this;
        }

        public Criteria andPrintmeterIn(List<Integer> values) {
            addCriterion("printmeter in", values, "printmeter");
            return (Criteria) this;
        }

        public Criteria andPrintmeterNotIn(List<Integer> values) {
            addCriterion("printmeter not in", values, "printmeter");
            return (Criteria) this;
        }

        public Criteria andPrintmeterBetween(Integer value1, Integer value2) {
            addCriterion("printmeter between", value1, value2, "printmeter");
            return (Criteria) this;
        }

        public Criteria andPrintmeterNotBetween(Integer value1, Integer value2) {
            addCriterion("printmeter not between", value1, value2, "printmeter");
            return (Criteria) this;
        }

        public Criteria andWastageIsNull() {
            addCriterion("wastage is null");
            return (Criteria) this;
        }

        public Criteria andWastageIsNotNull() {
            addCriterion("wastage is not null");
            return (Criteria) this;
        }

        public Criteria andWastageEqualTo(Integer value) {
            addCriterion("wastage =", value, "wastage");
            return (Criteria) this;
        }

        public Criteria andWastageNotEqualTo(Integer value) {
            addCriterion("wastage <>", value, "wastage");
            return (Criteria) this;
        }

        public Criteria andWastageGreaterThan(Integer value) {
            addCriterion("wastage >", value, "wastage");
            return (Criteria) this;
        }

        public Criteria andWastageGreaterThanOrEqualTo(Integer value) {
            addCriterion("wastage >=", value, "wastage");
            return (Criteria) this;
        }

        public Criteria andWastageLessThan(Integer value) {
            addCriterion("wastage <", value, "wastage");
            return (Criteria) this;
        }

        public Criteria andWastageLessThanOrEqualTo(Integer value) {
            addCriterion("wastage <=", value, "wastage");
            return (Criteria) this;
        }

        public Criteria andWastageIn(List<Integer> values) {
            addCriterion("wastage in", values, "wastage");
            return (Criteria) this;
        }

        public Criteria andWastageNotIn(List<Integer> values) {
            addCriterion("wastage not in", values, "wastage");
            return (Criteria) this;
        }

        public Criteria andWastageBetween(Integer value1, Integer value2) {
            addCriterion("wastage between", value1, value2, "wastage");
            return (Criteria) this;
        }

        public Criteria andWastageNotBetween(Integer value1, Integer value2) {
            addCriterion("wastage not between", value1, value2, "wastage");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteIsNull() {
            addCriterion("procedurenote is null");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteIsNotNull() {
            addCriterion("procedurenote is not null");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteEqualTo(String value) {
            addCriterion("procedurenote =", value, "procedurenote");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteNotEqualTo(String value) {
            addCriterion("procedurenote <>", value, "procedurenote");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteGreaterThan(String value) {
            addCriterion("procedurenote >", value, "procedurenote");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteGreaterThanOrEqualTo(String value) {
            addCriterion("procedurenote >=", value, "procedurenote");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteLessThan(String value) {
            addCriterion("procedurenote <", value, "procedurenote");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteLessThanOrEqualTo(String value) {
            addCriterion("procedurenote <=", value, "procedurenote");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteLike(String value) {
            addCriterion("procedurenote like", value, "procedurenote");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteNotLike(String value) {
            addCriterion("procedurenote not like", value, "procedurenote");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteIn(List<String> values) {
            addCriterion("procedurenote in", values, "procedurenote");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteNotIn(List<String> values) {
            addCriterion("procedurenote not in", values, "procedurenote");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteBetween(String value1, String value2) {
            addCriterion("procedurenote between", value1, value2, "procedurenote");
            return (Criteria) this;
        }

        public Criteria andProcedurenoteNotBetween(String value1, String value2) {
            addCriterion("procedurenote not between", value1, value2, "procedurenote");
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