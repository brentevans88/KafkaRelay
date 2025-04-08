# Things to change in the template

## application.yml

- app.name property
- server.port
- server.servlet.context-path
- logging.file.name
- springdoc.packagesToScan

## banner.txt

- [service name](https://devops.datenkollektiv.de/banner.txt/index.html)

## Package Names

- com.hawkeyeinnovations.[sport] --> e.g. tennis, baseball, golf..
- com.hawkeyeinnovations.sport.[service_name] --> short name of the service WITHOUT underscores

## Class Names

- Application
- SomethingController
- SomethingService
- SomethingControllerIT

Then replace the contents of this file with a proper README

## Docker

- Create an ECR for the service (https://eu-west-2.console.aws.amazon.com/ecr/repositories?region=eu-west-2)
- Replace `<registry-service-name>` in `build.gradle` with the correct registry name.
- For terraform AWS service deployment requires healthcheck command to be of format:
```terraform
healthcheck_cmd = "THC_PORT=<APP-PORT> THC_PATH=<APP-ACTUATOR-HEALTH-RELATIVE-PATH> /layers/paketo-buildpacks_health-checker/thc/bin/thc"
```

## FTP

- If service needs to be copied to FTP set `<service-name>` in `ftpPublish` task in `Service/build.gradle` to the correct service
- If not remove `ftpPublish` task from `Service/build.gradle` and property from `Jenkinsfile`

## Notes

### OpenApi v3

[springdoc](https://springdoc.org/)

To generate any `@ControllerAdvice` error handling in the documentation, the methods must define a `@ResponseStatus`
annotation with the appropriate `@HttpStatus` - see `ErrorHandler`

If you see an error dialog (`Unable to infer base url`) when testing the swagger ui in your browser, try clearing the
browser cached files.