package io.httpdoc.core;

/**
 * 排序的
 *
 * @author
 * 2018/11/7
 */
public interface Ordered<T extends Ordered<T>> extends Comparable<T> {

    int getOrder();

    void setOrder(int order);

}
