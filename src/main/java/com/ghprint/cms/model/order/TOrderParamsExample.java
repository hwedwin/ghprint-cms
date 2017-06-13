package com.ghprint.cms.model.order;

import java.util.ArrayList;
import java.util.List;

public class TOrderParamsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderParamsExample() {
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

        public Criteria andMaterialidIsNull() {
            addCriterion("materialid is null");
            return (Criteria) this;
        }

        public Criteria andMaterialidIsNotNull() {
            addCriterion("materialid is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialidEqualTo(Integer value) {
            addCriterion("materialid =", value, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidNotEqualTo(Integer value) {
            addCriterion("materialid <>", value, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidGreaterThan(Integer value) {
            addCriterion("materialid >", value, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidGreaterThanOrEqualTo(Integer value) {
            addCriterion("materialid >=", value, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidLessThan(Integer value) {
            addCriterion("materialid <", value, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidLessThanOrEqualTo(Integer value) {
            addCriterion("materialid <=", value, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidIn(List<Integer> values) {
            addCriterion("materialid in", values, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidNotIn(List<Integer> values) {
            addCriterion("materialid not in", values, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidBetween(Integer value1, Integer value2) {
            addCriterion("materialid between", value1, value2, "materialid");
            return (Criteria) this;
        }

        public Criteria andMaterialidNotBetween(Integer value1, Integer value2) {
            addCriterion("materialid not between", value1, value2, "materialid");
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

        public Criteria andStocksumIsNull() {
            addCriterion("stocksum is null");
            return (Criteria) this;
        }

        public Criteria andStocksumIsNotNull() {
            addCriterion("stocksum is not null");
            return (Criteria) this;
        }

        public Criteria andStocksumEqualTo(Integer value) {
            addCriterion("stocksum =", value, "stocksum");
            return (Criteria) this;
        }

        public Criteria andStocksumNotEqualTo(Integer value) {
            addCriterion("stocksum <>", value, "stocksum");
            return (Criteria) this;
        }

        public Criteria andStocksumGreaterThan(Integer value) {
            addCriterion("stocksum >", value, "stocksum");
            return (Criteria) this;
        }

        public Criteria andStocksumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stocksum >=", value, "stocksum");
            return (Criteria) this;
        }

        public Criteria andStocksumLessThan(Integer value) {
            addCriterion("stocksum <", value, "stocksum");
            return (Criteria) this;
        }

        public Criteria andStocksumLessThanOrEqualTo(Integer value) {
            addCriterion("stocksum <=", value, "stocksum");
            return (Criteria) this;
        }

        public Criteria andStocksumIn(List<Integer> values) {
            addCriterion("stocksum in", values, "stocksum");
            return (Criteria) this;
        }

        public Criteria andStocksumNotIn(List<Integer> values) {
            addCriterion("stocksum not in", values, "stocksum");
            return (Criteria) this;
        }

        public Criteria andStocksumBetween(Integer value1, Integer value2) {
            addCriterion("stocksum between", value1, value2, "stocksum");
            return (Criteria) this;
        }

        public Criteria andStocksumNotBetween(Integer value1, Integer value2) {
            addCriterion("stocksum not between", value1, value2, "stocksum");
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