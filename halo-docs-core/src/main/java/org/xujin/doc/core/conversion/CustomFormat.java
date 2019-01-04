package org.xujin.doc.core.conversion;

/**
 * 自定义的转换格式
 *
 * @author
 * @date 2018-04-19 11:03
 **/
public class CustomFormat implements Format {
    private static final long serialVersionUID = 6084957981476869704L;

    private String refPrefix = REF_PREFIX;
    private String refSuffix = REF_SUFFIX;
    private String mapPrefix = MAP_PREFIX;
    private String mapSuffix = MAP_SUFFIX;
    private String arrPrefix = ARR_PREFIX;
    private String arrSuffix = ARR_SUFFIX;
    private boolean pkgIncluded = true;
    private boolean canonical = true;

    @Override
    public String getRefPrefix() {
        return refPrefix;
    }

    public void setRefPrefix(String refPrefix) {
        this.refPrefix = refPrefix;
    }

    @Override
    public String getRefSuffix() {
        return refSuffix;
    }

    public void setRefSuffix(String refSuffix) {
        this.refSuffix = refSuffix;
    }

    @Override
    public String getMapPrefix() {
        return mapPrefix;
    }

    public void setMapPrefix(String mapPrefix) {
        this.mapPrefix = mapPrefix;
    }

    @Override
    public String getMapSuffix() {
        return mapSuffix;
    }

    public void setMapSuffix(String mapSuffix) {
        this.mapSuffix = mapSuffix;
    }

    @Override
    public String getArrPrefix() {
        return arrPrefix;
    }

    public void setArrPrefix(String arrPrefix) {
        this.arrPrefix = arrPrefix;
    }

    @Override
    public String getArrSuffix() {
        return arrSuffix;
    }

    public void setArrSuffix(String arrSuffix) {
        this.arrSuffix = arrSuffix;
    }

    @Override
    public boolean isPkgIncluded() {
        return pkgIncluded;
    }

    public void setPkgIncluded(boolean pkgIncluded) {
        this.pkgIncluded = pkgIncluded;
    }

    @Override
    public boolean isCanonical() {
        return canonical;
    }

    public void setCanonical(boolean canonical) {
        this.canonical = canonical;
    }
}
