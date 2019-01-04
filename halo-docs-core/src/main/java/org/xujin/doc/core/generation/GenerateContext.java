package org.xujin.doc.core.generation;

import org.xujin.doc.core.Document;
import org.xujin.doc.core.strategy.Strategy;
import org.xujin.doc.core.supplier.Supplier;

/**
 * 生成上下文
 *
 * @author
 * @date 2018-07-10 10:43
 **/
public abstract class GenerateContext {
    private final Generation generation;

    public GenerateContext(Generation generation) {
        this.generation = generation;
    }

    public Generation getGeneration() {
        return generation;
    }

    public Document getDocument() {
        return generation.getDocument();
    }

    public String getDirectory() {
        return generation.getDirectory();
    }

    public String getPkg() {
        return generation.getPkg();
    }

    public boolean isPkgForced() {
        return generation.isPkgForced();
    }

    public Supplier getSupplier() {
        return generation.getSupplier();
    }

    public Strategy getStrategy() {
        return generation.getStrategy();
    }
}
