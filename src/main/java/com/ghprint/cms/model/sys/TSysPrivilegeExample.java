package com.ghprint.cms.model.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TSysPrivilegeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSysPrivilegeExample() {
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

        public Criteria andPrivilegeidIsNull() {
            addCriterion("privilegeid is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeidIsNotNull() {
            addCriterion("privilegeid is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeidEqualTo(String value) {
            addCriterion("privilegeid =", value, "privilegeid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeidNotEqualTo(String value) {
            addCriterion("privilegeid <>", value, "privilegeid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeidGreaterThan(String value) {
            addCriterion("privilegeid >", value, "privilegeid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeidGreaterThanOrEqualTo(String value) {
            addCriterion("privilegeid >=", value, "privilegeid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeidLessThan(String value) {
            addCriterion("privilegeid <", value, "privilegeid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeidLessThanOrEqualTo(String value) {
            addCriterion("privilegeid <=", value, "privilegeid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeidLike(String value) {
            addCriterion("privilegeid like", value, "privilegeid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeidNotLike(String value) {
            addCriterion("privilegeid not like", value, "privilegeid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeidIn(List<String> values) {
            addCriterion("privilegeid in", values, "privilegeid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeidNotIn(List<String> values) {
            addCriterion("privilegeid not in", values, "privilegeid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeidBetween(String value1, String value2) {
            addCriterion("privilegeid between", value1, value2, "privilegeid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeidNotBetween(String value1, String value2) {
            addCriterion("privilegeid not between", value1, value2, "privilegeid");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameIsNull() {
            addCriterion("privilegename is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameIsNotNull() {
            addCriterion("privilegename is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameEqualTo(String value) {
            addCriterion("privilegename =", value, "privilegename");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameNotEqualTo(String value) {
            addCriterion("privilegename <>", value, "privilegename");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameGreaterThan(String value) {
            addCriterion("privilegename >", value, "privilegename");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameGreaterThanOrEqualTo(String value) {
            addCriterion("privilegename >=", value, "privilegename");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameLessThan(String value) {
            addCriterion("privilegename <", value, "privilegename");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameLessThanOrEqualTo(String value) {
            addCriterion("privilegename <=", value, "privilegename");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameLike(String value) {
            addCriterion("privilegename like", value, "privilegename");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameNotLike(String value) {
            addCriterion("privilegename not like", value, "privilegename");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameIn(List<String> values) {
            addCriterion("privilegename in", values, "privilegename");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameNotIn(List<String> values) {
            addCriterion("privilegename not in", values, "privilegename");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameBetween(String value1, String value2) {
            addCriterion("privilegename between", value1, value2, "privilegename");
            return (Criteria) this;
        }

        public Criteria andPrivilegenameNotBetween(String value1, String value2) {
            addCriterion("privilegename not between", value1, value2, "privilegename");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescIsNull() {
            addCriterion("privilegedesc is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescIsNotNull() {
            addCriterion("privilegedesc is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescEqualTo(String value) {
            addCriterion("privilegedesc =", value, "privilegedesc");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescNotEqualTo(String value) {
            addCriterion("privilegedesc <>", value, "privilegedesc");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescGreaterThan(String value) {
            addCriterion("privilegedesc >", value, "privilegedesc");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescGreaterThanOrEqualTo(String value) {
            addCriterion("privilegedesc >=", value, "privilegedesc");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescLessThan(String value) {
            addCriterion("privilegedesc <", value, "privilegedesc");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescLessThanOrEqualTo(String value) {
            addCriterion("privilegedesc <=", value, "privilegedesc");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescLike(String value) {
            addCriterion("privilegedesc like", value, "privilegedesc");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescNotLike(String value) {
            addCriterion("privilegedesc not like", value, "privilegedesc");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescIn(List<String> values) {
            addCriterion("privilegedesc in", values, "privilegedesc");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescNotIn(List<String> values) {
            addCriterion("privilegedesc not in", values, "privilegedesc");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescBetween(String value1, String value2) {
            addCriterion("privilegedesc between", value1, value2, "privilegedesc");
            return (Criteria) this;
        }

        public Criteria andPrivilegedescNotBetween(String value1, String value2) {
            addCriterion("privilegedesc not between", value1, value2, "privilegedesc");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
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