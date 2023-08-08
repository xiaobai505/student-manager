package com.agoni.core.omp;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.*;
import com.agoni.core.omp.enums.Operator;
import com.agoni.core.omp.enums.OrderByEnumFunction;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.ColumnCache;
import com.baomidou.mybatisplus.core.toolkit.support.LambdaMeta;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class OmpDbUtil {
    private static final String ORDER = "order";
    private static final String ORDER_BY = "orderBy";
    private static final String PAGE = "page";
    private static final String LIMIT = "limit";
    private static final List<String> EXCLUDE_FIELD = CollUtil.newArrayList(new String[]{"page", "limit", "orderBy", "order"});
    private static final List<String> OPERATORS = (List)CollUtil.newArrayList(Operator.values()).stream().map(Operator::getValue).collect(Collectors.toList());

    public OmpDbUtil() {
    }

    public static <T> void fillOrderBy(Object query, QueryWrapper<T> queryWrapper) {
        fillOrderBy(query, queryWrapper, queryWrapper.getEntityClass());
    }

    public static <T> void fillOrderBy(Object query, QueryWrapper<T> queryWrapper, Class<T> aClass) {
        if (query != null) {
            String orderByProperties = (String) BeanUtil.getProperty(query, "orderBy");
            String order = (String)BeanUtil.getProperty(query, "order");
            if (!StrUtil.isEmpty(orderByProperties)) {
                boolean isAsc = StrUtil.equals("ASC", order, true);
                fillOrderBy(queryWrapper, aClass, isAsc, orderByProperties.split(","));
            }
        }
    }

    public static <T> void fillOrderBy(Object query, OrderByEnumFunction orderEnum, QueryWrapper<T> queryWrapper, Class<T> aClass) {
        if (query != null) {
            if (orderEnum != null && orderEnum.apply() != null) {
                String orderByProperties = (String)BeanUtil.getProperty(query, "orderBy");
                String order = (String)BeanUtil.getProperty(query, "order");
                if (!StrUtil.isEmpty(orderByProperties)) {
                    HashMap<String, String> mapping = orderEnum.apply();
                    List<String> orderByPropertyArray = (List)StrUtil.split(orderByProperties, ",").stream().map((column) -> {
                        String mappingProperty = (String)mapping.get(column);
                        return StrUtil.isNotEmpty(mappingProperty) ? mappingProperty : column;
                    }).collect(Collectors.toList());
                    boolean isAsc = StrUtil.equals("ASC", order, true);
                    fillOrderBy(queryWrapper, aClass, isAsc, (String[]) ArrayUtil.toArray(orderByPropertyArray, String.class));
                }
            } else {
                fillOrderBy(query, queryWrapper, aClass);
            }
        }
    }

    public static <T> void fillOrderBy(QueryWrapper<T> queryWrapper, Class<T> aClass, boolean isAsc, String... orderByProperties) {
        if (orderByProperties != null && orderByProperties.length != 0) {
            List<String> orderByColumns = (List)CollUtil.newArrayList(orderByProperties).stream().filter((orderByProperty) -> {
                return StrUtil.isNotEmpty(getColumnByProperty(aClass, orderByProperty));
            }).map((orderByProperty) -> {
                return getColumnByProperty(aClass, orderByProperty);
            }).collect(Collectors.toList());
            if (!CollUtil.isEmpty(orderByColumns)) {
                queryWrapper.orderBy(true, isAsc, orderByColumns);
            }
        }
    }

    public static <T> void fillOrderBy(QueryWrapper<T> queryWrapper, boolean isAsc, String... orderByProperties) {
        if (orderByProperties != null && orderByProperties.length != 0) {
            List<String> orderByColumns = (List)CollUtil.newArrayList(orderByProperties).stream().map(CharSequenceUtil::toUnderlineCase).collect(Collectors.toList());
            queryWrapper.orderBy(true, isAsc, orderByColumns);
        }
    }

    public static <T> String getColumnByProperty(Class<T> clazz, String property) {
        Map<String, ColumnCache> columnCacheMap = LambdaUtils.getColumnMap(clazz);
        if (StrUtil.isNotEmpty(property)) {
            property = StrUtil.toCamelCase(property).toUpperCase();
            ColumnCache columnCache = (ColumnCache)columnCacheMap.get(property);
            if (columnCache != null) {
                return columnCache.getColumn();
            }
        }

        return null;
    }

    public static <T> void autoCondition(Object query, QueryWrapper<T> queryWrapper, Class<T> poClass) {
        if (query != null) {
            queryWrapper.setEntityClass(poClass);
            List<Field> fields = CollUtil.newArrayList(ClassUtil.getDeclaredFields(query.getClass()));
            fields.stream().filter((field) -> {
                return !EXCLUDE_FIELD.contains(field.getName());
            }).forEach((field) -> {
                AutoWrapper annotation = (AutoWrapper) AnnotationUtil.getAnnotation(field, AutoWrapper.class);
                Object queryValue = ReflectUtil.getFieldValue(query, field);
                if (annotation == null) {
                    setCondition(queryWrapper, field.getName(), queryValue);
                } else {
                    String property = getColumnByProperty(poClass, annotation.name());
                    if (property != null) {
                        extracted(queryWrapper, queryValue, property, annotation.condition());
                    }
                }

            });
        }
    }

    public static <T> void autoCondition(Object query, QueryWrapper<T> queryWrapper) {
        autoCondition(query, queryWrapper, queryWrapper.getEntityClass());
    }

    public static <T> void autoWrapper(Object query, QueryWrapper<T> queryWrapper, Class<T> poClass) {
        autoCondition(query, queryWrapper, poClass);
        autoSelect(query, queryWrapper);
        fillOrderBy(query, queryWrapper);
    }

    private static <T> void autoSelect(Object query, QueryWrapper<T> queryWrapper) {
        Object columns = ReflectUtil.getFieldValue(query, "columns");
        if (ObjectUtil.isNotEmpty(columns)) {
            queryWrapper.select(columns.toString());
        }
    }

    public static <T> void autoWrapper(Object query, QueryWrapper<T> queryWrapper) {
        autoCondition(query, queryWrapper, queryWrapper.getEntityClass());
        fillOrderBy(query, queryWrapper);
    }

    /** @deprecated */
    @Deprecated
    public static <T, R, S> void upDown(T po, boolean isUp, BaseMapper<T> mapper, SFunction<T, R> getOrderFunction, SFunction<T, S> getParentFunction) {
        R orderNum = getOrderFunction.apply(po);
        S parent = getParentFunction.apply(po);
        QueryWrapper<T> queryWrapper = Wrappers.query();
        ((LambdaQueryWrapper)((LambdaQueryWrapper)((LambdaQueryWrapper)((LambdaQueryWrapper)queryWrapper.lambda().isNull(parent == null, getParentFunction)).eq(parent != null, getParentFunction, parent)).lt(isUp, getOrderFunction, orderNum)).gt(!isUp, getOrderFunction, orderNum)).orderBy(true, !isUp, getOrderFunction);
        upDown(po, mapper, getOrderFunction, orderNum, queryWrapper);
    }

    public static <T, R, S> void upDown(T po, boolean isUp, BaseMapper<T> mapper, SFunction<T, R> getOrderFunction, SFunction<T, S> getParentFunction, QueryWrapper<T> queryWrapper) {
        R orderNum = getOrderFunction.apply(po);
        S parent = getParentFunction.apply(po);
        ((LambdaQueryWrapper)((LambdaQueryWrapper)((LambdaQueryWrapper)((LambdaQueryWrapper)queryWrapper.lambda().isNull(parent == null, getParentFunction)).eq(parent != null, getParentFunction, parent)).lt(isUp, getOrderFunction, orderNum)).gt(!isUp, getOrderFunction, orderNum)).orderBy(true, !isUp, getOrderFunction);
        upDown(po, mapper, getOrderFunction, orderNum, queryWrapper);
    }

    public static <T, R, S> void upDown(T po, boolean isUp, BaseMapper<T> mapper, SFunction<T, R> getOrderFunction) {
        R orderNum = getOrderFunction.apply(po);
        QueryWrapper<T> queryWrapper = Wrappers.query();
        ((LambdaQueryWrapper)((LambdaQueryWrapper)queryWrapper.lambda().lt(isUp, getOrderFunction, orderNum)).gt(!isUp, getOrderFunction, orderNum)).orderBy(true, !isUp, getOrderFunction);
        upDown(po, mapper, getOrderFunction, orderNum, queryWrapper);
    }

    public static <T, R, S> void upDown(T po, boolean isUp, BaseMapper<T> mapper, SFunction<T, R> getOrderFunction, QueryWrapper<T> queryWrapper) {
        R orderNum = getOrderFunction.apply(po);
        ((LambdaQueryWrapper)((LambdaQueryWrapper)queryWrapper.lambda().lt(isUp, getOrderFunction, orderNum)).gt(!isUp, getOrderFunction, orderNum)).orderBy(true, !isUp, getOrderFunction);
        upDown(po, mapper, getOrderFunction, orderNum, queryWrapper);
    }

    private static <T> void setCondition(QueryWrapper<T> queryWrapper, String queryName, Object queryValue) {
        Class<T> poClass = queryWrapper.getEntityClass();
        String property = getColumnByProperty(poClass, queryName);
        if (property != null) {
            extracted(queryWrapper, queryValue, property, Operator.EQ);
        } else {
            List<String> list = (List)OPERATORS.stream().filter((item) -> {
                return StrUtil.endWith(queryName, item);
            }).collect(Collectors.toList());
            if (!CollUtil.isEmpty(list)) {
                String operator;
                if (list.size() > 1) {
                    operator = (String)list.stream().max(Comparator.comparing(String::length)).get();
                } else {
                    operator = (String)list.get(0);
                }

                String queryColumn = StrUtil.subBefore(queryName, operator, true);
                String column = getColumnByProperty(poClass, queryColumn);
                if (column != null) {
                    Operator operatorEnum = (Operator) EnumUtil.fromString(Operator.class, StrUtil.toUnderlineCase(operator).toUpperCase());
                    extracted(queryWrapper, queryValue, column, operatorEnum);
                }
            }
        }
    }

    private static <T> void extracted(QueryWrapper<T> queryWrapper, Object queryValue, String column, Operator operatorEnum) {
        boolean isNotEmpty = true;
        if (queryValue instanceof String) {
            isNotEmpty = StrUtil.isNotEmpty((String)queryValue);
        }

        Collection collection;
        switch (operatorEnum) {
            case EQ:
                queryWrapper.eq(queryValue != null && isNotEmpty, column, queryValue);
                break;
            case GE:
                queryWrapper.ge(queryValue != null && isNotEmpty, column, queryValue);
                break;
            case GT:
                queryWrapper.gt(queryValue != null && isNotEmpty, column, queryValue);
                break;
            case IN:
                if (queryValue instanceof String) {
                    queryWrapper.in(isNotEmpty, column, StrUtil.split((String)queryValue, ","));
                }

                if (queryValue instanceof Collection) {
                    collection = (Collection)queryValue;
                    queryWrapper.in(CollUtil.isNotEmpty(collection), column, collection);
                }
                break;
            case NOT_IN:
                if (queryValue instanceof String) {
                    queryWrapper.notIn(isNotEmpty, column, StrUtil.split((String)queryValue, ","));
                }

                if (queryValue instanceof Collection) {
                    collection = (Collection)queryValue;
                    queryWrapper.notIn(CollUtil.isNotEmpty(collection), column, collection);
                }
                break;
            case LE:
                queryWrapper.le(queryValue != null && isNotEmpty, column, queryValue);
                break;
            case LT:
                queryWrapper.lt(queryValue != null && isNotEmpty, column, queryValue);
                break;
            case NE:
                queryWrapper.ne(queryValue != null && isNotEmpty, column, queryValue);
                break;
            case LIKE:
                queryWrapper.like(queryValue != null && isNotEmpty, column, queryValue);
                break;
            case IS_NULL:
                queryWrapper.isNull(column != null, column);
                break;
            case IS_NOT_NULL:
                queryWrapper.isNotNull(column != null, column);
                break;
            case NOT_LIKE:
                queryWrapper.notLike(queryValue != null && isNotEmpty, column, queryValue);
                break;
            case LIKE_LEFT:
                queryWrapper.likeLeft(queryValue != null && isNotEmpty, column, queryValue);
                break;
            case LIKE_RIGHT:
                queryWrapper.likeRight(queryValue != null && isNotEmpty, column, queryValue);
        }

    }

    private static <T, R> void upDown(T po, BaseMapper<T> mapper, SFunction<T, R> getOrderFunction, R orderNum, QueryWrapper<T> queryWrapper) {
        Page<T> page = new Page(1L, 1L);
        Optional<T> first = ((Page)mapper.selectPage(page, queryWrapper)).getRecords().stream().findFirst();
        if (first.isPresent()) {
            T exchangeBigTree = first.get();
            LambdaMeta meta = LambdaUtils.extract(getOrderFunction);
            String methodName = meta.getImplMethodName();
            String orderNumName = getFieldName(methodName);
            BeanUtil.setFieldValue(po, orderNumName, getOrderFunction.apply(exchangeBigTree));
            BeanUtil.setFieldValue(exchangeBigTree, orderNumName, orderNum);
            mapper.updateById(exchangeBigTree);
            mapper.updateById(po);
        }
    }

    private static String getFieldName(String methodName) {
        String orderNumName;
        if (!methodName.startsWith("get") && !methodName.startsWith("set")) {
            if (!methodName.startsWith("is")) {
                throw new IllegalArgumentException("Invalid Getter or Setter name: " + methodName);
            }

            orderNumName = StrUtil.removePreAndLowerFirst(methodName, 2);
        } else {
            orderNumName = StrUtil.removePreAndLowerFirst(methodName, 3);
        }

        return orderNumName;
    }
}
