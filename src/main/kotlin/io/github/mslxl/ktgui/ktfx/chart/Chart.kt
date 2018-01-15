package io.github.mslxl.ktgui.ktfx.chart

import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.scene.chart.*

inline fun <X, Y> FxPanelNode.areaChart(xAxis: Axis<X>, yAxis: Axis<Y>, block: AreaChart<X, Y>.() -> Unit) = _ktfx(AreaChart(xAxis, yAxis), block)

inline fun <X, Y> FxPanelNode.barChart(xAxis: Axis<X>, yAxis: Axis<Y>, block: BarChart<X, Y>.() -> Unit) = _ktfx(BarChart(xAxis, yAxis), block)

inline fun <X, Y> FxPanelNode.bubbleChart(xAxis: Axis<X>, yAxis: Axis<Y>, block: BubbleChart<X, Y>.() -> Unit) = _ktfx(BubbleChart(xAxis, yAxis), block)

inline fun <X, Y> FxPanelNode.lineChart(xAxis: Axis<X>, yAxis: Axis<Y>, block: LineChart<X, Y>.() -> Unit) = _ktfx(LineChart(xAxis, yAxis), block)

inline fun <X, Y> FxPanelNode.scatterChart(xAxis: Axis<X>, yAxis: Axis<Y>, block: ScatterChart<X, Y>.() -> Unit) = _ktfx(ScatterChart(xAxis, yAxis), block)

inline fun <X, Y> FxPanelNode.stackedAreaChart(xAxis: Axis<X>, yAxis: Axis<Y>, block: StackedAreaChart<X, Y>.() -> Unit) = _ktfx(StackedAreaChart(xAxis, yAxis), block)

inline fun <X, Y> FxPanelNode.stackedBarChart(xAxis: Axis<X>, yAxis: Axis<Y>, block: StackedBarChart<X, Y>.() -> Unit) = _ktfx(StackedBarChart(xAxis, yAxis), block)

inline fun <X, Y> FxPanelNode.pieChart(block: PieChart.() -> Unit) = _ktfx(PieChart(), block)

