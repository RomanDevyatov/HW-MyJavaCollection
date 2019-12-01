package com.netcracker;

import java.util.Iterator;
import java.util.function.Consumer;


public interface Iterable<E> {
   Iterator<E> iterator();

}
