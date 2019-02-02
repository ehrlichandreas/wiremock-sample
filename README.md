# wiremock-sample

```
mvn archetype:generate -B \
    -DarchetypeGroupId=com.github.ehrlichandreas \
    -DarchetypeArtifactId=wiremock-sample-archetype \
    -DarchetypeVersion=1.0.2 \
    -DgroupId=newProjectId \
    -DartifactId=sample \
    -Dversion=1.0-SNAPSHOT \
    -Dpackage=com.company.project
```

Adopt properties in top generated **pom.xml** to your needs:
```
<wiremock.server.port>__wiremock.server.port__</wiremock.server.port>
<web.app.display.name>__web.app.display.name__</web.app.display.name>
<wiremock.stubs.root-context>__wiremock.stubs.root-context__</wiremock.stubs.root-context>
<wiremock.mappings.output.directory>__wiremock-stubs__</wiremock.mappings.output.directory>
<wiremock.standalone.properties.file>__standalone.properties__</wiremock.standalone.properties.file>
```
to something like
```
<wiremock.server.port>8080</wiremock.server.port>
<web.app.display.name>project's wiremock</web.app.display.name>
<wiremock.stubs.root-context>/root/context</wiremock.stubs.root-context>
<wiremock.mappings.output.directory>wiremock-stubs</wiremock.mappings.output.directory>
<wiremock.standalone.properties.file>standalone.properties</wiremock.standalone.properties.file>
```
or
```
<wiremock.server.port>8090</wiremock.server.port>
<web.app.display.name>foo</web.app.display.name>
<wiremock.stubs.root-context></wiremock.stubs.root-context>
<wiremock.mappings.output.directory>wiremock2-stubs</wiremock.mappings.output.directory>
<wiremock.standalone.properties.file>standalone2.properties</wiremock.standalone.properties.file>
```

than

```
mvn clean install
```