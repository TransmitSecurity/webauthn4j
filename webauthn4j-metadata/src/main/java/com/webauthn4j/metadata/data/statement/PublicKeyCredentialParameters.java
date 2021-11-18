package com.webauthn4j.metadata.data.statement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * This metadata statement contains a subset of verifiable information for authenticators certified by the FIDO Alliance.
 */
public class PublicKeyCredentialParameters implements Serializable {
    private final String type;
    private final Integer alg;

    @JsonCreator
    public PublicKeyCredentialParameters(
            @JsonProperty("type") String type,
            @JsonProperty("alg") Integer alg) {

        this.type = type;
        this.alg = alg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicKeyCredentialParameters that = (PublicKeyCredentialParameters) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(alg, that.alg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, alg);
    }

    @JsonGetter("type")
    public String getType() {
        return type;
    }

    @JsonGetter("alg")
    public Integer getAlg() {
        return alg;
    }
}
