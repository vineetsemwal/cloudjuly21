package corejava.collectiondemo;

import java.util.Comparator;

public class EmployeeIdComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer id1, Integer id2) {
        return id2-id1;
    }
}
