package com.soulostar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private static class NestedInteger{
        ArrayList<Integer> nested;

        public NestedInteger(ArrayList<Integer> nested) {
            this.nested = nested;
        }

        public boolean isInteger() {
            return this.nested.size()==1;
        }

        public Integer getInteger() {
            if (this.isInteger())return nested.get(0);
            else return null;
        }

        public List<NestedInteger> getList() {
            return new ArrayList<NestedInteger>();
        }
    }
    ArrayList<Integer> list = new ArrayList<>();
    int index;

    public void recursive(List<NestedInteger> nestedList){
        for (NestedInteger iterator:nestedList) {
            if (iterator.isInteger()){
                list.add(iterator.getInteger());
            }else {
                recursive(iterator.getList());
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        recursive(nestedList);
        index = 0;
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index == list.size();
    }
}
