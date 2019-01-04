package org.xujin.doc.core.generation;

import org.xujin.doc.core.Controller;
import org.xujin.doc.core.Operation;

/**
 * Operation生成上下文
 *
 * @author
 * @date 2018-07-10 10:53
 **/
public class OperationGenerateContext extends ControllerGenerateContext {
    private final Operation operation;

    public OperationGenerateContext(Generation generation, Controller controller, Operation operation) {
        super(generation, controller);
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }
}
