package com.ghprint.cms.model.production;

import java.util.ArrayList;
import java.util.List;

public class TPrintingProcedureafterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPrintingProcedureafterExample() {
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

        public Criteria andQualitycheckIsNull() {
            addCriterion("qualitycheck is null");
            return (Criteria) this;
        }

        public Criteria andQualitycheckIsNotNull() {
            addCriterion("qualitycheck is not null");
            return (Criteria) this;
        }

        public Criteria andQualitycheckEqualTo(String value) {
            addCriterion("qualitycheck =", value, "qualitycheck");
            return (Criteria) this;
        }

        public Criteria andQualitycheckNotEqualTo(String value) {
            addCriterion("qualitycheck <>", value, "qualitycheck");
            return (Criteria) this;
        }

        public Criteria andQualitycheckGreaterThan(String value) {
            addCriterion("qualitycheck >", value, "qualitycheck");
            return (Criteria) this;
        }

        public Criteria andQualitycheckGreaterThanOrEqualTo(String value) {
            addCriterion("qualitycheck >=", value, "qualitycheck");
            return (Criteria) this;
        }

        public Criteria andQualitycheckLessThan(String value) {
            addCriterion("qualitycheck <", value, "qualitycheck");
            return (Criteria) this;
        }

        public Criteria andQualitycheckLessThanOrEqualTo(String value) {
            addCriterion("qualitycheck <=", value, "qualitycheck");
            return (Criteria) this;
        }

        public Criteria andQualitycheckLike(String value) {
            addCriterion("qualitycheck like", value, "qualitycheck");
            return (Criteria) this;
        }

        public Criteria andQualitycheckNotLike(String value) {
            addCriterion("qualitycheck not like", value, "qualitycheck");
            return (Criteria) this;
        }

        public Criteria andQualitycheckIn(List<String> values) {
            addCriterion("qualitycheck in", values, "qualitycheck");
            return (Criteria) this;
        }

        public Criteria andQualitycheckNotIn(List<String> values) {
            addCriterion("qualitycheck not in", values, "qualitycheck");
            return (Criteria) this;
        }

        public Criteria andQualitycheckBetween(String value1, String value2) {
            addCriterion("qualitycheck between", value1, value2, "qualitycheck");
            return (Criteria) this;
        }

        public Criteria andQualitycheckNotBetween(String value1, String value2) {
            addCriterion("qualitycheck not between", value1, value2, "qualitycheck");
            return (Criteria) this;
        }

        public Criteria andSplitsizrIsNull() {
            addCriterion("splitsizr is null");
            return (Criteria) this;
        }

        public Criteria andSplitsizrIsNotNull() {
            addCriterion("splitsizr is not null");
            return (Criteria) this;
        }

        public Criteria andSplitsizrEqualTo(Integer value) {
            addCriterion("splitsizr =", value, "splitsizr");
            return (Criteria) this;
        }

        public Criteria andSplitsizrNotEqualTo(Integer value) {
            addCriterion("splitsizr <>", value, "splitsizr");
            return (Criteria) this;
        }

        public Criteria andSplitsizrGreaterThan(Integer value) {
            addCriterion("splitsizr >", value, "splitsizr");
            return (Criteria) this;
        }

        public Criteria andSplitsizrGreaterThanOrEqualTo(Integer value) {
            addCriterion("splitsizr >=", value, "splitsizr");
            return (Criteria) this;
        }

        public Criteria andSplitsizrLessThan(Integer value) {
            addCriterion("splitsizr <", value, "splitsizr");
            return (Criteria) this;
        }

        public Criteria andSplitsizrLessThanOrEqualTo(Integer value) {
            addCriterion("splitsizr <=", value, "splitsizr");
            return (Criteria) this;
        }

        public Criteria andSplitsizrIn(List<Integer> values) {
            addCriterion("splitsizr in", values, "splitsizr");
            return (Criteria) this;
        }

        public Criteria andSplitsizrNotIn(List<Integer> values) {
            addCriterion("splitsizr not in", values, "splitsizr");
            return (Criteria) this;
        }

        public Criteria andSplitsizrBetween(Integer value1, Integer value2) {
            addCriterion("splitsizr between", value1, value2, "splitsizr");
            return (Criteria) this;
        }

        public Criteria andSplitsizrNotBetween(Integer value1, Integer value2) {
            addCriterion("splitsizr not between", value1, value2, "splitsizr");
            return (Criteria) this;
        }

        public Criteria andTransparentkeepIsNull() {
            addCriterion("transparentkeep is null");
            return (Criteria) this;
        }

        public Criteria andTransparentkeepIsNotNull() {
            addCriterion("transparentkeep is not null");
            return (Criteria) this;
        }

        public Criteria andTransparentkeepEqualTo(Integer value) {
            addCriterion("transparentkeep =", value, "transparentkeep");
            return (Criteria) this;
        }

