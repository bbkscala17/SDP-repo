package singleton

class Singleton private(){  // private constructor

}

//companion object
object Singleton {
  private val instance: Singleton = new Singleton
  def getInstance() = instance
}