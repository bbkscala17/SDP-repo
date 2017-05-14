package prototype
// why comment out the clone method in this trait? To get rid of an error message
// on advice from http://stackoverflow.com/questions/8618937/scala-specifying-public-method-overriding-protected-method#8619704
// "Here's the important part of the error message: "and is therefore overridden by concrete method clone in class Object".
// "You should provide an implementation of the clone method in your trait. It's not ideal, but it's what you have to do since clone is a concrete method on Object."

trait Prototype extends Cloneable {
//  def clone(): AccessControl
}