package hw7_18001163;

public interface Entry<K, E> {
    K getKey(); // K là khóa của phần tử

    E getValue(); // E là giá trị phần tử
}