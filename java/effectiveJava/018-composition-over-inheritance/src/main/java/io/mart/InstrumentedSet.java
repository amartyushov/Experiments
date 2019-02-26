package io.mart;

import java.util.Collection;
import java.util.Set;

/**
 * This is a wrapper and decorator.
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {
	
	private int addCount = 0;
	
	public InstrumentedSet(Set<E> s) {
		super(s);
	}
	
	
	public int getAddCount() {
		return addCount;
	}
	
	
	@Override
	public boolean add(E e) {
		addCount ++;
		return super.add(e);
	}
	
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}
}
