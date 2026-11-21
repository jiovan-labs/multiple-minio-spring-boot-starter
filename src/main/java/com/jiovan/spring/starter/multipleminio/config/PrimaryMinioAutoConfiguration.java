/*
 * Copyright (c) 2020 Jiovan Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jiovan.spring.starter.multipleminio.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.jiovan.plexus.spring.toolkit.property.MinioProperties;
import com.jiovan.plexus.spring.toolkit.util.MinioConfigWraps;
import io.minio.MinioClient;
import jakarta.annotation.Nonnull;


/**
 * Primary configuration for minio client
 *
 * @author David Hsing
 *
 * @see io.minio.MinioClient
 * @see "https://min.io"
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(prefix = PrimaryMinioAutoConfiguration.PROPERTIES_PREFIX, name = "endpoint")
@ConditionalOnClass(value = MinioClient.class)
public class PrimaryMinioAutoConfiguration {
    public static final String PROPERTIES_PREFIX = "jiovan.multiple-minio.primary";    // $NON-NLS-1$
    public static final String MINIO_PROPERTIES = "primaryMinioProperties";    // $NON-NLS-1$
    public static final String MINIO_CLIENT = "primaryMinioClient";    // $NON-NLS-1$

    /**
     * Returns the minio properties bean bound from the configured properties prefix
     *
     * @return the bound minio properties bean
     */
    @Primary
    @Bean(name = MINIO_PROPERTIES)
    @ConfigurationProperties(prefix = PROPERTIES_PREFIX)
    @ConditionalOnMissingBean(name = MINIO_PROPERTIES)
    public MinioProperties minioProperties() {
        return new MinioProperties();
    }

    /**
     * Returns the {@link io.minio.MinioClient} bean configured from the given minio properties
     *
     * @param properties the minio properties holding the endpoint and credentials
     *
     * @return the configured minio client
     *
     * @throws java.lang.Exception if the minio client cannot be created
     */
    @Primary
    @Bean(name = MINIO_CLIENT)
    @ConditionalOnBean(name = MINIO_PROPERTIES, value = MinioProperties.class)
    @ConditionalOnMissingBean(name = MINIO_CLIENT)
    public MinioClient minioClient(@Qualifier(value = MINIO_PROPERTIES) @Nonnull MinioProperties properties) throws Exception {
        return MinioConfigWraps.minioClient(properties);
    }
}