        public Criteria andTransparentkeepNotEqualTo(Integer value) {
            addCriterion("transparentkeep <>", value, "transparentkeep");
            return (Criteria) this;
        }

        public Criteria andTransparentkeepGreaterThan(Integer value) {
            addCriterion("transparentkeep >", value, "transparentkeep");
            return (Criteria) this;
        }

        public Criteria andTransparentkeepGreaterThanOrEqualTo(Integer value) {
            addCriterion("transparentkeep >=", value, "transparentkeep");
            return (Criteria) this;
        }

        public Criteria andTransparentkeepLessThan(Integer value) {
            addCriterion("transparentkeep <", value, "transparentkeep");
            return (Criteria) this;
        }

        public Criteria andTransparentkeepLessThanOrEqualTo(Integer value) {
            addCriterion("transparentkeep <=", value, "transparentkeep");
            return (Criteria) this;
        }

        public Criteria andTransparentkeepIn(List<Integer> values) {
            addCriterion("transparentkeep in", values, "transparentkeep");
            return (Criteria) this;
        }

        public Criteria andTransparentkeepNotIn(List<Integer> values) {
            addCriterion("transparentkeep not in", values, "transparentkeep");
            return (Criteria) this;
        }

        public Criteria andTransparentkeepBetween(Integer value1, Integer value2) {
            addCriterion("transparentkeep between", value1, value2, "transparentkeep");
            return (Criteria) this;
        }

        public Criteria andTransparentkeepNotBetween(Integer value1, Integer value2) {
            addCriterion("transparentkeep not between", value1, value2, "transparentkeep");
            return (Criteria) this;
        }

        public Criteria andMergesizeIsNull() {
            addCriterion("mergesize is null");
            return (Criteria) this;
        }

        public Criteria andMergesizeIsNotNull() {
            addCriterion("mergesize is not null");
            return (Criteria) this;
        }

        public Criteria andMergesizeEqualTo(String value) {
            addCriterion("mergesize =", value, "mergesize");
            return (Criteria) this;
        }

        public Criteria andMergesizeNotEqualTo(String value) {
            addCriterion("mergesize <>", value, "mergesize");
            return (Criteria) this;
        }

        public Criteria andMergesizeGreaterThan(String value) {
            addCriterion("mergesize >", value, "mergesize");
            return (Criteria) this;
        }

        public Criteria andMergesizeGreaterThanOrEqualTo(String value) {
            addCriterion("mergesize >=", value, "mergesize");
            return (Criteria) this;
        }

        public Criteria andMergesizeLessThan(String value) {
            addCriterion("mergesize <", value, "mergesize");
            return (Criteria) this;
        }

        public Criteria andMergesizeLessThanOrEqualTo(String value) {
            addCriterion("mergesize <=", value, "mergesize");
            return (Criteria) this;
        }

        public Criteria andMergesizeLike(String value) {
            addCriterion("mergesize like", value, "mergesize");
            return (Criteria) this;
        }

        public Criteria andMergesizeNotLike(String value) {
            addCriterion("mergesize not like", value, "mergesize");
            return (Criteria) this;
        }

        public Criteria andMergesizeIn(List<String> values) {
            addCriterion("mergesize in", values, "mergesize");
            return (Criteria) this;
        }

        public Criteria andMergesizeNotIn(List<String> values) {
            addCriterion("mergesize not in", values, "mergesize");
            return (Criteria) this;
        }

        public Criteria andMergesizeBetween(String value1, String value2) {
            addCriterion("mergesize between", value1, value2, "mergesize");
            return (Criteria) this;
        }

        public Criteria andMergesizeNotBetween(String value1, String value2) {
            addCriterion("mergesize not between", value1, value2, "mergesize");
            return (Criteria) this;
        }

        public Criteria andSplithighIsNull() {
            addCriterion("splithigh is null");
            return (Criteria) this;
        }

        public Criteria andSplithighIsNotNull() {
            addCriterion("splithigh is not null");
            return (Criteria) this;
        }

        public Criteria andSplithighEqualTo(Integer value) {
            addCriterion("splithigh =", value, "splithigh");
            return (Criteria) this;
        }

        public Criteria andSplithighNotEqualTo(Integer value) {
            addCriterion("splithigh <>", value, "splithigh");
            return (Criteria) this;
        }

        public Criteria andSplithighGreaterThan(Integer value) {
            addCriterion("splithigh >", value, "splithigh");
            return (Criteria) this;
        }

        public Criteria andSplithighGreaterThanOrEqualTo(Integer value) {
            addCriterion("splithigh >=", value, "splithigh");
            return (Criteria) this;
        }

        public Criteria andSplithighLessThan(Integer value) {
            addCriterion("splithigh <", value, "splithigh");
            return (Criteria) this;
        }

        public Criteria andSplithighLessThanOrEqualTo(Integer value) {
            addCriterion("splithigh <=", value, "splithigh");
            return (Criteria) this;
        }

