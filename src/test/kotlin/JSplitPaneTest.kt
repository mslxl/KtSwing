import io.github.mslxl.ktswing.*
import io.github.mslxl.ktswing.debug.showDebugWindows

fun main(args: Array<String>) {
    frame {
        cardpanel {
            splitPane {
                isOneTouchExpandable = true
                left {
                    splitPane {
                        top {
                            borderpanel {
                                north {
                                    textfield {

                                    }
                                }
                                centre {
                                    tree {

                                    }
                                }
                            }

                        }
                        bottom {
                            scrollPane {
                                list<String>{

                                }
                            }
                        }
                    }
                }
                right {
                    textarea {

                    }
                }
            }
        }
        showDebugWindows()
    }
}