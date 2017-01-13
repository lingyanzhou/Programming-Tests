package lzhou.algorithms;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Comparator;

/**
 * MaxHeap
 */
public class Heap<T>
{
    private List<T> list = null;
    private Comparator<T> comparator = null;
    
    public Heap(Comparator<T> comparator) {
        list = new ArrayList<T>();
        this.comparator = comparator;
    }

    public Heap(List<T> list, Comparator<T> comparator) {
        this.list = new ArrayList<T>(list);
        this.comparator = comparator;
        buildHeap(this.list, this.comparator);
    }

    public void add(T a) {
        list.add(a);
        int index = list.size()-1;
        while (index!=0 && comparator.compare(a, list.get(parentIndex(index)))>0) {
            swapListEntries(list, index, parentIndex(index));
            index = parentIndex(index);
        }
    }
    
    public int size() {
        return list.size();
    }

    public T peekMax() {
        if (list.size()==0) {
            throw new NoSuchElementException();
        }
        return list.get(0);
    }

    public T removeMax() {
        if (list.size()==0) {
            throw new NoSuchElementException();
        }
        T ret = list.get(0);
        swapListEntries(list, 0, list.size()-1);
        list.remove(list.size()-1);
        heapify(list, comparator, 0);
        return ret;
    }

    private void buildHeap(List<T> list, Comparator<T> comparator) {
        int lastNodeWithChild = parentIndex(list.size()-1);
        for (int i=lastNodeWithChild; i>=0; --i) {
            heapify(list, comparator, i);
        }
    }

    private void heapify(List<T> list, Comparator<T> comparator, int node) {
        int size = list.size();
        int largestChildIndex = node;
        while (true) {
            int leftChildInd = leftChildIndex(node);
            int rightChildInd = rightChildIndex(node);
            if (leftChildInd<list.size()) {
                if (comparator.compare(list.get(leftChildInd), list.get(node))>0) {
                    largestChildIndex = leftChildInd;
                }
                if (rightChildInd<list.size()
                    && comparator.compare(list.get(rightChildInd), list.get(node))>0
                    && comparator.compare(list.get(rightChildInd), list.get(leftChildInd))>0) {
                    largestChildIndex = rightChildInd;
                }
                if (largestChildIndex!=node) {
                    swapListEntries(list, node, largestChildIndex);
                    node = largestChildIndex;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    private static int parentIndex(int index) {
        assert index > 0;
        return (index+1)/2-1;
    }

    private static int leftChildIndex(int index) {
        assert index >= 0;
        return (index+1)*2-1;
    }

    private static int rightChildIndex(int index) {
        assert index >= 0;
        return (index+1)*2;
    }

    private void swapListEntries(List<T> list, int p, int q) {
        assert p>=0 && q>=0 && p<list.size() && q<list.size();
        T tmp = list.get(p);
        list.set(p, list.get(q));
        list.set(q, tmp);
    }
}
