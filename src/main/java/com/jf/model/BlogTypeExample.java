package com.jf.model;

import java.util.ArrayList;
import java.util.List;

public class BlogTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogTypeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

        public Criteria andBlogTypeIsNull() {
            addCriterion("blog_type is null");
            return (Criteria) this;
        }

        public Criteria andBlogTypeIsNotNull() {
            addCriterion("blog_type is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTypeEqualTo(Integer value) {
            addCriterion("blog_type =", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeNotEqualTo(Integer value) {
            addCriterion("blog_type <>", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeGreaterThan(Integer value) {
            addCriterion("blog_type >", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_type >=", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeLessThan(Integer value) {
            addCriterion("blog_type <", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeLessThanOrEqualTo(Integer value) {
            addCriterion("blog_type <=", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeIn(List<Integer> values) {
            addCriterion("blog_type in", values, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeNotIn(List<Integer> values) {
            addCriterion("blog_type not in", values, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeBetween(Integer value1, Integer value2) {
            addCriterion("blog_type between", value1, value2, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_type not between", value1, value2, "blogType");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andBack1IsNull() {
            addCriterion("back1 is null");
            return (Criteria) this;
        }

        public Criteria andBack1IsNotNull() {
            addCriterion("back1 is not null");
            return (Criteria) this;
        }

        public Criteria andBack1EqualTo(String value) {
            addCriterion("back1 =", value, "back1");
            return (Criteria) this;
        }

        public Criteria andBack1NotEqualTo(String value) {
            addCriterion("back1 <>", value, "back1");
            return (Criteria) this;
        }

        public Criteria andBack1GreaterThan(String value) {
            addCriterion("back1 >", value, "back1");
            return (Criteria) this;
        }

        public Criteria andBack1GreaterThanOrEqualTo(String value) {
            addCriterion("back1 >=", value, "back1");
            return (Criteria) this;
        }

        public Criteria andBack1LessThan(String value) {
            addCriterion("back1 <", value, "back1");
            return (Criteria) this;
        }

        public Criteria andBack1LessThanOrEqualTo(String value) {
            addCriterion("back1 <=", value, "back1");
            return (Criteria) this;
        }

        public Criteria andBack1Like(String value) {
            addCriterion("back1 like", value, "back1");
            return (Criteria) this;
        }

        public Criteria andBack1NotLike(String value) {
            addCriterion("back1 not like", value, "back1");
            return (Criteria) this;
        }

        public Criteria andBack1In(List<String> values) {
            addCriterion("back1 in", values, "back1");
            return (Criteria) this;
        }

        public Criteria andBack1NotIn(List<String> values) {
            addCriterion("back1 not in", values, "back1");
            return (Criteria) this;
        }

        public Criteria andBack1Between(String value1, String value2) {
            addCriterion("back1 between", value1, value2, "back1");
            return (Criteria) this;
        }

        public Criteria andBack1NotBetween(String value1, String value2) {
            addCriterion("back1 not between", value1, value2, "back1");
            return (Criteria) this;
        }

        public Criteria andBack2IsNull() {
            addCriterion("back2 is null");
            return (Criteria) this;
        }

        public Criteria andBack2IsNotNull() {
            addCriterion("back2 is not null");
            return (Criteria) this;
        }

        public Criteria andBack2EqualTo(String value) {
            addCriterion("back2 =", value, "back2");
            return (Criteria) this;
        }

        public Criteria andBack2NotEqualTo(String value) {
            addCriterion("back2 <>", value, "back2");
            return (Criteria) this;
        }

        public Criteria andBack2GreaterThan(String value) {
            addCriterion("back2 >", value, "back2");
            return (Criteria) this;
        }

        public Criteria andBack2GreaterThanOrEqualTo(String value) {
            addCriterion("back2 >=", value, "back2");
            return (Criteria) this;
        }

        public Criteria andBack2LessThan(String value) {
            addCriterion("back2 <", value, "back2");
            return (Criteria) this;
        }

        public Criteria andBack2LessThanOrEqualTo(String value) {
            addCriterion("back2 <=", value, "back2");
            return (Criteria) this;
        }

        public Criteria andBack2Like(String value) {
            addCriterion("back2 like", value, "back2");
            return (Criteria) this;
        }

        public Criteria andBack2NotLike(String value) {
            addCriterion("back2 not like", value, "back2");
            return (Criteria) this;
        }

        public Criteria andBack2In(List<String> values) {
            addCriterion("back2 in", values, "back2");
            return (Criteria) this;
        }

        public Criteria andBack2NotIn(List<String> values) {
            addCriterion("back2 not in", values, "back2");
            return (Criteria) this;
        }

        public Criteria andBack2Between(String value1, String value2) {
            addCriterion("back2 between", value1, value2, "back2");
            return (Criteria) this;
        }

        public Criteria andBack2NotBetween(String value1, String value2) {
            addCriterion("back2 not between", value1, value2, "back2");
            return (Criteria) this;
        }

        public Criteria andBack3IsNull() {
            addCriterion("back3 is null");
            return (Criteria) this;
        }

        public Criteria andBack3IsNotNull() {
            addCriterion("back3 is not null");
            return (Criteria) this;
        }

        public Criteria andBack3EqualTo(String value) {
            addCriterion("back3 =", value, "back3");
            return (Criteria) this;
        }

        public Criteria andBack3NotEqualTo(String value) {
            addCriterion("back3 <>", value, "back3");
            return (Criteria) this;
        }

        public Criteria andBack3GreaterThan(String value) {
            addCriterion("back3 >", value, "back3");
            return (Criteria) this;
        }

        public Criteria andBack3GreaterThanOrEqualTo(String value) {
            addCriterion("back3 >=", value, "back3");
            return (Criteria) this;
        }

        public Criteria andBack3LessThan(String value) {
            addCriterion("back3 <", value, "back3");
            return (Criteria) this;
        }

        public Criteria andBack3LessThanOrEqualTo(String value) {
            addCriterion("back3 <=", value, "back3");
            return (Criteria) this;
        }

        public Criteria andBack3Like(String value) {
            addCriterion("back3 like", value, "back3");
            return (Criteria) this;
        }

        public Criteria andBack3NotLike(String value) {
            addCriterion("back3 not like", value, "back3");
            return (Criteria) this;
        }

        public Criteria andBack3In(List<String> values) {
            addCriterion("back3 in", values, "back3");
            return (Criteria) this;
        }

        public Criteria andBack3NotIn(List<String> values) {
            addCriterion("back3 not in", values, "back3");
            return (Criteria) this;
        }

        public Criteria andBack3Between(String value1, String value2) {
            addCriterion("back3 between", value1, value2, "back3");
            return (Criteria) this;
        }

        public Criteria andBack3NotBetween(String value1, String value2) {
            addCriterion("back3 not between", value1, value2, "back3");
            return (Criteria) this;
        }

        public Criteria andBack4IsNull() {
            addCriterion("back4 is null");
            return (Criteria) this;
        }

        public Criteria andBack4IsNotNull() {
            addCriterion("back4 is not null");
            return (Criteria) this;
        }

        public Criteria andBack4EqualTo(String value) {
            addCriterion("back4 =", value, "back4");
            return (Criteria) this;
        }

        public Criteria andBack4NotEqualTo(String value) {
            addCriterion("back4 <>", value, "back4");
            return (Criteria) this;
        }

        public Criteria andBack4GreaterThan(String value) {
            addCriterion("back4 >", value, "back4");
            return (Criteria) this;
        }

        public Criteria andBack4GreaterThanOrEqualTo(String value) {
            addCriterion("back4 >=", value, "back4");
            return (Criteria) this;
        }

        public Criteria andBack4LessThan(String value) {
            addCriterion("back4 <", value, "back4");
            return (Criteria) this;
        }

        public Criteria andBack4LessThanOrEqualTo(String value) {
            addCriterion("back4 <=", value, "back4");
            return (Criteria) this;
        }

        public Criteria andBack4Like(String value) {
            addCriterion("back4 like", value, "back4");
            return (Criteria) this;
        }

        public Criteria andBack4NotLike(String value) {
            addCriterion("back4 not like", value, "back4");
            return (Criteria) this;
        }

        public Criteria andBack4In(List<String> values) {
            addCriterion("back4 in", values, "back4");
            return (Criteria) this;
        }

        public Criteria andBack4NotIn(List<String> values) {
            addCriterion("back4 not in", values, "back4");
            return (Criteria) this;
        }

        public Criteria andBack4Between(String value1, String value2) {
            addCriterion("back4 between", value1, value2, "back4");
            return (Criteria) this;
        }

        public Criteria andBack4NotBetween(String value1, String value2) {
            addCriterion("back4 not between", value1, value2, "back4");
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
    }
}