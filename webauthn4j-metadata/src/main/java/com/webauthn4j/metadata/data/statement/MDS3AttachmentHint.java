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
 * The supported attachment hint type(s).
 *
 * @see <a href="https://fidoalliance.org/specs/common-specs/fido-registry-v2.2-rd-20210525.html#authenticator-attachment-hints">§3.4 Authenticator Attachment Hints</a>
 */
public enum MDS3AttachmentHint {

    INTERNAL("internal"),
    EXTERNAL("external"),
    WIRED("wired"),
    WIRELESS("wireless"),
    NFC("nfc"),
    BLUETOOTH("bluetooth"),
    NETWORK("network"),
    READY("ready"),
    WIFI_DIRECT("wifi_direct");

    private final String value;

    MDS3AttachmentHint(String value) {
        this.value = value;
    }

    public static MDS3AttachmentHint create(String value) {
        switch (value) {
            case "internal":
                return INTERNAL;
            case "external":
                return EXTERNAL;
            case "wired":
                return WIRED;
            case "wireless":
                return WIRELESS;
            case "nfc":
                return NFC;
            case "bluetooth":
                return BLUETOOTH;
            case "network":
                return NETWORK;
            case "ready":
                return READY;
            case "wifi_direct":
                return WIFI_DIRECT;
            default:
                throw new IllegalArgumentException("value '" + value + "' is not supported");
        }
    }

    @JsonCreator
    private static MDS3AttachmentHint deserialize(String value) throws InvalidFormatException {
        try {
            return create(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidFormatException(null, "value is not supported\"", value, MDS3AttachmentHint.class);
        }
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}
