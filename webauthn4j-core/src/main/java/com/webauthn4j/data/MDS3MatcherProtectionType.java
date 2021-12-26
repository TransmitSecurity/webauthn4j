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
import com.webauthn4j.util.UnsignedNumberUtil;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * The supported matcher protection type(s).
 *
 * @see <a href="https://fidoalliance.org/specs/fido-v2.0-rd-20180702/fido-registry-v2.0-rd-20180702.html#matcher-protection-types">§3.3 Matcher Protection Types</a>
 */
public enum MDS3MatcherProtectionType {

    SOFTWARE("software"),
    TEE("tee"),
    ON_CHIP("on_chip");

    private final String value;

    MDS3MatcherProtectionType(String value) {
        this.value = value;
    }

    public static @NonNull MDS3MatcherProtectionType create(String value) {
        switch (value) {
            case "software":
                return SOFTWARE;
            case "tee":
                return TEE;
            case "on_chip":
                return ON_CHIP;
            default:
                throw new IllegalArgumentException("value '" + value + "' is not supported");
        }
    }

    @SuppressWarnings("unused")
    @JsonCreator
    private static @NonNull MDS3MatcherProtectionType deserialize(String value) throws InvalidFormatException {
        try {
            return create(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidFormatException(null, "value is not supported", value, MDS3MatcherProtectionType.class);
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
