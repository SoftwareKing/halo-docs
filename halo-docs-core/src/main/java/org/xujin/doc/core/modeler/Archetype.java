package org.xujin.doc.core.modeler;

import org.xujin.doc.core.Document;
import org.xujin.doc.core.Schema;
import org.xujin.doc.core.supplier.Supplier;

/**
 * 结构
 *
 * @author
 * @date 2018-05-18 11:02
 **/
public class Archetype {
    private Document document;
    private String pkg;
    private boolean pkgForced;
    private Supplier supplier;
    private Schema schema;

    public Archetype() {
    }

    public Archetype(Document document, String pkg, boolean pkgForced, Supplier supplier, Schema schema) {
        this.document = document;
        this.pkg = pkg;
        this.pkgForced = pkgForced;
        this.supplier = supplier;
        this.schema = schema;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public boolean isPkgForced() {
        return pkgForced;
    }

    public void setPkgForced(boolean pkgForced) {
        this.pkgForced = pkgForced;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }
}
