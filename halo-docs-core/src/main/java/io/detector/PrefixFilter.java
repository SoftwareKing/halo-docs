package io.detector;

/**
 * 前缀过滤器
 */
public class PrefixFilter implements Filter {
    private final String prefix;

    public PrefixFilter(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("prefix == null");
        }
        this.prefix = prefix;
    }

    @Override
    public boolean accept(Resource resource, FilterChain chain) {
        return resource.getName().startsWith(prefix) && chain.doNext(resource);
    }

    public String getPrefix() {
        return prefix;
    }
}
