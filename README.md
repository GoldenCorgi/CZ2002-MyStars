# Project Template for CZ2002 MyStars

![Java Automatic CodeCoverage Report](https://github.com/GoldenCorgi/CZ2002-MyStars/workflows/Java%20Automatic%20CodeCoverage%20Report/badge.svg)
[![Netlify Status](https://api.netlify.com/api/v1/badges/122779ae-d183-46e9-beef-6e66a0d4db3f/deploy-status)](https://cz2002-mystars.netlify.app)
[![codecov](https://codecov.io/gh/GoldenCorgi/CZ2002-MyStars/branch/master/graph/badge.svg?token=W928NWEEMJ)](https://codecov.io/gh/GoldenCorgi/CZ2002-MyStars)

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/GoldenCorgi/">
    <img src="https://github.com/GoldenCorgi/NTU--Mod--CZ2002-MyStars/blob/master/readme.png" alt="Logo">
  </a>

  <h3 align="center">CZ2002 Object-Oriented Design Principles</h3>

  <p align="center">
    "oh nooo, I deployed an entire application with full website documentation and unit testing, code coverage, and CI/CD, but noooo my concepts are too weak, A-"
    <br />
    <strong> subjective academic grading with no proper review/appeal procedure is bullshit for ANY high-cost college. </strong>
    <br />
    <br />
    <a href="">2020</a>
    ·
    <a href="">Final Grade</a>
    ·
    <a href="">A-</a>
    <br />
    <br />
  </p>
</p>



<p align="center">
  <img src="https://i.redd.it/5mfbi6v63ir41.jpg" width="70%" />
</p>


## Documentation

* This project uses Netlify to host our documentation. 
* The website hosting our JavaDoc documentation can be found here [https://cz2002-mystars.netlify.app](https://cz2002-mystars.netlify.app)

## Code Coverage

* This project uses JaCoCo and CodeCov for our code coverage reports.
* An icicle graph showing the code coverage for tests. The top section represents the entire project. Proceeding with folders and finally individual files. The size and color of each slice is representing the number of statements and the coverage, respectively.

[![codecov](https://codecov.io/gh/GoldenCorgi/CZ2002-MyStars/branch/master/graphs/icicle.svg?token=W928NWEEMJ)](https://codecov.io/gh/GoldenCorgi/CZ2002-MyStars)


## Build automation using Gradle

* This project uses Gradle for build automation and dependency management. It includes a basic build script (i.e. the `build.gradle` file).

## Testing


### I/O redirection tests

* To run _I/O redirection_ tests (aka _Text UI tests_), navigate to the `text-ui-test` and run the `runtest(.bat/.sh)` script.

### JUnit tests

* JUnit5 combined with JaCoCo and GitHub Actions is used for automated integration and unit testing

## CI/CD using GitHub Actions

The project uses [GitHub actions](https://github.com/features/actions) for CI. When pushing a commit to this repo or PR against it, GitHub actions will run automatically to build and verify the code as updated by the commit/PR.

## Tools Used

- Java JDK 11 (Programming Language)
- Gradle (Build Automation Tool)
- IntelliJ IDEA 2020.03 (Integrated Development Environment - IDE)
- GitHub (Version Control, Collaborative Tool)
- GitHub Actions (Continuous Integration / Continuous Delivery - CI/CD)
- JUnit5 (Unit Testing Framework)
- JaCoCo (Code Coverage)
- CodeCov (Code Coverage) 
- Netlify (Website Application Hosting) 
