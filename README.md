# KtSwing

A simple DSL library for Swing.

|                                   JitPack                                    |                                           Travis-CI                                            |
|:----------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------:|
| [![](https://jitpack.io/v/mslxl/KtGUI.svg)](https://jitpack.io/#mslxl/KtGUI) | [![](https://travis-ci.org/mslxl/KtGUI.svg?branch=master)](https://travis-ci.org/mslxl/KtGUI/) |

## How it looks like
```kotlin
fun searchBar() = swing<JPanel> {
    attr {
        border = TitledBorder("Search")
    }
    borderLayout {
        center {
            textField()
        }
        right {
            button("Search")
        }
    }
}

fun main() =
    frame {
        attr {
            title = "Sample"
            bounds = bounds.withH(400).withW(500)
        }
        borderLayout {
            top {
                panel(searchBar().initBlock)
            }
            center {
                textArea()
            }
        }
    }.exitOnClose
```

![Sample](screencaps/sample.png)
