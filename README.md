# Baseline Profile Benchmark Demo
## What
This is a simple Android app that tests performance using Baseline Profiles against Normal Compilation
## Why

- I made project in order to learn the benefits of using Baseline Profiles in an Android app/Library
- I added tests to check :
  1. Application Start- up performance
  2. Scroll and Navigate to the end of the list. 
- The results for this simple app were impeccable for such a small application.
- `startUpForCompilationModeNone` and `scrollAndNavigateForCompilationModeNone` tests compilation without Baseline Profile
- `startUpForCompilationModePartial` and `scrollAndNavigateForCompilationModePartial` tests compilation with Baseline Profile
## Results
![pic](https://github.com/Mzazi25/BaselineProfileBenchmarkDemo/assets/95022986/7ca01a06-7911-472e-9993-75eeced74f68)