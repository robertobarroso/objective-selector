package com.seedtag.objectiveselector.util;

import java.util.Comparator;
import java.util.List;

public class ChainComparator<T> implements Comparator<T> {
   
	private List<Comparator<T>> comparatorList;
	
	public ChainComparator(List<Comparator<T>> comparatorList) {
		this.comparatorList = comparatorList;
	}
   
	@Override
	public int compare(T p1, T p2) {
       int result;
       for(Comparator<T> comparator : comparatorList) {
         if ((result = comparator.compare(p1, p2)) != 0) {
             return result;
         }
       }
       return 0;
   }
}