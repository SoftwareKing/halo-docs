package io.detector;

/**
 * java类过滤器，superclass == null 时代表不关心是否是否个类的子类
 */
public class ClassFilter implements Filter {
    private final Class<?> superclass;

    public ClassFilter() {
        this(null);
    }

    public ClassFilter(Class<?> superclass) {
        this.superclass = superclass;
    }

    @Override
    public boolean accept(Resource resource, FilterChain chain) {
        return resource.isClass() && (superclass == null || superclass.isAssignableFrom(resource.toClass())) && chain.doNext(resource);
    }

    public Class<?> getSuperclass() {
        return superclass;
    }
}
