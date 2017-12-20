# Android Mvp Starter

An android mvp starter template that makes a simple http api call from jsonplaceholder and uses bunch of useful android library to get started.

## This project uses:
- [RxJava2](https://github.com/ReactiveX/RxJava) and [RxAndroid](https://github.com/ReactiveX/RxAndroid)
- [Retrofit](http://square.github.io/retrofit/) / [OkHttp](http://square.github.io/okhttp/)
- [Gson](https://github.com/google/gson)
- [Dagger 2](http://google.github.io/dagger/)
- [Butterknife](https://github.com/JakeWharton/butterknife)
- [Google Play Services](https://developers.google.com/android/guides/overview)
- [Timber](https://github.com/JakeWharton/timber)
- [Glide 3](https://github.com/bumptech/glide)
- [Stetho](http://facebook.github.io/stetho/)
- [Espresso](https://google.github.io/android-testing-support-library/) for UI tests
- [Robolectric](http://robolectric.org/) for framework specific unit tests
- [Mockito](http://mockito.org/)
- [Checkstyle](http://checkstyle.sourceforge.net/), [PMD](https://pmd.github.io/) and [Findbugs](http://findbugs.sourceforge.net/) for code analysis


## Create new project using yeoman [This Project heavely uses yeoman mvp stater generator](https://github.com/androidstarters/generator-android-mvp-starter)


## Building

To build, install and run a debug version, run this from the root of the project:
```sh
./gradlew app:assembleDebug
```

## Testing

To run **unit** tests on your machine:

```sh
./gradlew test
```

To run **instrumentation** tests on connected devices:

```sh
./gradlew connectedAndroidTest
```

## Code Analysis tools

The following code analysis tools are set up on this project:

* [PMD](https://pmd.github.io/)

```sh
./gradlew pmd
```

* [Findbugs](http://findbugs.sourceforge.net/)

```sh
./gradlew findbugs
```

* [Checkstyle](http://checkstyle.sourceforge.net/)

```sh
./gradlew checkstyle
```

## The check task

To ensure that your code is valid and stable use check:

```sh
./gradlew check
```

## Jacoco Reports

#### Generate Jacoco coverage reports for the Debug build. Only unit tests.

```sh
app:testDebugUnitTestCoverage
```

#### Generate Jacoco coverage reports for the Release build. Only unit tests.

```sh
app:testReleaseUnitTestCoverage
```

#### Generate Jacoco coverage reports for the Debug build. Both unit and espresso tests.

```sh
app:unitAndEspressoDebugTestCoverage
```

#### Generate Jacoco coverage reports for the Release build. Both unit and espresso tests.

```sh
app:unitAndEspressoReleaseTestCoverage
```





## License
```
MIT License

Copyright (c) 2017 Abhishek Prajapati

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=false} -->
<!-- code_chunk_output -->

* [Android Mvp Starter](#android-mvp-starter)
	* [This project uses:](#this-project-uses)
	* [Create new project using yeoman This Project heavely uses yeoman mvp stater generator](#create-new-project-using-yeoman-this-project-heavely-uses-yeoman-mvp-stater-generatorhttpsgithubcomandroidstartersgenerator-android-mvp-starter)
	* [Building](#building)
	* [Testing](#testing)
	* [Code Analysis tools](#code-analysis-tools)
	* [The check task](#the-check-task)
	* [Jacoco Reports](#jacoco-reports)
			* [Generate Jacoco coverage reports for the Debug build. Only unit tests.](#generate-jacoco-coverage-reports-for-the-debug-build-only-unit-tests)
			* [Generate Jacoco coverage reports for the Release build. Only unit tests.](#generate-jacoco-coverage-reports-for-the-release-build-only-unit-tests)
			* [Generate Jacoco coverage reports for the Debug build. Both unit and espresso tests.](#generate-jacoco-coverage-reports-for-the-debug-build-both-unit-and-espresso-tests)
			* [Generate Jacoco coverage reports for the Release build. Both unit and espresso tests.](#generate-jacoco-coverage-reports-for-the-release-build-both-unit-and-espresso-tests)
	* [License](#license)

<!-- /code_chunk_output -->
