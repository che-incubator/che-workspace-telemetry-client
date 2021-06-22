/*
 * Copyright (c) 2012-2021 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.incubator.workspace.telemetry.anonymizer;

import static org.slf4j.LoggerFactory.getLogger;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Singleton;

import org.slf4j.Logger;

@Singleton
public class SHA1HashGenerator {
    private static final Logger LOG = getLogger(SHA1HashGenerator.class);
    private static final String SHA_1 = "SHA-1";
    private static final String UTF_8 = "utf8";
    private static final String HEX= "%040x";

    public String generateHash(final String input) {
        String hash = null;
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(SHA_1);
            digest.reset();
            digest.update(input.getBytes(UTF_8));
            hash = String.format(HEX, new BigInteger(1, digest.digest()));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            LOG.error("Can not generate hash due to missing algorithm or unsupported encoding", e);
        }
        return hash;
    }

}
