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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.webauthn4j.data.MDS3KeyProtectionType;
import com.webauthn4j.data.MDS3MatcherProtectionType;
import com.webauthn4j.data.attestation.authenticator.AAGUID;
import com.webauthn4j.metadata.data.uaf.AAID;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * This metadata statement contains a subset of verifiable information for authenticators certified by the FIDO Alliance.
 */
public class MDS3MetadataStatement implements IMetadataStatement, Serializable {
    private final String legalHeader;
    private final AAID aaid;
    private final AAGUID aaguid;
    private final List<String> attestationCertificateKeyIdentifiers;
    private final String description;
    private final AlternativeDescriptions alternativeDescriptions;
    private final BigInteger authenticatorVersion;
    private final String protocolFamily;
    private final Integer schema;
    private final List<Version> upv;
    private final List<MDS3AuthenticationAlgorithm> authenticationAlgorithms;
    private final List<MDS3PublicKeyRepresentationFormat> publicKeyAlgAndEncodings;
    private final List<MDS3AttestationType> attestationTypes;
    private final List<MDS3VerificationMethodANDCombinations> userVerificationDetails;
    private final List<MDS3KeyProtectionType> keyProtection;
    private final Boolean isKeyRestricted;
    private final Boolean isFreshUserVerificationRequired;
    private final List<MDS3MatcherProtectionType> matcherProtection;
    private final Integer cryptoStrength;
    private final List<MDS3AttachmentHint> attachmentHint;
    private final List<MDS3TransactionConfirmationDisplay> tcDisplay;
    private final String tcDisplayContentType;
    private final List<DisplayPNGCharacteristicsDescriptor> tcDisplayPNGCharacteristics;
    private final List<X509Certificate> attestationRootCertificates;
    private final List<EcdaaTrustAnchor> ecdaaTrustAnchors;
    private final String icon;
    private final List<ExtensionDescriptor> supportedExtensions;
    private final AuthenticatorGetInfo authenticatorGetInfo;


    @JsonCreator
    public MDS3MetadataStatement(
            @JsonProperty("legalHeader") String legalHeader,
            @JsonProperty("aaid") AAID aaid,
            @JsonProperty("aaguid") AAGUID aaguid,
            @JsonProperty("attestationCertificateKeyIdentifiers") List<String> attestationCertificateKeyIdentifiers,
            @JsonProperty("description") String description,
            @JsonProperty("alternativeDescriptions") AlternativeDescriptions alternativeDescriptions,
            @JsonProperty("authenticatorVersion") BigInteger authenticatorVersion,
            @JsonProperty("protocolFamily") String protocolFamily,
            @JsonProperty("schema") Integer schema,
            @JsonProperty("upv") List<Version> upv,
            @JsonProperty("authenticationAlgorithms") List<MDS3AuthenticationAlgorithm> authenticationAlgorithms,
            @JsonProperty("publicKeyAlgAndEncodings") List<MDS3PublicKeyRepresentationFormat> publicKeyAlgAndEncodings,
            @JsonProperty("attestationTypes") List<MDS3AttestationType> attestationTypes,
            @JsonProperty("userVerificationDetails") List<MDS3VerificationMethodANDCombinations> userVerificationDetails,
            @JsonProperty("keyProtection") List<MDS3KeyProtectionType> keyProtection,
            @JsonProperty("isKeyRestricted") Boolean isKeyRestricted,
            @JsonProperty("isFreshUserVerificationRequired") Boolean isFreshUserVerificationRequired,
            @JsonProperty("matcherProtection") List<MDS3MatcherProtectionType>  matcherProtection,
            @JsonProperty("cryptoStrength") Integer cryptoStrength,
            @JsonProperty("attachmentHint") List<MDS3AttachmentHint> attachmentHint,
            @JsonProperty("tcDisplay") List<MDS3TransactionConfirmationDisplay> tcDisplay,
            @JsonProperty("tcDisplayContentType") String tcDisplayContentType,
            @JsonProperty("tcDisplayPNGCharacteristics") List<DisplayPNGCharacteristicsDescriptor> tcDisplayPNGCharacteristics,
            @JsonProperty("attestationRootCertificates") List<X509Certificate> attestationRootCertificates,
            @JsonProperty("ecdaaTrustAnchors") List<EcdaaTrustAnchor> ecdaaTrustAnchors,
            @JsonProperty("icon") String icon,
            @JsonProperty("supportedExtensions") List<ExtensionDescriptor> supportedExtensions,
            @JsonProperty("authenticatorGetInfo") AuthenticatorGetInfo authenticatorGetInfo) {

        this.legalHeader = legalHeader;
        this.aaid = aaid;
        this.aaguid = aaguid;
        this.attestationCertificateKeyIdentifiers = attestationCertificateKeyIdentifiers;
        this.description = description;
        this.alternativeDescriptions = alternativeDescriptions;
        this.authenticatorVersion = authenticatorVersion;
        this.protocolFamily = protocolFamily;
        this.schema = schema;
        this.upv = upv;
        this.authenticationAlgorithms = authenticationAlgorithms;
        this.publicKeyAlgAndEncodings = publicKeyAlgAndEncodings;
        this.attestationTypes = attestationTypes;
        this.userVerificationDetails = userVerificationDetails;
        this.keyProtection = keyProtection;
        this.isKeyRestricted = isKeyRestricted;
        this.isFreshUserVerificationRequired = isFreshUserVerificationRequired;
        this.matcherProtection = matcherProtection;
        this.cryptoStrength = cryptoStrength;
        this.attachmentHint = attachmentHint;
        this.tcDisplay = tcDisplay;
        this.tcDisplayContentType = tcDisplayContentType;
        this.tcDisplayPNGCharacteristics = tcDisplayPNGCharacteristics;
        this.attestationRootCertificates = attestationRootCertificates;
        this.ecdaaTrustAnchors = ecdaaTrustAnchors;
        this.icon = icon;
        this.supportedExtensions = supportedExtensions;
        this.authenticatorGetInfo = authenticatorGetInfo;
    }

