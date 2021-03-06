package org.xujin.doc.core.fragment.annotation;

import org.xujin.doc.core.Preference;
import org.xujin.doc.core.appender.LineAppender;
import org.xujin.doc.core.type.HDClass;

import java.io.IOException;
import java.util.Set;

public class HDAnnotationClass extends HDAnnotationConstant {
    private final HDClass clazz;

    public HDAnnotationClass(HDClass clazz) {
        if (clazz == null) throw new NullPointerException();
        this.clazz = clazz;
    }

    public HDAnnotationClass(Class<?> clazz) {
        this(clazz != null ? new HDClass(clazz) : null);
    }

    public HDAnnotationClass(String className) {
        this(className != null ? new HDClass(className) : null);
    }

    @Override
    public <T extends LineAppender<T>> void joinTo(T appender, Preference preference) throws IOException {
        appender.append(clazz).append(".class");
    }

    @Override
    public Set<String> imports() {
        return clazz.imports();
    }
}
