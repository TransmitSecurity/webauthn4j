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
 * The supported transaction confirmation display type(s).
 *
 * @see <a href="https://fidoalliance.org/specs/common-specs/fido-registry-v2.2-rd-20210525.html#transaction-confirmation-display-types">§3.2 Key Protection Types</a>
 */
public enum MDS3TransactionConfirmationDisplay {

    ANY("any"),
    PRIVILEGED_SOFTWARE("privileged_software"),
    TEE("tee"),
    HARDWARE("hardware"),
    REMOTE("remote");

    private final String value;

    MDS3TransactionConfirmationDisplay(String value) {
        this.value = value;
    }

    @SuppressWarnings("Duplicates")
    public static MDS3TransactionConfirmationDisplay create(String value) {
        switch (value) {
            case "any":
                return ANY;
            case "privileged_software":
                return PRIVILEGED_SOFTWARE;
            case "tee":
                return TEE;
            case "hardware":
                return HARDWARE;
            case "remote":
                return REMOTE;
            default:
                throw new IllegalArgumentException("value '" + value + "' is not supported");
        }
    }

    @JsonCreator
    private static MDS3TransactionConfirmationDisplay deserialize(String value) throws InvalidFormatException {
        try {
            return create(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidFormatException(null, "value is not supported\"", value, MDS3TransactionConfirmationDisplay.class);
        }
    }

    @JsonValue
    public String getValue() {
        return value;
    }


}
