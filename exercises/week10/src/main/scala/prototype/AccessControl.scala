package prototype

class AccessControl(val controlLevel: String,
                    var access: String)
    extends Prototype {

  override def clone(): AccessControl = new AccessControl(controlLevel, access)

  override def toString(): String = "Access Control Level: " + controlLevel + " , Access: " + access
}