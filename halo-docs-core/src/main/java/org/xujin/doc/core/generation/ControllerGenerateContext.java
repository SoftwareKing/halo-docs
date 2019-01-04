package org.xujin.doc.core.generation;

import org.xujin.doc.core.Controller;

/**
 * Controller生成上下文
 *
 * @author
 * @date 2018-07-10 10:43
 **/
public class ControllerGenerateContext extends GenerateContext {
    private final Controller controller;

    public ControllerGenerateContext(Generation generation, Controller controller) {
        super(generation);
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }

}
