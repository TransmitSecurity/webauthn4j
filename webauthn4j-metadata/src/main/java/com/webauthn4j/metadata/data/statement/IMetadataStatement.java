package com.webauthn4j.metadata.data.statement;

import com.webauthn4j.data.attestation.authenticator.AAGUID;
import com.webauthn4j.metadata.data.uaf.AAID;

import java.security.cert.X509Certificate;
import java.util.List;

public interface IMetadataStatement {

    String getLegalHeader();

    AAID getAaid();

    AAGUID getAaguid();

    List<String> getAttestationCertificateKeyIdentifiers();

    String getDescription();

    AlternativeDescriptions getAlternativeDescriptions();

    String getProtocolFamily();

    List<Version> getUpv();

    Boolean getKeyRestricted();

    Boolean getFreshUserVerificationRequired();

    String getTcDisplayContentType();

    List<DisplayPNGCharacteristicsDescriptor> getTcDisplayPNGCharacteristics();
    List<X509Certificate> getAttestationRootCertificates();

    List<EcdaaTrustAnchor> getEcdaaTrustAnchors();

    String getIcon();

}
