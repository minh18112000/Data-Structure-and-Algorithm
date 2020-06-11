package hw4_18001163;

public interface QueueInterface<E> extends Iterable<E> {
	public void enqueue(E element);

	public E dequeue();

	public boolean isEmpty();

	public E first();
}