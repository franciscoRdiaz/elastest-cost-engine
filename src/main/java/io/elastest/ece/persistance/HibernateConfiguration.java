package io.elastest.ece.persistance;

/**
 * Copyright (c) 2017. Zuercher Hochschule fuer Angewandte Wissenschaften
 * All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 * <p>
 * Created by Manu Perez on 14/07/17.
 */


import io.elastest.ece.load.model.HibernateCredentials;
import io.elastest.ece.model.ElasTest.CostModel;
import io.elastest.ece.model.TJob;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
    public static Configuration createConfiguration(HibernateCredentials credentials) {
        Configuration conf = new Configuration();

        // add mandatory hibernate classes
        conf.addAnnotatedClass(TJob.class).addAnnotatedClass(CostModel.class);

        // now set properties
        conf.setProperty("hibernate.connection.driver_class", credentials.getHibernateDriver())
                .setProperty("hibernate.connection.url", credentials.getHibernateURL())
                .setProperty("hibernate.connection.username", credentials.getHibernateUsername())
                .setProperty("hibernate.connection.password", credentials.getHibernatePassword())
                .setProperty("hibernate.dialect", credentials.getHibernateDialect())
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("show_sql", "false");

        return conf;
    }
}