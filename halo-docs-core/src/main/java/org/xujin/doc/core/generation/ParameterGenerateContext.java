package org.xujin.doc.core.generation;

import org.xujin.doc.core.Controller;
import org.xujin.doc.core.Operation;
import org.xujin.doc.core.Parameter;

import java.util.List;

/**
 * Parameter生成上下文
 *
 * @author
 * @date 2018-07-10 11:23
 **/
public class ParameterGenerateContext extends OperationGenerateContext {
    private final List<Parameter> parameters;

    public ParameterGenerateContext(Generation generation, Controller controller, Operation operation, List<Parameter> parameters) {
        super(generation, controller, operation);
        this.parameters = parameters;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }
}
