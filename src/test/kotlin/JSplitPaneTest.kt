import io.github.mslxl.ktgui.ktswing.component.*
import io.github.mslxl.ktgui.ktswing.frame
import io.github.mslxl.ktgui.ktswing.layout.borderpanel
import io.github.mslxl.ktgui.ktswing.layout.cardpanel

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

    }
}