package singleton

class Singleton private(){  // private constructor

}

//companion object
object Singleton {
  private val instance: Singleton = new Singleton
  // val is immutable so this will cover it and ensure there is only one.  Dont need a null check.
  def getInstance() = instance
}
