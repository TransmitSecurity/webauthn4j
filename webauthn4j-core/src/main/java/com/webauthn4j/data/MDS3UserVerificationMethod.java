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
package com.webauthn4j.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * The supported user verification method(s).
 *
 * @see <a href="https://fidoalliance.org/specs/common-specs/fido-registry-v2.1-ps-20191217.html#user-verification-methods">§3.1 User Verification Methods</a>
 */
public enum MDS3UserVerificationMethod {

    PRESENCE_INTERNAL("presence_internal"),
    FINGERPRINT_INTERNAL("fingerprint_internal"),
    PASSCODE_INTERNAL("passcode_internal"),
    VOICEPRINT_INTERNAL("voiceprint_internal"),
    FACEPRINT_INTERNAL("faceprint_internal"),
    LOCATION_INTERNAL("location_internal"),
    EYEPRINT_INTERNAL("eyeprint_internal"),
    PATTERN_INTERNAL("pattern_internal"),
    HANDPRINT_INTERNAL("handprint_internal"),
    PASSCODE_EXTERNAL("passcode_external"),
    PATTERN_EXTERNAL("pattern_external"),
    NONE("none"),
    ALL("all");

    private final String value;

    MDS3UserVerificationMethod(String value) {
        this.value = value;
    }

    public static MDS3UserVerificationMethod create(String value) {
        switch (value) {
            case "presence_internal":
                return PRESENCE_INTERNAL;
            case "fingerprint_internal":
                return FINGERPRINT_INTERNAL;
            case "passcode_internal":
                return PASSCODE_INTERNAL;
            case "voiceprint_internal":
                return VOICEPRINT_INTERNAL;
            case "faceprint_internal":
                return FACEPRINT_INTERNAL;
            case "location_internal":
                return LOCATION_INTERNAL;
            case "eyeprint_internal":
                return EYEPRINT_INTERNAL;
            case "pattern_internal":
                return PATTERN_INTERNAL;
            case "handprint_internal":
                return HANDPRINT_INTERNAL;
            case "passcode_external":
                return PASSCODE_EXTERNAL;
            case "pattern_external":
                return PATTERN_EXTERNAL;
            case "none":
                return NONE;
            default:
                throw new IllegalArgumentException("value '" + value + "' is not supported");
        }
    }

    @SuppressWarnings("unused")
    @JsonCreator
    private static @NonNull MDS3UserVerificationMethod deserialize(String value) throws InvalidFormatException {
        try {
            return create(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidFormatException(null, "value is not supported", value, MDS3UserVerificationMethod.class);
        }
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
