package com.ghprint.cms.model.production;

import java.util.ArrayList;
import java.util.List;

public class TPrintingDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPrintingDataExample() {
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

        public Criteria andTemplatenumIsNull() {
            addCriterion("templatenum is null");
            return (Criteria) this;
        }

        public Criteria andTemplatenumIsNotNull() {
            addCriterion("templatenum is not null");
            return (Criteria) this;
        }

        public Criteria andTemplatenumEqualTo(String value) {
            addCriterion("templatenum =", value, "templatenum");
            return (Criteria) this;
        }

        public Criteria andTemplatenumNotEqualTo(String value) {
            addCriterion("templatenum <>", value, "templatenum");
            return (Criteria) this;
        }

        public Criteria andTemplatenumGreaterThan(String value) {
            addCriterion("templatenum >", value, "templatenum");
            return (Criteria) this;
        }

        public Criteria andTemplatenumGreaterThanOrEqualTo(String value) {
            addCriterion("templatenum >=", value, "templatenum");
            return (Criteria) this;
        }

        public Criteria andTemplatenumLessThan(String value) {
            addCriterion("templatenum <", value, "templatenum");
            return (Criteria) this;
        }

        public Criteria andTemplatenumLessThanOrEqualTo(String value) {
            addCriterion("templatenum <=", value, "templatenum");
            return (Criteria) this;
        }

        public Criteria andTemplatenumLike(String value) {
            addCriterion("templatenum like", value, "templatenum");
            return (Criteria) this;
        }

        public Criteria andTemplatenumNotLike(String value) {
            addCriterion("templatenum not like", value, "templatenum");
            return (Criteria) this;
        }

        public Criteria andTemplatenumIn(List<String> values) {
            addCriterion("templatenum in", values, "templatenum");
            return (Criteria) this;
        }

        public Criteria andTemplatenumNotIn(List<String> values) {
            addCriterion("templatenum not in", values, "templatenum");
            return (Criteria) this;
        }

        public Criteria andTemplatenumBetween(String value1, String value2) {
            addCriterion("templatenum between", value1, value2, "templatenum");
            return (Criteria) this;
        }

        public Criteria andTemplatenumNotBetween(String value1, String value2) {
            addCriterion("templatenum not between", value1, value2, "templatenum");
            return (Criteria) this;
        }

        public Criteria andPrintsizeIsNull() {
            addCriterion("printsize is null");
            return (Criteria) this;
        }

        public Criteria andPrintsizeIsNotNull() {
            addCriterion("printsize is not null");
            return (Criteria) this;
        }

        public Criteria andPrintsizeEqualTo(Integer value) {
            addCriterion("printsize =", value, "printsize");
            return (Criteria) this;
        }

        public Criteria andPrintsizeNotEqualTo(Integer value) {
            addCriterion("printsize <>", value, "printsize");
            return (Criteria) this;
        }

        public Criteria andPrintsizeGreaterThan(Integer value) {
            addCriterion("printsize >", value, "printsize");
            return (Criteria) this;
        }

