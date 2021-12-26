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
 * The supported authentication algorithm(s).
 *
 * @see <a href="https://fidoalliance.org/specs/common-specs/fido-registry-v2.2-rd-20210525.html#authentication-algorithms">§3.6.1 Authentication Algorithms</a>
 */
public enum MDS3AuthenticationAlgorithm {

    SECP256R1_ECDSA_SHA256_RAW("secp256r1_ecdsa_sha256_raw"),
    SECP256R1_ECDSA_SHA256_DER("secp256r1_ecdsa_sha256_der"),
    RSASSA_PSS_SHA256_RAW("rsassa_pss_sha256_raw"),
    RSASSA_PSS_SHA256_DER("rsassa_pss_sha256_der"),
    SECP256K1_ECDSA_SHA256_RAW("secp256k1_ecdsa_sha256_raw"),
    SECP256K1_ECDSA_SHA256_DER("secp256k1_ecdsa_sha256_der"),
    SM2_SM3_RAW("sm2_sm3_raw"),
    RSA_EMSA_PKCS1_SHA256_RAW("rsa_emsa_pkcs1_sha256_raw"),
    RSA_EMSA_PKCS1_SHA256_DER("rsa_emsa_pkcs1_sha256_der"),
    RSASSA_PSS_SHA384_RAW("rsassa_pss_sha384_raw"),
    RSASSA_PSS_SHA512_RAW("rsassa_pss_sha512_raw"),
    RSASSA_PKCSV15_SHA256_RAW("rsassa_pkcsv15_sha256_raw"),
    RSASSA_PKCSV15_SHA384_RAW("rsassa_pkcsv15_sha384_raw"),
    RSASSA_PKCSV15_SHA512_RAW("rsassa_pkcsv15_sha512_raw"),
    RSASSA_PKCSV15_SHA1_RAW("rsassa_pkcsv15_sha1_raw"),
    SECP384R1_ECDSA_SHA384_RAW("secp384r1_ecdsa_sha384_raw"),
    SECP521R1_ECDSA_SHA512_RAW("secp521r1_ecdsa_sha512_raw"),
    ED25519_EDDSA_SHA512_RAW("ed25519_eddsa_sha512_raw"),
    ED448_EDDSA_SHA512_RAW("ed448_eddsa_sha512_raw");

    private final String value;

    MDS3AuthenticationAlgorithm(String value) {
        this.value = value;
    }

    public static MDS3AuthenticationAlgorithm create(String value) {
        switch (value) {
            case "secp256r1_ecdsa_sha256_raw":
                return SECP256R1_ECDSA_SHA256_RAW;
            case "secp256r1_ecdsa_sha256_der":
                return SECP256R1_ECDSA_SHA256_DER;
            case "rsassa_pss_sha256_raw":
                return RSASSA_PSS_SHA256_RAW;
            case "rsassa_pss_sha256_der":
                return RSASSA_PSS_SHA256_DER;
            case "secp256k1_ecdsa_sha256_raw":
                return SECP256K1_ECDSA_SHA256_RAW;
            case "secp256k1_ecdsa_sha256_der":
                return SECP256K1_ECDSA_SHA256_DER;
            case "sm2_sm3_raw":
                return SM2_SM3_RAW;
            case "rsa_emsa_pkcs1_sha256_raw":
                return RSA_EMSA_PKCS1_SHA256_RAW;
            case "rsa_emsa_pkcs1_sha256_der":
                return RSA_EMSA_PKCS1_SHA256_DER;
            case "rsassa_pss_sha384_raw":
                return RSASSA_PSS_SHA384_RAW;
            case "rsassa_pss_sha512_raw":
                return RSASSA_PSS_SHA512_RAW;
            case "rsassa_pkcsv15_sha256_raw":
                return RSASSA_PKCSV15_SHA256_RAW;
            case "rsassa_pkcsv15_sha384_raw":
                return RSASSA_PKCSV15_SHA384_RAW;
            case "rsassa_pkcsv15_sha512_raw":
                return RSASSA_PKCSV15_SHA512_RAW;
            case "rsassa_pkcsv15_sha1_raw":
                return RSASSA_PKCSV15_SHA1_RAW;
            case "secp384r1_ecdsa_sha384_raw":
                return SECP384R1_ECDSA_SHA384_RAW;
            case "secp521r1_ecdsa_sha512_raw":
                return SECP521R1_ECDSA_SHA512_RAW;
            case "ed25519_eddsa_sha512_raw":
                return ED25519_EDDSA_SHA512_RAW;
            case "ed448_eddsa_sha512_raw":
                return ED448_EDDSA_SHA512_RAW;
            default:
                throw new IllegalArgumentException("value '" + value + "' is supported");
        }
    }

    @JsonCreator
    private static MDS3AuthenticationAlgorithm deserialize(String value) throws InvalidFormatException {
        try {
            return create(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidFormatException(null, "value is supported", value, MDS3AuthenticationAlgorithm.class);
        }
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}
