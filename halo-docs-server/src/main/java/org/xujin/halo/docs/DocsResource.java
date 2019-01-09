package org.xujin.halo.docs;

import java.util.List;

/**
 * @author xujin
 */
public class DocsResource {

    private String name;
    private String location;
    private List<String> instanceInfoList;
    private String swaggerVersion;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getInstanceInfoList() {
        return instanceInfoList;
    }

    public void setInstanceInfoList(List<String> instanceInfoList) {
        this.instanceInfoList = instanceInfoList;
    }

    public String getSwaggerVersion() {
        return swaggerVersion;
    }

    public void setSwaggerVersion(String swaggerVersion) {
        this.swaggerVersion = swaggerVersion;
    }
}
