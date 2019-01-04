package org.xujin.doc.core.strategy;

import java.io.IOException;

/**
 * 过滤器策略
 *
 * @author
 * @date 2018-07-09 13:28
 **/
public abstract class FilterStrategy implements Strategy {
    protected final Strategy strategy;

    protected FilterStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void execute(Task task) throws IOException {
        strategy.execute(task);
    }

}
