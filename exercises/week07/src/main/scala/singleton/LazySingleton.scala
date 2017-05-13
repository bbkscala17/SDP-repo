package singleton

class LazySingleton private() { // private constructor
}

object LazySingleton {
  private var _instance: LazySingleton = null  //is now var and is inititally null so can inititalise when getInstance is called

  def getInstance(): LazySingleton = {
    if (_instance == null)
      _instance = new LazySingleton()
    _instance
  }
}