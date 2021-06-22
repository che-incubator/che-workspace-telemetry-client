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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SHA1HashGeneratorTest {
    private static final String TEST_USERNAME= "test-username";
    private static final String EXPECTED_SHA1_HASH= "ded736438647e25487ef37c6c6ca2420ef0072db";

    @Test
    public void testHashGeneration() {
        String hash = new SHA1HashGenerator().generateHash(TEST_USERNAME);
        assertEquals(hash, EXPECTED_SHA1_HASH);
    }

}