    public String getLegalHeader() {
        return legalHeader;
    }

    public AAID getAaid() {
        return aaid;
    }

    public AAGUID getAaguid() {
        return aaguid;
    }

    public List<String> getAttestationCertificateKeyIdentifiers() {
        return attestationCertificateKeyIdentifiers;
    }

    public String getDescription() {
        return description;
    }

    public AlternativeDescriptions getAlternativeDescriptions() {
        return alternativeDescriptions;
    }

    public BigInteger getAuthenticatorVersion() {
        return authenticatorVersion;
    }

    public String getProtocolFamily() {
        return protocolFamily;
    }

    public Integer getSchema() {
        return schema;
    }

    public List<Version> getUpv() {
        return upv;
    }

    public List<MDS3AuthenticationAlgorithm> getAuthenticationAlgorithms() {
        return authenticationAlgorithms;
    }

    public List<MDS3PublicKeyRepresentationFormat> getPublicKeyAlgAndEncodings() {
        return publicKeyAlgAndEncodings;
    }

    public List<MDS3AttestationType> getAttestationTypes() {
        return attestationTypes;
    }

    public List<MDS3VerificationMethodANDCombinations> getUserVerificationDetails() {
        return userVerificationDetails;
    }

    public List<MDS3KeyProtectionType> getKeyProtection() {
        return keyProtection;
    }

    public Boolean getKeyRestricted() {
        return isKeyRestricted;
    }

    public Boolean getFreshUserVerificationRequired() {
        return isFreshUserVerificationRequired;
    }

    public List<MDS3MatcherProtectionType> getMatcherProtection() {
        return matcherProtection;
    }

    public Integer getCryptoStrength() {
        return cryptoStrength;
    }

    public List<MDS3AttachmentHint> getAttachmentHint() {
        return attachmentHint;
    }

    public List<MDS3TransactionConfirmationDisplay> getTcDisplay() {
        return tcDisplay;
    }

    public String getTcDisplayContentType() {
        return tcDisplayContentType;
    }

    public List<DisplayPNGCharacteristicsDescriptor> getTcDisplayPNGCharacteristics() { return tcDisplayPNGCharacteristics; }

    public List<X509Certificate> getAttestationRootCertificates() {
        return attestationRootCertificates;
    }

    public List<EcdaaTrustAnchor> getEcdaaTrustAnchors() {
        return ecdaaTrustAnchors;
    }

    public String getIcon() {
        return icon;
    }

    public List<ExtensionDescriptor> getSupportedExtensions() { return supportedExtensions; }

    public AuthenticatorGetInfo getAuthenticatorGetInfo() { return authenticatorGetInfo; }

}