        public Criteria andPrintsizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("printsize >=", value, "printsize");
            return (Criteria) this;
        }

        public Criteria andPrintsizeLessThan(Integer value) {
            addCriterion("printsize <", value, "printsize");
            return (Criteria) this;
        }

        public Criteria andPrintsizeLessThanOrEqualTo(Integer value) {
            addCriterion("printsize <=", value, "printsize");
            return (Criteria) this;
        }

        public Criteria andPrintsizeIn(List<Integer> values) {
            addCriterion("printsize in", values, "printsize");
            return (Criteria) this;
        }

        public Criteria andPrintsizeNotIn(List<Integer> values) {
            addCriterion("printsize not in", values, "printsize");
            return (Criteria) this;
        }

        public Criteria andPrintsizeBetween(Integer value1, Integer value2) {
            addCriterion("printsize between", value1, value2, "printsize");
            return (Criteria) this;
        }

        public Criteria andPrintsizeNotBetween(Integer value1, Integer value2) {
            addCriterion("printsize not between", value1, value2, "printsize");
            return (Criteria) this;
        }

        public Criteria andTemplatelengthIsNull() {
            addCriterion("templatelength is null");
            return (Criteria) this;
        }

        public Criteria andTemplatelengthIsNotNull() {
            addCriterion("templatelength is not null");
            return (Criteria) this;
        }

        public Criteria andTemplatelengthEqualTo(Integer value) {
            addCriterion("templatelength =", value, "templatelength");
            return (Criteria) this;
        }

        public Criteria andTemplatelengthNotEqualTo(Integer value) {
            addCriterion("templatelength <>", value, "templatelength");
            return (Criteria) this;
        }

        public Criteria andTemplatelengthGreaterThan(Integer value) {
            addCriterion("templatelength >", value, "templatelength");
            return (Criteria) this;
        }

        public Criteria andTemplatelengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("templatelength >=", value, "templatelength");
            return (Criteria) this;
        }

        public Criteria andTemplatelengthLessThan(Integer value) {
            addCriterion("templatelength <", value, "templatelength");
            return (Criteria) this;
        }

        public Criteria andTemplatelengthLessThanOrEqualTo(Integer value) {
            addCriterion("templatelength <=", value, "templatelength");
            return (Criteria) this;
        }

        public Criteria andTemplatelengthIn(List<Integer> values) {
            addCriterion("templatelength in", values, "templatelength");
            return (Criteria) this;
        }

        public Criteria andTemplatelengthNotIn(List<Integer> values) {
            addCriterion("templatelength not in", values, "templatelength");
            return (Criteria) this;
        }

        public Criteria andTemplatelengthBetween(Integer value1, Integer value2) {
            addCriterion("templatelength between", value1, value2, "templatelength");
            return (Criteria) this;
        }

        public Criteria andTemplatelengthNotBetween(Integer value1, Integer value2) {
            addCriterion("templatelength not between", value1, value2, "templatelength");
            return (Criteria) this;
        }

        public Criteria andTemplateperimeterIsNull() {
            addCriterion("templateperimeter is null");
            return (Criteria) this;
        }

        public Criteria andTemplateperimeterIsNotNull() {
            addCriterion("templateperimeter is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateperimeterEqualTo(Integer value) {
            addCriterion("templateperimeter =", value, "templateperimeter");
            return (Criteria) this;
        }

        public Criteria andTemplateperimeterNotEqualTo(Integer value) {
            addCriterion("templateperimeter <>", value, "templateperimeter");
            return (Criteria) this;
        }

        public Criteria andTemplateperimeterGreaterThan(Integer value) {
            addCriterion("templateperimeter >", value, "templateperimeter");
            return (Criteria) this;
        }

        public Criteria andTemplateperimeterGreaterThanOrEqualTo(Integer value) {
            addCriterion("templateperimeter >=", value, "templateperimeter");
            return (Criteria) this;
        }

        public Criteria andTemplateperimeterLessThan(Integer value) {
            addCriterion("templateperimeter <", value, "templateperimeter");
            return (Criteria) this;
        }

        public Criteria andTemplateperimeterLessThanOrEqualTo(Integer value) {
            addCriterion("templateperimeter <=", value, "templateperimeter");
            return (Criteria) this;
        }

        public Criteria andTemplateperimeterIn(List<Integer> values) {
            addCriterion("templateperimeter in", values, "templateperimeter");
            return (Criteria) this;
        }

        public Criteria andTemplateperimeterNotIn(List<Integer> values) {
            addCriterion("templateperimeter not in", values, "templateperimeter");
            return (Criteria) this;
        }

        public Criteria andTemplateperimeterBetween(Integer value1, Integer value2) {
            addCriterion("templateperimeter between", value1, value2, "templateperimeter");
            return (Criteria) this;
        }

        public Criteria andTemplateperimeterNotBetween(Integer value1, Integer value2) {
            addCriterion("templateperimeter not between", value1, value2, "templateperimeter");
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

        public Criteria andSpellcountEqualTo(String value) {
            addCriterion("spellcount =", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountNotEqualTo(String value) {
            addCriterion("spellcount <>", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountGreaterThan(String value) {
            addCriterion("spellcount >", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountGreaterThanOrEqualTo(String value) {
            addCriterion("spellcount >=", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountLessThan(String value) {
            addCriterion("spellcount <", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountLessThanOrEqualTo(String value) {
            addCriterion("spellcount <=", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountLike(String value) {
            addCriterion("spellcount like", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountNotLike(String value) {
            addCriterion("spellcount not like", value, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountIn(List<String> values) {
            addCriterion("spellcount in", values, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountNotIn(List<String> values) {
            addCriterion("spellcount not in", values, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountBetween(String value1, String value2) {
            addCriterion("spellcount between", value1, value2, "spellcount");
            return (Criteria) this;
        }

        public Criteria andSpellcountNotBetween(String value1, String value2) {
            addCriterion("spellcount not between", value1, value2, "spellcount");
            return (Criteria) this;
        }

        public Criteria andBankuncountIsNull() {
            addCriterion("bankuncount is null");
            return (Criteria) this;
        }

        public Criteria andBankuncountIsNotNull() {
            addCriterion("bankuncount is not null");
            return (Criteria) this;
        }

        public Criteria andBankuncountEqualTo(Integer value) {
            addCriterion("bankuncount =", value, "bankuncount");
            return (Criteria) this;
        }

        public Criteria andBankuncountNotEqualTo(Integer value) {
            addCriterion("bankuncount <>", value, "bankuncount");
            return (Criteria) this;
        }

        public Criteria andBankuncountGreaterThan(Integer value) {
            addCriterion("bankuncount >", value, "bankuncount");
            return (Criteria) this;
        }

        public Criteria andBankuncountGreaterThanOrEqualTo(Integer value) {
            addCriterion("bankuncount >=", value, "bankuncount");
            return (Criteria) this;
        }

        public Criteria andBankuncountLessThan(Integer value) {
            addCriterion("bankuncount <", value, "bankuncount");
            return (Criteria) this;
        }

        public Criteria andBankuncountLessThanOrEqualTo(Integer value) {
            addCriterion("bankuncount <=", value, "bankuncount");
            return (Criteria) this;
        }

        public Criteria andBankuncountIn(List<Integer> values) {
            addCriterion("bankuncount in", values, "bankuncount");
            return (Criteria) this;
        }

        public Criteria andBankuncountNotIn(List<Integer> values) {
            addCriterion("bankuncount not in", values, "bankuncount");
            return (Criteria) this;
        }

        public Criteria andBankuncountBetween(Integer value1, Integer value2) {
            addCriterion("bankuncount between", value1, value2, "bankuncount");
            return (Criteria) this;
        }

        public Criteria andBankuncountNotBetween(Integer value1, Integer value2) {
            addCriterion("bankuncount not between", value1, value2, "bankuncount");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andPrintnoteIsNull() {
            addCriterion("printnote is null");
            return (Criteria) this;
        }

        public Criteria andPrintnoteIsNotNull() {
            addCriterion("printnote is not null");
            return (Criteria) this;
        }

        public Criteria andPrintnoteEqualTo(String value) {
            addCriterion("printnote =", value, "printnote");
            return (Criteria) this;
        }

        public Criteria andPrintnoteNotEqualTo(String value) {
            addCriterion("printnote <>", value, "printnote");
            return (Criteria) this;
        }

        public Criteria andPrintnoteGreaterThan(String value) {
            addCriterion("printnote >", value, "printnote");
            return (Criteria) this;
        }

        public Criteria andPrintnoteGreaterThanOrEqualTo(String value) {
            addCriterion("printnote >=", value, "printnote");
            return (Criteria) this;
        }

        public Criteria andPrintnoteLessThan(String value) {
            addCriterion("printnote <", value, "printnote");
            return (Criteria) this;
        }

        public Criteria andPrintnoteLessThanOrEqualTo(String value) {
            addCriterion("printnote <=", value, "printnote");
            return (Criteria) this;
        }

        public Criteria andPrintnoteLike(String value) {
            addCriterion("printnote like", value, "printnote");
            return (Criteria) this;
        }

        public Criteria andPrintnoteNotLike(String value) {
            addCriterion("printnote not like", value, "printnote");
            return (Criteria) this;
        }

        public Criteria andPrintnoteIn(List<String> values) {
            addCriterion("printnote in", values, "printnote");
            return (Criteria) this;
        }

        public Criteria andPrintnoteNotIn(List<String> values) {
            addCriterion("printnote not in", values, "printnote");
            return (Criteria) this;
        }

        public Criteria andPrintnoteBetween(String value1, String value2) {
            addCriterion("printnote between", value1, value2, "printnote");
            return (Criteria) this;
        }

        public Criteria andPrintnoteNotBetween(String value1, String value2) {
            addCriterion("printnote not between", value1, value2, "printnote");
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