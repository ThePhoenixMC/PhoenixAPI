#!/usr/bin/env bash
if [ "$TRAVIS_REPO_SLUG" == "ThePhoenixMC/PhoenixAPI" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then

  echo -e "Publishing build to artifactory...\n"

  ./jfrog rt config --url https://lss233.com/artifactory --user travis-ci --password $ARTIFACTORY_PASSWORD default
  ./jfrog rt u --build-number=$TRAVIS_BUILD_NUMBER --build-name="PhoenixAPI" "target/Phoenix-API-1.0.0-SNAPSHOT.jar" "generic-local/PhoenixMC/Phoenix-API/"
  ./jfrog rt bag PhoenixAPI $TRAVIS_BUILD_NUMBER
  ./jfrog rt bce PhoenixAPI $TRAVIS_BUILD_NUMBER
  ./jfrog rt bp --env-exclude="*TOKEN;*PASSWORD;*KEY;*password*;*secret*;*key*" PhoenixAPI $TRAVIS_BUILD_NUMBER

  echo -e "Published build to artifactory.\n"

fi