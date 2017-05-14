package prototype

class AccessControl(val controlLevel: String,
                    var access: String)
    extends Prototype {

  override def clone(): AccessControl = ???

  override def toString(): String = "Access Control Level: " + controlLevel + " , Access: " + access
}