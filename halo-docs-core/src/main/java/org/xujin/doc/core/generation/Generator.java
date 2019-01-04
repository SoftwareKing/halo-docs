package org.xujin.doc.core.generation;

import java.io.IOException;

/**
 * 代码生成器
 *
 * @author
 * @date 2018-04-19 15:48
 **/
public interface Generator {

    void generate(Generation generation) throws IOException;

}
