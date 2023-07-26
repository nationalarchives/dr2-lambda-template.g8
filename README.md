# DR2 Scala Lambda Template

This is a template which can be used to set up Scala lambda functions for the DR2 team.

The template can mostly be used by other teams but the GitHub actions workflows use dr2-github-actions which are specific to DR2. 
You can set the setup_ci property to false to exclude the .github/ folder.

## Arguments

### name
Used for the folder name, the name of the assembled jar and the lambda name in the CI jobs.
Kebab case should be used.
### organisation 
Used for the package structure and the organisation in build.sbt
### use_event
Creates a lambda which takes an event. This is an SQS event by default but the aws-lambda-java-events is imported so this can be swapped out for another one.
Can't be used with use_input_stream
### use_input_stream
Creates a lambda which takes an input stream. Can't be used with use_event
### setup_ci
Creates the .github/workflows folder and a test, build and deploy workflow. This is DR2 specific so it can be ignored.

## Files
### Lambda
A class which either implements `RequestStreamHandler` or `RequestHandler[SQSEvent, Unit]` 
This is the entrypoint for the lambda.

### LambdaTest
A scalatest skeleton extending `AnyFlatSpec` with a skeleton test included.

### Application properties
An empty application properties file in `src/main/resources` and `src/test/resources`

### Logging configuration
A log4j2 configuration file which outputs logs as json. 
The bridge between log4j2 and slf4j is included.

### Scalafmt
The `scalafmt.conf` file is set with sensible defaults and the plugin is imported.

### sbt assembly
The plugin is imported and it is configured in `build.sbt`

### Licence file
The standard MIT Crown Copyright licence.

### build.sbt
Imports the lambda, scalatest and logging dependencies as well as configuring sbt assembly.

### README
A README file with the name of the repo split as the heading. For example `test-repo` becomes `# Test Repo`

## Pre commit hooks
There is a config file for [pre-commit](https://pre-commit.com/) which runs scalafmtCheckAll before any commits. To install the hook:

```bash
pip install pre-commit # This only needs to be done once globally
git init
pre-commit install
```
