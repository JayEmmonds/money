/*
 * Copyright 2012-2015 Comcast Cable Communications Management, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.comcast.money.core

import java.util.Collections

import com.comcast.money.api._
import com.comcast.money.core.internal.ThreadLocalSpanTracer

// $COVERAGE-OFF
object DisabledSpanHandler extends SpanHandler {

  def handle(spanInfo: SpanInfo): Unit = ()
}

object DisabledTracer extends Tracer with ThreadLocalSpanTracer {

  val spanFactory: SpanFactory = DisabledSpanFactory

  override def startSpan(key: String, spanId: Option[SpanId] = None): Unit = ()

  override def time(key: String): Unit = ()

  override def record(key: String, measure: Double): Unit = ()

  override def record(key: String, measure: Double, propogate: Boolean): Unit = ()

  override def record(key: String, measure: String): Unit = ()

  override def record(key: String, measure: String, propogate: Boolean): Unit = ()

  override def record(key: String, measure: Long): Unit = ()

  override def record(key: String, measure: Long, propogate: Boolean): Unit = ()

  override def record(key: String, measure: Boolean): Unit = ()

  override def record(key: String, measure: Boolean, propogate: Boolean): Unit = ()

  override def record(note: Note[_]): Unit = ()

  override def stopSpan(result: Boolean): Unit = ()

  override def startTimer(key: String): Unit = ()

  override def stopTimer(key: String): Unit = ()

  override def close(): Unit = ()
}

object DisabledSpanFactory extends SpanFactory {

  def newSpan(spanName: String): Span = DisabledSpan

  def childSpan(childName: String, span: Span): Span = DisabledSpan

  def childSpan(childName: String, span: Span, sticky: Boolean): Span = DisabledSpan

  def newSpan(spanId: SpanId, spanName: String): Span = DisabledSpan
}

object DisabledSpan extends Span {

  def start(): Unit = ()

  def stop(): Unit = ()

  def stop(result: java.lang.Boolean): Unit = ()

  def stopTimer(timerKey: String): Unit = ()

  def record(note: Note[_]): Unit = ()

  def startTimer(timerKey: String): Unit = ()

  def info(): SpanInfo = null
}

object NilSpanInfo extends SpanInfo {
  def notes = Collections.emptyMap[String, Note[_]]

  def startTimeMillis = 0L

  def startTimeMicros = 0L

  def endTimeMillis = 0L

  def endTimeMicros = 0L

  def success = false

  def id = NilSpanId

  def name = ""

  def durationMicros() = 0L

  def appName = ""

  def host = ""
}

object NilSpanId extends SpanId("", 0L, 0L) {
  override def newChildId: SpanId = throw new IllegalStateException()
}
// $COVERAGE-ON$