        public Criteria andSplithighIn(List<Integer> values) {
            addCriterion("splithigh in", values, "splithigh");
            return (Criteria) this;
        }

        public Criteria andSplithighNotIn(List<Integer> values) {
            addCriterion("splithigh not in", values, "splithigh");
            return (Criteria) this;
        }

        public Criteria andSplithighBetween(Integer value1, Integer value2) {
            addCriterion("splithigh between", value1, value2, "splithigh");
            return (Criteria) this;
        }

        public Criteria andSplithighNotBetween(Integer value1, Integer value2) {
            addCriterion("splithigh not between", value1, value2, "splithigh");
            return (Criteria) this;
        }

        public Criteria andGlueplaceIsNull() {
            addCriterion("glueplace is null");
            return (Criteria) this;
        }

        public Criteria andGlueplaceIsNotNull() {
            addCriterion("glueplace is not null");
            return (Criteria) this;
        }

        public Criteria andGlueplaceEqualTo(String value) {
            addCriterion("glueplace =", value, "glueplace");
            return (Criteria) this;
        }

        public Criteria andGlueplaceNotEqualTo(String value) {
            addCriterion("glueplace <>", value, "glueplace");
            return (Criteria) this;
        }

        public Criteria andGlueplaceGreaterThan(String value) {
            addCriterion("glueplace >", value, "glueplace");
            return (Criteria) this;
        }

        public Criteria andGlueplaceGreaterThanOrEqualTo(String value) {
            addCriterion("glueplace >=", value, "glueplace");
            return (Criteria) this;
        }

        public Criteria andGlueplaceLessThan(String value) {
            addCriterion("glueplace <", value, "glueplace");
            return (Criteria) this;
        }

        public Criteria andGlueplaceLessThanOrEqualTo(String value) {
            addCriterion("glueplace <=", value, "glueplace");
            return (Criteria) this;
        }

        public Criteria andGlueplaceLike(String value) {
            addCriterion("glueplace like", value, "glueplace");
            return (Criteria) this;
        }

        public Criteria andGlueplaceNotLike(String value) {
            addCriterion("glueplace not like", value, "glueplace");
            return (Criteria) this;
        }

        public Criteria andGlueplaceIn(List<String> values) {
            addCriterion("glueplace in", values, "glueplace");
            return (Criteria) this;
        }

        public Criteria andGlueplaceNotIn(List<String> values) {
            addCriterion("glueplace not in", values, "glueplace");
            return (Criteria) this;
        }

        public Criteria andGlueplaceBetween(String value1, String value2) {
            addCriterion("glueplace between", value1, value2, "glueplace");
            return (Criteria) this;
        }

        public Criteria andGlueplaceNotBetween(String value1, String value2) {
            addCriterion("glueplace not between", value1, value2, "glueplace");
            return (Criteria) this;
        }

        public Criteria andFoldplaceIsNull() {
            addCriterion("foldplace is null");
            return (Criteria) this;
        }

        public Criteria andFoldplaceIsNotNull() {
            addCriterion("foldplace is not null");
            return (Criteria) this;
        }

        public Criteria andFoldplaceEqualTo(String value) {
            addCriterion("foldplace =", value, "foldplace");
            return (Criteria) this;
        }

        public Criteria andFoldplaceNotEqualTo(String value) {
            addCriterion("foldplace <>", value, "foldplace");
            return (Criteria) this;
        }

        public Criteria andFoldplaceGreaterThan(String value) {
            addCriterion("foldplace >", value, "foldplace");
            return (Criteria) this;
        }

        public Criteria andFoldplaceGreaterThanOrEqualTo(String value) {
            addCriterion("foldplace >=", value, "foldplace");
            return (Criteria) this;
        }

        public Criteria andFoldplaceLessThan(String value) {
            addCriterion("foldplace <", value, "foldplace");
            return (Criteria) this;
        }

        public Criteria andFoldplaceLessThanOrEqualTo(String value) {
            addCriterion("foldplace <=", value, "foldplace");
            return (Criteria) this;
        }

        public Criteria andFoldplaceLike(String value) {
            addCriterion("foldplace like", value, "foldplace");
            return (Criteria) this;
        }

        public Criteria andFoldplaceNotLike(String value) {
            addCriterion("foldplace not like", value, "foldplace");
            return (Criteria) this;
        }

        public Criteria andFoldplaceIn(List<String> values) {
            addCriterion("foldplace in", values, "foldplace");
            return (Criteria) this;
        }

        public Criteria andFoldplaceNotIn(List<String> values) {
            addCriterion("foldplace not in", values, "foldplace");
            return (Criteria) this;
        }

        public Criteria andFoldplaceBetween(String value1, String value2) {
            addCriterion("foldplace between", value1, value2, "foldplace");
            return (Criteria) this;
        }

