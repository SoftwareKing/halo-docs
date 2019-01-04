package io.httpdoc.core.appender;

import java.io.IOException;

/**
 * 可回车的拼接器
 *
 * @author
 * @date 2018-05-02 14:21
 **/
public abstract class EnterableAppender<T extends EnterableAppender<T>> extends AbstractAppender<T> implements Enterable<T> {

    @Override
    public T enter() throws IOException {
        return append(CRLF);
    }

}
