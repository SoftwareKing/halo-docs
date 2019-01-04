package org.xujin.docs.spring.mvc;

import org.xujin.doc.core.interpretation.Interpreter;
import org.xujin.doc.core.supplier.Supplier;
import org.xujin.doc.core.translation.Container;
import org.xujin.doc.core.translation.Translation;

public abstract class SpringMVCTranslation {
    private final Translation translation;

    protected SpringMVCTranslation(Translation translation) {
        this.translation = translation;
    }

    protected SpringMVCTranslation(SpringMVCTranslation parent) {
        this.translation = parent.translation;
    }

    public String getHttpdoc() {
        return translation.getHttpdoc();
    }

    public String getProtocol() {
        return translation.getProtocol();
    }

    public String getHostname() {
        return translation.getHostname();
    }

    public Integer getPort() {
        return translation.getPort();
    }

    public String getContext() {
        return translation.getContext();
    }

    public String getVersion() {
        return translation.getVersion();
    }

    public Container getContainer() {
        return translation.getContainer();
    }

    public Supplier getSupplier() {
        return translation.getSupplier();
    }

    public Interpreter getInterpreter() {
        return translation.getInterpreter();
    }

}
