# Submitting Issues
* Name convention: `"[" "FE "? task_context task_hierarchy? "] " task_name `
* Add labels
* Set a milestone
* Use [Skitch](https://evernote.com/skitch/) to improve its description

# Pull Requests Checklist
* Open a new Pull Request when starting a new issue, adding the "IN PROGRESS" label
* Associate an issue
* Assign it to yourself
* Set the current milestone
* Move solved issue to Review on [hubboard](https://huboard.com/indigotech/br-example_name-app-android)
* Ask for code review on github: `@<People> ready for code review!`

# Merge
* Fetch: `git fetch origin -p`
* Rebase your branch: `git rebase -p origin/develop`
  * Check if GUIDE flavour is building
* Merge it on GitHub and then inform your team on Slack: `@group, develop updated`
* Check if your travis build is actually builded

# Main Flow
## Sprint 1
* All endpoints should have a button to be tested in a pre-defined Activity inside the app

# Planning checklist

## Main Test
* Test at least in in Android versions 4.0, 4.1 and 6.0
* Test at least in the screens of Google Nexus S (480x800) and Google Nexus 6P (1440x2560)
* Test without connection
* Test through a fast connection (wifi)
* Test through a slow connection
* Test all screens when the app comes back from background
* Test push notification flow, if the screen contemplates
* Test if the screen has the correct analytics implemented
* Test in a real device to avoid performance issues and memory leaks

## Devices to test per dev
Device  | Dev
------------- | -------------
4.1 Nexus S - 480x800  | Fill out
5.1 Nexus 6 - 1440x2560  | Fill out
6.0 Nexus 5X - 1080x1920 | Fill out
4.4 Nexus 4 768x1280 | Fill out
6.0 Nexus 6P 1440x2560 | Fill out

## Homologation test
* Test in all Android versions 4.0+
* Test in LG Optimus L3 II (240x320)

## Front-end tests
* Open the guide 
* Test every screen on the guide (using Nexus 5 simulator) comparing it with the android sketch

## New features / APIs
* Consider time to research existing dependencies
 - To avoid "reinventing the wheel" and also to certificate that the possible solution fulfills all the requirements
* Check if the new feature requires an API not implemented yet
 - Dev should validate the API before implementing
 - Negotiate with PO if the API requires a fix or implementation

## Refactoring
* Consider time to refactor
* Consider time to solve technical debts

## Conventions
* Please follow the [Conventions](https://github.com/indigotech/br-example_name-app-android/blob/develop/Conventions.md)

## Retrospectives
* See which problems/solutions we've found so far on our [retrospectives](https://github.com/indigotech/br-example_name-app-android/blob/develop/docs/Retrospective.md)