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
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.webauthn4j.util.UnsignedNumberUtil;

/**
 * The supported attestation type(s). (e.g. ATTESTATION_BASIC_FULL(0x3E07), ATTESTATION_BASIC_SURROGATE(0x3E08)).
 *
 * @see <a href="https://fidoalliance.org/specs/common-specs/fido-registry-v2.2-rd-20210525.html#authenticator-attestation-types">§3.6.3 Authenticator Attestation Types</a>
 */
public enum MDS3AttestationType {

    BASIC_FULL("basic_full"),
    BASIC_SURROGATE("basic_surrogate"),
    ECDAA("ecdaa"),
    ATTCA("attca"),
    NONE("none");

    private final String value;

    MDS3AttestationType(String value) {
        this.value = value;
    }

    public static MDS3AttestationType create(String value) {

        switch (value) {
            case "basic_full":
                return BASIC_FULL;
            case "basic_surrogate":
                return BASIC_SURROGATE;
            case "ecdaa":
                return ECDAA;
            case "attca":
                return ATTCA;
            case "none":
                return NONE;
            default:
                throw new IllegalArgumentException("value '" + value + "' is not supported");
        }
    }

    @JsonCreator
    private static MDS3AttestationType deserialize(String value) throws InvalidFormatException {
        try {
            return create(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidFormatException(null, "value is not supported", value, MDS3AttestationType.class);
        }
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}