        public Criteria andFoldplaceNotBetween(String value1, String value2) {
            addCriterion("foldplace not between", value1, value2, "foldplace");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeIsNull() {
            addCriterion("tearlinesize is null");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeIsNotNull() {
            addCriterion("tearlinesize is not null");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeEqualTo(String value) {
            addCriterion("tearlinesize =", value, "tearlinesize");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeNotEqualTo(String value) {
            addCriterion("tearlinesize <>", value, "tearlinesize");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeGreaterThan(String value) {
            addCriterion("tearlinesize >", value, "tearlinesize");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeGreaterThanOrEqualTo(String value) {
            addCriterion("tearlinesize >=", value, "tearlinesize");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeLessThan(String value) {
            addCriterion("tearlinesize <", value, "tearlinesize");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeLessThanOrEqualTo(String value) {
            addCriterion("tearlinesize <=", value, "tearlinesize");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeLike(String value) {
            addCriterion("tearlinesize like", value, "tearlinesize");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeNotLike(String value) {
            addCriterion("tearlinesize not like", value, "tearlinesize");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeIn(List<String> values) {
            addCriterion("tearlinesize in", values, "tearlinesize");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeNotIn(List<String> values) {
            addCriterion("tearlinesize not in", values, "tearlinesize");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeBetween(String value1, String value2) {
            addCriterion("tearlinesize between", value1, value2, "tearlinesize");
            return (Criteria) this;
        }

        public Criteria andTearlinesizeNotBetween(String value1, String value2) {
            addCriterion("tearlinesize not between", value1, value2, "tearlinesize");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceIsNull() {
            addCriterion("tearlineplace is null");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceIsNotNull() {
            addCriterion("tearlineplace is not null");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceEqualTo(String value) {
            addCriterion("tearlineplace =", value, "tearlineplace");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceNotEqualTo(String value) {
            addCriterion("tearlineplace <>", value, "tearlineplace");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceGreaterThan(String value) {
            addCriterion("tearlineplace >", value, "tearlineplace");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceGreaterThanOrEqualTo(String value) {
            addCriterion("tearlineplace >=", value, "tearlineplace");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceLessThan(String value) {
            addCriterion("tearlineplace <", value, "tearlineplace");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceLessThanOrEqualTo(String value) {
            addCriterion("tearlineplace <=", value, "tearlineplace");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceLike(String value) {
            addCriterion("tearlineplace like", value, "tearlineplace");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceNotLike(String value) {
            addCriterion("tearlineplace not like", value, "tearlineplace");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceIn(List<String> values) {
            addCriterion("tearlineplace in", values, "tearlineplace");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceNotIn(List<String> values) {
            addCriterion("tearlineplace not in", values, "tearlineplace");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceBetween(String value1, String value2) {
            addCriterion("tearlineplace between", value1, value2, "tearlineplace");
            return (Criteria) this;
        }

        public Criteria andTearlineplaceNotBetween(String value1, String value2) {
            addCriterion("tearlineplace not between", value1, value2, "tearlineplace");
            return (Criteria) this;
        }

        public Criteria andProductstyleIsNull() {
            addCriterion("productstyle is null");
            return (Criteria) this;
        }

        public Criteria andProductstyleIsNotNull() {
            addCriterion("productstyle is not null");
            return (Criteria) this;
        }

        public Criteria andProductstyleEqualTo(String value) {
            addCriterion("productstyle =", value, "productstyle");
            return (Criteria) this;
        }

        public Criteria andProductstyleNotEqualTo(String value) {
            addCriterion("productstyle <>", value, "productstyle");
            return (Criteria) this;
        }

        public Criteria andProductstyleGreaterThan(String value) {
            addCriterion("productstyle >", value, "productstyle");
            return (Criteria) this;
        }

        public Criteria andProductstyleGreaterThanOrEqualTo(String value) {
            addCriterion("productstyle >=", value, "productstyle");
            return (Criteria) this;
        }

        public Criteria andProductstyleLessThan(String value) {
            addCriterion("productstyle <", value, "productstyle");
            return (Criteria) this;
        }

        public Criteria andProductstyleLessThanOrEqualTo(String value) {
            addCriterion("productstyle <=", value, "productstyle");
            return (Criteria) this;
        }

        public Criteria andProductstyleLike(String value) {
            addCriterion("productstyle like", value, "productstyle");
            return (Criteria) this;
        }

        public Criteria andProductstyleNotLike(String value) {
            addCriterion("productstyle not like", value, "productstyle");
            return (Criteria) this;
        }

        public Criteria andProductstyleIn(List<String> values) {
            addCriterion("productstyle in", values, "productstyle");
            return (Criteria) this;
        }

        public Criteria andProductstyleNotIn(List<String> values) {
            addCriterion("productstyle not in", values, "productstyle");
            return (Criteria) this;
        }

        public Criteria andProductstyleBetween(String value1, String value2) {
            addCriterion("productstyle between", value1, value2, "productstyle");
            return (Criteria) this;
        }

        public Criteria andProductstyleNotBetween(String value1, String value2) {
            addCriterion("productstyle not between", value1, value2, "productstyle");
            return (Criteria) this;
        }

        public Criteria andScrolldirectionIsNull() {
            addCriterion("scrolldirection is null");
            return (Criteria) this;
        }

        public Criteria andScrolldirectionIsNotNull() {
            addCriterion("scrolldirection is not null");
            return (Criteria) this;
        }

        public Criteria andScrolldirectionEqualTo(Integer value) {
            addCriterion("scrolldirection =", value, "scrolldirection");
            return (Criteria) this;
        }

        public Criteria andScrolldirectionNotEqualTo(Integer value) {
            addCriterion("scrolldirection <>", value, "scrolldirection");
            return (Criteria) this;
        }

        public Criteria andScrolldirectionGreaterThan(Integer value) {
            addCriterion("scrolldirection >", value, "scrolldirection");
            return (Criteria) this;
        }

        public Criteria andScrolldirectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("scrolldirection >=", value, "scrolldirection");
            return (Criteria) this;
        }

        public Criteria andScrolldirectionLessThan(Integer value) {
            addCriterion("scrolldirection <", value, "scrolldirection");
            return (Criteria) this;
        }

        public Criteria andScrolldirectionLessThanOrEqualTo(Integer value) {
            addCriterion("scrolldirection <=", value, "scrolldirection");
            return (Criteria) this;
        }

        public Criteria andScrolldirectionIn(List<Integer> values) {
            addCriterion("scrolldirection in", values, "scrolldirection");
            return (Criteria) this;
        }

        public Criteria andScrolldirectionNotIn(List<Integer> values) {
            addCriterion("scrolldirection not in", values, "scrolldirection");
            return (Criteria) this;
        }

        public Criteria andScrolldirectionBetween(Integer value1, Integer value2) {
            addCriterion("scrolldirection between", value1, value2, "scrolldirection");
            return (Criteria) this;
        }

        public Criteria andScrolldirectionNotBetween(Integer value1, Integer value2) {
            addCriterion("scrolldirection not between", value1, value2, "scrolldirection");
            return (Criteria) this;
        }

        public Criteria andScrolllengthIsNull() {
            addCriterion("scrolllength is null");
            return (Criteria) this;
        }

        public Criteria andScrolllengthIsNotNull() {
            addCriterion("scrolllength is not null");
            return (Criteria) this;
        }

        public Criteria andScrolllengthEqualTo(String value) {
            addCriterion("scrolllength =", value, "scrolllength");
            return (Criteria) this;
        }

        public Criteria andScrolllengthNotEqualTo(String value) {
            addCriterion("scrolllength <>", value, "scrolllength");
            return (Criteria) this;
        }

        public Criteria andScrolllengthGreaterThan(String value) {
            addCriterion("scrolllength >", value, "scrolllength");
            return (Criteria) this;
        }

        public Criteria andScrolllengthGreaterThanOrEqualTo(String value) {
            addCriterion("scrolllength >=", value, "scrolllength");
            return (Criteria) this;
        }

        public Criteria andScrolllengthLessThan(String value) {
            addCriterion("scrolllength <", value, "scrolllength");
            return (Criteria) this;
        }

        public Criteria andScrolllengthLessThanOrEqualTo(String value) {
            addCriterion("scrolllength <=", value, "scrolllength");
            return (Criteria) this;
        }

        public Criteria andScrolllengthLike(String value) {
            addCriterion("scrolllength like", value, "scrolllength");
            return (Criteria) this;
        }

        public Criteria andScrolllengthNotLike(String value) {
            addCriterion("scrolllength not like", value, "scrolllength");
            return (Criteria) this;
        }

        public Criteria andScrolllengthIn(List<String> values) {
            addCriterion("scrolllength in", values, "scrolllength");
            return (Criteria) this;
        }

        public Criteria andScrolllengthNotIn(List<String> values) {
            addCriterion("scrolllength not in", values, "scrolllength");
            return (Criteria) this;
        }

        public Criteria andScrolllengthBetween(String value1, String value2) {
            addCriterion("scrolllength between", value1, value2, "scrolllength");
            return (Criteria) this;
        }

        public Criteria andScrolllengthNotBetween(String value1, String value2) {
            addCriterion("scrolllength not between", value1, value2, "scrolllength");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeIsNull() {
            addCriterion("repeatscrollsize is null");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeIsNotNull() {
            addCriterion("repeatscrollsize is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeEqualTo(String value) {
            addCriterion("repeatscrollsize =", value, "repeatscrollsize");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeNotEqualTo(String value) {
            addCriterion("repeatscrollsize <>", value, "repeatscrollsize");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeGreaterThan(String value) {
            addCriterion("repeatscrollsize >", value, "repeatscrollsize");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeGreaterThanOrEqualTo(String value) {
            addCriterion("repeatscrollsize >=", value, "repeatscrollsize");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeLessThan(String value) {
            addCriterion("repeatscrollsize <", value, "repeatscrollsize");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeLessThanOrEqualTo(String value) {
            addCriterion("repeatscrollsize <=", value, "repeatscrollsize");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeLike(String value) {
            addCriterion("repeatscrollsize like", value, "repeatscrollsize");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeNotLike(String value) {
            addCriterion("repeatscrollsize not like", value, "repeatscrollsize");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeIn(List<String> values) {
            addCriterion("repeatscrollsize in", values, "repeatscrollsize");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeNotIn(List<String> values) {
            addCriterion("repeatscrollsize not in", values, "repeatscrollsize");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeBetween(String value1, String value2) {
            addCriterion("repeatscrollsize between", value1, value2, "repeatscrollsize");
            return (Criteria) this;
        }

        public Criteria andRepeatscrollsizeNotBetween(String value1, String value2) {
            addCriterion("repeatscrollsize not between", value1, value2, "repeatscrollsize");
            return (Criteria) this;
        }

        public Criteria andProceduresumIsNull() {
            addCriterion("proceduresum is null");
            return (Criteria) this;
        }

        public Criteria andProceduresumIsNotNull() {
            addCriterion("proceduresum is not null");
            return (Criteria) this;
        }

        public Criteria andProceduresumEqualTo(String value) {
            addCriterion("proceduresum =", value, "proceduresum");
            return (Criteria) this;
        }

        public Criteria andProceduresumNotEqualTo(String value) {
            addCriterion("proceduresum <>", value, "proceduresum");
            return (Criteria) this;
        }

        public Criteria andProceduresumGreaterThan(String value) {
            addCriterion("proceduresum >", value, "proceduresum");
            return (Criteria) this;
        }

        public Criteria andProceduresumGreaterThanOrEqualTo(String value) {
            addCriterion("proceduresum >=", value, "proceduresum");
            return (Criteria) this;
        }

        public Criteria andProceduresumLessThan(String value) {
            addCriterion("proceduresum <", value, "proceduresum");
            return (Criteria) this;
        }

        public Criteria andProceduresumLessThanOrEqualTo(String value) {
            addCriterion("proceduresum <=", value, "proceduresum");
            return (Criteria) this;
        }

        public Criteria andProceduresumLike(String value) {
            addCriterion("proceduresum like", value, "proceduresum");
            return (Criteria) this;
        }

        public Criteria andProceduresumNotLike(String value) {
            addCriterion("proceduresum not like", value, "proceduresum");
            return (Criteria) this;
        }

        public Criteria andProceduresumIn(List<String> values) {
            addCriterion("proceduresum in", values, "proceduresum");
            return (Criteria) this;
        }

        public Criteria andProceduresumNotIn(List<String> values) {
            addCriterion("proceduresum not in", values, "proceduresum");
            return (Criteria) this;
        }

        public Criteria andProceduresumBetween(String value1, String value2) {
            addCriterion("proceduresum between", value1, value2, "proceduresum");
            return (Criteria) this;
        }

        public Criteria andProceduresumNotBetween(String value1, String value2) {
            addCriterion("proceduresum not between", value1, value2, "proceduresum");
            return (Criteria) this;
        }

        public Criteria andInterfacecountIsNull() {
            addCriterion("interfacecount is null");
            return (Criteria) this;
        }

        public Criteria andInterfacecountIsNotNull() {
            addCriterion("interfacecount is not null");
            return (Criteria) this;
        }

        public Criteria andInterfacecountEqualTo(Integer value) {
            addCriterion("interfacecount =", value, "interfacecount");
            return (Criteria) this;
        }

        public Criteria andInterfacecountNotEqualTo(Integer value) {
            addCriterion("interfacecount <>", value, "interfacecount");
            return (Criteria) this;
        }

        public Criteria andInterfacecountGreaterThan(Integer value) {
            addCriterion("interfacecount >", value, "interfacecount");
            return (Criteria) this;
        }

        public Criteria andInterfacecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("interfacecount >=", value, "interfacecount");
            return (Criteria) this;
        }

        public Criteria andInterfacecountLessThan(Integer value) {
            addCriterion("interfacecount <", value, "interfacecount");
            return (Criteria) this;
        }

        public Criteria andInterfacecountLessThanOrEqualTo(Integer value) {
            addCriterion("interfacecount <=", value, "interfacecount");
            return (Criteria) this;
        }

        public Criteria andInterfacecountIn(List<Integer> values) {
            addCriterion("interfacecount in", values, "interfacecount");
            return (Criteria) this;
        }

        public Criteria andInterfacecountNotIn(List<Integer> values) {
            addCriterion("interfacecount not in", values, "interfacecount");
            return (Criteria) this;
        }

        public Criteria andInterfacecountBetween(Integer value1, Integer value2) {
            addCriterion("interfacecount between", value1, value2, "interfacecount");
            return (Criteria) this;
        }

        public Criteria andInterfacecountNotBetween(Integer value1, Integer value2) {
            addCriterion("interfacecount not between", value1, value2, "interfacecount");
            return (Criteria) this;
        }

        public Criteria andHemcountIsNull() {
            addCriterion("hemcount is null");
            return (Criteria) this;
        }

        public Criteria andHemcountIsNotNull() {
            addCriterion("hemcount is not null");
            return (Criteria) this;
        }

        public Criteria andHemcountEqualTo(Integer value) {
            addCriterion("hemcount =", value, "hemcount");
            return (Criteria) this;
        }

        public Criteria andHemcountNotEqualTo(Integer value) {
            addCriterion("hemcount <>", value, "hemcount");
            return (Criteria) this;
        }

        public Criteria andHemcountGreaterThan(Integer value) {
            addCriterion("hemcount >", value, "hemcount");
            return (Criteria) this;
        }

        public Criteria andHemcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("hemcount >=", value, "hemcount");
            return (Criteria) this;
        }

        public Criteria andHemcountLessThan(Integer value) {
            addCriterion("hemcount <", value, "hemcount");
            return (Criteria) this;
        }

        public Criteria andHemcountLessThanOrEqualTo(Integer value) {
            addCriterion("hemcount <=", value, "hemcount");
            return (Criteria) this;
        }

        public Criteria andHemcountIn(List<Integer> values) {
            addCriterion("hemcount in", values, "hemcount");
            return (Criteria) this;
        }

        public Criteria andHemcountNotIn(List<Integer> values) {
            addCriterion("hemcount not in", values, "hemcount");
            return (Criteria) this;
        }

        public Criteria andHemcountBetween(Integer value1, Integer value2) {
            addCriterion("hemcount between", value1, value2, "hemcount");
            return (Criteria) this;
        }

        public Criteria andHemcountNotBetween(Integer value1, Integer value2) {
            addCriterion("hemcount not between", value1, value2, "hemcount");
            return (Criteria) this;
        }

        public Criteria andBoxwayIsNull() {
            addCriterion("boxway is null");
            return (Criteria) this;
        }

        public Criteria andBoxwayIsNotNull() {
            addCriterion("boxway is not null");
            return (Criteria) this;
        }

        public Criteria andBoxwayEqualTo(String value) {
            addCriterion("boxway =", value, "boxway");
            return (Criteria) this;
        }

        public Criteria andBoxwayNotEqualTo(String value) {
            addCriterion("boxway <>", value, "boxway");
            return (Criteria) this;
        }

        public Criteria andBoxwayGreaterThan(String value) {
            addCriterion("boxway >", value, "boxway");
            return (Criteria) this;
        }

        public Criteria andBoxwayGreaterThanOrEqualTo(String value) {
            addCriterion("boxway >=", value, "boxway");
            return (Criteria) this;
        }

        public Criteria andBoxwayLessThan(String value) {
            addCriterion("boxway <", value, "boxway");
            return (Criteria) this;
        }

        public Criteria andBoxwayLessThanOrEqualTo(String value) {
            addCriterion("boxway <=", value, "boxway");
            return (Criteria) this;
        }

        public Criteria andBoxwayLike(String value) {
            addCriterion("boxway like", value, "boxway");
            return (Criteria) this;
        }

        public Criteria andBoxwayNotLike(String value) {
            addCriterion("boxway not like", value, "boxway");
            return (Criteria) this;
        }

        public Criteria andBoxwayIn(List<String> values) {
            addCriterion("boxway in", values, "boxway");
            return (Criteria) this;
        }

        public Criteria andBoxwayNotIn(List<String> values) {
            addCriterion("boxway not in", values, "boxway");
            return (Criteria) this;
        }

        public Criteria andBoxwayBetween(String value1, String value2) {
            addCriterion("boxway between", value1, value2, "boxway");
            return (Criteria) this;
        }

        public Criteria andBoxwayNotBetween(String value1, String value2) {
            addCriterion("boxway not between", value1, value2, "boxway");
            return (Criteria) this;
        }

        public Criteria andBoxsizeIsNull() {
            addCriterion("boxsize is null");
            return (Criteria) this;
        }

        public Criteria andBoxsizeIsNotNull() {
            addCriterion("boxsize is not null");
            return (Criteria) this;
        }

        public Criteria andBoxsizeEqualTo(String value) {
            addCriterion("boxsize =", value, "boxsize");
            return (Criteria) this;
        }

        public Criteria andBoxsizeNotEqualTo(String value) {
            addCriterion("boxsize <>", value, "boxsize");
            return (Criteria) this;
        }

        public Criteria andBoxsizeGreaterThan(String value) {
            addCriterion("boxsize >", value, "boxsize");
            return (Criteria) this;
        }

        public Criteria andBoxsizeGreaterThanOrEqualTo(String value) {
            addCriterion("boxsize >=", value, "boxsize");
            return (Criteria) this;
        }

        public Criteria andBoxsizeLessThan(String value) {
            addCriterion("boxsize <", value, "boxsize");
            return (Criteria) this;
        }

        public Criteria andBoxsizeLessThanOrEqualTo(String value) {
            addCriterion("boxsize <=", value, "boxsize");
            return (Criteria) this;
        }

        public Criteria andBoxsizeLike(String value) {
            addCriterion("boxsize like", value, "boxsize");
            return (Criteria) this;
        }

        public Criteria andBoxsizeNotLike(String value) {
            addCriterion("boxsize not like", value, "boxsize");
            return (Criteria) this;
        }

        public Criteria andBoxsizeIn(List<String> values) {
            addCriterion("boxsize in", values, "boxsize");
            return (Criteria) this;
        }

        public Criteria andBoxsizeNotIn(List<String> values) {
            addCriterion("boxsize not in", values, "boxsize");
            return (Criteria) this;
        }

        public Criteria andBoxsizeBetween(String value1, String value2) {
            addCriterion("boxsize between", value1, value2, "boxsize");
            return (Criteria) this;
        }

        public Criteria andBoxsizeNotBetween(String value1, String value2) {
            addCriterion("boxsize not between", value1, value2, "boxsize");
            return (Criteria) this;
        }

        public Criteria andSplitsumIsNull() {
            addCriterion("splitsum is null");
            return (Criteria) this;
        }

        public Criteria andSplitsumIsNotNull() {
            addCriterion("splitsum is not null");
            return (Criteria) this;
        }

        public Criteria andSplitsumEqualTo(Integer value) {
            addCriterion("splitsum =", value, "splitsum");
            return (Criteria) this;
        }

        public Criteria andSplitsumNotEqualTo(Integer value) {
            addCriterion("splitsum <>", value, "splitsum");
            return (Criteria) this;
        }

        public Criteria andSplitsumGreaterThan(Integer value) {
            addCriterion("splitsum >", value, "splitsum");
            return (Criteria) this;
        }

        public Criteria andSplitsumGreaterThanOrEqualTo(Integer value) {
            addCriterion("splitsum >=", value, "splitsum");
            return (Criteria) this;
        }

        public Criteria andSplitsumLessThan(Integer value) {
            addCriterion("splitsum <", value, "splitsum");
            return (Criteria) this;
        }

        public Criteria andSplitsumLessThanOrEqualTo(Integer value) {
            addCriterion("splitsum <=", value, "splitsum");
            return (Criteria) this;
        }

        public Criteria andSplitsumIn(List<Integer> values) {
            addCriterion("splitsum in", values, "splitsum");
            return (Criteria) this;
        }

        public Criteria andSplitsumNotIn(List<Integer> values) {
            addCriterion("splitsum not in", values, "splitsum");
            return (Criteria) this;
        }

        public Criteria andSplitsumBetween(Integer value1, Integer value2) {
            addCriterion("splitsum between", value1, value2, "splitsum");
            return (Criteria) this;
        }

        public Criteria andSplitsumNotBetween(Integer value1, Integer value2) {
            addCriterion("splitsum not between", value1, value2, "splitsum");
            return (Criteria) this;
        }

        public Criteria andMouldIsNull() {
            addCriterion("mould is null");
            return (Criteria) this;
        }

        public Criteria andMouldIsNotNull() {
            addCriterion("mould is not null");
            return (Criteria) this;
        }

        public Criteria andMouldEqualTo(String value) {
            addCriterion("mould =", value, "mould");
            return (Criteria) this;
        }

        public Criteria andMouldNotEqualTo(String value) {
            addCriterion("mould <>", value, "mould");
            return (Criteria) this;
        }

        public Criteria andMouldGreaterThan(String value) {
            addCriterion("mould >", value, "mould");
            return (Criteria) this;
        }

        public Criteria andMouldGreaterThanOrEqualTo(String value) {
            addCriterion("mould >=", value, "mould");
            return (Criteria) this;
        }

        public Criteria andMouldLessThan(String value) {
            addCriterion("mould <", value, "mould");
            return (Criteria) this;
        }

        public Criteria andMouldLessThanOrEqualTo(String value) {
            addCriterion("mould <=", value, "mould");
            return (Criteria) this;
        }

        public Criteria andMouldLike(String value) {
            addCriterion("mould like", value, "mould");
            return (Criteria) this;
        }

        public Criteria andMouldNotLike(String value) {
            addCriterion("mould not like", value, "mould");
            return (Criteria) this;
        }

        public Criteria andMouldIn(List<String> values) {
            addCriterion("mould in", values, "mould");
            return (Criteria) this;
        }

        public Criteria andMouldNotIn(List<String> values) {
            addCriterion("mould not in", values, "mould");
            return (Criteria) this;
        }

        public Criteria andMouldBetween(String value1, String value2) {
            addCriterion("mould between", value1, value2, "mould");
            return (Criteria) this;
        }

        public Criteria andMouldNotBetween(String value1, String value2) {
            addCriterion("mould not between", value1, value2, "mould");
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