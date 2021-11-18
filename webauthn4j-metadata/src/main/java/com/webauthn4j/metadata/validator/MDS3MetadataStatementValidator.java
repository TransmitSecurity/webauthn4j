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

package com.webauthn4j.metadata.validator;

import com.webauthn4j.metadata.data.statement.MDS3MetadataStatement;
import com.webauthn4j.metadata.exception.UnknownProtocolFamilyException;

import java.util.Arrays;
import java.util.List;

public class MDS3MetadataStatementValidator {

    private final List<String> KNOWN_PROTOCOL_FAMILY = Arrays.asList("uaf", "u2f", "fido2");

    public void validate(MDS3MetadataStatement metadataStatement) {
        validateProtocolFamily(metadataStatement.getProtocolFamily());
        validateScheme(metadataStatement.getSchema());
    }

    private void validateProtocolFamily(String protocolFamily) {
        if (!KNOWN_PROTOCOL_FAMILY.contains(protocolFamily)) {
            throw new UnknownProtocolFamilyException(String.format("Unknown protocol family '%s' is provided", protocolFamily));
        }
    }

    private void validateScheme(Integer schema) {
        if (schema != 3) {
            throw new UnknownProtocolFamilyException(String.format("bad scheme version '%s' is provided", schema));
        }
    }

}
