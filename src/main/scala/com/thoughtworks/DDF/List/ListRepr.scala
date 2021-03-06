package com.thoughtworks.DDF.List

import com.thoughtworks.DDF.Product.{ProductInfo, ProductRepr}

trait ListRepr[Info[_], Repr[_]] extends ProductRepr[Info, Repr] with ListInfo[Info, Repr] {
  def nil[A](implicit ai: Info[A]): Repr[List[A]]

  def cons[A](implicit ai: Info[A]): Repr[A => List[A] => List[A]]

  def listMatch[A, B](implicit ai: Info[A], bi: Info[B]): Repr[List[A] => B => (A => List[A] => B) => B]

  def listMap[A, B](implicit ai: Info[A], bi: Info[B]): Repr[(A => B) => List[A] => List[B]]

  def reverse[A](implicit ai: Info[A]): Repr[List[A] => List[A]]

  def foldRight[A, B](implicit ai: Info[A], bi: Info[B]): Repr[(A => B => B) => B => List[A] => B]

  def foldLeft[A, B](implicit ai: Info[A], bi: Info[B]): Repr[(A => B => A) => A => List[B] => A]

  def listZip[A, B](implicit ai: Info[A], bi: Info[B]): Repr[List[A] => List[B] => List[(A, B)]]
}