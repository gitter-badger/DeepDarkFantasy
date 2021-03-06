package com.thoughtworks.DDF.Sum

import com.thoughtworks.DDF.Arrow.ShowArrow
import com.thoughtworks.DDF.{NoInfo, Show}

trait ShowSum extends SumRepr[NoInfo, Show] with ShowArrow with SimpleSum[Show] {
  override def left[A, B](implicit at: NoInfo[A], bt: NoInfo[B]) = Show("left")

  override def right[A, B](implicit at: NoInfo[A], bt: NoInfo[B]) = Show("right")

  override def sumMatch[A, B, C](implicit at: NoInfo[A], bt: NoInfo[B], ct: NoInfo[C]) = Show("sumMatch")
}

object ShowSum {
  implicit def apply = new ShowSum {}
}