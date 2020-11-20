# Project Template for CZ2002 MyStars

![Java Automatic CodeCoverage Report](https://github.com/GoldenCorgi/CZ2002-MyStars/workflows/Java%20Automatic%20CodeCoverage%20Report/badge.svg)
![Java CI/CD Integrated Test](https://github.com/GoldenCorgi/CZ2002-MyStars/workflows/Java%20CI/CD%20Integrated%20Test/badge.svg)
[![Netlify Status](https://api.netlify.com/api/v1/badges/122779ae-d183-46e9-beef-6e66a0d4db3f/deploy-status)](https://cz2002-mystars.netlify.app)
[![codecov](https://codecov.io/gh/GoldenCorgi/CZ2002-MyStars/branch/master/graph/badge.svg?token=W928NWEEMJ)](https://codecov.io/gh/GoldenCorgi/CZ2002-MyStars)

## Documentation

The website hosting our documentation can be found here [https://cz2002-mystars.netlify.app](https://cz2002-mystars.netlify.app)


## Code Coverage

An icicle graph showing the code coverage for tests. The top section represents the entire project. Proceeding with folders and finally individual files. The size and color of each slice is representing the number of statements and the coverage, respectively.

[![codecov](https://codecov.io/gh/GoldenCorgi/CZ2002-MyStars/branch/master/graphs/icicle.svg?token=W928NWEEMJ)](https://codecov.io/gh/GoldenCorgi/CZ2002-MyStars)





## Setting up in Intellij

This is a project template for a greenfield Java project. Given below are instructions on how to use it.

Tools Used: JDK 11 (use the exact version), update Intellij to the most recent version.

1. **Configure Intellij for JDK 11**, as described [here](https://se-education.org/guides/tutorials/intellijJdk.html).
1. **Import the project _as a Gradle project_**, as described [here](https://se-education.org/guides/tutorials/intellijImportGradleProject.html).
1. **Verify the set up**: After the importing is complete, locate the `src/main/java/mystars/Main.java` file, right-click it, and choose `Run Main.main()` :
```
  __  ____     _______ _______       _____   _____ 
 |  \/  \ \   / / ____|__   __|/\   |  __ \ / ____|
 | \  / |\ \_/ / (___    | |  /  \  | |__) | (___  
 | |\/| | \   / \___ \   | | / /\ \ |  _  / \___ \ 
 | |  | |  | |  ____) |  | |/ ____ \| | \ \ ____) |
 |_|  |_|  |_| |_____/   |_/_/    \_\_|  \_\_____/ 
                                                   
   ```





## Build automation using Gradle

* This project uses Gradle for build automation and dependency management. It includes a basic build script as well (i.e. the `build.gradle` file).
* If you are new to Gradle, refer to the [Gradle Tutorial at se-education.org/guides](https://se-education.org/guides/tutorials/gradle.html).

## Testing

### YS - To run all the tests below, just doubleclick on Run_Before_Pushing.bat, it will settle everything


### I/O redirection tests

* To run _I/O redirection_ tests (aka _Text UI tests_), navigate to the `text-ui-test` and run the `runtest(.bat/.sh)` script.

### JUnit tests

* A skeleton JUnit test (`src/test/java/mystars/MainTest.java`) is provided with this project template. 
* If you are new to JUnit, refer to the [JUnit Tutorial at se-education.org/guides](https://se-education.org/guides/tutorials/junit.html).

## Checkstyle

* A sample CheckStyle rule configuration is provided in this project.
* If you are new to Checkstyle, refer to the [Checkstyle Tutorial at se-education.org/guides](https://se-education.org/guides/tutorials/checkstyle.html).

## CI using GitHub Actions

The project uses [GitHub actions](https://github.com/features/actions) for CI. When you push a commit to this repo or PR against it, GitHub actions will run automatically to build and verify the code as updated by the commit/PR.

## Documentation

`/docs` folder contains a skeleton version of the project documentation.

This documentation is automatically generated using JavaDoc
