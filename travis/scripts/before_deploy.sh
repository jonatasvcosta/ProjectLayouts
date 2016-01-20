#!/bin/sh
set -e

echo "Creating deploy resources folder..."
mkdir $APP_DEPLOY_PATH

echo "Copying APKs to deploy folder..."
cp -rf $APP_RELEASE_STAGING_PATH $APP_DEPLOY_PATH
cp -rf $APP_RELEASE_PRODUCTION_PATH $APP_DEPLOY_PATH
