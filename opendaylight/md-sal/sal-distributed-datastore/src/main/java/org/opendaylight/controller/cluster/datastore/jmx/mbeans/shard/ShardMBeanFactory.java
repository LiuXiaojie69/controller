/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.cluster.datastore.jmx.mbeans.shard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Basheeruddin syedbahm@cisco.com
 *
 */
public class ShardMBeanFactory {
    private static Map<String, ShardStats> shardMBeans =
        new HashMap<String, ShardStats>();

    public static ShardStats getShardStatsMBean(String shardName) {
        if (shardMBeans.containsKey(shardName)) {
            return shardMBeans.get(shardName);
        } else {
            ShardStats shardStatsMBeanImpl = new ShardStats(shardName);

            if (shardStatsMBeanImpl.registerMBean()) {
                shardMBeans.put(shardName, shardStatsMBeanImpl);
            }
            return shardStatsMBeanImpl;
        }
    }

}
