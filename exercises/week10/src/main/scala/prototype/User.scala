package prototype

class User(var userName: String,
           var level: String,
           var accessControl: AccessControl) {

  override def toString(): String = "Name: " + userName + ", Level: " + level + " Access: " + accessControl.toString()
}
