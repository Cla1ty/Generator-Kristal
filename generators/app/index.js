'use strict';
var Generator = require('yeoman-generator');
var chalk = require('chalk');
const mkdirp = require('mkdirp');
var yosay = require('yosay');

module.exports = Generator.extend({
  prompting: function () {
    // Have Yeoman greet the user.
    this.log(yosay(
      'Welcome to the badass ' + chalk.red('generator-android-architecture') + ' generator!'
    ));

    var prompts = [{
      name: 'name',
      message: 'What are you calling your app?',
      store: true,
      default: this.appname,
      validate: function (input) {
        if (/^([a-zA-Z0-9_]*)$/.test(input)) {
          return true;
        }
        return 'Your application name cannot contain special characters or a blank space, using the default name instead : ' + this.appname;
      }
    }, {
      name: 'appPackage',
      message: 'What package will you be publishing the app under?',
      validate: function (input) {
        if (/^([a-z_]{1}[a-z0-9_]*(\.[a-z_]{1}[a-z0-9_]*)*)$/.test(input)) {
          return true;
        }
        return 'The package name you have provided is not a valid Java package name.';
      },
      default: 'com.kristal.generator',
      store: true
    }];

    return this.prompt(prompts).then(function (props) {
      this.props = props;
    }.bind(this));
  },

  writing: function () {
    this.fs.copy(this.sourceRoot() + '/build.gradle', 'build.gradle');
    this.fs.copy(this.sourceRoot() + '/dependencies.gradle', 'dependencies.gradle');
    this.fs.copy(this.sourceRoot() + '/gitignore', '.gitignore');
    this.fs.copy(this.sourceRoot() + '/gradle', 'gradle');
    this.fs.copy(this.sourceRoot() + '/gradle.properties', 'gradle.properties');
    this.fs.copy(this.sourceRoot() + '/gradlew', 'gradlew');
    this.fs.copy(this.sourceRoot() + '/gradlew.bat', 'gradlew.bat');
    this.fs.copy(this.sourceRoot() + '/settings.gradle', 'settings.gradle');

    var dir = 'tool'
    var packageDir = this.props.appPackage.replace(/\./g, '/') + '/' + dir + '/';

    mkdirp(dir);
    mkdirp(dir + '/src/androidTest/java/' + packageDir);
    mkdirp(dir + '/src/main/java/' + packageDir);
    mkdirp(dir + '/src/test/java/' + packageDir);

    this.fs.copy(this.sourceRoot() + '/' + dir + '/gitignore',  dir + '/.gitignore');
    this.fs.copy(this.sourceRoot() + '/' + dir + '/proguard-rules.pro',  dir + '/proguard-rules.pro');
    this.fs.copy(this.sourceRoot() + '/' + dir + '/build.gradle',  dir + '/build.gradle');
    this.fs.copy(this.sourceRoot() + '/' + dir + '/src/main/res',  dir + '/src/main/res');

    this.fs.copyTpl(this.sourceRoot() + '/' + dir + '/src/androidTest/java/com/kristal/generator/' + dir,  dir + '/src/androidTest/java/' + packageDir, this.props);
    this.fs.copyTpl(this.sourceRoot() + '/' + dir + '/src/test/java/com/kristal/generator/' + dir,  dir + '/src/test/java/' + packageDir, this.props);
    this.fs.copyTpl(this.sourceRoot() + '/' + dir + '/src/main/java/com/kristal/generator/' + dir,  dir + '/src/main/java/' + packageDir, this.props);
    this.fs.copyTpl(this.sourceRoot() + '/' + dir + '/src/main/AndroidManifest.xml',  dir + '/src/main/AndroidManifest.xml', this.props);

    dir = 'domain'
    packageDir = this.props.appPackage.replace(/\./g, '/') + '/' + dir + '/';

    mkdirp(dir);
    mkdirp(dir + '/src/androidTest/java/' + packageDir);
    mkdirp(dir + '/src/main/java/' + packageDir);
    mkdirp(dir + '/src/test/java/' + packageDir);

    this.fs.copy(this.sourceRoot() + '/' + dir + '/gitignore',  dir + '/.gitignore');
    this.fs.copy(this.sourceRoot() + '/' + dir + '/proguard-rules.pro',  dir + '/proguard-rules.pro');
    this.fs.copy(this.sourceRoot() + '/' + dir + '/build.gradle',  dir + '/build.gradle');
    this.fs.copy(this.sourceRoot() + '/' + dir + '/src/main/res',  dir + '/src/main/res');

    // this.fs.copyTpl(this.sourceRoot() + '/domain/src/androidTest/java/com/kristal/generator/domain', 'domain/src/androidTest/java/' + packageDir, this.props);
    this.fs.copyTpl(this.sourceRoot() + '/domain/src/test/java/com/kristal/generator/domain', 'domain/src/test/java/' + packageDir, this.props);
    this.fs.copyTpl(this.sourceRoot() + '/domain/src/main/java/com/kristal/generator/domain', 'domain/src/main/java/' + packageDir, this.props);
    this.fs.copyTpl(this.sourceRoot() + '/domain/src/main/AndroidManifest.xml', 'domain/src/main/AndroidManifest.xml', this.props);

    dir = 'data'
    packageDir = this.props.appPackage.replace(/\./g, '/') + '/' + dir + '/';

    mkdirp(dir);
    mkdirp(dir + '/src/androidTest/java/' + packageDir);
    mkdirp(dir + '/src/main/java/' + packageDir);
    mkdirp(dir + '/src/test/java/' + packageDir);

    this.fs.copy(this.sourceRoot() + '/' + dir + '/gitignore',  dir + '/.gitignore');
    this.fs.copy(this.sourceRoot() + '/' + dir + '/proguard-rules.pro',  dir + '/proguard-rules.pro');
    this.fs.copy(this.sourceRoot() + '/' + dir + '/build.gradle',  dir + '/build.gradle');
    this.fs.copy(this.sourceRoot() + '/' + dir + '/src/main/res',  dir + '/src/main/res');

    this.fs.copyTpl(this.sourceRoot() + '/data/src/androidTest/java/com/kristal/generator/data', 'data/src/androidTest/java/' + packageDir, this.props);
    this.fs.copyTpl(this.sourceRoot() + '/data/src/test/java/com/kristal/generator/data', 'data/src/test/java/' + packageDir, this.props);
    this.fs.copyTpl(this.sourceRoot() + '/data/src/main/java/com/kristal/generator/data', 'data/src/main/java/' + packageDir, this.props);
    this.fs.copyTpl(this.sourceRoot() + '/data/src/main/AndroidManifest.xml', 'data/src/main/AndroidManifest.xml', this.props);

    dir = 'presentation'
    packageDir = this.props.appPackage.replace(/\./g, '/') + '/' + dir + '/';

    mkdirp(dir);
    mkdirp(dir + '/src/androidTest/java/' + packageDir);
    mkdirp(dir + '/src/main/java/' + packageDir);
    mkdirp(dir + '/src/test/java/' + packageDir);

    this.fs.copy(this.sourceRoot() + '/' + dir + '/gitignore',  dir + '/.gitignore');
    this.fs.copy(this.sourceRoot() + '/' + dir + '/proguard-rules.pro',  dir + '/proguard-rules.pro');
    this.fs.copy(this.sourceRoot() + '/' + dir + '/src/main/res',  dir + '/src/main/res');

    // this.fs.copyTpl(this.sourceRoot() + '/presentation/src/androidTest/java/com/kristal/generator/presentation', 'presentation/src/androidTest/java/' + packageDir, this.props);
    this.fs.copyTpl(this.sourceRoot() + '/presentation/src/test/java/com/kristal/generator/presentation', 'presentation/src/test/java/' + packageDir, this.props);
    this.fs.copyTpl(this.sourceRoot() + '/presentation/src/main/java/com/kristal/generator/presentation', 'presentation/src/main/java/' + packageDir, this.props);
    this.fs.copyTpl(this.sourceRoot() + '/presentation/src/main/AndroidManifest.xml', 'presentation/src/main/AndroidManifest.xml', this.props);
    this.fs.copyTpl(this.sourceRoot() + '/presentation/src/main/res/layout', 'presentation/src/main/res/layout', this.props);
    this.fs.copyTpl(this.sourceRoot() + '/' + dir + '/build.gradle',  dir + '/build.gradle', this.props);
  }
});
