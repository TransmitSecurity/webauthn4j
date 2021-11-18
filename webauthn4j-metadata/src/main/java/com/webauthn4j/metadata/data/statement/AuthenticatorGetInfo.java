/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.metadata.data.statement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.webauthn4j.data.attestation.authenticator.AAGUID;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * In the case of ECDAA attestation, the ECDAA-Issuer's trust anchor must be specified in this field.
 */
public class AuthenticatorGetInfo implements Serializable {
    private final List<String> versions;
    private final List<String> extensions;
    private final String aaguid;
    private final JsonNode options;
    private final Long maxMsgSize;
    private final List<Long> pinUvAuthProtocols;
    private final Long maxCredentialCountInList;
    private final Long maxCredentialIdLength;
    private final List<String> transports;
    private final List<PublicKeyCredentialParameters> algorithms;
    private final Long maxAuthenticatorConfigLength;
    private final Long defaultCredProtect;

    @JsonCreator
    public AuthenticatorGetInfo(
            @JsonProperty("versions") List<String> versions,
            @JsonProperty("extensions") List<String> extensions,
            @JsonProperty("aaguid") String aaguid,
            @JsonProperty("options") JsonNode options,
            @JsonProperty("maxMsgSize") Long maxMsgSize,
            @JsonProperty("pinUvAuthProtocols") List<Long> pinUvAuthProtocols,
            @JsonProperty("maxCredentialCountInList") Long maxCredentialCountInList,
            @JsonProperty("maxCredentialIdLength") Long maxCredentialIdLength,
            @JsonProperty("transports") List<String> transports,
            @JsonProperty("algorithms") List<PublicKeyCredentialParameters> algorithms,
            @JsonProperty("maxAuthenticatorConfigLength") Long maxAuthenticatorConfigLength,
            @JsonProperty("defaultCredProtect") Long defaultCredProtect) {

        this.versions = versions;
        this.extensions = extensions;
        this.aaguid = aaguid;
        this.options = options;
        this.maxMsgSize = maxMsgSize;
        this.pinUvAuthProtocols = pinUvAuthProtocols;
        this.maxCredentialCountInList = maxCredentialCountInList;
        this.maxCredentialIdLength = maxCredentialIdLength;
        this.transports = transports;
        this.algorithms = algorithms;
        this.maxAuthenticatorConfigLength = maxAuthenticatorConfigLength;
        this.defaultCredProtect = defaultCredProtect;

    }

    @JsonGetter("versions")
    public List<String> getVersions() {
        return versions;
    }

    @JsonGetter("extensions")
    public List<String> getExtensions() {
        return extensions;
    }

    @JsonGetter("aaguid")
    public String getAgguid() {
        return aaguid;
    }

    @JsonGetter("options")
    public JsonNode getOptions() {
        return options;
    }

    @JsonGetter("maxMsgSize")
    public Long getMaxMsgSize() {
        return maxMsgSize;
    }

    @JsonGetter("pinUvAuthProtocols")
    public List<Long> getPinUvAuthProtocols() {
        return pinUvAuthProtocols;
    }

    @JsonGetter("maxCredentialCountInList")
    public Long getMaxCredentialCountInList() {
        return maxCredentialCountInList;
    }

    @JsonGetter("maxCredentialIdLength")
    public Long getMaxCredentialIdLength() {
        return maxCredentialIdLength;
    }

    @JsonGetter("transports")
    public List<String> getTransports() {
        return transports;
    }

    @JsonGetter("algorithms")
    public List<PublicKeyCredentialParameters> getAlgorithms() {
        return algorithms;
    }

    @JsonGetter("maxAuthenticatorConfigLength")
    public Long getMaxAuthenticatorConfigLength() {
        return maxAuthenticatorConfigLength;
    }

    @JsonGetter("defaultCredProtect")
    public Long getDefaultCredProtect() {
        return defaultCredProtect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticatorGetInfo that = (AuthenticatorGetInfo) o;
        return Objects.equals(versions, that.versions) &&
                Objects.equals(extensions, that.extensions) &&
                Objects.equals(aaguid, that.aaguid) &&
                Objects.equals(options, that.options) &&
                Objects.equals(maxMsgSize, that.maxMsgSize) &&
                Objects.equals(pinUvAuthProtocols, that.pinUvAuthProtocols) &&
                Objects.equals(maxCredentialCountInList, that.maxCredentialCountInList) &&
                Objects.equals(maxCredentialIdLength, that.maxCredentialIdLength) &&
                Objects.equals(transports, that.transports) &&
                Objects.equals(algorithms, that.algorithms) &&
                Objects.equals(maxAuthenticatorConfigLength, that.maxAuthenticatorConfigLength) &&
                Objects.equals(defaultCredProtect, that.defaultCredProtect);
    }

    @Override
    public int hashCode() {

        return Objects.hash(versions,
                            extensions,
                            aaguid,
                            options,
                            maxMsgSize,
                            pinUvAuthProtocols,
                            maxCredentialCountInList,
                            maxCredentialIdLength,
                            transports,
                            algorithms,
                            maxAuthenticatorConfigLength,
                            defaultCredProtect);
    }
}
