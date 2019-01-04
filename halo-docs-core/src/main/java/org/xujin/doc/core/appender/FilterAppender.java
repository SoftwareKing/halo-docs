package org.xujin.doc.core.appender;

import java.io.IOException;

/**
 * 过滤拼接器
 *
 * @author
 * @date 2018-04-28 15:13
 **/
public abstract class FilterAppender<T extends FilterAppender<T>> extends AbstractAppender<T> implements Appender<T> {
    protected final Appender<?> appender;

    protected FilterAppender(Appender<?> appender) {
        this.appender = appender;
    }

    @Override
    public T append(char c) throws IOException {
        validate();
        appender.append(c);
        return (T) this;
    }

}
