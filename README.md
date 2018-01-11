# KtGUI

This is a DSL system for Swing and JavaFX.

**Probably not backward compatible, so please be careful upgrade version.**

**Will produce a large number of class files, cautious.**

[![](https://jitpack.io/v/mslxl/KtGUI.svg)](https://jitpack.io/#mslxl/KtGUI)

[![](https://travis-ci.org/mslxl/KtGUI.svg?branch=master)](https://travis-ci.org/mslxl/KtGUI/)

Do not access functions, variables, and constants that begin with `_`, starting with `_`  just for `inline`.

I'm very sorry for my poor English, so please Chinese API document shall prevail (If you know Chinese).

Welcome to contribute code or correct mistakes.

## How to use it

Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
}
```

Then add the dependency

```groovy
dependencies {
    compile 'com.github.mslxl:KtGUI:${ktgui_version}'
}
```

## Getting Started

See [Wiki](https://github.com/mslxl/KtGUI/wiki)

## Features

- [x] Support Swing


- [x] Support JavaFX


- [ ] Support JFoenix


- [ ] Less class


- [ ] Better bind


- [ ] Better JOptionPane


- [ ] Better Alert


- [ ] Full document

