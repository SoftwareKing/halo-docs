package org.xujin.doc.core.translation;

import org.xujin.doc.core.Document;
import org.xujin.doc.core.exception.DocumentTranslationException;

/**
 * 文档翻译器
 *
 * @author
 * @date 2018-04-19 15:48
 **/
public interface Translator {

    Document translate(Translation translation) throws DocumentTranslationException;

    String normalize(String path);

}
