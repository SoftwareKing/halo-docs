package io.detector;

/**
 * 后缀过滤器
 */
public class SuffixFilter implements Filter {
    private final String suffix;

    public SuffixFilter(String suffix) {
        if (suffix == null) {
            throw new IllegalArgumentException("suffix == null");
        }
        this.suffix = suffix;
    }

    @Override
    public boolean accept(Resource resource, FilterChain chain) {
        return resource.getName().endsWith(suffix) && chain.doNext(resource);
    }

    public String getSuffix() {
        return suffix;
    }
}
