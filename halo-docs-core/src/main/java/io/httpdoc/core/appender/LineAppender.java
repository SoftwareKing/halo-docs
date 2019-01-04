package io.httpdoc.core.appender;

/**
 * 按行拼接器
 *
 * @author
 * @date 2018-05-02 13:35
 **/
public interface LineAppender<T extends LineAppender<T>> extends Appender<T>, Enterable<T> {

}
