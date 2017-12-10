/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.skywalking.apm.collector.configuration;

import java.util.Properties;
import org.skywalking.apm.collector.configuration.service.ApdexThresholdService;
import org.skywalking.apm.collector.configuration.service.IApdexThresholdService;
import org.skywalking.apm.collector.core.module.Module;
import org.skywalking.apm.collector.core.module.ModuleProvider;
import org.skywalking.apm.collector.core.module.ServiceNotProvidedException;

/**
 * @author peng-yongsheng
 */
public class ConfigurationModuleProvider extends ModuleProvider {

    @Override public String name() {
        return "default";
    }

    @Override public Class<? extends Module> module() {
        return ConfigurationModule.class;
    }

    @Override public void prepare(Properties config) throws ServiceNotProvidedException {
        this.registerServiceImplementation(IApdexThresholdService.class, new ApdexThresholdService());
    }

    @Override public void start(Properties config) throws ServiceNotProvidedException {

    }

    @Override public void notifyAfterCompleted() throws ServiceNotProvidedException {

    }

    @Override public String[] requiredModules() {
        return new String[0];
    }
}