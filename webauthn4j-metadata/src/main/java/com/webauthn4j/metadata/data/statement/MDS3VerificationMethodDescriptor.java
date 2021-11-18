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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.webauthn4j.data.MDS3UserVerificationMethod;
import com.webauthn4j.data.UserVerificationMethod;

import java.io.Serializable;
import java.util.Objects;

/**
 * A descriptor for a specific base user verification method as implemented by the authenticator.
 */
public class MDS3VerificationMethodDescriptor implements Serializable {

    private final MDS3UserVerificationMethod userVerification;
    private final CodeAccuracyDescriptor caDesc;
    private final BiometricAccuracyDescriptor baDesc;
    private final PatternAccuracyDescriptor paDesc;

    @JsonCreator
    public MDS3VerificationMethodDescriptor(
            @JsonProperty("userVerification") MDS3UserVerificationMethod userVerification,
            @JsonProperty("caDesc") CodeAccuracyDescriptor caDesc,
            @JsonProperty("baDesc") BiometricAccuracyDescriptor baDesc,
            @JsonProperty("paDesc") PatternAccuracyDescriptor paDesc) {
        this.userVerification = userVerification;
        this.caDesc = caDesc;
        this.baDesc = baDesc;
        this.paDesc = paDesc;
    }

    public MDS3UserVerificationMethod getUserVerification() {
        return userVerification;
    }

    public CodeAccuracyDescriptor getCaDesc() {
        return caDesc;
    }

    public BiometricAccuracyDescriptor getBaDesc() {
        return baDesc;
    }

    public PatternAccuracyDescriptor getPaDesc() {
        return paDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MDS3VerificationMethodDescriptor that = (MDS3VerificationMethodDescriptor) o;
        return Objects.equals(userVerification, that.userVerification) &&
                Objects.equals(caDesc, that.caDesc) &&
                Objects.equals(baDesc, that.baDesc) &&
                Objects.equals(paDesc, that.paDesc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userVerification, caDesc, baDesc, paDesc);
    }
}
