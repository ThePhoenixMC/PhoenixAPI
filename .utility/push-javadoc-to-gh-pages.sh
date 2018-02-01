#!/bin/bash
# https://github.com/ReadyTalk/swt-bling/tree/master/.utility
if [ "$TRAVIS_REPO_SLUG" == "ThePhoenixMC/PhoenixAPI" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then

  echo -e "Publishing javadoc...\n"

  cp -R $TRAVIS_BUILD_DIR/target/apidocs $HOME/javadoc-latest

  cd $HOME
  git config --global user.email "travis@travis-ci.org"
  git config --global user.name "travis-ci"
  git clone --quiet https://$GH_TOKEN@github.com/ThePhoenixMC/ThePhoenixMC.github.io.git gh-pages > /dev/null

  cd gh-pages
  git rm -rf ./javadoc
  cp -Rf $HOME/javadoc-latest ./javadoc
  git add -f .
  git commit -m "Latest javadoc on successful travis build $TRAVIS_BUILD_NUMBER auto-pushed to gh-pages"
  git push -fq origin master > /dev/null

  echo -e "Published Javadoc to gh-pages.\n"

fi