#!/bin/sh
set -e

echo "Generated APK files:"
ls -la $APP_DEPLOY_PATH | grep apk

if [ "$TRAVIS_PULL_REQUEST" != "false" ]; then
  echo "This is a pull request. No deployment will be done."
  exit 0
fi
if [ -z "$TRAVIS_TAG" ]; then
  echo "This is not a tag. No HockeyApp deployment will be done."
  exit 0
fi


HOCKEYAPP_RELEASE_DATE=`date '+%Y-%m-%d %H:%M:%S'`
HOCKEYAPP_RELEASE_NOTES="Build: $TRAVIS_BUILD_NUMBER - Uploaded: $HOCKEYAPP_RELEASE_DATE"

response=$(echo "Submitting APK to hockeyapp..."
curl https://rink.hockeyapp.net/api/2/apps/upload \
  -F status="2" \
  -F notify="2" \
  -F notes="$HOCKEYAPP_RELEASE_NOTES" \
  -F notes_type="0" \
  -F ipa="@$HOCKEYAPP_APP_RELEASE_PATH" \
  -F tags="$HOCKEYAPP_DISTRIBUTION_TAGS" \
  -H "X-HockeyAppToken: $HOCKEYAPP_API_TOKEN")

echo "$response"


# Options used for API:
# from http://support.hockeyapp.net/kb/api/api-apps
