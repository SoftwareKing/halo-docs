package org.xujin.docs.spring.mvc;

import org.xujin.doc.core.Document;
import org.xujin.doc.core.translation.Translation;

public class ControllerTranslation extends SpringMVCTranslation {
    private final Document document;

    public ControllerTranslation(Translation translation, Document document) {
        super(translation);
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }

}
