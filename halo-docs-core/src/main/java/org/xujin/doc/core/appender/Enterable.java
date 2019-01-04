package org.xujin.doc.core.appender;

import java.io.IOException;

/**
 * 可回车的
 *
 * @author
 * @date 2018-05-02 14:19
 **/
public interface Enterable<T extends Enterable<T>> {

    char CRLF = '\n';

    /**
     * 回车
     *
     * @return {@code this}
     * @throws IOException IO异常
     */
    T enter() throws IOException;

}
