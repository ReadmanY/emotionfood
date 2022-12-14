package com.team.emofood.dto;

import java.util.ArrayList;
import java.util.List;

public class RestaurantExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    public RestaurantExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRnameIsNull() {
            addCriterion("rname is null");
            return (Criteria) this;
        }

        public Criteria andRnameIsNotNull() {
            addCriterion("rname is not null");
            return (Criteria) this;
        }

        public Criteria andRnameEqualTo(String value) {
            addCriterion("rname =", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotEqualTo(String value) {
            addCriterion("rname <>", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThan(String value) {
            addCriterion("rname >", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThanOrEqualTo(String value) {
            addCriterion("rname >=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThan(String value) {
            addCriterion("rname <", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThanOrEqualTo(String value) {
            addCriterion("rname <=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLike(String value) {
            addCriterion("rname like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotLike(String value) {
            addCriterion("rname not like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameIn(List<String> values) {
            addCriterion("rname in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotIn(List<String> values) {
            addCriterion("rname not in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameBetween(String value1, String value2) {
            addCriterion("rname between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotBetween(String value1, String value2) {
            addCriterion("rname not between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRcateIsNull() {
            addCriterion("rcate is null");
            return (Criteria) this;
        }

        public Criteria andRcateIsNotNull() {
            addCriterion("rcate is not null");
            return (Criteria) this;
        }

        public Criteria andRcateEqualTo(String value) {
            addCriterion("rcate =", value, "rcate");
            return (Criteria) this;
        }

        public Criteria andRcateNotEqualTo(String value) {
            addCriterion("rcate <>", value, "rcate");
            return (Criteria) this;
        }

        public Criteria andRcateGreaterThan(String value) {
            addCriterion("rcate >", value, "rcate");
            return (Criteria) this;
        }

        public Criteria andRcateGreaterThanOrEqualTo(String value) {
            addCriterion("rcate >=", value, "rcate");
            return (Criteria) this;
        }

        public Criteria andRcateLessThan(String value) {
            addCriterion("rcate <", value, "rcate");
            return (Criteria) this;
        }

        public Criteria andRcateLessThanOrEqualTo(String value) {
            addCriterion("rcate <=", value, "rcate");
            return (Criteria) this;
        }

        public Criteria andRcateLike(String value) {
            addCriterion("rcate like", value, "rcate");
            return (Criteria) this;
        }

        public Criteria andRcateNotLike(String value) {
            addCriterion("rcate not like", value, "rcate");
            return (Criteria) this;
        }

        public Criteria andRcateIn(List<String> values) {
            addCriterion("rcate in", values, "rcate");
            return (Criteria) this;
        }

        public Criteria andRcateNotIn(List<String> values) {
            addCriterion("rcate not in", values, "rcate");
            return (Criteria) this;
        }

        public Criteria andRcateBetween(String value1, String value2) {
            addCriterion("rcate between", value1, value2, "rcate");
            return (Criteria) this;
        }

        public Criteria andRcateNotBetween(String value1, String value2) {
            addCriterion("rcate not between", value1, value2, "rcate");
            return (Criteria) this;
        }

        public Criteria andRaddrIsNull() {
            addCriterion("raddr is null");
            return (Criteria) this;
        }

        public Criteria andRaddrIsNotNull() {
            addCriterion("raddr is not null");
            return (Criteria) this;
        }

        public Criteria andRaddrEqualTo(String value) {
            addCriterion("raddr =", value, "raddr");
            return (Criteria) this;
        }

        public Criteria andRaddrNotEqualTo(String value) {
            addCriterion("raddr <>", value, "raddr");
            return (Criteria) this;
        }

        public Criteria andRaddrGreaterThan(String value) {
            addCriterion("raddr >", value, "raddr");
            return (Criteria) this;
        }

        public Criteria andRaddrGreaterThanOrEqualTo(String value) {
            addCriterion("raddr >=", value, "raddr");
            return (Criteria) this;
        }

        public Criteria andRaddrLessThan(String value) {
            addCriterion("raddr <", value, "raddr");
            return (Criteria) this;
        }

        public Criteria andRaddrLessThanOrEqualTo(String value) {
            addCriterion("raddr <=", value, "raddr");
            return (Criteria) this;
        }

        public Criteria andRaddrLike(String value) {
            addCriterion("raddr like", value, "raddr");
            return (Criteria) this;
        }

        public Criteria andRaddrNotLike(String value) {
            addCriterion("raddr not like", value, "raddr");
            return (Criteria) this;
        }

        public Criteria andRaddrIn(List<String> values) {
            addCriterion("raddr in", values, "raddr");
            return (Criteria) this;
        }

        public Criteria andRaddrNotIn(List<String> values) {
            addCriterion("raddr not in", values, "raddr");
            return (Criteria) this;
        }

        public Criteria andRaddrBetween(String value1, String value2) {
            addCriterion("raddr between", value1, value2, "raddr");
            return (Criteria) this;
        }

        public Criteria andRaddrNotBetween(String value1, String value2) {
            addCriterion("raddr not between", value1, value2, "raddr");
            return (Criteria) this;
        }

        public Criteria andRaddrGuIsNull() {
            addCriterion("raddr_gu is null");
            return (Criteria) this;
        }

        public Criteria andRaddrGuIsNotNull() {
            addCriterion("raddr_gu is not null");
            return (Criteria) this;
        }

        public Criteria andRaddrGuEqualTo(String value) {
            addCriterion("raddr_gu =", value, "raddrGu");
            return (Criteria) this;
        }

        public Criteria andRaddrGuNotEqualTo(String value) {
            addCriterion("raddr_gu <>", value, "raddrGu");
            return (Criteria) this;
        }

        public Criteria andRaddrGuGreaterThan(String value) {
            addCriterion("raddr_gu >", value, "raddrGu");
            return (Criteria) this;
        }

        public Criteria andRaddrGuGreaterThanOrEqualTo(String value) {
            addCriterion("raddr_gu >=", value, "raddrGu");
            return (Criteria) this;
        }

        public Criteria andRaddrGuLessThan(String value) {
            addCriterion("raddr_gu <", value, "raddrGu");
            return (Criteria) this;
        }

        public Criteria andRaddrGuLessThanOrEqualTo(String value) {
            addCriterion("raddr_gu <=", value, "raddrGu");
            return (Criteria) this;
        }

        public Criteria andRaddrGuLike(String value) {
            addCriterion("raddr_gu like", value, "raddrGu");
            return (Criteria) this;
        }

        public Criteria andRaddrGuNotLike(String value) {
            addCriterion("raddr_gu not like", value, "raddrGu");
            return (Criteria) this;
        }

        public Criteria andRaddrGuIn(List<String> values) {
            addCriterion("raddr_gu in", values, "raddrGu");
            return (Criteria) this;
        }

        public Criteria andRaddrGuNotIn(List<String> values) {
            addCriterion("raddr_gu not in", values, "raddrGu");
            return (Criteria) this;
        }

        public Criteria andRaddrGuBetween(String value1, String value2) {
            addCriterion("raddr_gu between", value1, value2, "raddrGu");
            return (Criteria) this;
        }

        public Criteria andRaddrGuNotBetween(String value1, String value2) {
            addCriterion("raddr_gu not between", value1, value2, "raddrGu");
            return (Criteria) this;
        }

        public Criteria andRphoneIsNull() {
            addCriterion("rphone is null");
            return (Criteria) this;
        }

        public Criteria andRphoneIsNotNull() {
            addCriterion("rphone is not null");
            return (Criteria) this;
        }

        public Criteria andRphoneEqualTo(String value) {
            addCriterion("rphone =", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneNotEqualTo(String value) {
            addCriterion("rphone <>", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneGreaterThan(String value) {
            addCriterion("rphone >", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneGreaterThanOrEqualTo(String value) {
            addCriterion("rphone >=", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneLessThan(String value) {
            addCriterion("rphone <", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneLessThanOrEqualTo(String value) {
            addCriterion("rphone <=", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneLike(String value) {
            addCriterion("rphone like", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneNotLike(String value) {
            addCriterion("rphone not like", value, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneIn(List<String> values) {
            addCriterion("rphone in", values, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneNotIn(List<String> values) {
            addCriterion("rphone not in", values, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneBetween(String value1, String value2) {
            addCriterion("rphone between", value1, value2, "rphone");
            return (Criteria) this;
        }

        public Criteria andRphoneNotBetween(String value1, String value2) {
            addCriterion("rphone not between", value1, value2, "rphone");
            return (Criteria) this;
        }

        public Criteria andRlocateXIsNull() {
            addCriterion("rlocate_x is null");
            return (Criteria) this;
        }

        public Criteria andRlocateXIsNotNull() {
            addCriterion("rlocate_x is not null");
            return (Criteria) this;
        }

        public Criteria andRlocateXEqualTo(Float value) {
            addCriterion("rlocate_x =", value, "rlocateX");
            return (Criteria) this;
        }

        public Criteria andRlocateXNotEqualTo(Float value) {
            addCriterion("rlocate_x <>", value, "rlocateX");
            return (Criteria) this;
        }

        public Criteria andRlocateXGreaterThan(Float value) {
            addCriterion("rlocate_x >", value, "rlocateX");
            return (Criteria) this;
        }

        public Criteria andRlocateXGreaterThanOrEqualTo(Float value) {
            addCriterion("rlocate_x >=", value, "rlocateX");
            return (Criteria) this;
        }

        public Criteria andRlocateXLessThan(Float value) {
            addCriterion("rlocate_x <", value, "rlocateX");
            return (Criteria) this;
        }

        public Criteria andRlocateXLessThanOrEqualTo(Float value) {
            addCriterion("rlocate_x <=", value, "rlocateX");
            return (Criteria) this;
        }

        public Criteria andRlocateXIn(List<Float> values) {
            addCriterion("rlocate_x in", values, "rlocateX");
            return (Criteria) this;
        }

        public Criteria andRlocateXNotIn(List<Float> values) {
            addCriterion("rlocate_x not in", values, "rlocateX");
            return (Criteria) this;
        }

        public Criteria andRlocateXBetween(Float value1, Float value2) {
            addCriterion("rlocate_x between", value1, value2, "rlocateX");
            return (Criteria) this;
        }

        public Criteria andRlocateXNotBetween(Float value1, Float value2) {
            addCriterion("rlocate_x not between", value1, value2, "rlocateX");
            return (Criteria) this;
        }

        public Criteria andRlocateYIsNull() {
            addCriterion("rlocate_y is null");
            return (Criteria) this;
        }

        public Criteria andRlocateYIsNotNull() {
            addCriterion("rlocate_y is not null");
            return (Criteria) this;
        }

        public Criteria andRlocateYEqualTo(Float value) {
            addCriterion("rlocate_y =", value, "rlocateY");
            return (Criteria) this;
        }

        public Criteria andRlocateYNotEqualTo(Float value) {
            addCriterion("rlocate_y <>", value, "rlocateY");
            return (Criteria) this;
        }

        public Criteria andRlocateYGreaterThan(Float value) {
            addCriterion("rlocate_y >", value, "rlocateY");
            return (Criteria) this;
        }

        public Criteria andRlocateYGreaterThanOrEqualTo(Float value) {
            addCriterion("rlocate_y >=", value, "rlocateY");
            return (Criteria) this;
        }

        public Criteria andRlocateYLessThan(Float value) {
            addCriterion("rlocate_y <", value, "rlocateY");
            return (Criteria) this;
        }

        public Criteria andRlocateYLessThanOrEqualTo(Float value) {
            addCriterion("rlocate_y <=", value, "rlocateY");
            return (Criteria) this;
        }

        public Criteria andRlocateYIn(List<Float> values) {
            addCriterion("rlocate_y in", values, "rlocateY");
            return (Criteria) this;
        }

        public Criteria andRlocateYNotIn(List<Float> values) {
            addCriterion("rlocate_y not in", values, "rlocateY");
            return (Criteria) this;
        }

        public Criteria andRlocateYBetween(Float value1, Float value2) {
            addCriterion("rlocate_y between", value1, value2, "rlocateY");
            return (Criteria) this;
        }

        public Criteria andRlocateYNotBetween(Float value1, Float value2) {
            addCriterion("rlocate_y not between", value1, value2, "rlocateY");
            return (Criteria) this;
        }

        public Criteria andKidIsNull() {
            addCriterion("kid is null");
            return (Criteria) this;
        }

        public Criteria andKidIsNotNull() {
            addCriterion("kid is not null");
            return (Criteria) this;
        }

        public Criteria andKidEqualTo(Integer value) {
            addCriterion("kid =", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotEqualTo(Integer value) {
            addCriterion("kid <>", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidGreaterThan(Integer value) {
            addCriterion("kid >", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidGreaterThanOrEqualTo(Integer value) {
            addCriterion("kid >=", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidLessThan(Integer value) {
            addCriterion("kid <", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidLessThanOrEqualTo(Integer value) {
            addCriterion("kid <=", value, "kid");
            return (Criteria) this;
        }

        public Criteria andKidIn(List<Integer> values) {
            addCriterion("kid in", values, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotIn(List<Integer> values) {
            addCriterion("kid not in", values, "kid");
            return (Criteria) this;
        }

        public Criteria andKidBetween(Integer value1, Integer value2) {
            addCriterion("kid between", value1, value2, "kid");
            return (Criteria) this;
        }

        public Criteria andKidNotBetween(Integer value1, Integer value2) {
            addCriterion("kid not between", value1, value2, "kid");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table restaurant
     *
     * @mbg.generated do_not_delete_during_merge Sun Oct 23 17:51:11 KST 2022
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
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