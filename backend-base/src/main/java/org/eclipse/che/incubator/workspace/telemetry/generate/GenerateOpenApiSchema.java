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
package org.eclipse.che.incubator.workspace.telemetry.generate;

import java.io.FileWriter;
import java.io.IOException;

import io.smallrye.config.SmallRyeConfigBuilder;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.jboss.jandex.Index;
import org.jboss.jandex.IndexReader;

import io.smallrye.openapi.api.OpenApiConfigImpl;
import io.smallrye.openapi.api.OpenApiConstants;
import io.smallrye.openapi.runtime.io.OpenApiSerializer;
import io.smallrye.openapi.runtime.io.OpenApiSerializer.Format;
import io.smallrye.openapi.runtime.scanner.OpenApiAnnotationScanner;

public class GenerateOpenApiSchema {
  public static void main(String[] args) throws IOException {
    System.setProperty(OpenApiConstants.SCHEMA_REFERENCES_ENABLE, "true");
    IndexReader indexReader = new IndexReader(GenerateOpenApiSchema.class.getClassLoader().getResourceAsStream("META-INF/jandex.idx"));
    Index index = indexReader.read();
    Config config = new SmallRyeConfigBuilder()
      .addDefaultSources()
      .addDiscoveredConverters()
      .addDiscoveredSources()
      .build();
    OpenAPI openAPI = new OpenApiAnnotationScanner(new OpenApiConfigImpl(config), index).scan();
    String yaml = OpenApiSerializer.serialize(openAPI, Format.YAML);
    FileWriter fileWriter = new FileWriter(args[0]);
    fileWriter.write(yaml);
    fileWriter.close();
  }
}
