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
package org.eclipse.che.incubator.workspace.telemetry;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(
    info = @Info(
        title = "Che Workspace Telemetry API",
        description = "This is the API of the Che workspace telemetry manager",
        version = "0.0.1",
        contact = @Contact(email = "dfestal@redhat.com"),
        license = @License(
            name = "Eclipse Public License - v 2.0",
            url = "https://www.eclipse.org/legal/epl-2.0/"
        )
    )
)
@ApplicationPath("/telemetry")
public class TelemetryApplication extends Application {
}
