package com.todolist_test2.demo.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andWexinIsNull() {
            addCriterion("wexin is null");
            return (Criteria) this;
        }

        public Criteria andWexinIsNotNull() {
            addCriterion("wexin is not null");
            return (Criteria) this;
        }

        public Criteria andWexinEqualTo(String value) {
            addCriterion("wexin =", value, "wexin");
            return (Criteria) this;
        }

        public Criteria andWexinNotEqualTo(String value) {
            addCriterion("wexin <>", value, "wexin");
            return (Criteria) this;
        }

        public Criteria andWexinGreaterThan(String value) {
            addCriterion("wexin >", value, "wexin");
            return (Criteria) this;
        }

        public Criteria andWexinGreaterThanOrEqualTo(String value) {
            addCriterion("wexin >=", value, "wexin");
            return (Criteria) this;
        }

        public Criteria andWexinLessThan(String value) {
            addCriterion("wexin <", value, "wexin");
            return (Criteria) this;
        }

        public Criteria andWexinLessThanOrEqualTo(String value) {
            addCriterion("wexin <=", value, "wexin");
            return (Criteria) this;
        }

        public Criteria andWexinLike(String value) {
            addCriterion("wexin like", value, "wexin");
            return (Criteria) this;
        }

        public Criteria andWexinNotLike(String value) {
            addCriterion("wexin not like", value, "wexin");
            return (Criteria) this;
        }

        public Criteria andWexinIn(List<String> values) {
            addCriterion("wexin in", values, "wexin");
            return (Criteria) this;
        }

        public Criteria andWexinNotIn(List<String> values) {
            addCriterion("wexin not in", values, "wexin");
            return (Criteria) this;
        }

        public Criteria andWexinBetween(String value1, String value2) {
            addCriterion("wexin between", value1, value2, "wexin");
            return (Criteria) this;
        }

        public Criteria andWexinNotBetween(String value1, String value2) {
            addCriterion("wexin not between", value1, value2, "wexin");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andHeadIconIsNull() {
            addCriterion("head_icon is null");
            return (Criteria) this;
        }

        public Criteria andHeadIconIsNotNull() {
            addCriterion("head_icon is not null");
            return (Criteria) this;
        }

        public Criteria andHeadIconEqualTo(String value) {
            addCriterion("head_icon =", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotEqualTo(String value) {
            addCriterion("head_icon <>", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconGreaterThan(String value) {
            addCriterion("head_icon >", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconGreaterThanOrEqualTo(String value) {
            addCriterion("head_icon >=", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconLessThan(String value) {
            addCriterion("head_icon <", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconLessThanOrEqualTo(String value) {
            addCriterion("head_icon <=", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconLike(String value) {
            addCriterion("head_icon like", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotLike(String value) {
            addCriterion("head_icon not like", value, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconIn(List<String> values) {
            addCriterion("head_icon in", values, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotIn(List<String> values) {
            addCriterion("head_icon not in", values, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconBetween(String value1, String value2) {
            addCriterion("head_icon between", value1, value2, "headIcon");
            return (Criteria) this;
        }

        public Criteria andHeadIconNotBetween(String value1, String value2) {
            addCriterion("head_icon not between", value1, value2, "headIcon");
            return (Criteria) this;
        }

        public Criteria andBgImageIsNull() {
            addCriterion("bg_image is null");
            return (Criteria) this;
        }

        public Criteria andBgImageIsNotNull() {
            addCriterion("bg_image is not null");
            return (Criteria) this;
        }

        public Criteria andBgImageEqualTo(String value) {
            addCriterion("bg_image =", value, "bgImage");
            return (Criteria) this;
        }

        public Criteria andBgImageNotEqualTo(String value) {
            addCriterion("bg_image <>", value, "bgImage");
            return (Criteria) this;
        }

        public Criteria andBgImageGreaterThan(String value) {
            addCriterion("bg_image >", value, "bgImage");
            return (Criteria) this;
        }

        public Criteria andBgImageGreaterThanOrEqualTo(String value) {
            addCriterion("bg_image >=", value, "bgImage");
            return (Criteria) this;
        }

        public Criteria andBgImageLessThan(String value) {
            addCriterion("bg_image <", value, "bgImage");
            return (Criteria) this;
        }

        public Criteria andBgImageLessThanOrEqualTo(String value) {
            addCriterion("bg_image <=", value, "bgImage");
            return (Criteria) this;
        }

        public Criteria andBgImageLike(String value) {
            addCriterion("bg_image like", value, "bgImage");
            return (Criteria) this;
        }

        public Criteria andBgImageNotLike(String value) {
            addCriterion("bg_image not like", value, "bgImage");
            return (Criteria) this;
        }

        public Criteria andBgImageIn(List<String> values) {
            addCriterion("bg_image in", values, "bgImage");
            return (Criteria) this;
        }

        public Criteria andBgImageNotIn(List<String> values) {
            addCriterion("bg_image not in", values, "bgImage");
            return (Criteria) this;
        }

        public Criteria andBgImageBetween(String value1, String value2) {
            addCriterion("bg_image between", value1, value2, "bgImage");
            return (Criteria) this;
        }

        public Criteria andBgImageNotBetween(String value1, String value2) {
            addCriterion("bg_image not between", value1, value2, "bgImage");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("last_login_time =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("last_login_time <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("last_login_time >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_time >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("last_login_time <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_login_time <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("last_login_time in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("last_login_time not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Byte value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Byte value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Byte value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Byte value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Byte value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Byte value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Byte> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Byte> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Byte value1, Byte value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Byte value1, Byte value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredIsNull() {
            addCriterion("account_non_expired is null");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredIsNotNull() {
            addCriterion("account_non_expired is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredEqualTo(Byte value) {
            addCriterion("account_non_expired =", value, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredNotEqualTo(Byte value) {
            addCriterion("account_non_expired <>", value, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredGreaterThan(Byte value) {
            addCriterion("account_non_expired >", value, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredGreaterThanOrEqualTo(Byte value) {
            addCriterion("account_non_expired >=", value, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredLessThan(Byte value) {
            addCriterion("account_non_expired <", value, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredLessThanOrEqualTo(Byte value) {
            addCriterion("account_non_expired <=", value, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredIn(List<Byte> values) {
            addCriterion("account_non_expired in", values, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredNotIn(List<Byte> values) {
            addCriterion("account_non_expired not in", values, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredBetween(Byte value1, Byte value2) {
            addCriterion("account_non_expired between", value1, value2, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredNotBetween(Byte value1, Byte value2) {
            addCriterion("account_non_expired not between", value1, value2, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedIsNull() {
            addCriterion("account_non_locked is null");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedIsNotNull() {
            addCriterion("account_non_locked is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedEqualTo(Byte value) {
            addCriterion("account_non_locked =", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedNotEqualTo(Byte value) {
            addCriterion("account_non_locked <>", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedGreaterThan(Byte value) {
            addCriterion("account_non_locked >", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedGreaterThanOrEqualTo(Byte value) {
            addCriterion("account_non_locked >=", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedLessThan(Byte value) {
            addCriterion("account_non_locked <", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedLessThanOrEqualTo(Byte value) {
            addCriterion("account_non_locked <=", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedIn(List<Byte> values) {
            addCriterion("account_non_locked in", values, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedNotIn(List<Byte> values) {
            addCriterion("account_non_locked not in", values, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedBetween(Byte value1, Byte value2) {
            addCriterion("account_non_locked between", value1, value2, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedNotBetween(Byte value1, Byte value2) {
            addCriterion("account_non_locked not between", value1, value2, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredIsNull() {
            addCriterion("credentials_non_expired is null");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredIsNotNull() {
            addCriterion("credentials_non_expired is not null");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredEqualTo(Byte value) {
            addCriterion("credentials_non_expired =", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredNotEqualTo(Byte value) {
            addCriterion("credentials_non_expired <>", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredGreaterThan(Byte value) {
            addCriterion("credentials_non_expired >", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredGreaterThanOrEqualTo(Byte value) {
            addCriterion("credentials_non_expired >=", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredLessThan(Byte value) {
            addCriterion("credentials_non_expired <", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredLessThanOrEqualTo(Byte value) {
            addCriterion("credentials_non_expired <=", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredIn(List<Byte> values) {
            addCriterion("credentials_non_expired in", values, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredNotIn(List<Byte> values) {
            addCriterion("credentials_non_expired not in", values, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredBetween(Byte value1, Byte value2) {
            addCriterion("credentials_non_expired between", value1, value2, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredNotBetween(Byte value1, Byte value2) {
            addCriterion("credentials_non_expired not between", value1, value2, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
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