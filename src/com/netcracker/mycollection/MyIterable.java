package com.netcracker.mycollection;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;


public interface MyIterable<T> {

   Iterator<T> iterator();
}