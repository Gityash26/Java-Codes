/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~ Methods of LinkedList Class ~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        _____________________|________________________
        |                                             |
    LinkedList                                 LinkedList Deque 
      Methods                                       Methods

=====================================================================================
:::::::::::::::::::::: Linked List Methods ::::::::::::::::::::::::::::::::::::::
-------------------------------------------------------------------------------------

==== Adding Elements ===============
=====================================

(1) boolean add(Element e)
(2) void add(int index, Element e)
(3) boolean addAll(Collection c)
(4) boolean addAll(int index, Collection c)


==== Removing Elements ===============
=====================================

(1) E remove(int index)
(2) boolean remove(Object o)
(3) boolean removeAll(Collection<?> c)
(4) void clear()


==== Retrieving Elements ===============
=====================================

(1) E get(int index)
(2) int indexOf(Object o):
(3) int lastIndexOf(Object o):
(4) List<E> subList(int fromIndex, int toIndex)


==== Search Elements ===============
=====================================

(1) boolean contains(Object o)
(2) boolean containsAll(Collection<?> c)


==== Query Elements ===============
=====================================

(1) boolean equals(Object o)
(2) int size()
(3) boolean isEmpty()


==== Converting to Array ===============
=====================================

(1) Object[] toArray()
(2) <T> T[] toArray(T[] a)
                      




=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`==`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=
:::::::::::::::::::::: Linked List Deque Methods :::::::::::::::::::::::::::::::::::
=====================================================================================
-> Following methods are inherited from the Deque interface-


==== Adding Elements ===============
=====================================

(1) void addFirst(E e)
(2) void addLast(E e)
(3) boolean offerFirst(E e)
(4) boolean offerLast(E e)


==== Removing Elements ===============
=====================================

(1) E removeFirst()
(2) E removeLast()
(3) E pollFirst()
(4) E pollLast()


==== Retrieving Elements ===============
=====================================

(1) E getFirst()
(2) E getLast()
(3) E peekFirst()
(4) E peekLast()

*/