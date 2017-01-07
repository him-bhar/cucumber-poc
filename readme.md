# Behavioral Driven Development and testing via Cucumber

## Cucumber integration with Maven.
Following maven dependencies are required:
```xml
	<dependency>
		<groupId>info.cukes</groupId>
		<artifactId>cucumber-junit</artifactId>
		<version>${cucumber.version}</version>
		<scope>test</scope>
	</dependency>
	<dependency>
		<groupId>info.cukes</groupId>
		<artifactId>cucumber-java</artifactId>
		<version>${cucumber.version}</version>
		<scope>test</scope>
	</dependency>
	<dependency>
		<groupId>info.cukes</groupId>
		<artifactId>cucumber-spring</artifactId>  <!-- This is required so cucumber can used bean injects with spring as the underlying framework. -->
		<version>${cucumber.version}</version>
		<scope>test</scope>
	</dependency>
```



## Cucumber reporting plugin integration with Maven
```xml
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-surefire-plugin</artifactId>
		<version>${surefire.plugin.version}</version>
		<configuration>
		  <includes>
			<exclude>**/SpringEnabledCalculatorTest.java</exclude>
			<exclude>**/CalculatorTest.java</exclude>
		  </includes>
		</configuration>
	</plugin>
	<plugin>
		<groupId>net.masterthought</groupId>
		<artifactId>maven-cucumber-reporting</artifactId>
		<version>${cucumber-maven-reporting.plugin.version}</version>
		<executions>
			<execution>
				<id>execution</id>
				<phase>verify</phase>
				<goals>
					<goal>generate</goal>
				</goals>
				<configuration>
					<projectName>calculator-reporting-sample</projectName>
					<outputDirectory>${project.build.directory}/cucumber-html-reports</outputDirectory>
					<cucumberOutput>${project.build.directory}/reports/json</cucumberOutput>
					<parallelTesting>false</parallelTesting>
				</configuration>
			</execution>
		</executions>
	</plugin>
```

> As you can see the test cases are explicitly ignored in surefire plugin, its required so that JUnit runner doesn't execute the cucumber based tests. As it will not actually executed the tests. With this cucumber actually runs these tests, the way they are supposed to be.

|Plugin property|Description|
|---|---|
|projectName|When are report is generated report will contain the project name as what is mentioned here. (Cosmetic only)|
|cucumberOutput|The location where cucumber generated json files are kept. Used for generating the reporting via reporting plugin|
|outputDirectory|The location where reporting plugin generated HTML files will be saved (Output of the reporting plugin)|

