package org.xujin.doc.core.appender;

import java.io.IOException;

/**
 * 过滤拼接器
 *
 * @author
 * @date 2018-04-28 15:13
 **/
public abstract class FilterLineAppender<T extends FilterLineAppender<T>> extends AbstractLineAppender<T> implements LineAppender<T> {
    protected final LineAppender<?> appender;

    protected FilterLineAppender(LineAppender<?> appender) {
        this.appender = appender;
    }

    @Override
    protected void append(String line) throws IOException {
        appender.append(line).enter();
    }

}
