import io.github.mslxl.ktswing.component.*
import io.github.mslxl.ktswing.frame
import io.github.mslxl.ktswing.layout.borderpanel
import io.github.mslxl.ktswing.layout.cardpanel

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