/*
 * Copyright <2020> Amazon.com, final Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, final Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, final WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, final either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */

package software.amazon.neptune.opencypher;

import com.google.common.collect.ImmutableList;
import software.amazon.jdbc.utilities.ConnectionProperties;
import java.util.List;
import java.util.Properties;

/**
 * OpenCypher connection properties class.
 */
public class OpenCypherConnectionProperties {
    private final Properties properties = new Properties();
    private final List<String> keys = ImmutableList.of(
            ConnectionProperties.ENDPOINT_KEY,              // "user", "password"
            ConnectionProperties.CONNECTION_TIMEOUT_KEY,
            ConnectionProperties.CONNECTION_RETRY_COUNT_KEY);

    /**
     * Constructor for OpenCypherConnectionProperties.
     * @param properties Properties to examine and extract key details from.
     */
    public OpenCypherConnectionProperties(final Properties properties) {
        keys.forEach(key -> this.properties.put(key, properties.get(key)));
    }

    protected String getEndpoint() {
        return (String) properties.get(ConnectionProperties.ENDPOINT_KEY);
    }

    protected String getUser() {
        return (String) properties.get("user");
    }

    protected String getPassword() {
        return (String) properties.get("password");
    }

    protected int getConnectionTimeout() {
        return (int) properties.get(ConnectionProperties.CONNECTION_TIMEOUT_KEY);
    }

    protected int getConnectionRetryCount() {
        return (int) properties.get(ConnectionProperties.CONNECTION_RETRY_COUNT_KEY);
    }
}
