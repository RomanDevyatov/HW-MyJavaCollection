package com.netcracker.mycollection;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;


public interface IterableA<T> {

   Iterator<T> iterator();


//   default void forEach(Consumer<? super E> action) {
//      Objects.requireNonNull(action);
//      for (E t : this) action.accept(t);
//   }


//   default Spliterator<E> spliterator() {
//      return Spliterators.spliteratorUnknownSize(iterator(), 0);
//   }
}