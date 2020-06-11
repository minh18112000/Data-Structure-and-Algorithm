package hw6_18001163;

public class HeapSort<K extends Comparable, E> extends MinHeapPriorityQueue<K, E> {
    public void sort() {
        int size = n;
        System.out.print("After sort: ");
        for (int i = 0; i < size; i++) {
            System.out.print(removeMin().getKey() + " ");
        }
        System.out.println("");
    }

    public void selectSort(ArrEntry<K, E>[] arr) {
        for (int i = n - 1; i >= 1; --i) {
            int maxId = i;
            for (int j = 0; j < i; ++j) {
                if (arr[j].getKey().compareTo(arr[maxId].getKey()) >= 0) {
                    maxId = j;
                }
            }
            ArrEntry<K, E> temp = arr[maxId];
            arr[maxId] = arr[i];
            arr[i] = temp;
        }
    }

    public ArrEntry<K, E>[] arr() {
        ArrEntry<K, E>[] arr = array;
        return arr;
    }

    public void merge(ArrEntry<K, E>[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        ArrEntry<K, E>[] arrLeft = new ArrEntry[n1];
        ArrEntry<K, E>[] arrRight = new ArrEntry[n2];
        for (int i = 0; i < n1; ++i)
            arrLeft[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            arrRight[j] = arr[mid + 1 + j];
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (arrLeft[i].getKey().compareTo(arrRight[j].getKey()) <= 0) {
                arr[k] = arrLeft[i];
                i++;
            } else {
                arr[k] = arrRight[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = arrLeft[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = arrRight[j];
            j++;
            k++;
        }
    }

    public void mergeSort(ArrEntry<K, E>[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public int partition(ArrEntry<K, E>[] arr, int low, int high) {
        int pivot = (int) arr[high].getKey();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if ((int) arr[j].getKey() < pivot) {
                i++;
                ArrEntry<K, E> temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        ArrEntry<K, E> temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public void quickSort(ArrEntry<K, E>[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public void printArray(ArrEntry<K, E>[] arr) {
        System.out.print("After sort: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i].getKey() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort<>();
        ArrEntry<Integer, String> entry1 = new ArrEntry(1, "A");
        heapSort.insert(entry1);
        heapSort.insert(6, "E");
        heapSort.insert(3, "C");
        heapSort.insert(10, "H");
        heapSort.insert(15, "K");
        heapSort.insert(7, "K");
        heapSort.insert(4, "K");
        heapSort.insert(11, "K");
        heapSort.insert(16, "K");
        System.out.println("");
        System.out.print("Before sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(heapSort.arr()[i].getKey() + " ");
        }
        System.out.println();
        long start = System.nanoTime();
        // HEAP SORT: 0.9711ms.
        heapSort.sort();
        // SELECT SORT: 0.0231ms.
        // heapSort.selectSort(heapSort.arr());
        // MERGE SORT: 0.027ms.
        // heapSort.mergeSort(heapSort.arr(), 0, n - 1);
        // QUICK SORT: 0.0127ms.
        // heapSort.quickSort(heapSort.arr(), 0, n - 1);
        long end = System.nanoTime();
        // chi goi method printArray() voi select, merge, quick sort con heap sort thi
        // da co san trong method sort() nen khong can goi. 
        // heapSort.printArray(heapSort.arr());
        System.out.println("Thoi gian sap xep: " + ((double) (end - start) / 1000000) + "ms");
    }
}