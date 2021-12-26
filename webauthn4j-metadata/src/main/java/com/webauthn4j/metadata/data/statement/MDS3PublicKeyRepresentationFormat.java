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
 * The supported publik key representation format(s).
 *
 * @see <a href="https://fidoalliance.org/specs/common-specs/fido-registry-v2.2-rd-20210525.html#public-key-representation-formats">§3.6.2 Public Key Representation Formats</a>
 */
public enum MDS3PublicKeyRepresentationFormat {

    ECC_X962_RAW("ecc_x962_raw"),
    ECC_X962_DER("ecc_x962_der"),
    RSA_2048_RAW("rsa_2048_raw"),
    RSA_2048_DER("rsa_2048_der"),
    COSE("cose");

    private final String value;

    MDS3PublicKeyRepresentationFormat(String value) {
        this.value = value;
    }

    public static MDS3PublicKeyRepresentationFormat create(String value) {
        switch (value) {
            case "ecc_x962_raw":
                return ECC_X962_RAW;
            case "ecc_x962_der":
                return ECC_X962_DER;
            case "rsa_2048_raw":
                return RSA_2048_RAW;
            case "rsa_2048_der":
                return RSA_2048_DER;
            case "cose":
                return COSE;
            default:
                throw new IllegalArgumentException("value '" + value + "' is not supported");
        }
    }

    @JsonCreator
    private static MDS3PublicKeyRepresentationFormat deserialize(String value) throws InvalidFormatException {
        try {
            return create(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidFormatException(null, "value is not supported", value, AttestationType.class);
        }
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}
