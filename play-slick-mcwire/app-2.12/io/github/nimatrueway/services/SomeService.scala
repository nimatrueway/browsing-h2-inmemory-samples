package io.github.nimatrueway.services

class SomeServiceImpl extends SomeService {
  val giveAString = "RealApplication"
}

trait SomeService {
  def giveAString: String
}