package iterator

import java.util.Iterator

class ShapeIterator(private var shapes: Array[Shape]) extends Iterator[Shape] {
  var index = 0;

  override def hasNext(): Boolean = index < shapes.size

  override def next(): Shape = {
    index +=1
    shapes(index-1)
  }

  /**
    * remove the current item from the collection
    */
  override def remove(): Unit = {
    shapes = shapes.drop(index)
  }
}