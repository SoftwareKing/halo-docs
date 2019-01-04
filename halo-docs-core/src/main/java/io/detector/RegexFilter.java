package io.detector;

/**
 * 正则表达式过滤器
 */
public class RegexFilter implements Filter {
    private final String regex;

    public RegexFilter(String regex) {
        if (regex == null) {
            throw new IllegalArgumentException("regex == null");
        }
        this.regex = regex;
    }

    @Override
    public boolean accept(Resource resource, FilterChain chain) {
        return resource.getName().matches(regex) && chain.doNext(resource);
    }

    public String getRegex() {
        return regex;
    }
}
