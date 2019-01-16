package org.xujin.halo.docs.ribbon;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import com.netflix.zuul.context.RequestContext;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Random;

/**
 * 自定义负载均衡策略解决指定实例IP调用问题
 *
 */
public class InstanceInfoByIpRibbonRule extends ZoneAvoidanceRule {

    Random rand = new Random();

    @Override
    public Server choose(Object key) {
        RequestContext ctx = RequestContext.getCurrentContext();
        String designatedHost = ctx.getRequest().getHeader("designatedHost");
        List<Server> serverList = this.getPredicate()
                .getEligibleServers(this.getLoadBalancer().getAllServers(), key);
        if (CollectionUtils.isEmpty(serverList)) {
            return null;
        }
        if(StringUtils.isEmpty(designatedHost)){
            return getServerRand();
        }else{
            for (Server server:serverList) {
                if(designatedHost.equals(String.valueOf(server))){
                    return server;
                }
            }

        }
        return null;
    }
    private Server getServerRand() {
        Server server = null;
        List<Server> upList = this.getLoadBalancer().getReachableServers();
        List<Server> allList = this.getLoadBalancer().getAllServers();
        int serverCount = allList.size();
        if (serverCount == 0) {
            return null;
        }
        int index = rand.nextInt(serverCount);
        server = (Server)upList.get(index);
        if (server == null) {
            Thread.yield();
        } else {
            if (server.isAlive()) {
                return server;
            }
            server = null;
        }
        return server;
    }


}

