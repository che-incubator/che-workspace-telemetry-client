/*
 * Copyright (c) 2021 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.incubator.workspace.telemetry.base;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class AbstractAnalyticsManagerTest {

    @Inject
    AbstractAnalyticsManager analyticsManager;

    @BeforeAll
    public static void setUp() {
        System.setProperty("che.api.internal", "https://fake-che.com/api");
        System.setProperty("che.workspace.id", "fake-workspace");
        System.setProperty("che.machine.token", "fake-token");
    }

    @AfterAll
    public static void tearDown() {
        System.clearProperty("che.api.internal");
    }


    @Test
    public void testInstantiation() {
        assertNotNull(analyticsManager);
    }

    @Test
    public void testMockResponseProperties() {
        assertEquals(analyticsManager.workspaceId, "fake-workspace");
        assertEquals(analyticsManager.workspaceName, "wksp-lqq9");
        assertEquals(analyticsManager.createdOn, "1575567196811");
        assertEquals(analyticsManager.updatedOn, "1575575662792");
        assertEquals(analyticsManager.stackId, "Go");
        assertEquals(analyticsManager.firstStart, true);
    }
}
