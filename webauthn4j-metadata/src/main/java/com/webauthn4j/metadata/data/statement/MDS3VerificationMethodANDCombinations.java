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
import com.webauthn4j.util.AssertUtil;

import java.util.*;

public class MDS3VerificationMethodANDCombinations extends AbstractList<MDS3VerificationMethodDescriptor> {

    private final int size;
    private final MDS3VerificationMethodDescriptor[] descriptors;

    @JsonCreator
    public MDS3VerificationMethodANDCombinations(List<MDS3VerificationMethodDescriptor> descriptors) {
        AssertUtil.notNull(descriptors, "descriptors must not be null");
        this.size = descriptors.size();
        this.descriptors = descriptors.toArray(new MDS3VerificationMethodDescriptor[this.size]);
    }

    public MDS3VerificationMethodANDCombinations() {
        this(Collections.emptyList());
    }

    @Override
    public MDS3VerificationMethodDescriptor get(int index) {
        return descriptors[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        MDS3VerificationMethodANDCombinations that = (MDS3VerificationMethodANDCombinations) o;
        return size == that.size &&
                Arrays.equals(descriptors, that.descriptors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), size);
        result = 31 * result + Arrays.hashCode(descriptors);
        return result;
    }
}
