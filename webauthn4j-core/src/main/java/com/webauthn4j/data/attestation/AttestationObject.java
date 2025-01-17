/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.data.attestation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.webauthn4j.data.attestation.authenticator.AuthenticatorData;
import com.webauthn4j.data.attestation.statement.AttestationStatement;
import com.webauthn4j.data.extension.authenticator.RegistrationExtensionAuthenticatorOutput;
import com.webauthn4j.util.AssertUtil;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.io.Serializable;
import java.util.Objects;

/**
 * The attestation object contains both authenticator data and an attestation statement.
 *
 * @see <a href="https://www.w3.org/TR/webauthn-1/#sctn-attestation">§6.4 Attestation</a>
 * @see <a href="https://www.w3.org/TR/webauthn-1/#generating-an-attestation-object">§6.4.4 Generating an Attestation Object</a>
 */
public class AttestationObject implements Serializable {

    //~ Instance fields ================================================================================================
    @JsonProperty("authData")
    private final AuthenticatorData<RegistrationExtensionAuthenticatorOutput> authenticatorData;

    @JsonProperty("attStmt")
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
            property = "fmt"
    )
    private final AttestationStatement attestationStatement;

    @JsonCreator
    public AttestationObject(
            @NonNull @JsonProperty("authData") AuthenticatorData<RegistrationExtensionAuthenticatorOutput> authenticatorData,
            @NonNull @JsonProperty("attStmt") AttestationStatement attestationStatement) {
        AssertUtil.notNull(authenticatorData, "authenticatorData must not be null");
        AssertUtil.notNull(attestationStatement, "attestationStatement must not be null");
        this.authenticatorData = authenticatorData;
        this.attestationStatement = attestationStatement;
    }

    public @NonNull AuthenticatorData<RegistrationExtensionAuthenticatorOutput> getAuthenticatorData() {
        return authenticatorData;
    }

    @JsonProperty("fmt")
    public @NonNull String getFormat() {
        return attestationStatement.getFormat();
    }

    public @NonNull AttestationStatement getAttestationStatement() {
        return attestationStatement;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttestationObject that = (AttestationObject) o;
        return Objects.equals(authenticatorData, that.authenticatorData) &&
                Objects.equals(attestationStatement, that.attestationStatement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authenticatorData, attestationStatement);
    }

    @Override
    public String toString() {
        return "AttestationObject(" +
                "authenticatorData=" + authenticatorData +
                ", fmt=" + getFormat() +
                ", attestationStatement=" + attestationStatement +
                ')';
    }
}
